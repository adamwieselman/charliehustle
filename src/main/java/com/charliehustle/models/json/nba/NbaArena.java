package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NbaArena {

    @JsonAlias("name")
    private String name;

    @JsonAlias("isDomestic")
    private boolean domestic;

    @JsonAlias("city")
    private String city;

    @JsonAlias("stateAbbr")
    private String stateAbbr;

    @JsonAlias("country")
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDomestic() {
        return domestic;
    }

    public void setDomestic(boolean domestic) {
        this.domestic = domestic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
