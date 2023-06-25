package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class StrikeAltData {

    @JsonAlias("ID")
    private String id;

    @JsonAlias("Name")
    private String name;

    @JsonAlias("Attempts")
    private String attempts;

    @JsonAlias("Landed")
    private String landed;

    @JsonAlias("Missed")
    private String missed;

    @JsonAlias("Pct")
    private String pct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttempts() {
        return attempts;
    }

    public void setAttempts(String attempts) {
        this.attempts = attempts;
    }

    public String getLanded() {
        return landed;
    }

    public void setLanded(String landed) {
        this.landed = landed;
    }

    public String getMissed() {
        return missed;
    }

    public void setMissed(String missed) {
        this.missed = missed;
    }

    public String getPct() {
        return pct;
    }

    public void setPct(String pct) {
        this.pct = pct;
    }
}
