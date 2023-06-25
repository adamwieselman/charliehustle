package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Fighter {

    @JsonAlias("FighterID")
    private String fighterId;

    @JsonAlias("Color")
    private String cornerColor;

    @JsonAlias("FirstName")
    private String firstName;

    @JsonAlias("LastName")
    private String lastName;

    @JsonAlias("FullName")
    private String fullName;

    @JsonAlias("Height")
    private String height;

    @JsonAlias("Weight")
    private String weight;

    @JsonAlias("Stance")
    private String stance;

    public String getFighterId() {
        return fighterId;
    }

    public void setFighterId(String fighterId) {
        this.fighterId = fighterId;
    }

    public String getCornerColor() {
        return cornerColor;
    }

    public void setCornerColor(String cornerColor) {
        this.cornerColor = cornerColor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStance() {
        return stance;
    }

    public void setStance(String stance) {
        this.stance = stance;
    }
}
