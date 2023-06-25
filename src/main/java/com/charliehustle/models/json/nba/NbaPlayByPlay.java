package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NbaPlayByPlay {

    @JsonAlias("g")
    private NbaGame nbaGame;

    public NbaGame getNbaGame() {
        return nbaGame;
    }

    public void setNbaGame(NbaGame nbaGame) {
        this.nbaGame = nbaGame;
    }
}

