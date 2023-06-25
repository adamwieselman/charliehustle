package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NflPlayByPlayData {

    @JsonAlias("viewer")
    private NflPlayByPlayDataViewer viewer;

    public NflPlayByPlayDataViewer getViewer() {
        return viewer;
    }

    public void setViewer(NflPlayByPlayDataViewer viewer) {
        this.viewer = viewer;
    }





}
