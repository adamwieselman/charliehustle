package com.charliehustle.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.BaseballPlayer;

public class BaseballPlayerDataUpdateServiceHelperTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @Mock
    Cell cell;

    @InjectMocks
    public BaseballPlayerDataUpdateServiceHelper baseballPlayerDataUpdateServiceHelper = new BaseballPlayerDataUpdateServiceHelper();

    Map<String, String> playerMap;
    BaseballPlayer baseballPlayer;

    @Before
    public void before() {
        playerMap = new HashMap<>();
        baseballPlayer = new BaseballPlayer();
        baseballPlayer.setAge("10");
        baseballPlayer.setHanded("Left");
        baseballPlayer.setInjuryDate("2001-01-10");
        baseballPlayer.setInjuryNotes("injury");
        baseballPlayer.setMlbEta("mlbEta");
        baseballPlayer.setPlayerName("playername");
        baseballPlayer.setOrganizationalRank("orgRank");
        baseballPlayer.setOverallRank("overallRank");
        baseballPlayer.setPlatoon("platoon");
        baseballPlayer.setPosition("position");
        baseballPlayer.setPlayingLevel("playingLevel");
        baseballPlayer.setRole("role");
        baseballPlayer.setTeamId("teamId");
    }

    @Test
    public void testPlayerDataUpdateMapInitialSetup() {
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(playerMap);
        Map<String, String> map = baseballPlayerDataUpdateServiceHelper.playerDataUpdateMapInitialSetup(baseballPlayer);
        assertEquals("Left", map.get("Hand"));
        assertEquals("position", map.get("Position"));
        assertEquals("10", map.get("Age"));
        assertEquals("overallRank", map.get("MLB Overall Rank"));
        assertEquals("orgRank", map.get("MLB Organizational Rank"));
        assertEquals("platoon", map.get("Platoon"));
    }

    @Test
    public void testUpdateOP_SP_willReturnP() {
        baseballPlayer.setPosition("SP");
        baseballPlayerDataUpdateServiceHelper.updateOP(baseballPlayer, playerMap);
        assertEquals("P", playerMap.get("OP"));
    }

    @Test
    public void testUpdateOP_RP_willReturnP() {
        baseballPlayer.setPosition("RP");
        baseballPlayerDataUpdateServiceHelper.updateOP(baseballPlayer, playerMap);
        assertEquals("P", playerMap.get("OP"));
    }

    @Test
    public void testUpdateOP_other_willReturnO() {
        baseballPlayer.setPosition("3B");
        baseballPlayerDataUpdateServiceHelper.updateOP(baseballPlayer, playerMap);
        assertEquals("O", playerMap.get("OP"));
    }

    @Test
    public void testUpdateRole() {
        baseballPlayer.setRole("1");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("1", playerMap.get("#"));

        baseballPlayer.setRole("2");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("2", playerMap.get("#"));

        baseballPlayer.setRole("3");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("3", playerMap.get("#"));

        baseballPlayer.setRole("4");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("4", playerMap.get("#"));

        baseballPlayer.setRole("5");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("5", playerMap.get("#"));

        baseballPlayer.setRole("6");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("6", playerMap.get("#"));

        baseballPlayer.setRole("7");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("7", playerMap.get("#"));

        baseballPlayer.setRole("8");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("8", playerMap.get("#"));

        baseballPlayer.setRole("9");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("9", playerMap.get("#"));

        baseballPlayer.setRole("Bench");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("10", playerMap.get("#"));

        baseballPlayer.setRole("SP1");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("11", playerMap.get("#"));

        baseballPlayer.setRole("SP2");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("12", playerMap.get("#"));

        baseballPlayer.setRole("SP3");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("13", playerMap.get("#"));

        baseballPlayer.setRole("SP4");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("14", playerMap.get("#"));

        baseballPlayer.setRole("SP5");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("15", playerMap.get("#"));

        baseballPlayer.setRole("SP6");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("15", playerMap.get("#"));

        baseballPlayer.setRole("SPOT");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("15", playerMap.get("#"));

        baseballPlayer.setRole("CL");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("16", playerMap.get("#"));

        baseballPlayer.setRole("SU8");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("17", playerMap.get("#"));

        baseballPlayer.setRole("SU7");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("17", playerMap.get("#"));

        baseballPlayer.setRole("SU");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("17", playerMap.get("#"));

        baseballPlayer.setRole("MID");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("18", playerMap.get("#"));

        baseballPlayer.setRole("LR");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("18", playerMap.get("#"));

        baseballPlayer.setRole("Inj");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("19", playerMap.get("#"));

        baseballPlayer.setRole("AAA");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("21", playerMap.get("#"));

        baseballPlayer.setRole("AA");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("22", playerMap.get("#"));

        baseballPlayer.setRole("A+");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("23", playerMap.get("#"));

        baseballPlayer.setRole("A");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("24", playerMap.get("#"));

        baseballPlayer.setRole("A-");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("24", playerMap.get("#"));

        baseballPlayer.setRole("Rk");
        baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        assertEquals("25", playerMap.get("#"));

        //baseballPlayer.setRole("Blah");
        //baseballPlayerDataUpdateServiceHelper.updateRole(baseballPlayer, playerMap);
        //assertEquals("33", playerMap.get("#"));
    }

    @Test
    public void testUpdateTeam() {
        baseballPlayer.setTeamId("1");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("LAA", playerMap.get("Team"));

        baseballPlayer.setTeamId("2");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("BAL", playerMap.get("Team"));

        baseballPlayer.setTeamId("3");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("BOS", playerMap.get("Team"));

        baseballPlayer.setTeamId("4");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("CHW", playerMap.get("Team"));

        baseballPlayer.setTeamId("5");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("CLE", playerMap.get("Team"));

        baseballPlayer.setTeamId("6");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("DET", playerMap.get("Team"));

        baseballPlayer.setTeamId("7");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("KC", playerMap.get("Team"));

        baseballPlayer.setTeamId("8");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("MIN", playerMap.get("Team"));

        baseballPlayer.setTeamId("9");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("NYY", playerMap.get("Team"));

        baseballPlayer.setTeamId("10");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("OAK", playerMap.get("Team"));

        baseballPlayer.setTeamId("11");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("SEA", playerMap.get("Team"));

        baseballPlayer.setTeamId("12");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("TB", playerMap.get("Team"));

        baseballPlayer.setTeamId("13");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("TEX", playerMap.get("Team"));

        baseballPlayer.setTeamId("14");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("TOR", playerMap.get("Team"));

        baseballPlayer.setTeamId("15");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("ARI", playerMap.get("Team"));

        baseballPlayer.setTeamId("16");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("ATL", playerMap.get("Team"));

        baseballPlayer.setTeamId("17");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("CHC", playerMap.get("Team"));

        baseballPlayer.setTeamId("18");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("CIN", playerMap.get("Team"));

        baseballPlayer.setTeamId("19");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("COL", playerMap.get("Team"));

        baseballPlayer.setTeamId("20");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("MIA", playerMap.get("Team"));

        baseballPlayer.setTeamId("21");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("HOU", playerMap.get("Team"));

        baseballPlayer.setTeamId("22");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("LAD", playerMap.get("Team"));

        baseballPlayer.setTeamId("23");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("MIL", playerMap.get("Team"));

        baseballPlayer.setTeamId("24");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("WAS", playerMap.get("Team"));

        baseballPlayer.setTeamId("25");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("NYM", playerMap.get("Team"));

        baseballPlayer.setTeamId("26");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("PHI", playerMap.get("Team"));

        baseballPlayer.setTeamId("27");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("PIT", playerMap.get("Team"));

        baseballPlayer.setTeamId("28");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("STL", playerMap.get("Team"));

        baseballPlayer.setTeamId("29");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("SD", playerMap.get("Team"));

        baseballPlayer.setTeamId("30");
        baseballPlayerDataUpdateServiceHelper.updateTeam(baseballPlayer, playerMap);
        assertEquals("SF", playerMap.get("Team"));
    }

    @Test
    public void testUpdateOwner_Waivered() {
        Mockito.when(cell.getStringCellValue()).thenReturn("W (1/14)");
        baseballPlayerDataUpdateServiceHelper.updateOwner(cell, playerMap);
        assertEquals("ZZ", playerMap.get("Owner"));
    }

    @Test
    public void testUpdateOwner_Value() {
        Mockito.when(cell.getStringCellValue()).thenReturn("WEST");
        baseballPlayerDataUpdateServiceHelper.updateOwner(cell, playerMap);
        assertEquals("WEST", playerMap.get("Owner"));
    }

    @Test
    public void testGetPlayerName_Null_returnNull() {
        Mockito.when(cell.getStringCellValue()).thenReturn(null);
        String playerName = baseballPlayerDataUpdateServiceHelper.getPlayerName(cell);
        assertNull(playerName);
    }

    @Test
    public void testGetPlayerName_nonCatcher_returnName() {
        Mockito.when(cell.getStringCellValue()).thenReturn("WEST 1B | OAK");
        String playerName = baseballPlayerDataUpdateServiceHelper.getPlayerName(cell);
        assertEquals("WEST", playerName);
    }

    @Test
    public void testGetPlayerName_Catcher_returnName() {
        Mockito.when(cell.getStringCellValue()).thenReturn("WEST C | OAK");
        String playerName = baseballPlayerDataUpdateServiceHelper.getPlayerName(cell);
        assertEquals("WEST", playerName);
    }

    @Test
    public void testUpdatePosition(){
        Mockito.when(cell.getStringCellValue()).thenReturn("position");
        baseballPlayerDataUpdateServiceHelper.updatePosition(cell, playerMap);
        assertEquals("position", playerMap.get("Position"));
    }

    @Test
    public void testUpdatePrice_ZZ(){
        Mockito.when(cell.getNumericCellValue()).thenReturn(25.0);
        playerMap.put("Owner", "ZZ");
        baseballPlayerDataUpdateServiceHelper.updatePrice(cell, playerMap);
        assertNull(playerMap.get("Price"));
    }

    @Test
    public void testUpdatePrice_Owner(){
        Mockito.when(cell.getNumericCellValue()).thenReturn(59.6);
        playerMap.put("Owner", "Adam");
        baseballPlayerDataUpdateServiceHelper.updatePrice(cell, playerMap);
        assertEquals("59.6", playerMap.get("Price"));
    }

    @Test
    public void testUpdateContract_ZZ(){
        Mockito.when(cell.getStringCellValue()).thenReturn("ZZ");
        playerMap.put("Owner", "ZZ");
        baseballPlayerDataUpdateServiceHelper.updateContract(cell, playerMap);
        assertNull(playerMap.get("Contract"));
    }

    @Test
    public void testUpdateContract_String(){
        Mockito.when(cell.getCellType()).thenReturn(CellType.STRING);
        Mockito.when(cell.getStringCellValue()).thenReturn("Adam");
        playerMap.put("Owner", "Adam");
        baseballPlayerDataUpdateServiceHelper.updateContract(cell, playerMap);
        assertEquals("Adam", playerMap.get("Contract"));
    }

    @Test
    public void testUpdateContract_Numeric(){
        Mockito.when(cell.getCellType()).thenReturn(CellType.NUMERIC);
        Mockito.when(cell.getNumericCellValue()).thenReturn(2.0);
        playerMap.put("Owner", "Badger");
        baseballPlayerDataUpdateServiceHelper.updateContract(cell, playerMap);
        assertEquals("2", playerMap.get("Contract"));
    }
}