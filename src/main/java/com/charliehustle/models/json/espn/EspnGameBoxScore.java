package com.charliehustle.models.json.espn;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class EspnGameBoxScore {

    @JsonAlias("game-boxscores")
    private List<EspnBoxScore> espnBoxScores;

    public List<EspnBoxScore> getEspnBoxScores() {
        return espnBoxScores;
    }

    public void setEspnBoxScores(List<EspnBoxScore> espnBoxScores) {
        this.espnBoxScores = espnBoxScores;
    }
}
