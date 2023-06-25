package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class NflPlayByPlayDataViewerGameDetails {

    @JsonAlias("homeTeam")
    private NflPlayByPlayTeam homeTeam;

    @JsonAlias("week")
    private Integer week;

    @JsonAlias("year")
    private Integer year;

    @JsonAlias("date")
    private String date;

    @JsonAlias("visitorTeam")
    private NflPlayByPlayTeam visitorTeam;

    @JsonAlias("weather")
    private NflPlayByPlayWeather weather;

    @JsonAlias("drives")
    private List<NflPlayByPlayDrive> drives;

    @JsonAlias("plays")
    private List<NflPlayByPlayPlay> plays;

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NflPlayByPlayTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(NflPlayByPlayTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public NflPlayByPlayTeam getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(NflPlayByPlayTeam visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public NflPlayByPlayWeather getWeather() {
        return weather;
    }

    public void setWeather(NflPlayByPlayWeather weather) {
        this.weather = weather;
    }

    public List<NflPlayByPlayDrive> getDrives() {
        return drives;
    }

    public void setDrives(List<NflPlayByPlayDrive> drives) {
        this.drives = drives;
    }

    public List<NflPlayByPlayPlay> getPlays() {
        return plays;
    }

    public void setPlays(List<NflPlayByPlayPlay> plays) {
        this.plays = plays;
    }
}
