package com.charliehustle.services;


import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.models.BaseballPlayer;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class BaseballPlayerDataUpdateServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @Mock
    MicrosoftObjectFactory microsoftObjectFactory;

    @Mock
    XSSFWorkbook workbook;

    @Mock
    XSSFSheet sheet;

    @Mock
    Table rosterTable;

    @Mock
    Row row;

    @Mock
    org.apache.poi.ss.usermodel.Row excelRow;

    @Mock
    File file;

    @Mock
    FileInputStream fis;

    @Mock
    Iterator<Row> iterator;

    @Mock
    Iterator<org.apache.poi.ss.usermodel.Row> excelRowIterator;

    @Mock
    Iterator<Cell> cellIterator;

    @Mock
    Cell cell;

    @Mock
    Cell cell2;

    @Mock
    AccessDatabaseService accessDatabaseService;

    @Mock
    BaseballPlayerDataUpdateServiceHelper baseballPlayerDataUpdateServiceHelper;

    @InjectMocks
    public BaseballPlayerDataUpdateService baseballPlayerDataUpdateService = new BaseballPlayerDataUpdateService();

    @Test
    public void testSetupRosterMaps_noAlt() throws IOException {
        Map<String, Row> currentRows = new HashMap<>();
        Map<String, Row> altCurrentRows = new HashMap<>();
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        Mockito.when(rosterTable.iterator()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true).thenReturn(false);
        Mockito.when(iterator.next()).thenReturn(row);
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerDataUpdateMap);
        Mockito.doNothing().when(accessDatabaseService).updateRow(rosterTable,row,playerDataUpdateMap);
        Mockito.when(row.getString("Name")).thenReturn("Adam");
        Mockito.when(row.getString("Alternate Name")).thenReturn(null);
        baseballPlayerDataUpdateService.setupRosterMaps(rosterTable, currentRows, altCurrentRows);
        assertEquals(1, currentRows.size());
    }

    @Test
    public void testSetupRosterMaps_alt() throws IOException {
        Map<String, Row> currentRows = new HashMap<>();
        Map<String, Row> altCurrentRows = new HashMap<>();
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        Mockito.when(rosterTable.iterator()).thenReturn(iterator);
        Mockito.when(iterator.hasNext()).thenReturn(true).thenReturn(false);
        Mockito.when(iterator.next()).thenReturn(row);
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerDataUpdateMap);
        Mockito.doNothing().when(accessDatabaseService).updateRow(rosterTable,row,playerDataUpdateMap);
        Mockito.when(row.getString("Name")).thenReturn("Adam");
        Mockito.when(row.getString("Alternate Name")).thenReturn("OtherAdam");
        baseballPlayerDataUpdateService.setupRosterMaps(rosterTable, currentRows, altCurrentRows);
        assertEquals(1, currentRows.size());
        assertEquals(1, altCurrentRows.size());
    }

    @Test
    public void testAddFanGraphsData_update() throws IOException {
        Map<String, Row> currentRows = new HashMap<>();
        currentRows.put("playername", row);
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        BaseballPlayer baseballPlayer = new BaseballPlayer();
        baseballPlayer.setPlayerName("playername");
        List<BaseballPlayer> players = new ArrayList<>();
        players.add(baseballPlayer);
        Mockito.when(baseballPlayerDataUpdateServiceHelper.playerDataUpdateMapInitialSetup(baseballPlayer)).thenReturn(playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateOP(baseballPlayer, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateRole(baseballPlayer, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateTeam(baseballPlayer, playerDataUpdateMap);
        Mockito.doNothing().when(accessDatabaseService).updateRow(rosterTable, row, playerDataUpdateMap);

        baseballPlayerDataUpdateService.addFanGraphsData(rosterTable, currentRows, players);
    }

    @Test
    public void testAddFanGraphsData_add() throws IOException {
        Map<String, Row> currentRows = new HashMap<>();
        currentRows.put("playername2", row);
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        BaseballPlayer baseballPlayer = new BaseballPlayer();
        baseballPlayer.setPlayerName("playername");
        List<BaseballPlayer> players = new ArrayList<>();
        players.add(baseballPlayer);
        Mockito.when(baseballPlayerDataUpdateServiceHelper.playerDataUpdateMapInitialSetup(baseballPlayer)).thenReturn(playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateOP(baseballPlayer, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateRole(baseballPlayer, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateTeam(baseballPlayer, playerDataUpdateMap);
        Mockito.doNothing().when(accessDatabaseService).addRowFantasyBaseball(rosterTable, playerDataUpdateMap);

        baseballPlayerDataUpdateService.addFanGraphsData(rosterTable, currentRows, players);
    }

    @Test
    public void testAddCbsData_playerNotFound() throws IOException {
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        Map<String, Row> currentRows = new HashMap<>();
        currentRows.put("playername", row);
        Map<String, Row> altCurrentRows = new HashMap<>();
        altCurrentRows.put("playername", row);
        playerDataUpdateMap.put("Owner", "Adam");
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerDataUpdateMap);
        Mockito.when(basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\" + "players.xlsx")).thenReturn(file);
        Mockito.when(basicObjectFactory.createFileInputStream(file)).thenReturn(fis);
        Mockito.when(microsoftObjectFactory.createXSSFWorkbook(fis)).thenReturn(workbook);
        Mockito.when(microsoftObjectFactory.createXSSFSheet(workbook, 0)).thenReturn(sheet);
        Mockito.when(sheet.iterator()).thenReturn(excelRowIterator);
        Mockito.when(excelRowIterator.hasNext()).thenReturn(true).thenReturn(false);
        Mockito.when(excelRowIterator.next()).thenReturn(excelRow);
        Mockito.when(excelRow.cellIterator()).thenReturn(cellIterator);
        Mockito.when(cellIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        Mockito.when(cellIterator.next()).thenReturn(cell);
        Mockito.when(cell.getStringCellValue()).thenReturn("player");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateOwner(cell, playerDataUpdateMap);
        Mockito.when(baseballPlayerDataUpdateServiceHelper.getPlayerName(cell)).thenReturn("player");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePosition(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePrice(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateContract(cell, playerDataUpdateMap);

        String playerName = baseballPlayerDataUpdateService.addCbsData(rosterTable, currentRows, altCurrentRows, "players");
        assertEquals("player Adam" + "\n", playerName);
    }

    @Test
    public void testAddCbsData_playerFoundRegular() throws IOException {
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        Map<String, Row> currentRows = new HashMap<>();
        currentRows.put("player", row);
        Map<String, Row> altCurrentRows = new HashMap<>();
        altCurrentRows.put("playername", row);
        playerDataUpdateMap.put("Owner", "Adam");
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerDataUpdateMap);
        Mockito.when(basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\" + "players.xlsx")).thenReturn(file);
        Mockito.when(basicObjectFactory.createFileInputStream(file)).thenReturn(fis);
        Mockito.when(microsoftObjectFactory.createXSSFWorkbook(fis)).thenReturn(workbook);
        Mockito.when(microsoftObjectFactory.createXSSFSheet(workbook, 0)).thenReturn(sheet);
        Mockito.when(sheet.iterator()).thenReturn(excelRowIterator);
        Mockito.when(excelRowIterator.hasNext()).thenReturn(true).thenReturn(false);
        Mockito.when(excelRowIterator.next()).thenReturn(excelRow);
        Mockito.when(excelRow.cellIterator()).thenReturn(cellIterator);
        Mockito.when(cellIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        Mockito.when(cellIterator.next()).thenReturn(cell);
        Mockito.when(cell.getStringCellValue()).thenReturn("player");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateOwner(cell, playerDataUpdateMap);
        Mockito.when(baseballPlayerDataUpdateServiceHelper.getPlayerName(cell)).thenReturn("player");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePosition(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePrice(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateContract(cell, playerDataUpdateMap);

        String playerName = baseballPlayerDataUpdateService.addCbsData(rosterTable, currentRows, altCurrentRows, "players");
        assertEquals("", playerName);
    }

    @Test
    public void testAddCbsData_playerFoundAlt() throws IOException {
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        Map<String, Row> currentRows = new HashMap<>();
        currentRows.put("playername", row);
        Map<String, Row> altCurrentRows = new HashMap<>();
        altCurrentRows.put("player", row);
        playerDataUpdateMap.put("Owner", "Adam");
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerDataUpdateMap);
        Mockito.when(basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\" + "players.xlsx")).thenReturn(file);
        Mockito.when(basicObjectFactory.createFileInputStream(file)).thenReturn(fis);
        Mockito.when(microsoftObjectFactory.createXSSFWorkbook(fis)).thenReturn(workbook);
        Mockito.when(microsoftObjectFactory.createXSSFSheet(workbook, 0)).thenReturn(sheet);
        Mockito.when(sheet.iterator()).thenReturn(excelRowIterator);
        Mockito.when(excelRowIterator.hasNext()).thenReturn(true).thenReturn(false);
        Mockito.when(excelRowIterator.next()).thenReturn(excelRow);
        Mockito.when(excelRow.cellIterator()).thenReturn(cellIterator);
        Mockito.when(cellIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        Mockito.when(cellIterator.next()).thenReturn(cell);
        Mockito.when(cell.getStringCellValue()).thenReturn("player");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateOwner(cell, playerDataUpdateMap);
        Mockito.when(baseballPlayerDataUpdateServiceHelper.getPlayerName(cell)).thenReturn("player");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePosition(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePrice(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateContract(cell, playerDataUpdateMap);

        String playerName = baseballPlayerDataUpdateService.addCbsData(rosterTable, currentRows, altCurrentRows, "players");
        assertEquals("", playerName);
    }

    @Test
    public void testAddCbsData_skipRow_playerNotFound() throws IOException {
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        Map<String, Row> currentRows = new HashMap<>();
        currentRows.put("playername", row);
        Map<String, Row> altCurrentRows = new HashMap<>();
        altCurrentRows.put("playername", row);
        playerDataUpdateMap.put("Owner", "Adam");
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerDataUpdateMap);
        Mockito.when(basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\" + "players.xlsx")).thenReturn(file);
        Mockito.when(basicObjectFactory.createFileInputStream(file)).thenReturn(fis);
        Mockito.when(microsoftObjectFactory.createXSSFWorkbook(fis)).thenReturn(workbook);
        Mockito.when(microsoftObjectFactory.createXSSFSheet(workbook, 0)).thenReturn(sheet);
        Mockito.when(sheet.iterator()).thenReturn(excelRowIterator);
        Mockito.when(excelRowIterator.hasNext()).thenReturn(true).thenReturn(false);
        Mockito.when(excelRowIterator.next()).thenReturn(excelRow);
        Mockito.when(excelRow.cellIterator()).thenReturn(cellIterator);
        Mockito.when(cellIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        Mockito.when(cellIterator.next()).thenReturn(cell);
        Mockito.when(cell.getStringCellValue()).thenReturn("player");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateOwner(cell, playerDataUpdateMap);
        Mockito.when(baseballPlayerDataUpdateServiceHelper.getPlayerName(cell)).thenReturn(null);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePosition(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePrice(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateContract(cell, playerDataUpdateMap);

        String playerName = baseballPlayerDataUpdateService.addCbsData(rosterTable, currentRows, altCurrentRows, "players");
        assertEquals("", playerName);
    }

    @Test
    public void testAddCbsData_skipRow_nonPlayerRow() throws IOException {
        Map<String, String> playerDataUpdateMap = new HashMap<>();
        Map<String, Row> currentRows = new HashMap<>();
        currentRows.put("playername", row);
        Map<String, Row> altCurrentRows = new HashMap<>();
        altCurrentRows.put("playername", row);
        playerDataUpdateMap.put("Owner", "Adam");
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerDataUpdateMap);
        Mockito.when(basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\" + "players.xlsx")).thenReturn(file);
        Mockito.when(basicObjectFactory.createFileInputStream(file)).thenReturn(fis);
        Mockito.when(microsoftObjectFactory.createXSSFWorkbook(fis)).thenReturn(workbook);
        Mockito.when(microsoftObjectFactory.createXSSFSheet(workbook, 0)).thenReturn(sheet);
        Mockito.when(sheet.iterator()).thenReturn(excelRowIterator);
        Mockito.when(excelRowIterator.hasNext()).thenReturn(true).thenReturn(false);
        Mockito.when(excelRowIterator.next()).thenReturn(excelRow);
        Mockito.when(excelRow.cellIterator()).thenReturn(cellIterator);
        Mockito.when(cellIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        Mockito.when(cellIterator.next()).thenReturn(cell);
        Mockito.when(cell.getStringCellValue()).thenReturn("Batters");
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateOwner(cell, playerDataUpdateMap);
        Mockito.when(baseballPlayerDataUpdateServiceHelper.getPlayerName(cell)).thenReturn(null);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePosition(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updatePrice(cell, playerDataUpdateMap);
        Mockito.doNothing().when(baseballPlayerDataUpdateServiceHelper).updateContract(cell, playerDataUpdateMap);

        String playerName = baseballPlayerDataUpdateService.addCbsData(rosterTable, currentRows, altCurrentRows, "players");
        assertEquals("", playerName);
    }
}