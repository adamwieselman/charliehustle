package com.charliehustle.models.json.wnba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class WnbaPlay {

    @JsonAlias("evt")
    private int event;

    @JsonAlias("cl")
    private String clock;

    @JsonAlias("de")
    private String description;

    @JsonAlias("locX")
    private int locX;

    @JsonAlias("locY")
    private int locY;

    @JsonAlias("mtype")
    private int mtype;

    @JsonAlias("etype")
    private int eventType;

    @JsonAlias("opid")
    private String oppositionId;

    @JsonAlias("tid")
    private int timeId;

    @JsonAlias("pid")
    private int playerId;

    @JsonAlias("hs")
    private int homeScore;

    @JsonAlias("vs")
    private int visitorScore;

    @JsonAlias("epid")
    private String extraPlayerId;

    @JsonAlias("oftid")
    private int oftid;

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLocX() {
        return locX;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }

    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getOppositionId() {
        return oppositionId;
    }

    public void setOppositionId(String oppositionId) {
        this.oppositionId = oppositionId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getVisitorScore() {
        return visitorScore;
    }

    public void setVisitorScore(int visitorScore) {
        this.visitorScore = visitorScore;
    }

    public String getExtraPlayerId() {
        return extraPlayerId;
    }

    public void setExtraPlayerId(String extraPlayerId) {
        this.extraPlayerId = extraPlayerId;
    }

    public int getOftid() {
        return oftid;
    }

    public void setOftid(int oftid) {
        this.oftid = oftid;
    }
}
