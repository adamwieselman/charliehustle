package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.Team;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamJsonHandlerHelper {

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public Team createTeamObject(JSONObject competition, Integer i) {
        Team team = basicObjectFactory.createTeam();
        JSONObject competitorTeam = competition.getJSONArray("competitors").getJSONObject(i).getJSONObject("team");
        team.setEspnTeamId(competitorTeam.getString("id"));
        team.setName(competitorTeam.getString("displayName"));
        team.setShortName(competitorTeam.getString("shortDisplayName"));

        return team;
    }
}
