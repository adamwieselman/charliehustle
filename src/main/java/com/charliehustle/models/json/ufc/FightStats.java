package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class FightStats {

    @JsonAlias("RoundStats")
    List<RoundStatsAlternate> roundStatusAlternateList;

    public List<RoundStatsAlternate> getRoundStatusAlternateList() {
        return roundStatusAlternateList;
    }

    public void setRoundStatusAlternateList(List<RoundStatsAlternate> roundStatusAlternateList) {
        this.roundStatusAlternateList = roundStatusAlternateList;
    }
}
