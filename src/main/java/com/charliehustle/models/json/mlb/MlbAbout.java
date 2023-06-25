package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbAbout {

    @JsonAlias("inning")
    private String inning;

    @JsonAlias("halfInning")
    private String halfInning;

    public String getInning() {
        return inning;
    }

    public void setInning(String inning) {
        this.inning = inning;
    }

    public String getHalfInning() {
        return halfInning;
    }

    public void setHalfInning(String halfInning) {
        this.halfInning = halfInning;
    }
}
