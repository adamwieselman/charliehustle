package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MlbRunner {

    @JsonAlias("details")
    private MlbRunnerDetails mlbRunnerDetails;

    @JsonAlias("movement")
    private MlbMovement mlbMovement;

    public MlbRunnerDetails getMlbRunnerDetails() {
        return mlbRunnerDetails;
    }

    public void setMlbRunnerDetails(MlbRunnerDetails mlbRunnerDetails) {
        this.mlbRunnerDetails = mlbRunnerDetails;
    }

    public MlbMovement getMlbMovement() {
        return mlbMovement;
    }

    public void setMlbMovement(MlbMovement mlbMovement) {
        this.mlbMovement = mlbMovement;
    }
}
