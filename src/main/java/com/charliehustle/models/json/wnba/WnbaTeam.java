package com.charliehustle.models.json.wnba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class WnbaTeam {

    @JsonAlias("tid")
    private int teamId;

    @JsonAlias("ta")
    private String teamAbbreviation;

    @JsonAlias("tn")
    private String teamName;

    @JsonAlias("tc")
    private String teamCity;

    @JsonAlias("s")
    private String teamScore;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamAbbreviation() {
        return teamAbbreviation;
    }

    public void setTeamAbbreviation(String teamAbbreviation) {
        this.teamAbbreviation = teamAbbreviation;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(String teamScore) {
        this.teamScore = teamScore;
    }
}
