package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StrikingData {

    @JsonAlias("Knock Down")
    private LandedAttempted knockdownLandedAttempted;

    @JsonAlias("Significant Strikes")
    private LandedAttempted significantStrikesLandedAttempted;

    @JsonAlias("Total Strikes")
    private LandedAttempted totalStrikesLandedAttempted;

    @JsonAlias("Punches")
    private LandedAttempted punchesLandedAttempted;

    @JsonAlias("Kicks")
    private LandedAttempted kicksLandedAttempted;

    @JsonAlias("Distance Strikes")
    private LandedAttempted distanceStrikesLandedAttempted;

    @JsonAlias("Clinch Significant Strikes")
    private LandedAttempted clinchSignificantStrikesLandedAttempted;

    @JsonAlias("Ground Significant Strikes")
    private LandedAttempted groundSignificantStrikesLandedAttempted;

    @JsonAlias("Clinch Total Strikes")
    private LandedAttempted clinchTotalStrikesLandedAttempted;

    @JsonAlias("Ground Total Strikes")
    private LandedAttempted groundTotalStrikesLandedAttempted;

    @JsonAlias("Head Significant Strikes")
    private LandedAttempted headSignificantStrikesLandedAttempted;

    @JsonAlias("Body Significant Strikes")
    private LandedAttempted bodySignificantStrikesLandedAttempted;

    @JsonAlias("Legs Significant Strikes")
    private LandedAttempted legsSignificantStrikesLandedAttempted;

    @JsonAlias("Head Total Strikes")
    private LandedAttempted headTotalStrikesLandedAttempted;

    @JsonAlias("Body Total Strikes")
    private LandedAttempted bodyTotalStrikesLandedAttempted;

    @JsonAlias("Leg Total Strikes")
    @JsonProperty("Legs Total Strikes")
    private LandedAttempted legsTotalStrikesLandedAttempted;

    @JsonAlias("Distance Head Strikes")
    private LandedAttempted distanceHeadStrikesLandedAttempted;

    @JsonAlias("Distance Body Strikes")
    private LandedAttempted distanceBodyStrikesLandedAttempted;

    @JsonAlias("Distance Leg Strikes")
    private LandedAttempted distanceLegStrikesLandedAttempted;

    @JsonAlias("Clinch Head Strikes")
    private LandedAttempted clinchHeadStrikesLandedAttempted;

    @JsonAlias("Clinch Body Strikes")
    private LandedAttempted clinchBodyStrikesLandedAttempted;

    @JsonAlias("Clinch Leg Strikes")
    private LandedAttempted clinchLegStrikesLandedAttempted;

    @JsonAlias("Ground Head Strikes")
    private LandedAttempted groundHeadStrikesLandedAttempted;

    @JsonAlias("Ground Body Strikes")
    private LandedAttempted groundBodyStrikesLandedAttempted;

    @JsonAlias("Ground Leg Strikes")
    private LandedAttempted groundLegStrikesLandedAttempted;

    @JsonAlias("Distance Head Kicks")
    private LandedAttempted distanceHeadKicksLandedAttempted;

    @JsonAlias("Distance Body Kicks")
    private LandedAttempted distanceBodyKicksLandedAttempted;

    @JsonAlias("Distance Leg Kicks")
    private LandedAttempted distanceLegKicksLandedAttempted;

    @JsonAlias("Distance Head Punches")
    private LandedAttempted distanceHeadPunchesLandedAttempted;

    @JsonAlias("Distance Body Punches")
    private LandedAttempted distanceBodyPunchesLandedAttempted;

    @JsonAlias("Clinch Significant Kicks")
    private LandedAttempted clinchSignificantKicksLandedAttempted;

    @JsonAlias("Clinch Significant Punches")
    private LandedAttempted clinchSignificantPunchesLandedAttempted;

    @JsonAlias("Ground Significant Kicks")
    private LandedAttempted groundSignificantKicksLandedAttempted;

    @JsonAlias("Ground Significant Punches")
    private LandedAttempted groundSignificantPunchesLandedAttempted;

    public LandedAttempted getKnockdownLandedAttempted() {
        return knockdownLandedAttempted;
    }

    public void setKnockdownLandedAttempted(LandedAttempted knockdownLandedAttempted) {
        this.knockdownLandedAttempted = knockdownLandedAttempted;
    }

    public LandedAttempted getSignificantStrikesLandedAttempted() {
        return significantStrikesLandedAttempted;
    }

    public void setSignificantStrikesLandedAttempted(LandedAttempted significantStrikesLandedAttempted) {
        this.significantStrikesLandedAttempted = significantStrikesLandedAttempted;
    }

    public LandedAttempted getTotalStrikesLandedAttempted() {
        return totalStrikesLandedAttempted;
    }

    public void setTotalStrikesLandedAttempted(LandedAttempted totalStrikesLandedAttempted) {
        this.totalStrikesLandedAttempted = totalStrikesLandedAttempted;
    }

    public LandedAttempted getPunchesLandedAttempted() {
        return punchesLandedAttempted;
    }

    public void setPunchesLandedAttempted(LandedAttempted punchesLandedAttempted) {
        this.punchesLandedAttempted = punchesLandedAttempted;
    }

    public LandedAttempted getKicksLandedAttempted() {
        return kicksLandedAttempted;
    }

    public void setKicksLandedAttempted(LandedAttempted kicksLandedAttempted) {
        this.kicksLandedAttempted = kicksLandedAttempted;
    }

    public LandedAttempted getDistanceStrikesLandedAttempted() {
        return distanceStrikesLandedAttempted;
    }

    public void setDistanceStrikesLandedAttempted(LandedAttempted distanceStrikesLandedAttempted) {
        this.distanceStrikesLandedAttempted = distanceStrikesLandedAttempted;
    }

    public LandedAttempted getClinchSignificantStrikesLandedAttempted() {
        return clinchSignificantStrikesLandedAttempted;
    }

    public void setClinchSignificantStrikesLandedAttempted(LandedAttempted clinchSignificantStrikesLandedAttempted) {
        this.clinchSignificantStrikesLandedAttempted = clinchSignificantStrikesLandedAttempted;
    }

    public LandedAttempted getGroundSignificantStrikesLandedAttempted() {
        return groundSignificantStrikesLandedAttempted;
    }

    public void setGroundSignificantStrikesLandedAttempted(LandedAttempted groundSignificantStrikesLandedAttempted) {
        this.groundSignificantStrikesLandedAttempted = groundSignificantStrikesLandedAttempted;
    }

    public LandedAttempted getClinchTotalStrikesLandedAttempted() {
        return clinchTotalStrikesLandedAttempted;
    }

    public void setClinchTotalStrikesLandedAttempted(LandedAttempted clinchTotalStrikesLandedAttempted) {
        this.clinchTotalStrikesLandedAttempted = clinchTotalStrikesLandedAttempted;
    }

    public LandedAttempted getGroundTotalStrikesLandedAttempted() {
        return groundTotalStrikesLandedAttempted;
    }

    public void setGroundTotalStrikesLandedAttempted(LandedAttempted groundTotalStrikesLandedAttempted) {
        this.groundTotalStrikesLandedAttempted = groundTotalStrikesLandedAttempted;
    }

    public LandedAttempted getHeadSignificantStrikesLandedAttempted() {
        return headSignificantStrikesLandedAttempted;
    }

    public void setHeadSignificantStrikesLandedAttempted(LandedAttempted headSignificantStrikesLandedAttempted) {
        this.headSignificantStrikesLandedAttempted = headSignificantStrikesLandedAttempted;
    }

    public LandedAttempted getBodySignificantStrikesLandedAttempted() {
        return bodySignificantStrikesLandedAttempted;
    }

    public void setBodySignificantStrikesLandedAttempted(LandedAttempted bodySignificantStrikesLandedAttempted) {
        this.bodySignificantStrikesLandedAttempted = bodySignificantStrikesLandedAttempted;
    }

    public LandedAttempted getLegsSignificantStrikesLandedAttempted() {
        return legsSignificantStrikesLandedAttempted;
    }

    public void setLegsSignificantStrikesLandedAttempted(LandedAttempted legsSignificantStrikesLandedAttempted) {
        this.legsSignificantStrikesLandedAttempted = legsSignificantStrikesLandedAttempted;
    }

    public LandedAttempted getHeadTotalStrikesLandedAttempted() {
        return headTotalStrikesLandedAttempted;
    }

    public void setHeadTotalStrikesLandedAttempted(LandedAttempted headTotalStrikesLandedAttempted) {
        this.headTotalStrikesLandedAttempted = headTotalStrikesLandedAttempted;
    }

    public LandedAttempted getBodyTotalStrikesLandedAttempted() {
        return bodyTotalStrikesLandedAttempted;
    }

    public void setBodyTotalStrikesLandedAttempted(LandedAttempted bodyTotalStrikesLandedAttempted) {
        this.bodyTotalStrikesLandedAttempted = bodyTotalStrikesLandedAttempted;
    }

    public LandedAttempted getLegsTotalStrikesLandedAttempted() {
        return legsTotalStrikesLandedAttempted;
    }

    public void setLegsTotalStrikesLandedAttempted(LandedAttempted legsTotalStrikesLandedAttempted) {
        this.legsTotalStrikesLandedAttempted = legsTotalStrikesLandedAttempted;
    }

    public LandedAttempted getDistanceHeadStrikesLandedAttempted() {
        return distanceHeadStrikesLandedAttempted;
    }

    public void setDistanceHeadStrikesLandedAttempted(LandedAttempted distanceHeadStrikesLandedAttempted) {
        this.distanceHeadStrikesLandedAttempted = distanceHeadStrikesLandedAttempted;
    }

    public LandedAttempted getDistanceBodyStrikesLandedAttempted() {
        return distanceBodyStrikesLandedAttempted;
    }

    public void setDistanceBodyStrikesLandedAttempted(LandedAttempted distanceBodyStrikesLandedAttempted) {
        this.distanceBodyStrikesLandedAttempted = distanceBodyStrikesLandedAttempted;
    }

    public LandedAttempted getDistanceLegStrikesLandedAttempted() {
        return distanceLegStrikesLandedAttempted;
    }

    public void setDistanceLegStrikesLandedAttempted(LandedAttempted distanceLegStrikesLandedAttempted) {
        this.distanceLegStrikesLandedAttempted = distanceLegStrikesLandedAttempted;
    }

    public LandedAttempted getClinchHeadStrikesLandedAttempted() {
        return clinchHeadStrikesLandedAttempted;
    }

    public void setClinchHeadStrikesLandedAttempted(LandedAttempted clinchHeadStrikesLandedAttempted) {
        this.clinchHeadStrikesLandedAttempted = clinchHeadStrikesLandedAttempted;
    }

    public LandedAttempted getClinchBodyStrikesLandedAttempted() {
        return clinchBodyStrikesLandedAttempted;
    }

    public void setClinchBodyStrikesLandedAttempted(LandedAttempted clinchBodyStrikesLandedAttempted) {
        this.clinchBodyStrikesLandedAttempted = clinchBodyStrikesLandedAttempted;
    }

    public LandedAttempted getClinchLegStrikesLandedAttempted() {
        return clinchLegStrikesLandedAttempted;
    }

    public void setClinchLegStrikesLandedAttempted(LandedAttempted clinchLegStrikesLandedAttempted) {
        this.clinchLegStrikesLandedAttempted = clinchLegStrikesLandedAttempted;
    }

    public LandedAttempted getGroundHeadStrikesLandedAttempted() {
        return groundHeadStrikesLandedAttempted;
    }

    public void setGroundHeadStrikesLandedAttempted(LandedAttempted groundHeadStrikesLandedAttempted) {
        this.groundHeadStrikesLandedAttempted = groundHeadStrikesLandedAttempted;
    }

    public LandedAttempted getGroundBodyStrikesLandedAttempted() {
        return groundBodyStrikesLandedAttempted;
    }

    public void setGroundBodyStrikesLandedAttempted(LandedAttempted groundBodyStrikesLandedAttempted) {
        this.groundBodyStrikesLandedAttempted = groundBodyStrikesLandedAttempted;
    }

    public LandedAttempted getGroundLegStrikesLandedAttempted() {
        return groundLegStrikesLandedAttempted;
    }

    public void setGroundLegStrikesLandedAttempted(LandedAttempted groundLegStrikesLandedAttempted) {
        this.groundLegStrikesLandedAttempted = groundLegStrikesLandedAttempted;
    }

    public LandedAttempted getDistanceHeadKicksLandedAttempted() {
        return distanceHeadKicksLandedAttempted;
    }

    public void setDistanceHeadKicksLandedAttempted(LandedAttempted distanceHeadKicksLandedAttempted) {
        this.distanceHeadKicksLandedAttempted = distanceHeadKicksLandedAttempted;
    }

    public LandedAttempted getDistanceBodyKicksLandedAttempted() {
        return distanceBodyKicksLandedAttempted;
    }

    public void setDistanceBodyKicksLandedAttempted(LandedAttempted distanceBodyKicksLandedAttempted) {
        this.distanceBodyKicksLandedAttempted = distanceBodyKicksLandedAttempted;
    }

    public LandedAttempted getDistanceLegKicksLandedAttempted() {
        return distanceLegKicksLandedAttempted;
    }

    public void setDistanceLegKicksLandedAttempted(LandedAttempted distanceLegKicksLandedAttempted) {
        this.distanceLegKicksLandedAttempted = distanceLegKicksLandedAttempted;
    }

    public LandedAttempted getDistanceHeadPunchesLandedAttempted() {
        return distanceHeadPunchesLandedAttempted;
    }

    public void setDistanceHeadPunchesLandedAttempted(LandedAttempted distanceHeadPunchesLandedAttempted) {
        this.distanceHeadPunchesLandedAttempted = distanceHeadPunchesLandedAttempted;
    }

    public LandedAttempted getDistanceBodyPunchesLandedAttempted() {
        return distanceBodyPunchesLandedAttempted;
    }

    public void setDistanceBodyPunchesLandedAttempted(LandedAttempted distanceBodyPunchesLandedAttempted) {
        this.distanceBodyPunchesLandedAttempted = distanceBodyPunchesLandedAttempted;
    }

    public LandedAttempted getClinchSignificantKicksLandedAttempted() {
        return clinchSignificantKicksLandedAttempted;
    }

    public void setClinchSignificantKicksLandedAttempted(LandedAttempted clinchSignificantKicksLandedAttempted) {
        this.clinchSignificantKicksLandedAttempted = clinchSignificantKicksLandedAttempted;
    }

    public LandedAttempted getClinchSignificantPunchesLandedAttempted() {
        return clinchSignificantPunchesLandedAttempted;
    }

    public void setClinchSignificantPunchesLandedAttempted(LandedAttempted clinchSignificantPunchesLandedAttempted) {
        this.clinchSignificantPunchesLandedAttempted = clinchSignificantPunchesLandedAttempted;
    }

    public LandedAttempted getGroundSignificantKicksLandedAttempted() {
        return groundSignificantKicksLandedAttempted;
    }

    public void setGroundSignificantKicksLandedAttempted(LandedAttempted groundSignificantKicksLandedAttempted) {
        this.groundSignificantKicksLandedAttempted = groundSignificantKicksLandedAttempted;
    }

    public LandedAttempted getGroundSignificantPunchesLandedAttempted() {
        return groundSignificantPunchesLandedAttempted;
    }

    public void setGroundSignificantPunchesLandedAttempted(LandedAttempted groundSignificantPunchesLandedAttempted) {
        this.groundSignificantPunchesLandedAttempted = groundSignificantPunchesLandedAttempted;
    }
}
