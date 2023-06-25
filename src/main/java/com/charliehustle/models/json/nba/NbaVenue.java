package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NbaVenue {

    @JsonAlias("address")
    private NbaAddress nbaAddress;

    @JsonAlias("fullName")
    private String fullName;

    @JsonAlias("indoor")
    private boolean indoor;

    @JsonAlias("id")
    private String id;

    @JsonAlias("capacity")
    private int capacity;

    public NbaAddress getNbaAddress() {
        return nbaAddress;
    }

    public void setNbaAddress(NbaAddress nbaAddress) {
        this.nbaAddress = nbaAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
