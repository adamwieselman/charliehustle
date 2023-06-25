package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbGame {

    @JsonAlias("gamePk")
    private int gamePk;

    @JsonAlias("link")
    private String link;

    @JsonAlias("gamePk")
    private String gameType;

    @JsonAlias("season")
    private String season;

    @JsonAlias("gameDate")
    private String gameDate;

    @JsonAlias("status")
    private MlbStatus mlbStatus;

    @JsonAlias("dayNight")
    private String dayNight;

    public int getGamePk() {
        return gamePk;
    }

    public void setGamePk(int gamePk) {
        this.gamePk = gamePk;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public MlbStatus getMlbStatus() {
        return mlbStatus;
    }

    public void setMlbStatus(MlbStatus mlbStatus) {
        this.mlbStatus = mlbStatus;
    }

    public String getDayNight() {
        return dayNight;
    }

    public void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }
}
