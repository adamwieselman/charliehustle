package com.charliehustle.models.json.espn;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class EspnSbData {

    @JsonAlias("events")
    private List<EspnEvent> espnEvents;

    @JsonAlias("week")
    private EspnWeek espnWeek;

    @JsonAlias("season")
    private EspnSeason espnSeason;

    public List<EspnEvent> getEspnEvents() {
        return espnEvents;
    }

    public void setEspnEvents(List<EspnEvent> espnEvents) {
        this.espnEvents = espnEvents;
    }

    public EspnWeek getEspnWeek() {
        return espnWeek;
    }

    public void setESPNWeek(EspnWeek espnWeek) {
        this.espnWeek = espnWeek;
    }

    public EspnSeason getEspnSeason() {
        return espnSeason;
    }

    public void setEspnSeason(EspnSeason espnSeason) {
        this.espnSeason = espnSeason;
    }
}
