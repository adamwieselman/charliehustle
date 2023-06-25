package com.charliehustle.models.json.nba;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NbaPeriod {

    @JsonAlias("isHalftime")
    private boolean halftime;

    @JsonAlias("isEndOfPeriod")
    private boolean endOfPeriod;

    @JsonAlias("current")
    private int current;

    @JsonAlias("type")
    private int type;

    @JsonAlias("maxRegular")
    private int maxRegular;

    public boolean isHalftime() {
        return halftime;
    }

    public void setHalftime(boolean halftime) {
        this.halftime = halftime;
    }

    public boolean isEndOfPeriod() {
        return endOfPeriod;
    }

    public void setEndOfPeriod(boolean endOfPeriod) {
        this.endOfPeriod = endOfPeriod;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMaxRegular() {
        return maxRegular;
    }

    public void setMaxRegular(int maxRegular) {
        this.maxRegular = maxRegular;
    }
}
