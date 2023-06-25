package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbBreaks {

    @JsonAlias("breakAngle")
    private String breakAngle;

    @JsonAlias("breakLength")
    private String breakLength;

    @JsonAlias("breakY")
    private String breakY;

    @JsonAlias("breakX")
    private String breakX;

    @JsonAlias("breakZ")
    private String breakZ;

    public String getBreakAngle() {
        return breakAngle;
    }

    public void setBreakAngle(String breakAngle) {
        this.breakAngle = breakAngle;
    }

    public String getBreakLength() {
        return breakLength;
    }

    public void setBreakLength(String breakLength) {
        this.breakLength = breakLength;
    }

    public String getBreakY() {
        return breakY;
    }

    public void setBreakY(String breakY) {
        this.breakY = breakY;
    }

    public String getBreakX() {
        return breakX;
    }

    public void setBreakX(String breakX) {
        this.breakX = breakX;
    }

    public String getBreakZ() {
        return breakZ;
    }

    public void setBreakZ(String breakZ) {
        this.breakZ = breakZ;
    }
}
