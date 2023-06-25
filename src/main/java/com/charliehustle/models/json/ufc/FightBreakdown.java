package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FightBreakdown {

    @JsonAlias("FMLiveFeed")
    private FightBreakdownFeed fightBreakdownFeed;

    public FightBreakdownFeed getFightBreakdownFeed() {
        return fightBreakdownFeed;
    }

    public void setFightBreakdownFeed(FightBreakdownFeed fightBreakdownFeed) {
        this.fightBreakdownFeed = fightBreakdownFeed;
    }
}
