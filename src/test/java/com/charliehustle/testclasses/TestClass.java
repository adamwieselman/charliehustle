package com.charliehustle.testclasses;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class TestClass {
    @JsonAlias("bigGame")
    private String game;

    private String place;

    @JsonAlias("events")
    private List<Event> events;

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Event> getEvents() {return events; }

    public void setEvents(List<Event> events) {this.events = events; }
}
