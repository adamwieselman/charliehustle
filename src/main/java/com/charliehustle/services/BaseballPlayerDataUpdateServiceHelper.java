package com.charliehustle.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charliehustle.beans.StatKey;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.BaseballPlayer;
import com.charliehustle.models.BaseballPlayerSavant;
import com.charliehustle.models.CbsPlayer;

@Component
public class BaseballPlayerDataUpdateServiceHelper {

    @Autowired
    private BasicObjectFactory basicObjectFactory;

    public Map<String, String> playerDataUpdateMapInitialSetup(BaseballPlayer player) {

        Map<String, String> playerDataUpdateMap = basicObjectFactory.createKeyValueMap();
        playerDataUpdateMap.put("Name", StringUtils.stripAccents(player.getPlayerName()));
        playerDataUpdateMap.put("Hand", player.getHanded());
        playerDataUpdateMap.put("Position", player.getPosition());
        playerDataUpdateMap.put("MLB Id", player.getMlbamid());
        playerDataUpdateMap.put("Age", player.getAge().contains("/") || player.getAge().isEmpty()? "0": player.getAge());
        playerDataUpdateMap.put("MLB Overall Rank", player.getOverallRank());
        playerDataUpdateMap.put("MLB Organizational Rank", player.getOrganizationalRank());
        playerDataUpdateMap.put("Platoon", player.getPlatoon());

        return playerDataUpdateMap;
    }

    public void updateOP(BaseballPlayer player, Map<String, String> playerDataUpdateMap) {
        String op = null;
        //OP Logic
        switch (player.getPosition().length() > 3 ? player.getPosition().substring(0, 2) : player.getPosition()) {
            case "SP":
            case "RP":
                op = "P";
                break;
            default:
                op = "O";
                break;
        }
        playerDataUpdateMap.put("OP", op);
    }

