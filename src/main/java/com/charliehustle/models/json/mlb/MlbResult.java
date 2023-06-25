package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbResult {

    @JsonAlias("description")
    private String description;

    @JsonAlias("type")
    private String type;

    @JsonAlias("event")
    private String event;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
