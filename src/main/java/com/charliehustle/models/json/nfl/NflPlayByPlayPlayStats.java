package com.charliehustle.models.json.nfl;

import com.fasterxml.jackson.annotation.JsonAlias;

public class NflPlayByPlayPlayStats {

    @JsonAlias("statId")
    private Integer statId;

    @JsonAlias("yards")
    private Integer yards;

    @JsonAlias("team")
    private NflPlayByPlayTeam team;

    @JsonAlias("playerName")
    private String playerName;

    public Integer getStatId() {
        return statId;
    }

    public void setStatId(Integer statId) {
        this.statId = statId;
    }

    public Integer getYards() {
        return yards;
    }

    public void setYards(Integer yards) {
        this.yards = yards;
    }

    public NflPlayByPlayTeam getTeam() {
        return team;
    }

    public void setTeam(NflPlayByPlayTeam team) {
        this.team = team;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
