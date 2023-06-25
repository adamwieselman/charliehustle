package com.charliehustle.models.json.wnba;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class WnbaMonthGameSchedule {

    @JsonAlias("mon")
    private String month;

    @JsonAlias("g")
    private List<WnbaGame> games;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<WnbaGame> getGames() {
        return games;
    }

    public void setGames(List<WnbaGame> games) {
        this.games = games;
    }
}
