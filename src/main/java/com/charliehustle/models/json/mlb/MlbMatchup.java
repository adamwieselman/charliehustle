package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbMatchup {

    @JsonAlias("batter")
    private String batter;

    @JsonAlias("pitcher")
    private String pitcher;

    @JsonAlias("rightLeft")
    private MlbRightLeft mlbRightLeft;

    public String getBatter() {
        return batter;
    }

    public void setBatter(String batter) {
        this.batter = batter;
    }

    public String getPitcher() {
        return pitcher;
    }

    public void setPitcher(String pitcher) {
        this.pitcher = pitcher;
    }

    public MlbRightLeft getMlbRightLeft() {
        return mlbRightLeft;
    }

    public void setMlbRightLeft(MlbRightLeft mlbRightLeft) {
        this.mlbRightLeft = mlbRightLeft;
    }
}
