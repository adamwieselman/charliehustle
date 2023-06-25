package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class FightCard {

    @JsonAlias("FightID")
    private String fightId;

    @JsonAlias("Referee")
    private String referee;

    @JsonAlias("WeightClass")
    private String weightClass;

    @JsonAlias("Fight")
    private List<FightStats> fightStatsList;

    public String getFightId() {
        return fightId;
    }

    public void setFightId(String fightId) {
        this.fightId = fightId;
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

    public List<FightStats> getFightStatsList() {
        return fightStatsList;
    }

    public void setFightStatsList(List<FightStats> fightStatsList) {
        this.fightStatsList = fightStatsList;
    }
}
