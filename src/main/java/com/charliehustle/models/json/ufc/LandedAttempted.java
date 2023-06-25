package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class LandedAttempted {

    @JsonAlias("Landed")
    private String landed;

    @JsonAlias("Attempts")
    private String attempted;

    public String getLanded() {
        return landed;
    }

    public void setLanded(String landed) {
        this.landed = landed;
    }

    public String getAttempted() {
        return attempted;
    }

    public void setAttempted(String attempted) {
        this.attempted = attempted;
    }
}
