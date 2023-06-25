package com.charliehustle.models;

public class CurrentGameStatus {

    String currentGameStatus;
    Integer currentPeriod;
    String currentClock;
    String currentState;

    public String getCurrentGameStatus() {
        return currentGameStatus;
    }

    public void setCurrentGameStatus(String currentGameStatus) {
        this.currentGameStatus = currentGameStatus;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getCurrentClock() {
        return currentClock;
    }

    public void setCurrentClock(String currentClock) {
        this.currentClock = currentClock;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
