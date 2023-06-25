package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NflPlayByPlay {

    @JsonAlias("data")
    private NflPlayByPlayData data;

    public NflPlayByPlayData getData() { return data; }

    public void setData(NflPlayByPlayData data) { this.data = data; }

}
