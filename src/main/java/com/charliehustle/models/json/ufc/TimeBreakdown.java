package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TimeBreakdown {

    @JsonAlias("Standing Time")
    private String standingTime;

    @JsonAlias("Ground Time")
    private String groundTime;

    @JsonAlias("Control Time")
    private String controlTime;

    @JsonAlias("Neutral Time")
    private String neutralTime;

    @JsonAlias("Ground Control Time")
    private String groundControlTime;

    @JsonAlias("Distance Time")
    private String distanceTime;

    @JsonAlias("Clinch Time")
    private String clinchTime;

    @JsonAlias("Misc. Ground Control Time")
    private String miscGroundControlTime;

    @JsonAlias("Guard Control Time")
    private String guardControlTime;

    @JsonAlias("Half Guard Control Time")
    private String halfGuardControlTime;

    @JsonAlias("Side Control Time")
    private String sideControlTime;

    @JsonAlias("Mount Control Time")
    private String mountControlTime;

    @JsonAlias("Back Control Time")
    private String backControlTime;

    public String getStandingTime() {
        return standingTime;
    }

    public void setStandingTime(String standingTime) {
        this.standingTime = standingTime;
    }

    public String getGroundTime() {
        return groundTime;
    }

    public void setGroundTime(String groundTime) {
        this.groundTime = groundTime;
    }

    public String getControlTime() {
        return controlTime;
    }

    public void setControlTime(String controlTime) {
        this.controlTime = controlTime;
    }

    public String getNeutralTime() {
        return neutralTime;
    }

    public void setNeutralTime(String neutralTime) {
        this.neutralTime = neutralTime;
    }

    public String getGroundControlTime() {
        return groundControlTime;
    }

    public void setGroundControlTime(String groundControlTime) {
        this.groundControlTime = groundControlTime;
    }

    public String getDistanceTime() {
        return distanceTime;
    }

    public void setDistanceTime(String distanceTime) {
        this.distanceTime = distanceTime;
    }

    public String getClinchTime() {
        return clinchTime;
    }

    public void setClinchTime(String clinchTime) {
        this.clinchTime = clinchTime;
    }

    public String getMiscGroundControlTime() {
        return miscGroundControlTime;
    }

    public void setMiscGroundControlTime(String miscGroundControlTime) {
        this.miscGroundControlTime = miscGroundControlTime;
    }

    public String getGuardControlTime() {
        return guardControlTime;
    }

    public void setGuardControlTime(String guardControlTime) {
        this.guardControlTime = guardControlTime;
    }

    public String getHalfGuardControlTime() {
        return halfGuardControlTime;
    }

    public void setHalfGuardControlTime(String halfGuardControlTime) {
        this.halfGuardControlTime = halfGuardControlTime;
    }

    public String getSideControlTime() {
        return sideControlTime;
    }

    public void setSideControlTime(String sideControlTime) {
        this.sideControlTime = sideControlTime;
    }

    public String getMountControlTime() {
        return mountControlTime;
    }

    public void setMountControlTime(String mountControlTime) {
        this.mountControlTime = mountControlTime;
    }

    public String getBackControlTime() {
        return backControlTime;
    }

    public void setBackControlTime(String backControlTime) {
        this.backControlTime = backControlTime;
    }
}
