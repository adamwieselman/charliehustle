package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NflPlayByPlayDrive {

    @JsonAlias("playIdStarted")
    private Integer playIdStarted;

    @JsonAlias("playIdEnded")
    private Integer playIdEnded;

    @JsonAlias("timeOfPossession")
    private String timeOfPossession;

    public Integer getPlayIdStarted() {
        return playIdStarted;
    }

    public void setPlayIdStarted(Integer playIdStarted) {
        this.playIdStarted = playIdStarted;
    }

    public Integer getPlayIdEnded() {
        return playIdEnded;
    }

    public void setPlayIdEnded(Integer playIdEnded) {
        this.playIdEnded = playIdEnded;
    }

    public String getTimeOfPossession() {
        return timeOfPossession;
    }

    public void setTimeOfPossession(String timeOfPossession) {
        this.timeOfPossession = timeOfPossession;
    }
}
