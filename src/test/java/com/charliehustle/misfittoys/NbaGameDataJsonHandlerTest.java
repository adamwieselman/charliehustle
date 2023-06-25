package com.charliehustle.misfittoys;

import com.charliehustle.factories.JsonObjectFactory;
import com.charliehustle.models.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;

public class NbaGameDataJsonHandlerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    JsonObjectFactory jsonObjectFactory;

    @Mock
    GameDataJsonHandlerHelper gameDataJsonHandlerHelper;

    @Mock
    JSONObject jsonObject;

    @Mock
    JSONArray jsonArrayEvents;

    @Mock
    JSONArray jsonArrayCompetitions;

    @Mock
    VenueJsonHandler venueJsonHandler;

    @Mock
    TeamJsonHandler teamJsonHandler;

    @Mock
    ConferenceJsonHandler conferenceJsonHandler;

    @Mock
    ConferenceTeamJsonHandler conferenceTeamJsonHandler;

    @Mock
    TeamVenueJsonHandler teamVenueJsonHandler;

    @Mock
    GameDataTeamJsonHandler gameDataTeamJsonHandler;

    @Mock
    GameDataService gameDataService;

    @InjectMocks
    public GameDataJsonHandler gameDataJsonHandler = new GameDataJsonHandler();

    @Test
    public void testReturnGameDataInfoRecords_badWebsiteData_shouldThrowException() throws Exception {

        Mockito.when(jsonObjectFactory.createJSONObject("badData")).thenThrow(new Exception("Bad data object badData"));

        try {
            gameDataJsonHandler.processGameDataInfo("badData");
            fail();
        }catch(Exception e){
            assertEquals("Bad data object badData", e.getMessage());
        }
    }

    @Test
    public void testReturnGameDataInfoRecords_objectDoesntExist_shouldThrowException() throws Exception {

        JSONObject jsonObject = new JSONObject("{content:{events:[{}]}}");
        Mockito.when(jsonObjectFactory.createJSONObject("{content:{events:[{}]}}")).thenReturn(jsonObject);

        try {
            gameDataJsonHandler.processGameDataInfo("{content:{events:[{}]}}");
            fail();
        }catch(Exception e){
            assertEquals("JSONObject[\"sbData\"] not found.", e.getMessage());
        }
    }

    @Test
    public void testProcessGameDataInfo_contestIsNotFinal_skipGame() throws Exception {
        CurrentGameStatus currentGameStatus = new CurrentGameStatus();
        currentGameStatus.setCurrentGameStatus("STATUS_NOT_STARTED");
        Mockito.when(jsonObjectFactory.createJSONObject("fakeJson")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("content")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("sbData")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONArray("events")).thenReturn(jsonArrayEvents);
        Mockito.when(jsonArrayEvents.length()).thenReturn(1);
        Mockito.when(jsonArrayEvents.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONArray("competitions")).thenReturn(jsonArrayCompetitions);
        Mockito.when(jsonArrayCompetitions.getJSONObject(0)).thenReturn(jsonObject);
        Mockito.when(gameDataJsonHandlerHelper.createGameStatus(jsonObject)).thenReturn(currentGameStatus);

        try {
            gameDataJsonHandler.processGameDataInfo("fakeJson");
            Mockito.verify(gameDataJsonHandlerHelper, times(0)).createGameDataObject(jsonObject);
        }catch(Exception e){
            fail();
        }
    }

    @Test
    public void testProcessGameDataInfo_contestIsFinal_GameFound_happyPath() throws Exception {
        CurrentGameStatus currentGameStatus = new CurrentGameStatus();
        currentGameStatus.setCurrentGameStatus("STATUS_FINAL");
        Mockito.when(jsonObjectFactory.createJSONObject("fakeJson")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("content")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("sbData")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getString("id")).thenReturn("12345");
        Mockito.when(jsonObject.getJSONArray("events")).thenReturn(jsonArrayEvents);
        Mockito.when(jsonArrayEvents.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONArray("competitions")).thenReturn(jsonArrayCompetitions);
        Mockito.when(jsonArrayEvents.length()).thenReturn(1);
        Mockito.when(jsonArrayCompetitions.getJSONObject(0)).thenReturn(jsonObject);
        Mockito.when(gameDataJsonHandlerHelper.createGameStatus(jsonObject)).thenReturn(currentGameStatus);
        Mockito.when(gameDataService.findByEspnGameId(Mockito.anyString())).thenReturn(new GameData());
        try {
            gameDataJsonHandler.processGameDataInfo("fakeJson");
            Mockito.verify(gameDataJsonHandlerHelper, times(0)).createGameDataObject(jsonObject);
        }catch(Exception e){
            fail();
        }
    }

    @Test
    public void testProcessGameDataInfo_contestIsFinal() throws Exception {
        CurrentGameStatus currentGameStatus = new CurrentGameStatus();
        GameData gameData = new GameData();
        Venue venue = new Venue();
        List<Team> teams = new ArrayList<>();
        List<Conference> conferences = new ArrayList<>();
        currentGameStatus.setCurrentGameStatus("STATUS_FINAL");
        Mockito.when(jsonObjectFactory.createJSONObject("fakeJson")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("content")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("sbData")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONArray("events")).thenReturn(jsonArrayEvents);
        Mockito.when(jsonArrayEvents.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
        Mockito.when(jsonArrayEvents.length()).thenReturn(1);
        Mockito.when(jsonObject.getJSONArray("competitions")).thenReturn(jsonArrayCompetitions);
        Mockito.when(jsonArrayCompetitions.getJSONObject(0)).thenReturn(jsonObject);
        Mockito.when(gameDataJsonHandlerHelper.createGameStatus(jsonObject)).thenReturn(currentGameStatus);
        Mockito.when(gameDataService.findByEspnGameId(Mockito.anyString())).thenReturn(null);
        Mockito.when(gameDataJsonHandlerHelper.createGameDataObject(jsonObject)).thenReturn(gameData);
        Mockito.when(gameDataService.saveGameDataInfo(gameData)).thenReturn(gameData);
        Mockito.when(venueJsonHandler.processVenueInfo(jsonObject)).thenReturn(venue);
        Mockito.when(teamJsonHandler.processTeamInfo(jsonObject)).thenReturn(teams);
        Mockito.when(conferenceJsonHandler.processConferenceInfo(jsonObject, jsonObject)).thenReturn(conferences);
        Mockito.doNothing().when(conferenceTeamJsonHandler).processConferenceTeamInfo(teams, conferences, gameData);
        Mockito.doNothing().when(teamVenueJsonHandler).processTeamVenueInfo(teams, venue, gameData);
        Mockito.doNothing().when(gameDataTeamJsonHandler).processGameDataTeamInfo(teams, gameData);

        try {
            gameDataJsonHandler.processGameDataInfo("fakeJson");
            Mockito.verify(venueJsonHandler, times(1)).processVenueInfo(jsonObject);
            Mockito.verify(teamJsonHandler, times(1)).processTeamInfo(jsonObject);
            Mockito.verify(conferenceJsonHandler, times(1)).processConferenceInfo(jsonObject, jsonObject);
            Mockito.verify(conferenceTeamJsonHandler, times(1)).processConferenceTeamInfo(teams, conferences, gameData);
            Mockito.verify(teamVenueJsonHandler, times(1)).processTeamVenueInfo(teams, venue, gameData);
            Mockito.verify(gameDataTeamJsonHandler, times(1)).processGameDataTeamInfo(teams, gameData);
        }catch(Exception e){
            fail();
        }
    }

//    @Test
//    public void testProcessGameDataInfo_contestIsFinal_noGameDataInfo_Venue_Teams_Conferences_Found() throws Exception {
//        CurrentGameStatus currentGameStatus = new CurrentGameStatus();
//        GameDataInfo gameDataInfo = new GameDataInfo();
//        Team team = new Team();
//        Conference conference = new Conference();
//        List<ConferenceTeam> conferenceTeams = new ArrayList<>();
//        ConferenceTeam conferenceTeam = new ConferenceTeam();
//        conferenceTeams.add(conferenceTeam);
//        currentGameStatus.setCurrentGameStatus("STATUS_FINAL");
//        Mockito.when(jsonObjectFactory.createJSONObject("fakeJson")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONObject("content")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONObject("sbData")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONArray("events")).thenReturn(jsonArrayEvents);
//        Mockito.when(jsonArrayEvents.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
//        Mockito.when(jsonArrayTeams.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONArray("competitions")).thenReturn(jsonArrayCompetitions);
//        Mockito.when(jsonObject.getJSONArray("competitors")).thenReturn(jsonArrayTeams);
//        Mockito.when(jsonObject.getJSONObject("venue")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONObject("team")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getString("id")).thenReturn("22334");
//        Mockito.when(jsonObject.getString("conferenceId")).thenReturn("304");
//        Mockito.when(venueService.findByEspnVenueId(Mockito.anyString())).thenReturn(new Venue());
//        Mockito.when(jsonArrayEvents.length()).thenReturn(1);
//        Mockito.when(jsonArrayTeams.length()).thenReturn(2);
//        Mockito.when(jsonArrayCompetitions.getJSONObject(0)).thenReturn(jsonObject);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createGameStatus(jsonObject)).thenReturn(currentGameStatus);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createGameDataInfoObject(jsonObject)).thenReturn(gameDataInfo);
//        Mockito.when(gameDataInfoService.findByEspnGameId(Mockito.anyString())).thenReturn(null);
//        Mockito.when(gameDataInfoService.saveGameDataInfo(Mockito.any(GameDataInfo.class))).thenReturn(gameDataInfo);
//        Mockito.when(teamService.findByEspnTeamId(Mockito.anyString())).thenReturn(team);
//        Mockito.when(conferenceService.findByEspnConferenceId(Mockito.anyString())).thenReturn(conference);
//        Mockito.when(conferenceTeamService.findByEspnTeamIdOrderByStartDate(team)).thenReturn(conferenceTeams);
//
//        try {
//            gameDataInfoJsonHandler.processGameDataInfo("fakeJson");
//            Mockito.verify(gameDataInfoJsonHandlerHelper, times(1)).createGameDataInfoObject(jsonObject);
//            Mockito.verify(gameDataInfoJsonHandlerHelper, times(0)).createVenueObject(jsonObject);
//            Mockito.verify(gameDataInfoJsonHandlerHelper, times(0)).createTeamObject(jsonObject, 0);
//            Mockito.verify(gameDataInfoJsonHandlerHelper, times(0)).createTeamObject(jsonObject, 1);
//            Mockito.verify(gameDataInfoJsonHandlerHelper, times(0)).createConferenceObject(jsonObject, 304);
//            Mockito.verify(gameDataInfoJsonHandlerHelper, times(0)).createConferenceTeamObject(conference, team, gameDataInfo);
//        }catch(Exception e){
//            fail();
//        }
//    }

}

