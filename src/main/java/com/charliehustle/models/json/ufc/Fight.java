package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Fight {

    @JsonAlias("FightID")
    private String fightId;

    @JsonAlias("WeightClassID")
    private String weightClassId;

    @JsonAlias("PossibleRds")
    private String possibleRounds;

    @JsonAlias("CurRd")
    private String currentRound;

    @JsonAlias("Fighters")
    private List<Fighter> fighters;

    @JsonAlias("Method")
    private String method;

    @JsonAlias("EndingRoundNum")
    private String endingRoundNumber;

    public String getFightId() {
        return fightId;
    }

    public void setFightId(String fightId) {
        this.fightId = fightId;
    }

    public String getWeightClassId() {
        return weightClassId;
    }

    public void setWeightClassId(String weightClassId) {
        this.weightClassId = weightClassId;
    }

    public String getPossibleRounds() {
        return possibleRounds;
    }

    public void setPossibleRounds(String possibleRounds) {
        this.possibleRounds = possibleRounds;
    }

    public String getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(String currentRound) {
        this.currentRound = currentRound;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEndingRoundNumber() {
        return endingRoundNumber;
    }

    public void setEndingRoundNumber(String endingRoundNumber) {
        this.endingRoundNumber = endingRoundNumber;
    }
}
