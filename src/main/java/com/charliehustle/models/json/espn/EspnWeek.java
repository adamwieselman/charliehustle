package com.charliehustle.models.json.espn;

import com.fasterxml.jackson.annotation.JsonAlias;

public class EspnWeek {

    @JsonAlias("number")
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
