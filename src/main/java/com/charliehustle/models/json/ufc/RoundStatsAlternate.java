package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class RoundStatsAlternate {

    @JsonAlias("RoundNum")
    private String RoundNum;

    @JsonAlias("Round")
    private List<FighterData> roundFighterData;

    public String getRoundNum() {
        return RoundNum;
    }

    public void setRoundNum(String roundNum) {
        RoundNum = roundNum;
    }

    public List<FighterData> getRoundFighterData() {
        return roundFighterData;
    }

    public void setRoundFighterData(List<FighterData> roundFighterData) {
        this.roundFighterData = roundFighterData;
    }
}
