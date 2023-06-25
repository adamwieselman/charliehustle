package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FightBreakdownFeed {

    @JsonAlias("EventID")
    private String eventId;

    @JsonAlias("FightCard")
    private FightCard fightCard;

    @JsonAlias("FightID")
    private String fightId;

    @JsonAlias("CurrentRound")
    private String currentRound;

    @JsonAlias("MaxRounds")
    private String maxRounds;

    @JsonAlias("CurrentRoundTime")
    private String currentRoundTime;

    @JsonAlias("Referee")
    private String referee;

    @JsonAlias("WeightClass")
    private String weightClass;

    @JsonAlias("RoundStats")
    private RoundStats roundStats;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getFightId() {
        return fightId;
    }

    public void setFightId(String fightId) {
        this.fightId = fightId;
    }

    public String getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(String currentRound) {
        this.currentRound = currentRound;
    }

    public String getMaxRounds() {
        return maxRounds;
    }

    public void setMaxRounds(String maxRounds) {
        this.maxRounds = maxRounds;
    }

    public String getCurrentRoundTime() {
        return currentRoundTime;
    }

    public void setCurrentRoundTime(String currentRoundTime) {
        this.currentRoundTime = currentRoundTime;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public RoundStats getRoundStats() {
        return roundStats;
    }

    public void setRoundStats(RoundStats roundStats) {
        this.roundStats = roundStats;
    }

    public FightCard getFightCard() {
        return fightCard;
    }

    public void setFightCard(FightCard fightCard) {
        this.fightCard = fightCard;
    }
}
