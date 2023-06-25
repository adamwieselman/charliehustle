package com.charliehustle.models.json.wnba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class WnbaPlayByPlay {

    @JsonAlias("g")
    private WnbaGame wnbaGame;

    public WnbaGame getWnbaGame() {
        return wnbaGame;
    }

    public void setWnbaGame(WnbaGame wnbaGame) {
        this.wnbaGame = wnbaGame;
    }
}

