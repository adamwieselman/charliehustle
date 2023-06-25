package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Round {

    @JsonAlias("Red")
    private FighterRoundData redFighterData;

    @JsonAlias("Blue")
    private FighterRoundData blueFighterData;

    public FighterRoundData getRedFighterData() {
        return redFighterData;
    }

    public void setRedFighterData(FighterRoundData redFighterData) {
        this.redFighterData = redFighterData;
    }

    public FighterRoundData getBlueFighterData() {
        return blueFighterData;
    }

    public void setBlueFighterData(FighterRoundData blueFighterData) {
        this.blueFighterData = blueFighterData;
    }
}
