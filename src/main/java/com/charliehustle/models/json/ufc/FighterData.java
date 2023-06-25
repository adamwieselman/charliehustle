package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class FighterData {

    @JsonAlias("FighterID")
    private String fighterId;

    @JsonAlias("Color")
    private String color;

    @JsonAlias("Fighter")
    private List<FighterAltData> fighterAltData;

    public String getFighterId() {
        return fighterId;
    }

    public void setFighterId(String fighterId) {
        this.fighterId = fighterId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<FighterAltData> getFighterAltData() {
        return fighterAltData;
    }

    public void setFighterAltData(List<FighterAltData> fighterAltData) {
        this.fighterAltData = fighterAltData;
    }
}
