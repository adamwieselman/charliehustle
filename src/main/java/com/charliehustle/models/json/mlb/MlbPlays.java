package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class MlbPlays {

    @JsonAlias("allPlays")
    private List<MlbPlay> mlbPlayList;

    public List<MlbPlay> getMlbPlayList() {
        return mlbPlayList;
    }

    public void setMlbPlayList(List<MlbPlay> mlbPlayList) {
        this.mlbPlayList = mlbPlayList;
    }
}
