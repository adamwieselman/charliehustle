package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbStats {

    @JsonAlias("endSpeed")
    private String endSpeed;

    @JsonAlias("startSpeed")
    private String startSpeed;

    @JsonAlias("breaks")
    private MlbBreaks mlbBreaks;

    @JsonAlias("coordinates")
    private MlbCoordinates mlbCoordinates;

    @JsonAlias("nastyFactor")
    private String nastyFactor;

    public String getEndSpeed() {
        return endSpeed;
    }

    public void setEndSpeed(String endSpeed) {
        this.endSpeed = endSpeed;
    }

    public String getStartSpeed() {
        return startSpeed;
    }

    public void setStartSpeed(String startSpeed) {
        this.startSpeed = startSpeed;
    }

    public MlbBreaks getMlbBreaks() {
        return mlbBreaks;
    }

    public void setMlbBreaks(MlbBreaks mlbBreaks) {
        this.mlbBreaks = mlbBreaks;
    }

    public MlbCoordinates getMlbCoordinates() {
        return mlbCoordinates;
    }

    public void setMlbCoordinates(MlbCoordinates mlbCoordinates) {
        this.mlbCoordinates = mlbCoordinates;
    }

    public String getNastyFactor() {
        return nastyFactor;
    }

    public void setNastyFactor(String nastyFactor) {
        this.nastyFactor = nastyFactor;
    }
}
