package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.JsonObjectFactory;
import com.charliehustle.models.Conference;
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

public class ConferenceJsonHandlerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    JsonObjectFactory jsonObjectFactory;

    @Mock
    ConferenceJsonHandlerHelper conferenceJsonHandlerHelper;

    @Mock
    JSONObject jsonObject;

    @Mock
    JSONArray jsonArrayConferences;

    @Mock
    ConferenceService conferenceService;

    @Mock
    BasicObjectFactory basicObjectFactory;

    @InjectMocks
    public ConferenceJsonHandler conferenceJsonHandler = new ConferenceJsonHandler();

    @Test
    public void testProcessConferenceInfo_conferenceFound(){
        ArrayList<Conference> conferenceList = new ArrayList<>();
        Mockito.when(jsonObject.getJSONArray("competitors")).thenReturn(jsonArrayConferences);
        Mockito.when(basicObjectFactory.createConferenceList()).thenReturn(conferenceList);
        Mockito.when(jsonArrayConferences.length()).thenReturn(1);
        Mockito.when(jsonArrayConferences.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("team")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getString("conferenceId")).thenReturn("3345");
        Mockito.when(conferenceService.findByEspnConferenceId("3345")).thenReturn(new Conference());

        List<Conference> conferences = conferenceJsonHandler.processConferenceInfo(jsonObject, jsonObject);
        Mockito.verify(conferenceJsonHandlerHelper, Mockito.times(0)).createConferenceObject(Mockito.any(JSONObject.class), Mockito.anyInt());
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
