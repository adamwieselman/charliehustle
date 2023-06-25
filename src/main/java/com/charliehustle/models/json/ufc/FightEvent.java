package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class FightEvent {

    @JsonAlias("EventID")
    private String eventId;

    @JsonAlias("GMT")
    private String eventTime;

    @JsonAlias("Venue")
    private String venue;

    @JsonAlias("Country")
    private String country;

    @JsonAlias("City")
    private String city;

    @JsonAlias("Fights")
    private List<Fight> fights;


    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Fight> getFights() {
        return fights;
    }

    public void setFights(List<Fight> fights) {
        this.fights = fights;
    }
}
