package com.charliehustle.enums;

public enum GameSport {
    NBA("nba"),
    MLB("mlb"),
    NFL("nfl"),
    WNBA("wnba"),
    COLLEGE_FOOTBALL("ncf"),
    COLLEGE_BASKETBALL("ncb"),
    UFC("ufc");

    // declaring private variable for getting values
    private String sport;

    // getter method
    public String getSport()
    {
        return this.sport;
    }

    // enum constructor - cannot be public or protected
    private GameSport(String sport)
    {
        this.sport = sport;
    }
}
