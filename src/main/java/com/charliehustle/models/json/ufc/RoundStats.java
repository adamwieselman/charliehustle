package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class RoundStats {

    @JsonAlias("Round1")
    private Round round1;

    @JsonAlias("Round2")
    private Round round2;

    @JsonAlias("Round3")
    private Round round3;

    @JsonAlias("Round4")
    private Round round4;

    @JsonAlias("Round5")
    private Round round5;

    public Round getRound1() {
        return round1;
    }

    public void setRound1(Round round1) {
        this.round1 = round1;
    }

    public Round getRound2() {
        return round2;
    }

    public void setRound2(Round round2) {
        this.round2 = round2;
    }

    public Round getRound3() {
        return round3;
    }

    public void setRound3(Round round3) {
        this.round3 = round3;
    }

    public Round getRound4() {
        return round4;
    }

    public void setRound4(Round round4) {
        this.round4 = round4;
    }

    public Round getRound5() {
        return round5;
    }

    public void setRound5(Round round5) {
        this.round5 = round5;
    }
}
