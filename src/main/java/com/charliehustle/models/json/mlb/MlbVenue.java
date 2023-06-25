package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbVenue {
    @JsonAlias("id")
    private String id;

    @JsonAlias("name")
    private String name;

    @JsonAlias("location")
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
}
