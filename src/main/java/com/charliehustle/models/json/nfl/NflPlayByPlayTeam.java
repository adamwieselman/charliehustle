package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NflPlayByPlayTeam {

    @JsonAlias("abbreviation")
    private String abbreviatiion;

    public String getAbbreviatiion() {
        return abbreviatiion;
    }

    public void setAbbreviatiion(String abbreviatiion) {
        this.abbreviatiion = abbreviatiion;
    }
}
