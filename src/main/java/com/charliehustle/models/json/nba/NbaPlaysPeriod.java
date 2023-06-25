package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NbaPlaysPeriod {

    @JsonAlias("p")
    @JsonProperty("period")
    private int period;

    @JsonAlias("pla")
    @JsonProperty("plays")
    private List<NbaPlay> nbaPlays;

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public List<NbaPlay> getNbaPlays() {
        return nbaPlays;
    }

    public void setNbaPlays(List<NbaPlay> nbaPlays) {
        this.nbaPlays = nbaPlays;
    }
}
