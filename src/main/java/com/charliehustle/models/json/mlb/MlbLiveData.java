package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbLiveData {

    @JsonAlias("plays")
    private MlbPlays mlbPlays;

    public MlbPlays getMlbPlays() {
        return mlbPlays;
    }

    public void setMlbPlays(MlbPlays mlbPlays) {
        this.mlbPlays = mlbPlays;
    }
}
