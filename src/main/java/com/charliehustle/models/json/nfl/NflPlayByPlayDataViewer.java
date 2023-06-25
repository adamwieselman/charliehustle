package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NflPlayByPlayDataViewer {

    @JsonAlias("gameDetail")
    private NflPlayByPlayDataViewerGameDetails gameDetails;

    public NflPlayByPlayDataViewerGameDetails getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(NflPlayByPlayDataViewerGameDetails gameDetails) {
        this.gameDetails = gameDetails;
    }
}