    public void updateRole(BaseballPlayer player, Map<String, String> playerDataUpdateMap) {
        String positionNumber = null;
        switch (player.getRole()) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                positionNumber = player.getRole();
                break;
            case "Bench":
                positionNumber = "10";
                break;
            case "SP1":
                positionNumber = "11";
                break;
            case "SP2":
                positionNumber = "12";
                break;
            case "SP3":
                positionNumber = "13";
                break;
            case "SP4":
                positionNumber = "14";
                break;
            case "SP5":
            case "SP6":
            case "SPOT":
                positionNumber = "15";
                break;
            case "CL":
                positionNumber = "16";
                break;
            case "SU8":
            case "SU7":
            case "SU":
                positionNumber = "17";
                break;
            case "MID":
            case "LR":
                positionNumber = "18";
                break;
            case "Inj":
            case "10IL":
            case "15IL":
            case "60IL":
                positionNumber = "19";
                break;
            case "AAA":
                positionNumber = "21";
                break;
            case "AA":
                positionNumber = "22";
                break;
            case "A+":
                positionNumber = "23";
                break;
            case "A-":
            case "A":
                positionNumber = "24";
                break;
            case "Rk":
                positionNumber = "25";
                break;
            default:
                switch (player.getType()) {
                    case "aaa-pp":
                    case "aaa-sp":
                    case "aaa-rp":
                        positionNumber = "21";
                        break;
                    case "aa-pp":
                    case "aa-sp":
                    case "aa-rp":
                        positionNumber = "22";
                        break;
                    case "ha-pp":
                    case "ha-pt":
                        positionNumber = "23";
                        break;
                    case "la-pp":
                    case "la-pt":
                        positionNumber = "24";
                        break;
                    case "ss-pp":
                    case "ss-pt":
                        positionNumber = "25";
                        break;
                    default:
                        positionNumber = "33";
                        break;
                }
                break;
        }
        playerDataUpdateMap.put("#", positionNumber);
    }

    public void updateTeam(BaseballPlayer player, Map<String, String> playerDataUpdateMap) {
        String team = null;
        switch (player.getTeamId()) {
            case "1":
                team = "LAA";
                break;
            case "2":
                team = "BAL";
                break;
            case "3":
                team = "BOS";
                break;
            case "4":
                team = "CHW";
                break;
            case "5":
                team = "CLE";
                break;
            case "6":
                team = "DET";
                break;
            case "7":
                team = "KC";
                break;
            case "8":
                team = "MIN";
                break;
            case "9":
                team = "NYY";
                break;
            case "10":
                team = "OAK";
                break;
            case "11":
                team = "SEA";
                break;
            case "12":
                team = "TB";
                break;
            case "13":
                team = "TEX";
                break;
            case "14":
                team = "TOR";
                break;
            case "15":
                team = "ARI";
                break;
            case "16":
                team = "ATL";
                break;
            case "17":
                team = "CHC";
                break;
            case "18":
                team = "CIN";
                break;
            case "19":
                team = "COL";
                break;
            case "20":
                team = "MIA";
                break;
            case "21":
                team = "HOU";
                break;
            case "22":
                team = "LAD";
                break;
            case "23":
                team = "MIL";
                break;
            case "24":
                team = "WAS";
                break;
            case "25":
                team = "NYM";
                break;
            case "26":
                team = "PHI";
                break;
            case "27":
                team = "PIT";
                break;
            case "28":
                team = "STL";
                break;
            case "29":
                team = "SD";
                break;
            case "30":
                team = "SF";
                break;
        }
        playerDataUpdateMap.put("Team", team);
    }

    public void updateOwner(Cell cell, Map<String, String> playerDataUpdateMap) {
        String owner = null;
        if (cell.getStringCellValue().startsWith("W ")) {//("W (")
            owner = "ZZ";
        } else {
            owner = cell.getStringCellValue();
        }
        playerDataUpdateMap.put("Owner", owner);
    }

    public String getPlayerName(Cell cell) {
        String playerNameInitial = cell.getStringCellValue();
        if (playerNameInitial == null) {
            //System.out.println("Owner row - skip");
        } else {
            int endPosition = playerNameInitial.indexOf(" |");
            if (playerNameInitial.charAt(endPosition - 2) == ' ') {
                return playerNameInitial.substring(0, endPosition - 2);
            } else {
                return playerNameInitial.substring(0, endPosition - 3);
            }
        }
        return null;
    }

    public void updatePosition(Cell cell, Map<String, String> playerDataUpdateMap) {
        String position = cell.getStringCellValue();
        playerDataUpdateMap.put("Position", position);
    }

    public void updatePrice(Cell cell, Map<String, String> playerDataUpdateMap) {
        String price = null;
        String owner = playerDataUpdateMap.get("Owner");
        if ("ZZ".equals(owner)) {
            price = null;
        } else {
            price = "" + cell.getNumericCellValue();
        }
        playerDataUpdateMap.put("Price", price);
    }

    public void updateContract(Cell cell, Map<String, String> playerDataUpdateMap) {

        String contract = null;
        String owner = playerDataUpdateMap.get("Owner");
        if ("ZZ".equals(owner)) {
            contract = null;
        } else {
            switch (cell.getCellType()) {
                case STRING:
                    contract = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    contract = "" + (int) cell.getNumericCellValue();
                    break;
            }
        }
        playerDataUpdateMap.put("Contract", contract);
    }

    public void updateBenefitsAndPAs (String opponentHand,
                                      String batterPitcher,
                                      Integer daysGone,
                                      boolean hitQuality,
                                      Map<String, String> playerDataUpdateMap,
                                      Map<StatKey, Double> baseballSavantStatisticalBreakdowns,
                                      Map<String, BaseballPlayerSavant> baseballPlayersSavant)
    {
        String statName;
        Double playerStat;
        Double kPctStrength = 0d;
        Double bbPctStrength = 0d;
        Double xBaStrength = 0d;
        Double xIsoStrength = 0d;
        Double xSlgStrength = 0d;
        Double contactStrength = 0d;
        Double overallStrength = 0d;
        Double statStrength = 0d;

        if(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")) != null) {

            for (int x = 0; x < 7; ++x) {
                switch (x) {
                    case 0:
                        statName = "Xobp";
                        if (!baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedObp().isEmpty()) {
                            playerStat = Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedObp());
                        } else {
                            playerStat = null;
                        }
                        break;
                    case 1:
                        statName = "Xwoba";
                        if (!baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedWoba().isEmpty()) {
                            playerStat = Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedWoba());
                        } else {
                            playerStat = null;
                        }
                        break;
                    case 2:
                        statName = "Xba";
                        if (!baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedBa().isEmpty()) {
                            playerStat = Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedBa());
                        } else {
                            playerStat = null;
                        }
                        break;
                    case 3:
                        statName = "Xslg";
                        if (!baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedSlg().isEmpty()) {
                            playerStat = Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedSlg());
                        } else {
                            playerStat = null;
                        }
                        break;
                    case 4:
                        statName = "Xiso";
                        if (!baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedSlg().isEmpty() && !baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedBa().isEmpty()) {
                            playerStat = Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedSlg()) - Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getExpectedBa());
                        } else {
                            playerStat = null;
                        }
                        break;
                    case 5:
                        statName = "KPct";
                        if (!baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getkPercent().isEmpty()) {
                            playerStat = Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getkPercent());
                        } else {
                            playerStat = null;
                        }
                        break;
                    case 6:
                        statName = "BBPct";
                        if (!baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getBbPercent().isEmpty()) {
                            playerStat = Double.parseDouble(baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getBbPercent());
                        } else {
                            playerStat = null;
                        }
                        break;
                    default:
                        statName = "";
                        playerStat = 0d;
                }

                StatKey statKeyAverage = new StatKey(opponentHand, statName, "Avg", batterPitcher, daysGone, hitQuality);
                StatKey statKeyStDev = new StatKey(opponentHand, statName, "StDev", batterPitcher, daysGone, hitQuality);

                Double statAverage = baseballSavantStatisticalBreakdowns.get(statKeyAverage);
                Double statStDev = baseballSavantStatisticalBreakdowns.get(statKeyStDev);

                if(statAverage == null){
                    System.out.println("stop here");
                }

                if (playerStat != null) {
                    if ((batterPitcher == "batter" && statName == "KPct") || (batterPitcher == "pitcher" && statName != "KPct")) {
                        statStrength = (statAverage - playerStat) / statStDev;
                    } else {
                        statStrength = (playerStat - statAverage) / statStDev;
                    }
                } else {
                    statStrength = 0d;
                }

                if(statName.equals("KPct")){
                    kPctStrength = statStrength;
                }else if(statName.equals("BBPct")){
                    bbPctStrength = statStrength;
                }else if(statName.equals("Xba")){
                    xBaStrength = statStrength;
                }else if(statName.equals("Xslg")){
                    xSlgStrength = statStrength;
                }else if(statName.equals("Xiso")){
                    xIsoStrength = statStrength;
                }

                if(statName.equals("KPct") || statName.equals("Xwoba") || statName.equals("Xiso")){
                    contactStrength +=statStrength;
                }

                if(statName.equals("BBPct")) {
                    overallStrength -= statStrength;
                }

                if(statName.equals("KPct") || statName.equals("Xslg")){
                    overallStrength += statStrength;
                }
            }

            if(hitQuality) {
                if (opponentHand.equals("L")) {  //Left  ****** here down left
                    switch (daysGone) {
                        case 0:
                            playerDataUpdateMap.put("YTD PA Left Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("YTD SO% Left Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("YTD BB% Left Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("YTD xBA Left Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("YTD xISO Left Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("YTD Contact Left Quality", contactStrength.toString());
                            playerDataUpdateMap.put("YTD Overall Left Quality", overallStrength.toString());
                            break;
                        case 15:
                            playerDataUpdateMap.put("2Week PA Left Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("2Week SO% Left Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("2Week BB% Left Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("2Week xBA Left Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("2Week xISO Left Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("2Week Contact Left Quality", contactStrength.toString());
                            playerDataUpdateMap.put("2Week Overall Left Quality", overallStrength.toString());
                            break;
                        case 45:
                            playerDataUpdateMap.put("6Week PA Left Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("6Week SO% Left Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("6Week BB% Left Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("6Week xBA Left Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("6Week xISO Left Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("6Week Contact Left Quality", contactStrength.toString());
                            playerDataUpdateMap.put("6Week Overall Left Quality", overallStrength.toString());
                            break;
                        case 90:
                            playerDataUpdateMap.put("3Month PA Left Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("3Month SO% Left Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("3Month BB% Left Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("3Month xBA Left Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("3Month xISO Left Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("3Month Contact Left Quality", contactStrength.toString());
                            playerDataUpdateMap.put("3Month Overall Left Quality", overallStrength.toString());
                            break;
                    }
                } else { //Right
                    switch (daysGone) {
                        case 0:
                            playerDataUpdateMap.put("YTD PA Right Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("YTD SO% Right Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("YTD BB% Right Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("YTD xBA Right Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("YTD xISO Right Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("YTD Contact Right Quality", contactStrength.toString());
                            playerDataUpdateMap.put("YTD Overall Right Quality", overallStrength.toString());
                            break;
                        case 15:
                            playerDataUpdateMap.put("2Week PA Right Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("2Week SO% Right Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("2Week BB% Right Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("2Week xBA Right Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("2Week xISO Right Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("2Week Contact Right Quality", contactStrength.toString());
                            playerDataUpdateMap.put("2Week Overall Right Quality", overallStrength.toString());
                            break;
                        case 45:
                            playerDataUpdateMap.put("6Week PA Right Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("6Week SO% Right Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("6Week BB% Right Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("6Week xBA Right Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("6Week xISO Right Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("6Week Contact Right Quality", contactStrength.toString());
                            playerDataUpdateMap.put("6Week Overall Right Quality", overallStrength.toString());
                            break;
                        case 90:
                            playerDataUpdateMap.put("3Month PA Right Quality", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("3Month SO% Right Quality", kPctStrength.toString());
                            playerDataUpdateMap.put("3Month BB% Right Quality", bbPctStrength.toString());
                            playerDataUpdateMap.put("3Month xBA Right Quality", xBaStrength.toString());
                            playerDataUpdateMap.put("3Month xISO Right Quality", xIsoStrength.toString());
                            playerDataUpdateMap.put("3Month Contact Right Quality", contactStrength.toString());
                            playerDataUpdateMap.put("3Month Overall Right Quality", overallStrength.toString());
                            break;
                    }
                }
            }else{
                if (opponentHand.equals("L")) {  //Left  ****** here down left
                    switch (daysGone) {
                        case 0:
                            playerDataUpdateMap.put("YTD PA Left", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("YTD SO% Left", kPctStrength.toString());
                            playerDataUpdateMap.put("YTD BB% Left", bbPctStrength.toString());
                            playerDataUpdateMap.put("YTD xBA Left", xBaStrength.toString());
                            playerDataUpdateMap.put("YTD xISO Left", xIsoStrength.toString());
                            playerDataUpdateMap.put("YTD Contact Left", contactStrength.toString());
                            playerDataUpdateMap.put("YTD Overall Left", overallStrength.toString());
                            break;
                        case 15:
                            playerDataUpdateMap.put("2Week PA Left", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("2Week SO% Left", kPctStrength.toString());
                            playerDataUpdateMap.put("2Week BB% Left", bbPctStrength.toString());
                            playerDataUpdateMap.put("2Week xBA Left", xBaStrength.toString());
                            playerDataUpdateMap.put("2Week xISO Left", xIsoStrength.toString());
                            playerDataUpdateMap.put("2Week Contact Left", contactStrength.toString());
                            playerDataUpdateMap.put("2Week Overall Left", overallStrength.toString());
                            break;
                        case 45:
                            playerDataUpdateMap.put("6Week PA Left", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("6Week SO% Left", kPctStrength.toString());
                            playerDataUpdateMap.put("6Week BB% Left", bbPctStrength.toString());
                            playerDataUpdateMap.put("6Week xBA Left", xBaStrength.toString());
                            playerDataUpdateMap.put("6Week xISO Left", xIsoStrength.toString());
                            playerDataUpdateMap.put("6Week Contact Left", contactStrength.toString());
                            playerDataUpdateMap.put("6Week Overall Left", overallStrength.toString());
                            break;
                        case 90:
                            playerDataUpdateMap.put("3Month PA Left", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("3Month SO% Left", kPctStrength.toString());
                            playerDataUpdateMap.put("3Month BB% Left", bbPctStrength.toString());
                            playerDataUpdateMap.put("3Month xBA Left", xBaStrength.toString());
                            playerDataUpdateMap.put("3Month xISO Left", xIsoStrength.toString());
                            playerDataUpdateMap.put("3Month Contact Left", contactStrength.toString());
                            playerDataUpdateMap.put("3Month Overall Left", overallStrength.toString());
                            break;
                    }
                } else { //Right
                    switch (daysGone) {
                        case 0:
                            playerDataUpdateMap.put("YTD PA Right", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("YTD SO% Right", kPctStrength.toString());
                            playerDataUpdateMap.put("YTD BB% Right", bbPctStrength.toString());
                            playerDataUpdateMap.put("YTD xBA Right", xBaStrength.toString());
                            playerDataUpdateMap.put("YTD xISO Right", xIsoStrength.toString());
                            playerDataUpdateMap.put("YTD Contact Right", contactStrength.toString());
                            playerDataUpdateMap.put("YTD Overall Right", overallStrength.toString());
                            break;
                        case 15:
                            playerDataUpdateMap.put("2Week PA Right", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("2Week SO% Right", kPctStrength.toString());
                            playerDataUpdateMap.put("2Week BB% Right", bbPctStrength.toString());
                            playerDataUpdateMap.put("2Week xBA Right", xBaStrength.toString());
                            playerDataUpdateMap.put("2Week xISO Right", xIsoStrength.toString());
                            playerDataUpdateMap.put("2Week Contact Right", contactStrength.toString());
                            playerDataUpdateMap.put("2Week Overall Right", overallStrength.toString());
                            break;
                        case 45:
                            playerDataUpdateMap.put("6Week PA Right", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("6Week SO% Right", kPctStrength.toString());
                            playerDataUpdateMap.put("6Week BB% Right", bbPctStrength.toString());
                            playerDataUpdateMap.put("6Week xBA Right", xBaStrength.toString());
                            playerDataUpdateMap.put("6Week xISO Right", xIsoStrength.toString());
                            playerDataUpdateMap.put("6Week Contact Right", contactStrength.toString());
                            playerDataUpdateMap.put("6Week Overall Right", overallStrength.toString());
                            break;
                        case 90:
                            playerDataUpdateMap.put("3Month PA Right", baseballPlayersSavant.get(playerDataUpdateMap.get("MLB Id")).getPlateAppearances());
                            playerDataUpdateMap.put("3Month SO% Right", kPctStrength.toString());
                            playerDataUpdateMap.put("3Month BB% Right", bbPctStrength.toString());
                            playerDataUpdateMap.put("3Month xBA Right", xBaStrength.toString());
                            playerDataUpdateMap.put("3Month xISO Right", xIsoStrength.toString());
                            playerDataUpdateMap.put("3Month Contact Right", contactStrength.toString());
                            playerDataUpdateMap.put("3Month Overall Right", overallStrength.toString());
                            break;
                    }
                }
            }
        }
    }

    public void updateCbsData (Map<String, String> playerDataUpdateMap,
                               List<CbsPlayer> allCbsBatters)
    {
        String playerName = playerDataUpdateMap.get("Name");
        Integer playerSpot = 99;
        if(playerDataUpdateMap.get("#") != null) {
            playerSpot = Integer.parseInt(playerDataUpdateMap.get("#"));
        }

        String team = playerDataUpdateMap.get("Team");
        String position = playerDataUpdateMap.get("Position");
        if(playerSpot < 26){
            int matches = 0;
            List<CbsPlayer> matchingPlayers = new ArrayList<>();
            String[] playerNameBreakdown = playerName.split(" ");
            int playerNameSize = playerNameBreakdown.length;
            for(CbsPlayer cbsPlayer : allCbsBatters){
                if(cbsPlayer.getTeam().equals(team)){

                    String[] cbsPlayerBreakdown = cbsPlayer.getName().split(" ");
                    int cbsPlayerNameSize = cbsPlayerBreakdown.length;

                    if(cbsPlayerNameSize == 2 && playerNameSize == 2){
                        if (cbsPlayerBreakdown[1].toUpperCase().contains(playerNameBreakdown[1].toUpperCase())){
                            matchingPlayers.add(cbsPlayer);
                        }
                    }else if(playerNameSize > 2 && cbsPlayerNameSize > 2) {
                        if (!playerNameBreakdown[2].toUpperCase().contains("JR") && !playerNameBreakdown[2].toUpperCase().contains("SR") && !playerNameBreakdown[2].toUpperCase().contains("III") && !playerNameBreakdown[2].toUpperCase().contains("IV") && !playerNameBreakdown[2].toUpperCase().contains("V")) {
                            if (cbsPlayerBreakdown[2].toUpperCase().contains(playerNameBreakdown[2].toUpperCase()) || cbsPlayerBreakdown[1].toUpperCase().contains(playerNameBreakdown[2].toUpperCase())) {
                                matchingPlayers.add(cbsPlayer);
                            }
                        } else {
                            if (cbsPlayerBreakdown[2].toUpperCase().contains(playerNameBreakdown[1].toUpperCase()) || cbsPlayerBreakdown[1].toUpperCase().contains(playerNameBreakdown[1].toUpperCase())) {
                                matchingPlayers.add(cbsPlayer);
                            }
                        }
                    }else if(playerNameSize > 2 && cbsPlayerNameSize == 2){
                        if (!playerNameBreakdown[2].toUpperCase().contains("JR") && !playerNameBreakdown[2].toUpperCase().contains("SR") && !playerNameBreakdown[2].toUpperCase().contains("III") && !playerNameBreakdown[2].toUpperCase().contains("IV") && !playerNameBreakdown[2].toUpperCase().contains("V")) {
                            if (cbsPlayerBreakdown[1].toUpperCase().contains(playerNameBreakdown[2].toUpperCase())){
                                matchingPlayers.add(cbsPlayer);
                            }
                        } else {
                            if (cbsPlayerBreakdown[1].toUpperCase().contains(playerNameBreakdown[1].toUpperCase())) {
                                matchingPlayers.add(cbsPlayer);
                            }
                        }
                    }else if(playerNameSize == 2 && cbsPlayerNameSize > 2){
                        if (cbsPlayerBreakdown[2].toUpperCase().contains(playerNameBreakdown[1].toUpperCase()) || cbsPlayerBreakdown[1].toUpperCase().contains(playerNameBreakdown[1].toUpperCase())) {
                            matchingPlayers.add(cbsPlayer);
                        }
                    }else{
                        System.out.println("weird ass name " + playerName);
                    }
                }
            }

            if(matchingPlayers.size() == 1){
                playerDataUpdateMap.put("Owner", matchingPlayers.get(0).getOwner());
                playerDataUpdateMap.put("Position",  matchingPlayers.get(0).getPosition());
                playerDataUpdateMap.put("Contract",  matchingPlayers.get(0).getContract());
                playerDataUpdateMap.put("Price",  matchingPlayers.get(0).getSalary());
                return;
            } else if(matchingPlayers.size() == 0) {
                System.out.println("No match for " + playerName);
            } else {
                System.out.println(playerName + " has " + matchingPlayers.size() + " matches");
                for(CbsPlayer cbsPlayer : matchingPlayers){
                    System.out.println(cbsPlayer.getName());
                    String[] cbsPlayerBreakdown = cbsPlayer.getName().split(" ");
                    if(cbsPlayerBreakdown[0].contains(playerNameBreakdown[0])){
                        System.out.println(cbsPlayer.getName() + " matches " + playerName);
                        playerDataUpdateMap.put("Owner", cbsPlayer.getOwner());
                        playerDataUpdateMap.put("Position",  cbsPlayer.getPosition());
                        playerDataUpdateMap.put("Contract",  cbsPlayer.getContract());
                        playerDataUpdateMap.put("Price",  cbsPlayer.getSalary());
                        return;
                    }
                }
                System.out.println("No one matched " + playerName);
            }
        }
    }
}
