package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NbaLineScore {

    @JsonAlias("value")
    private int value;

    @JsonAlias("score")
    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
