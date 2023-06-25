package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class MlbScoreboard {

    @JsonAlias("totalItems")
    private int totalItems;

    @JsonAlias("totalGames")
    private int totalGames;

    @JsonAlias("dates")
    private List<MlbGameDate> mlbGameDates;

    public List<MlbGameDate> getMlbGameDates() {
        return mlbGameDates;
    }

    public void setMlbGameDates(List<MlbGameDate> mlbGameDates) {
        this.mlbGameDates = mlbGameDates;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }
}
