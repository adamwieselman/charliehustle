package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbHitData {

    @JsonAlias("launchSpeed")
    private String launchSpeed;

    @JsonAlias("totalDistance")
    private String totalDistance;

    @JsonAlias("launchAngle")
    private String launchAngle;

    public String getLaunchSpeed() {
        return launchSpeed;
    }

    public void setLaunchSpeed(String launchSpeed) {
        this.launchSpeed = launchSpeed;
    }

    public String getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(String totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getLaunchAngle() {
        return launchAngle;
    }

    public void setLaunchAngle(String launchAngle) {
        this.launchAngle = launchAngle;
    }
}
