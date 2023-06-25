package com.charliehustle.models.json.ufc;

import com.fasterxml.jackson.annotation.JsonAlias;

public class GrapplingData {

    @JsonAlias("Takedowns")
    private LandedAttempted takedownsLandedAttempted;

    @JsonAlias("Submissions")
    private LandedAttempted submissionsLandedAttempted;

    @JsonAlias("Reversals")
    private LandedAttempted reversalsLandedAttempted;

    @JsonAlias("Standups")
    private LandedAttempted standupsLandedAttempted;

    public LandedAttempted getTakedownsLandedAttempted() {
        return takedownsLandedAttempted;
    }

    public void setTakedownsLandedAttempted(LandedAttempted takedownsLandedAttempted) {
        this.takedownsLandedAttempted = takedownsLandedAttempted;
    }

    public LandedAttempted getSubmissionsLandedAttempted() {
        return submissionsLandedAttempted;
    }

    public void setSubmissionsLandedAttempted(LandedAttempted submissionsLandedAttempted) {
        this.submissionsLandedAttempted = submissionsLandedAttempted;
    }

    public LandedAttempted getReversalsLandedAttempted() {
        return reversalsLandedAttempted;
    }

    public void setReversalsLandedAttempted(LandedAttempted reversalsLandedAttempted) {
        this.reversalsLandedAttempted = reversalsLandedAttempted;
    }

    public LandedAttempted getStandupsLandedAttempted() {
        return standupsLandedAttempted;
    }

    public void setStandupsLandedAttempted(LandedAttempted standupsLandedAttempted) {
        this.standupsLandedAttempted = standupsLandedAttempted;
    }

}
