package com.charliehustle.beans;

public class PlayContext {

    private String playDescription;
    private String homeTeam;
    private String visitorTeam;
    private Integer year;
    private Integer week;
    private String date;
    private Integer quarter;
    private String clockTime;
    private String playClock;
    private Integer down;
    private Integer yardsToGo;
    private String possessionTeam;
    private String defensiveTeam;
    private Integer yardsToGoal;


    private Integer yards;
    private Integer airYards;
    private Integer yardsAfterCatch;
    private boolean penaltyOnPlay;
    private boolean playDeleted;
    private String playType;
    private boolean scoringPlay;
    private String scoringPlayType;
    private String playDetailType;
    private boolean passIncomplete;
    private boolean passIntercepted;
    private boolean fumbled;
    private boolean fumbleLost;
    private boolean touchdown;
    private boolean defensiveTouchdown;
    private boolean fieldGoal;
    private boolean fieldGoalMissed;
    private boolean fieldGoalBlocked;
    private boolean puntBlocked;
    private boolean penaltyNoPlay;
    private boolean extraPoint;
    private boolean extraPointMissed;
    private boolean extraPointBlocked;
    private boolean twoPointConversion;
    private boolean twoPointConversionFailed;
    private boolean safety;
    private Integer penaltyYards;
    private Integer kickYards;

    private String primaryTackler;
    private String secondaryTackler;
    private String primaryOffensivePlayer;
    private String secondaryOffensivePlayer;
    private String primaryQbHitter;
    private String primaryPassDefender;
    private String secondaryPassDefender;
    private String primaryPassIntecepter;
    private String primaryForcedFumbler;
    private String penaltyPlayer;
    private String penaltyTeamAgainst;
    private String primaryKicker;
    private String primaryKickBlocker;

    private Integer homeScore;
    private Integer visitorScore;
    private Integer scoreDiff;

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getVisitorScore() {
        return visitorScore;
    }

    public void setVisitorScore(Integer visitorScore) {
        this.visitorScore = visitorScore;
    }

    public Integer getScoreDiff() {
        return scoreDiff;
    }

    public void setScoreDiff(Integer scoreDiff) {
        this.scoreDiff = scoreDiff;
    }

    public boolean isPuntBlocked() {
        return puntBlocked;
    }

    public void setPuntBlocked(boolean puntBlocked) {
        this.puntBlocked = puntBlocked;
    }

    public String getPrimaryKickBlocker() {
        return primaryKickBlocker;
    }

    public void setPrimaryKickBlocker(String primaryKickBlocker) {
        this.primaryKickBlocker = primaryKickBlocker;
    }

    public boolean isSafety() {
        return safety;
    }

    public void setSafety(boolean safety) {
        this.safety = safety;
    }

    public boolean isTwoPointConversion() {
        return twoPointConversion;
    }

    public void setTwoPointConversion(boolean twoPointConversion) {
        this.twoPointConversion = twoPointConversion;
    }

    public boolean isTwoPointConversionFailed() {
        return twoPointConversionFailed;
    }

    public void setTwoPointConversionFailed(boolean twoPointConversionFailed) {
        this.twoPointConversionFailed = twoPointConversionFailed;
    }

    public boolean isExtraPoint() {
        return extraPoint;
    }

    public void setExtraPoint(boolean extraPoint) {
        this.extraPoint = extraPoint;
    }

    public boolean isExtraPointMissed() {
        return extraPointMissed;
    }

    public void setExtraPointMissed(boolean extraPointMissed) {
        this.extraPointMissed = extraPointMissed;
    }

    public boolean isExtraPointBlocked() {
        return extraPointBlocked;
    }

    public void setExtraPointBlocked(boolean extraPointBlocked) {
        this.extraPointBlocked = extraPointBlocked;
    }

    public String getPlayDescription() {
        return playDescription;
    }

    public void setPlayDescription(String playDescription) {
        this.playDescription = playDescription;
    }

    public Integer getKickYards() {
        return kickYards;
    }

    public void setKickYards(Integer kickYards) {
        this.kickYards = kickYards;
    }

    public boolean isFieldGoal() {
        return fieldGoal;
    }

    public void setFieldGoal(boolean fieldGoal) {
        this.fieldGoal = fieldGoal;
    }

    public boolean isFieldGoalMissed() {
        return fieldGoalMissed;
    }

    public void setFieldGoalMissed(boolean fieldGoalMissed) {
        this.fieldGoalMissed = fieldGoalMissed;
    }

    public boolean isFieldGoalBlocked() {
        return fieldGoalBlocked;
    }

    public void setFieldGoalBlocked(boolean fieldGoalBlocked) {
        this.fieldGoalBlocked = fieldGoalBlocked;
    }

    public boolean isDefensiveTouchdown() {
        return defensiveTouchdown;
    }

    public void setDefensiveTouchdown(boolean defensiveTouchdown) {
        this.defensiveTouchdown = defensiveTouchdown;
    }

    public String getPrimaryKicker() {
        return primaryKicker;
    }

    public void setPrimaryKicker(String primaryKicker) {
        this.primaryKicker = primaryKicker;
    }

    public String getPenaltyTeamAgainst() {
        return penaltyTeamAgainst;
    }

    public void setPenaltyTeamAgainst(String penaltyTeamAgainst) {
        this.penaltyTeamAgainst = penaltyTeamAgainst;
    }

    public boolean isPenaltyNoPlay() {
        return penaltyNoPlay;
    }

