package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbTeams {

    @JsonAlias("away")
    private MlbTeam away;

    @JsonAlias("home")
    private MlbTeam home;

    public MlbTeam getAway() {
        return away;
    }

    public void setAway(MlbTeam away) {
        this.away = away;
    }

    public MlbTeam getHome() {
        return home;
    }

    public void setHome(MlbTeam home) {
        this.home = home;
    }
}
