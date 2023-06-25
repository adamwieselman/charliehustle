package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class FighterAltData {

    @JsonAlias("Strikes")
    List<StrikeAltData> strikeData;

    @JsonAlias("Grappling")
    List<GrapplingAltData> grapplingData;

    @JsonAlias("TIP")
    List<TipAltData> tipAltData;

    public List<StrikeAltData> getStrikeData() {
        return strikeData;
    }

    public void setStrikeData(List<StrikeAltData> strikeData) {
        this.strikeData = strikeData;
    }

    public List<GrapplingAltData> getGrapplingData() {
        return grapplingData;
    }

    public void setGrapplingData(List<GrapplingAltData> grapplingData) {
        this.grapplingData = grapplingData;
    }

    public List<TipAltData> getTipAltData() {
        return tipAltData;
    }

    public void setTipAltData(List<TipAltData> tipAltData) {
        this.tipAltData = tipAltData;
    }
}
