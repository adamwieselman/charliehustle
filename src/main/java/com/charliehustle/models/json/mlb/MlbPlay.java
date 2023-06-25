package com.charliehustle.models.json.mlb;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class MlbPlay {

    @JsonAlias("result")
    private MlbResult mlbResult;

    @JsonAlias("about")
    private MlbAbout mlbAbout;

    @JsonAlias("runners")
    private List<MlbRunner> mlbRunners;

    @JsonAlias("playEvents")
    private List<MlbPlayEvent> mlbPlayEvents;

    @JsonAlias("matchup")
    private MlbMatchup mlbMatchup;

    public MlbResult getMlbResult() {
        return mlbResult;
    }

    public void setMlbResult(MlbResult mlbResult) {
        this.mlbResult = mlbResult;
    }

    public MlbAbout getMlbAbout() {
        return mlbAbout;
    }

    public void setMlbAbout(MlbAbout mlbAbout) {
        this.mlbAbout = mlbAbout;
    }

    public List<MlbRunner> getMlbRunners() {
        return mlbRunners;
    }

    public void setMlbRunners(List<MlbRunner> mlbRunners) {
        this.mlbRunners = mlbRunners;
    }

    public List<MlbPlayEvent> getMlbPlayEvents() {
        return mlbPlayEvents;
    }

    public void setMlbPlayEvents(List<MlbPlayEvent> mlbPlayEvents) {
        this.mlbPlayEvents = mlbPlayEvents;
    }

    public MlbMatchup getMlbMatchup() {
        return mlbMatchup;
    }

    public void setMlbMatchup(MlbMatchup mlbMatchup) {
        this.mlbMatchup = mlbMatchup;
    }
}
