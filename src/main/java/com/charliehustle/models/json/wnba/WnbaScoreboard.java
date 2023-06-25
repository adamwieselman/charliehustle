package com.charliehustle.models.json.wnba;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class WnbaScoreboard {

    @JsonAlias("lscd")
    private List<WnbaLeagueSchedule> wnbaLeagueSchedules;

    public List<WnbaLeagueSchedule> getWnbaLeagueSchedules() {
        return wnbaLeagueSchedules;
    }

    public void setWnbaLeagueSchedules(List<WnbaLeagueSchedule> wnbaLeagueSchedules) {
        this.wnbaLeagueSchedules = wnbaLeagueSchedules;
    }
}