    public void setPenaltyNoPlay(boolean penaltyNoPlay) {
        this.penaltyNoPlay = penaltyNoPlay;
    }

    public Integer getPenaltyYards() {
        return penaltyYards;
    }

    public void setPenaltyYards(Integer penaltyYards) {
        this.penaltyYards = penaltyYards;
    }

    public String getPenaltyPlayer() {
        return penaltyPlayer;
    }

    public void setPenaltyPlayer(String penaltyPlayer) {
        this.penaltyPlayer = penaltyPlayer;
    }

    public boolean isTouchdown() {
        return touchdown;
    }

    public void setTouchdown(boolean touchdown) {
        this.touchdown = touchdown;
    }

    public boolean isFumbled() {
        return fumbled;
    }

    public void setFumbled(boolean fumbled) {
        this.fumbled = fumbled;
    }

    public boolean isFumbleLost() {
        return fumbleLost;
    }

    public void setFumbleLost(boolean fumbleLost) {
        this.fumbleLost = fumbleLost;
    }

    public String getPrimaryForcedFumbler() {
        return primaryForcedFumbler;
    }

    public void setPrimaryForcedFumbler(String primaryForcedFumbler) {
        this.primaryForcedFumbler = primaryForcedFumbler;
    }

    public String getSecondaryPassDefender() {
        return secondaryPassDefender;
    }

    public void setSecondaryPassDefender(String secondaryPassDefender) {
        this.secondaryPassDefender = secondaryPassDefender;
    }

    public String getPrimaryPassIntecepter() {
        return primaryPassIntecepter;
    }

    public void setPrimaryPassIntecepter(String primaryPassIntecepter) {
        this.primaryPassIntecepter = primaryPassIntecepter;
    }

    public boolean isPassIntercepted() {
        return passIntercepted;
    }

    public void setPassIntercepted(boolean passIntercepted) {
        this.passIntercepted = passIntercepted;
    }

    public String getPrimaryPassDefender() {
        return primaryPassDefender;
    }

    public void setPrimaryPassDefender(String primaryPassDefender) {
        this.primaryPassDefender = primaryPassDefender;
    }

    public boolean isPassIncomplete() {
        return passIncomplete;
    }

    public void setPassIncomplete(boolean passIncomplete) {
        this.passIncomplete = passIncomplete;
    }

    public String getPrimaryQbHitter() {
        return primaryQbHitter;
    }

    public void setPrimaryQbHitter(String primaryQbHitter) {
        this.primaryQbHitter = primaryQbHitter;
    }

    public Integer getAirYards() {
        return airYards;
    }

    public void setAirYards(Integer airYards) {
        this.airYards = airYards;
    }

    public Integer getYardsAfterCatch() {
        return yardsAfterCatch;
    }

    public void setYardsAfterCatch(Integer yardsAfterCatch) {
        this.yardsAfterCatch = yardsAfterCatch;
    }

    public String getPlayDetailType() {
        return playDetailType;
    }

    public void setPlayDetailType(String playDetailType) {
        this.playDetailType = playDetailType;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(String visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getClockTime() {
        return clockTime;
    }

    public void setClockTime(String clockTime) {
        this.clockTime = clockTime;
    }

    public String getPlayClock() {
        return playClock;
    }

    public void setPlayClock(String playClock) {
        this.playClock = playClock;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public Integer getYardsToGo() {
        return yardsToGo;
    }

    public void setYardsToGo(Integer yardsToGo) {
        this.yardsToGo = yardsToGo;
    }

    public String getPossessionTeam() {
        return possessionTeam;
    }

    public void setPossessionTeam(String possessionTeam) {
        this.possessionTeam = possessionTeam;
    }

    public String getDefensiveTeam() {
        return defensiveTeam;
    }

    public void setDefensiveTeam(String defensiveTeam) {
        this.defensiveTeam = defensiveTeam;
    }

    public Integer getYardsToGoal() {
        return yardsToGoal;
    }

    public void setYardsToGoal(Integer yardsToGoal) {
        this.yardsToGoal = yardsToGoal;
    }

    public Integer getYards() {
        return yards;
    }

    public void setYards(Integer yards) {
        this.yards = yards;
    }

    public boolean isPenaltyOnPlay() {
        return penaltyOnPlay;
    }

    public void setPenaltyOnPlay(boolean penaltyOnPlay) {
        this.penaltyOnPlay = penaltyOnPlay;
    }

    public boolean isPlayDeleted() {
        return playDeleted;
    }

    public void setPlayDeleted(boolean playDeleted) {
        this.playDeleted = playDeleted;
    }

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

    public String getPrimaryTackler() {
        return primaryTackler;
    }

    public void setPrimaryTackler(String primaryTackler) {
        this.primaryTackler = primaryTackler;
    }

    public String getSecondaryTackler() {
        return secondaryTackler;
    }

    public void setSecondaryTackler(String secondaryTackler) {
        this.secondaryTackler = secondaryTackler;
    }

    public String getPrimaryOffensivePlayer() {
        return primaryOffensivePlayer;
    }

    public void setPrimaryOffensivePlayer(String primaryOffensivePlayer) {
        this.primaryOffensivePlayer = primaryOffensivePlayer;
    }

    public String getSecondaryOffensivePlayer() {
        return secondaryOffensivePlayer;
    }

    public void setSecondaryOffensivePlayer(String secondaryOffensivePlayer) {
        this.secondaryOffensivePlayer = secondaryOffensivePlayer;
    }
}
