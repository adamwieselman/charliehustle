package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class NbaGame {

    @JsonAlias("seasonStageId")
    private int seasonStageId;

    @JsonAlias("seasonYear")
    private String seasonYear;

    @JsonAlias("leagueName")
    private String leagueName;

    @JsonAlias("gid")
    @JsonProperty("gameId")
    private String gameId;

    @JsonAlias("arena")
    private NbaArena nbaArena;

    @JsonAlias("statusNum")
    private int statusNum;

    @JsonAlias("startTimeEaster")
    private String startTimeEastern;

    @JsonAlias("startTimeUTC")
    private String startTimeUTC;

    @JsonAlias("endTimeUTC")
    private String endTimeUTC;

    @JsonAlias("gcode")
    @JsonProperty("gameUrlCode")
    private String gameUrlCode;

    @JsonAlias("attendance")
    private String attendance;

    @JsonAlias("hasGameBookPdf")
    private boolean gameBookPdf;

    @JsonAlias("gameDuration")
    private NbaGameDuration nbaGameDuration;

    @JsonAlias("period")
    private NbaPeriod nbaPeriod;

    @JsonAlias("vTeam")
    private NbaTeam vNbaTeam;

    @JsonAlias("hTeam")
    private NbaTeam hNbaTeam;

    @JsonAlias("pd")
    @JsonProperty("playsPeriod")
    private List<NbaPlaysPeriod> nbaPlaysPeriods;

    public List<NbaPlaysPeriod> getNbaPlaysPeriods() {
        return nbaPlaysPeriods;
    }

    public void setPlays(List<NbaPlaysPeriod> nbaPlaysPeriods) {
        this.nbaPlaysPeriods = nbaPlaysPeriods;
    }

    public NbaTeam getvNbaTeam() {
        return vNbaTeam;
    }

    public void setvNbaTeam(NbaTeam vNbaTeam) {
        this.vNbaTeam = vNbaTeam;
    }

    public NbaTeam gethNbaTeam() {
        return hNbaTeam;
    }

    public void sethNbaTeam(NbaTeam hNbaTeam) {
        this.hNbaTeam = hNbaTeam;
    }

    public int getSeasonStageId() {
        return seasonStageId;
    }

    public void setSeasonStageId(int seasonStageId) {
        this.seasonStageId = seasonStageId;
    }

    public String getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public NbaArena getNbaArena() {
        return nbaArena;
    }

    public void setNbaArena(NbaArena nbaArena) {
        this.nbaArena = nbaArena;
    }

    public int getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(int statusNum) {
        this.statusNum = statusNum;
    }

    public String getStartTimeEastern() {
        return startTimeEastern;
    }

    public void setStartTimeEastern(String startTimeEastern) {
        this.startTimeEastern = startTimeEastern;
    }

    public String getStartTimeUTC() {
        return startTimeUTC;
    }

    public void setStartTimeUTC(String startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

    public String getEndTimeUTC() {
        return endTimeUTC;
    }

    public void setEndTimeUTC(String endTimeUTC) {
        this.endTimeUTC = endTimeUTC;
    }

    public String getGameUrlCode() {
        return gameUrlCode;
    }

    public void setGameUrlCode(String gameUrlCode) {
        this.gameUrlCode = gameUrlCode;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public boolean isGameBookPdf() {
        return gameBookPdf;
    }

    public void setGameBookPdf(boolean gameBookPdf) {
        this.gameBookPdf = gameBookPdf;
    }

    public NbaGameDuration getNbaGameDuration() {
        return nbaGameDuration;
    }

    public void setNbaGameDuration(NbaGameDuration nbaGameDuration) {
        this.nbaGameDuration = nbaGameDuration;
    }

    public NbaPeriod getNbaPeriod() {
        return nbaPeriod;
    }

    public void setNbaPeriod(NbaPeriod nbaPeriod) {
        this.nbaPeriod = nbaPeriod;
    }


}