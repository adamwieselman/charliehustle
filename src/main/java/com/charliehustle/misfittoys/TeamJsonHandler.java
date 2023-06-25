package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.Team;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamJsonHandler {

    @Autowired
    TeamService teamService;

    @Autowired
    TeamJsonHandlerHelper teamJsonHandlerHelper;

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public List<Team> processTeamInfo(JSONObject competition) {
        List<Team> teams = basicObjectFactory.createTeamList();
        JSONArray competitorArray = competition.getJSONArray("competitors");
        for(int competitor = 0; competitor < competitorArray.length(); ++competitor) {
            Team team = teamService.findByEspnTeamId(competitorArray.getJSONObject(competitor).getJSONObject("team").getString("id"));
            if (team == null) {
                team = teamService.saveTeam(teamJsonHandlerHelper.createTeamObject(competition, competitor));
            }
            teams.add(team);
        }

        return teams;
    }
}
