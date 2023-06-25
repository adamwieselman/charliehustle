package com.charliehustle.models.json.wnba;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class WnbaGame {

    @JsonAlias("gid")
    private String gameId;

    @JsonAlias("gcode")
    private String gameCode;

    @JsonAlias("htm")
    private String gameStartDateUTC;

    @JsonAlias("an")
    private String arena;

    @JsonAlias("ac")
    private String arenaCity;

    @JsonAlias("st")
    private String status;

    @JsonAlias("stt")
    private String statusText;

    @JsonAlias("v")
    private WnbaTeam vistorTeam;

    @JsonAlias("h")
    private WnbaTeam homeTeam;

    @JsonAlias("p")
    private int period;

    @JsonAlias("pla")
    private List<WnbaPlay> wnbaPlays;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getGameStartDateUTC() {
        return gameStartDateUTC;
    }

    public void setGameStartDateUTC(String gameStartDateUTC) {
        this.gameStartDateUTC = gameStartDateUTC;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getArenaCity() {
        return arenaCity;
    }

    public void setArenaCity(String arenaCity) {
        this.arenaCity = arenaCity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public WnbaTeam getVistorTeam() {
        return vistorTeam;
    }

    public void setVistorTeam(WnbaTeam vistorTeam) {
        this.vistorTeam = vistorTeam;
    }

    public WnbaTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(WnbaTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public List<WnbaPlay> getWnbaPlays() {
        return wnbaPlays;
    }

    public void setWnbaPlays(List<WnbaPlay> wnbaPlays) {
        this.wnbaPlays = wnbaPlays;
    }
}
