package com.charliehustle.models.json.espn;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class EspnGamePlayByPlay {

    @JsonAlias("game-plays")
    private List<EspnPlayByPlay> espnPlayByPlays;

    public List<EspnPlayByPlay> getEspnPlayByPlays() {
        return espnPlayByPlays;
    }

    public void setEspnPlayByPlays(List<EspnPlayByPlay> espnPlayByPlays) {
        this.espnPlayByPlays = espnPlayByPlays;
    }
}