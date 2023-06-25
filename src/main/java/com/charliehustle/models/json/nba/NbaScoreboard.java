package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class NbaScoreboard {

    @JsonAlias("numGames")
    private int numGames;

    @JsonAlias("games")
    private List<NbaGame> nbaGames;

    public int getNumGames() {
        return numGames;
    }

    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }

    public List<NbaGame> getNbaGames() {
        return nbaGames;
    }

    public void setNbaGames(List<NbaGame> nbaGames) {
        this.nbaGames = nbaGames;
    }
}
