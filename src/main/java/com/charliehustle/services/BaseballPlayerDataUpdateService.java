package com.charliehustle.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charliehustle.beans.StatKey;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.models.BaseballPlayer;
import com.charliehustle.models.BaseballPlayerSavant;
import com.charliehustle.models.CbsPlayer;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

@Service
public class BaseballPlayerDataUpdateService {

    @Autowired
    private UnirestApiService unirestApiService;

    @Autowired
    private BasicObjectFactory basicObjectFactory;

    @Autowired
    private BaseballPlayerDataUpdateServiceHelper baseballPlayerDataUpdateServiceHelper;

    @Autowired
    private MicrosoftObjectFactory microsoftObjectFactory;

    @Autowired
    private AccessDatabaseService accessDatabaseService;

    public void setupRosterMaps(Table rosterTable, Map<String, Row> currentRows, Map<String, Row> altCurrentRows) throws IOException{
        System.out.println("Prepping access db rows");
        Map<String, String> playerDataUpdateMap = basicObjectFactory.createKeyValueMap();

        playerDataUpdateMap.put("#", "30");
        playerDataUpdateMap.put("Team", "ZZ");
        playerDataUpdateMap.put("Age", null);
        playerDataUpdateMap.put("Position", null);
        playerDataUpdateMap.put("BP Rank", null);
        playerDataUpdateMap.put("FG Rank", null);
        playerDataUpdateMap.put("MLB Overall Rank", null);
        playerDataUpdateMap.put("MLB Organizational Rank", null);
        playerDataUpdateMap.put("Price", null);
        playerDataUpdateMap.put("Contract", null);
        playerDataUpdateMap.put("Platoon", null);
        playerDataUpdateMap.put("Owner", "ZZ");

        for (Row row : rosterTable) {
            accessDatabaseService.updateRow(rosterTable,
                                            row,
                                            playerDataUpdateMap);

            currentRows.put(row.getString("NAME"), row);
            if (row.getString("Alternate Name") != null) {
                altCurrentRows.put(row.getString("Alternate Name"), row);
            }
        }
    }

    public void addFanGraphsData(Table rosterTable, Map<String, Row> currentRows, List<BaseballPlayer> allBaseballPlayers) throws IOException {
        System.out.println("Adding fangraphs data to db");
        for (BaseballPlayer player : allBaseballPlayers) {
           // System.out.println(player.getPlayerName());
            Map<String, String> playerDataUpdateMap = baseballPlayerDataUpdateServiceHelper.playerDataUpdateMapInitialSetup(player);
            baseballPlayerDataUpdateServiceHelper.updateOP(player, playerDataUpdateMap);
            baseballPlayerDataUpdateServiceHelper.updateRole(player, playerDataUpdateMap);
            baseballPlayerDataUpdateServiceHelper.updateTeam(player, playerDataUpdateMap);

            Row row = currentRows.get(player.getPlayerName());
            if (row != null) {
                accessDatabaseService.updateRow(rosterTable, row, playerDataUpdateMap);
            } else {
                playerDataUpdateMap.put("Name", player.getPlayerName());
                accessDatabaseService.addRowFantasyBaseball(rosterTable, playerDataUpdateMap);
            }
        }
    }

    public String addCbsData(Table rosterTable, Map<String, Row> currentRows, Map<String, Row> altCurrentRows, String fileName) throws IOException {
        File myFile = basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\" + fileName + ".xlsx");
        Map<String, String> playerDataUpdateMap = basicObjectFactory.createKeyValueMap();
        String cantFindPlayers = "";
        try(FileInputStream fis = basicObjectFactory.createFileInputStream(myFile)) {
            XSSFWorkbook myWorkBook = microsoftObjectFactory.createXSSFWorkbook(fis);
            XSSFSheet mySheet = microsoftObjectFactory.createXSSFSheet(myWorkBook, 0);
            Iterator<org.apache.poi.ss.usermodel.Row> rowIterator = mySheet.iterator();
            System.out.println("updating db with excel data");

            while (rowIterator.hasNext()) {
                org.apache.poi.ss.usermodel.Row row = rowIterator.next();
                String playerName = null;

                Iterator<Cell> cellIterator = row.cellIterator();
                int cellnumber = 0;
                boolean skipRow = false;
                while (cellIterator.hasNext() && !skipRow) {
                    Cell cell = cellIterator.next();
                    ++cellnumber;
                    if (cellnumber == 1 && ((cell.getStringCellValue().equals("Pitchers"))
                            || (cell.getStringCellValue().equals("Batters"))
                            || (cell.getStringCellValue().equals("Avail"))
                            || (cell.getStringCellValue().startsWith("TOTALS"))
                            || (cell.getStringCellValue().startsWith("Free Agents"))
                            || (cell.getStringCellValue() == null))) {

                        skipRow = true;
                    } else {
                        switch (cellnumber) {
                            case 1: // owner
                                baseballPlayerDataUpdateServiceHelper.updateOwner(cell, playerDataUpdateMap);
                                break;
                            case 2: // playername
                                playerName = baseballPlayerDataUpdateServiceHelper.getPlayerName(cell);
                                if(playerName == null) {
                                    skipRow = true;
                                }
                                break;
                            case 3: // position
                                baseballPlayerDataUpdateServiceHelper.updatePosition(cell, playerDataUpdateMap);
                                break;
                            case 4: // price
                                baseballPlayerDataUpdateServiceHelper.updatePrice(cell, playerDataUpdateMap);
                                break;
                            case 5: // contract
                                baseballPlayerDataUpdateServiceHelper.updateContract(cell, playerDataUpdateMap);
                                break;
                        }
                    }
                }

                if (!skipRow) {
                    Row currentRow = currentRows.get(playerName);
                    if (currentRow != null) {
                        accessDatabaseService.updateRow(rosterTable, currentRow, playerDataUpdateMap);
                    } else {
                        Row altCurrentRow = altCurrentRows.get(playerName);
                        if (altCurrentRow != null) {
                            System.out.println("updating row from alt " + playerName);
                            accessDatabaseService.updateRow(rosterTable, altCurrentRow, playerDataUpdateMap);
                        } else {
                            if (playerName != null) {
                                cantFindPlayers = cantFindPlayers + playerName + " " + playerDataUpdateMap.get("Owner") + "\n";
                            }
                        }
                    }
                }
            }
            System.out.println("adding complete");
        }

        return cantFindPlayers;
    }

