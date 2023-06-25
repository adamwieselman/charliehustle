package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class MlbGameDate {

    @JsonAlias("date")
    private String date;

    @JsonAlias("games")
    private List<MlbGame> mlbGames;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<MlbGame> getMlbGames() {
        return mlbGames;
    }

    public void setMlbGames(List<MlbGame> mlbGames) {
        this.mlbGames = mlbGames;
    }
}
