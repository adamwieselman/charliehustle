package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbPlayEvent {

    @JsonAlias("pitchNum")
    private int pitchNum;

    @JsonAlias("isPitch")
    private boolean pitch;

    @JsonAlias("stats")
    private MlbStats stats;

    @JsonAlias("details")
    private MlbPitchDetails mlbPitchDetails;

    @JsonAlias("hitData")
    private MlbHitData hitData;

    public int getPitchNum() {
        return pitchNum;
    }

    public void setPitchNum(int pitchNum) {
        this.pitchNum = pitchNum;
    }

    public boolean isPitch() {
        return pitch;
    }

    public void setPitch(boolean pitch) {
        this.pitch = pitch;
    }

    public MlbStats getStats() {
        return stats;
    }

    public void setStats(MlbStats stats) {
        this.stats = stats;
    }

    public MlbPitchDetails getMlbPitchDetails() {
        return mlbPitchDetails;
    }

    public void setMlbPitchDetails(MlbPitchDetails mlbPitchDetails) {
        this.mlbPitchDetails = mlbPitchDetails;
    }

    public MlbHitData getHitData() {
        return hitData;
    }

    public void setHitData(MlbHitData hitData) {
        this.hitData = hitData;
    }
}