    public void removeExistingRowsFromTable(Table rosterTable)
       throws IOException
    {
        for(Row row : rosterTable){
            accessDatabaseService.deleteRow(rosterTable, row);
        }

        System.out.println("Roster table rows deleted");
    }

    public void meldDataTogetherAndAddToDatabase (Table rosterTable,
                                                  List<BaseballPlayer> allBaseballPlayers,
                                                  Map<StatKey, Double> baseballSavantStatisticalBreakdowns,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersL,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersL,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersL,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersL,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersL,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersL,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersL,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersL,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersR,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersR,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersR,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersR,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersR,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersR,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersR,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersR,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersLQuality,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersLQuality,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersLQuality,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersLQuality,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersLQuality,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersLQuality,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersLQuality,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersLQuality,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersRQuality,
                                                  Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersRQuality,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersRQuality,
                                                  Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersRQuality,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersRQuality,
                                                  Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersRQuality,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersRQuality,
                                                  Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersRQuality,
                                                  List<CbsPlayer> allCbsBatters,
                                                  List<CbsPlayer> allCbsPitchers)
       throws IOException
    {
        System.out.println("Adding fangraphs data to db");
        for (BaseballPlayer player : allBaseballPlayers) {
            // System.out.println(player.getPlayerName());
            Map<String, String> playerDataUpdateMap = baseballPlayerDataUpdateServiceHelper.playerDataUpdateMapInitialSetup(player);
            baseballPlayerDataUpdateServiceHelper.updateOP(player, playerDataUpdateMap);
            baseballPlayerDataUpdateServiceHelper.updateRole(player, playerDataUpdateMap);
            baseballPlayerDataUpdateServiceHelper.updateTeam(player, playerDataUpdateMap);

            if(playerDataUpdateMap.get("OP")=="O") {
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L", "batter", 0, false, playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantBattersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","batter", 15, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantBattersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","batter", 45, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantBattersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","batter", 90, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantBattersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 0, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantBattersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 15, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantBattersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 45, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantBattersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 90, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantBattersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L", "batter", 0, true, playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantBattersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","batter", 15, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantBattersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","batter", 45, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantBattersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","batter", 90, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantBattersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 0, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantBattersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 15, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantBattersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 45, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantBattersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","batter", 90, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantBattersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateCbsData(playerDataUpdateMap, allCbsBatters);

            }else{
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 0, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantPitchersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 15, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantPitchersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 45, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantPitchersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 90, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantPitchersL);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 0, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantPitchersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 15, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantPitchersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 45, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantPitchersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 90, false,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantPitchersR);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 0, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantPitchersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 15, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantPitchersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 45, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantPitchersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("L","pitcher", 90, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantPitchersLQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 0, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantPitchersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 15, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoWeekBaseballPlayersSavantPitchersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 45, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, oneMonthBaseballPlayersSavantPitchersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateBenefitsAndPAs("R","pitcher", 90, true,playerDataUpdateMap, baseballSavantStatisticalBreakdowns, twoMonthBaseballPlayersSavantPitchersRQuality);
                baseballPlayerDataUpdateServiceHelper.updateCbsData(playerDataUpdateMap, allCbsPitchers);
            }

            accessDatabaseService.addRowFantasyBaseballSuperAuto(rosterTable, playerDataUpdateMap);

        }
    }
}
