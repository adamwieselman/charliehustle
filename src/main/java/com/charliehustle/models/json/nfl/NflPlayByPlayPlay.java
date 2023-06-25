package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class NflPlayByPlayPlay {

    @JsonAlias("playStats")
    private List<NflPlayByPlayPlayStats> playStats;

    @JsonAlias("possessionTeam")
    private NflPlayByPlayTeam possessionTeam;

    @JsonAlias("clockTime")
    private String clockTime;

    @JsonAlias("yardLine")
    private String yardLine;

    @JsonAlias("down")
    private Integer down;

    @JsonAlias("yardsToGo")
    private Integer yardsToGo;

    @JsonAlias("quarter")
    private Integer quarter;

    @JsonAlias("penaltyOnPlay")
    private boolean penaltyOnPlay;

    @JsonAlias("playClock")
    private String playClock;

    @JsonAlias("playDeleted")
    private boolean playDeleted;

    @JsonAlias("playDescription")
    private String playDescription;

    @JsonAlias("playId")
    private Integer playId;

    @JsonAlias("yards")
    private Integer yards;

    @JsonAlias("playType")
    private String playType;

    @JsonAlias("scoringPlay")
    private boolean scoringPlay;

    @JsonAlias("scoringPlayType")
    private String scoringPlayType;

    @JsonAlias("scoringTeam")
    private NflPlayByPlayTeam scoringTeam;

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public boolean isScoringPlay() {
        return scoringPlay;
    }

    public void setScoringPlay(boolean scoringPlay) {
        this.scoringPlay = scoringPlay;
    }

    public String getScoringPlayType() {
        return scoringPlayType;
    }

    public void setScoringPlayType(String scoringPlayType) {
        this.scoringPlayType = scoringPlayType;
    }

    public NflPlayByPlayTeam getScoringTeam() {
        return scoringTeam;
    }

    public void setScoringTeam(NflPlayByPlayTeam scoringTeam) {
        this.scoringTeam = scoringTeam;
    }

    public List<NflPlayByPlayPlayStats> getPlayStats() {
        return playStats;
    }

    public void setPlayStats(List<NflPlayByPlayPlayStats> playStats) {
        this.playStats = playStats;
    }

    public String getClockTime() {
        return clockTime;
    }

    public void setClockTime(String clockTime) {
        this.clockTime = clockTime;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public boolean isPenaltyOnPlay() {
        return penaltyOnPlay;
    }

    public void setPenaltyOnPlay(boolean penaltyOnPlay) {
        this.penaltyOnPlay = penaltyOnPlay;
    }

    public String getPlayClock() {
        return playClock;
    }

    public void setPlayClock(String playClock) {
        this.playClock = playClock;
    }

    public boolean isPlayDeleted() {
        return playDeleted;
    }

    public void setPlayDeleted(boolean playDeleted) {
        this.playDeleted = playDeleted;
    }

    public String getPlayDescription() {
        return playDescription;
    }

    public void setPlayDescription(String playDescription) {
        this.playDescription = playDescription;
    }

    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }

    public NflPlayByPlayTeam getPossessionTeam() {
        return possessionTeam;
    }

    public void setPossessionTeam(NflPlayByPlayTeam possessionTeam) {
        this.possessionTeam = possessionTeam;
    }

    public String getYardLine() {
        return yardLine;
    }

    public void setYardLine(String yardLine) {
        this.yardLine = yardLine;
    }

    public Integer getYardsToGo() {
        return yardsToGo;
    }

    public void setYardsToGo(Integer yardsToGo) {
        this.yardsToGo = yardsToGo;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYards() {
        return yards;
    }

    public void setYards(Integer yards) {
        this.yards = yards;
    }
}
