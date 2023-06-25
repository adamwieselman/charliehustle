package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FighterRoundData {

    @JsonAlias("FighterID")
    private String fighterId;

    @JsonAlias("Strikes")
    private StrikingData strikingData;

    @JsonAlias("Grappling")
    private GrapplingData grapplingData;

    @JsonAlias("TIP")
    private TimeBreakdown timeBreakdown;

    public String getFighterId() {
        return fighterId;
    }

    public void setFighterId(String fighterId) {
        this.fighterId = fighterId;
    }

    public StrikingData getStrikingData() {
        return strikingData;
    }

    public void setStrikingData(StrikingData strikingData) {
        this.strikingData = strikingData;
    }

    public GrapplingData getGrapplingData() {
        return grapplingData;
    }

    public void setGrapplingData(GrapplingData grapplingData) {
        this.grapplingData = grapplingData;
    }

    public TimeBreakdown getTimeBreakdown() {
        return timeBreakdown;
    }

    public void setTimeBreakdown(TimeBreakdown timeBreakdown) {
        this.timeBreakdown = timeBreakdown;
    }
}