//        Mockito.when(jsonObject.getJSONObject("venue")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONObject("team")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONArray("competitors")).thenReturn(jsonArrayTeams);
//        Mockito.when(jsonObject.getJSONObject("altSbDropdown")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONArray("options")).thenReturn(jsonArrayConferences);
//        Mockito.when(jsonObject.getString("conferenceId")).thenReturn("304").thenReturn("304").thenReturn("291");
//        Mockito.when(venueService.findByEspnVenueId(Mockito.anyString())).thenReturn(null);
//        Mockito.when(teamService.findByEspnTeamId(Mockito.anyString())).thenReturn(null);
//        Mockito.when(conferenceService.findByEspnConferenceId(Mockito.anyString())).thenReturn(null);
//        Mockito.when(jsonArrayEvents.length()).thenReturn(1);
//        Mockito.when(jsonArrayTeams.length()).thenReturn(2);
//        Mockito.when(jsonArrayConferences.length()).thenReturn(1);
//        Mockito.when(jsonArrayConferences.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getJSONObject("data")).thenReturn(jsonObject);
//        Mockito.when(jsonObject.getString("group")).thenReturn("304").thenReturn("291");
//        Mockito.when(jsonArrayCompetitions.getJSONObject(0)).thenReturn(jsonObject);
//        Mockito.when(jsonArrayTeams.getJSONObject(0)).thenReturn(jsonObject);
//        Mockito.when(jsonArrayTeams.getJSONObject(1)).thenReturn(jsonObject);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createGameStatus(jsonObject)).thenReturn(currentGameStatus);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createGameDataInfoObject(jsonObject)).thenReturn(gameDataInfo);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createVenueObject(jsonObject)).thenReturn(venue);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createTeamObject(Mockito.any(JSONObject.class), Mockito.anyInt())).thenReturn(team);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createConferenceObject(Mockito.any(JSONObject.class), Mockito.anyInt())).thenReturn(conference);
//        Mockito.when(gameDataInfoJsonHandlerHelper.createConferenceTeamObject(Mockito.any(Conference.class), Mockito.any(Team.class), Mockito.any(GameDataInfo.class))).thenReturn(conferenceTeam);
//        Mockito.when(gameDataInfoService.findByEspnGameId(Mockito.anyString())).thenReturn(null);
//        Mockito.when(gameDataInfoService.saveGameDataInfo(Mockito.any(GameDataInfo.class))).thenReturn(gameDataInfo);
//        Mockito.when(venueService.saveVenue(Mockito.any(Venue.class))).thenReturn(venue);
//        Mockito.when(teamService.saveTeam(Mockito.any(Team.class))).thenReturn(team);
//        Mockito.when(conferenceService.saveConference(Mockito.any(Conference.class))).thenReturn(conference);
//        Mockito.when(conferenceTeamService.findByEspnTeamIdOrderByStartDate(team)).thenReturn(conferenceTeams);
//        Mockito.when(conferenceTeamService.saveConferenceTeam(Mockito.any(ConferenceTeam.class))).thenReturn(conferenceTeam);
