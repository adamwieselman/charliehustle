package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbStatus {

    @JsonAlias("detailedState")
    private String detailedState;

    @JsonAlias("statusCode")
    private String statusCode;

    public String getDetailedState() {
        return detailedState;
    }

    public void setDetailedState(String detailedState) {
        this.detailedState = detailedState;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
