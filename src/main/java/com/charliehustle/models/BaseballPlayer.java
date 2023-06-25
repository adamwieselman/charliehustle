package com.charliehustle.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public class BaseballPlayer {

    @JsonAlias("teamid")
    private String teamId;

    @JsonAlias("role")
    private String role;

    @JsonAlias("type")
    private String type;

    @JsonAlias("mlbamid")
    private String mlbamid;

    @JsonAlias("position")
    private String position;

    @JsonAlias("player")
    private String playerName;

    @JsonAlias("age")
    private String age;

    @JsonAlias("handed")
    private String handed;

    @JsonAlias("platoon")
    private String platoon;

    @JsonAlias("eta")
    private String mlbEta;

    @JsonAlias("injurynotes")
    private String injuryNotes;

    @JsonAlias("injurydate")
    private String injuryDate;

    @JsonAlias("Org_Rank")
    private String organizationalRank;

    @JsonAlias("mlevel")
    private String playingLevel;

    @JsonAlias("Ovr_Rank")
    private String overallRank;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMlbamid ()
    {
        return mlbamid;
    }

    public void setMlbamid (String mlbamid)
    {
        this.mlbamid = mlbamid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHanded() {
        return handed;
    }

    public void setHanded(String handed) {
        this.handed = handed;
    }
    
    public void setPlatoon(String platoon){
        this.platoon = platoon;
    }
    
    public String getPlatoon(){
        return platoon;
    }

    @Override
    public String toString() {
        return "BaseballPlayer{" +
                "role='" + role + '\'' +
                ", position='" + position + '\'' +
                ", player='" + playerName + '\'' +
                ", age='" + age + '\'' +
                ", handed='" + handed + '\'' +
                ", platoon='" + platoon + '\'' +
                ", mlbEta='" + mlbEta + '\'' +
                ", injuryNotes='" + injuryNotes + '\'' +
                ", injuryDate='" + injuryDate + '\'' +
                ", organizationalRank=" + organizationalRank +
                ", playingLevel='" + playingLevel + '\'' +
                ", overallRank='" + overallRank + '\'' +
                '}';
    }

    public String getMlbEta() {
        return mlbEta;
    }

    public void setMlbEta(String mlbEta) {
        this.mlbEta = mlbEta;
    }

    public String getInjuryNotes() {
        return injuryNotes;
    }

    public void setInjuryNotes(String injuryNotes) {
        this.injuryNotes = injuryNotes;
    }

    public String getInjuryDate() {
        return injuryDate;
    }

    public void setInjuryDate(String injuryDate) {
        this.injuryDate = injuryDate;
    }

    public String getOrganizationalRank() {
        return organizationalRank;
    }

    public void setOrganizationalRank(String organizationalRank) {
        this.organizationalRank = organizationalRank;
    }

    public String getPlayingLevel() {
        return playingLevel;
    }

    public void setPlayingLevel(String playingLevel) {
        this.playingLevel = playingLevel;
    }

    public String getOverallRank() {
        return overallRank;
    }

    public void setOverallRank(String overallRank) {
        this.overallRank = overallRank;
    }

    public String getTeamId() { return teamId; }

    public void setTeamId(String teamId) { this.teamId = teamId;  }
}
