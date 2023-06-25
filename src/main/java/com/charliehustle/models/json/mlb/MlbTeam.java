package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbTeam {

    @JsonAlias("teamID")
    private String teamId;

    @JsonAlias("name")
    private MlbName mlbName;

    public MlbName getMlbName() {
        return mlbName;
    }

    public void setMlbName(MlbName mlbName) {
        this.mlbName = mlbName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
