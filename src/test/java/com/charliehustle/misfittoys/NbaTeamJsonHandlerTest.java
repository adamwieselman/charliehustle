package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.JsonObjectFactory;
import com.charliehustle.models.Team;
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

public class NbaTeamJsonHandlerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    JsonObjectFactory jsonObjectFactory;

    @Mock
    TeamJsonHandlerHelper teamJsonHandlerHelper;

    @Mock
    JSONObject jsonObject;

    @Mock
    JSONArray jsonArrayTeams;

    @Mock
    TeamService teamService;

    @Mock
    BasicObjectFactory basicObjectFactory;

    @InjectMocks
    public TeamJsonHandler teamJsonHandler = new TeamJsonHandler();

    @Test
    public void testProcessTeamInfo_teamFound() {
        ArrayList<Team> teamList = new ArrayList<>();
        Mockito.when(jsonObject.getJSONArray("competitors")).thenReturn(jsonArrayTeams);
        Mockito.when(basicObjectFactory.createTeamList()).thenReturn(teamList);
        Mockito.when(jsonArrayTeams.length()).thenReturn(1);
        Mockito.when(jsonArrayTeams.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("team")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getString("id")).thenReturn("936");
        Mockito.when(teamService.findByEspnTeamId("936")).thenReturn(new Team());

        List<Team> teams = teamJsonHandler.processTeamInfo(jsonObject);
        Mockito.verify(teamJsonHandlerHelper, Mockito.times(0)).createTeamObject(Mockito.any(JSONObject.class), Mockito.anyInt());
    }

    @Test
    public void testProcessTeamInfo_teamNotFound() {
        ArrayList<Team> teamList = new ArrayList<>();
        Mockito.when(jsonObject.getJSONArray("competitors")).thenReturn(jsonArrayTeams);
        Mockito.when(basicObjectFactory.createTeamList()).thenReturn(teamList);
        Mockito.when(jsonArrayTeams.length()).thenReturn(1);
        Mockito.when(jsonArrayTeams.getJSONObject(Mockito.anyInt())).thenReturn(jsonObject);
        Mockito.when(jsonObject.getJSONObject("team")).thenReturn(jsonObject);
        Mockito.when(jsonObject.getString("id")).thenReturn("936");
        Mockito.when(teamService.findByEspnTeamId("936")).thenReturn(null);
        Mockito.when(teamService.saveTeam(Mockito.any(Team.class))).thenReturn(new Team());

        List<Team> teams = teamJsonHandler.processTeamInfo(jsonObject);
        Mockito.verify(teamJsonHandlerHelper, Mockito.times(1)).createTeamObject(Mockito.any(JSONObject.class), Mockito.anyInt());
    }
}