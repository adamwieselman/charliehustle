package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FightSchedule {

    @JsonAlias("FMLiveFeed")
    private FightEvent fmLiveFeed;

    public FightEvent getFmLiveFeed() {
        return fmLiveFeed;
    }

    public void setFmLiveFeed(FightEvent fmLiveFeed) {
        this.fmLiveFeed = fmLiveFeed;
    }

}
