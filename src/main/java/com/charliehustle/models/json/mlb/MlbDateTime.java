package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbDateTime {

    @JsonAlias("dayNight")
    private String dayNight;

    @JsonAlias("originalDate")
    private String originalDate;

    @JsonAlias("time")
    private String time;

    public String getDayNight() {
        return dayNight;
    }

    public void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }

    public String getOriginalDate() {
        return originalDate;
    }

    public void setOriginalDate(String originalDate) {
        this.originalDate = originalDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
