package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbRightLeft {

    @JsonAlias("batter")
    private String batter;

    @JsonAlias("pitcher")
    private String pitcher;

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
}
