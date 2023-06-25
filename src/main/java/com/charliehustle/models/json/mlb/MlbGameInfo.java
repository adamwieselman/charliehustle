package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbGameInfo {

    @JsonAlias("gameData")
    private MlbGameData mlbGameData;

    @JsonAlias("liveData")
    private MlbLiveData mlbLiveData;

    public MlbGameData getMlbGameData() {
        return mlbGameData;
    }

    public void setMlbGameData(MlbGameData mlbGameData) {
        this.mlbGameData = mlbGameData;
    }

    public MlbLiveData getMlbLiveData() {
        return mlbLiveData;
    }

    public void setMlbLiveData(MlbLiveData mlbLiveData) {
        this.mlbLiveData = mlbLiveData;
    }
}
