package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbGameData {

    @JsonAlias("venue")
    private MlbVenue mlbVenue;

    @JsonAlias("datetime")
    private MlbDateTime mlbDateTime;

    @JsonAlias("teams")
    private MlbTeams mlbTeams;

    @JsonAlias("weather")
    private MlbWeather mlbWeather;

    public MlbWeather getMlbWeather() {
        return mlbWeather;
    }

    public void setMlbWeather(MlbWeather mlbWeather) {
        this.mlbWeather = mlbWeather;
    }

    public MlbTeams getMlbTeams() {
        return mlbTeams;
    }

    public void setMlbTeams(MlbTeams mlbTeams) {
        this.mlbTeams = mlbTeams;
    }

    public MlbDateTime getMlbDateTime() {
        return mlbDateTime;
    }

    public void setMlbDateTime(MlbDateTime mlbDateTime) {
        this.mlbDateTime = mlbDateTime;
    }

    public MlbVenue getMlbVenue() {
        return mlbVenue;
    }

    public void setMlbVenue(MlbVenue mlbVenue) {
        this.mlbVenue = mlbVenue;
    }
}
