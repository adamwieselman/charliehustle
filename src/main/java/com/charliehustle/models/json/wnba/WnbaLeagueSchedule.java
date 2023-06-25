package com.charliehustle.models.json.wnba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class WnbaLeagueSchedule {

    @JsonAlias("mscd")
    private WnbaMonthGameSchedule wnbaMonthGameSchedule;

    public WnbaMonthGameSchedule getWnbaMonthGameSchedule() {
        return wnbaMonthGameSchedule;
    }

    public void setWnbaMonthGameSchedule(WnbaMonthGameSchedule wnbaMonthGameSchedule) {
        this.wnbaMonthGameSchedule = wnbaMonthGameSchedule;
    }
}
