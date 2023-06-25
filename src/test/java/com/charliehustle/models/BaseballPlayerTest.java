package com.charliehustle.models;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class BaseballPlayerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public BaseballPlayer baseballPlayer = new BaseballPlayer();

    @Test
    public void testSetsGets() {
        baseballPlayer.setAge("10");
        baseballPlayer.setHanded("Left");
        baseballPlayer.setInjuryDate("2001-01-10");
        baseballPlayer.setInjuryNotes("injury");
        baseballPlayer.setMlbEta("mlbEta");
        baseballPlayer.setPlayerName("playername");
        baseballPlayer.setOrganizationalRank("orgRank");
        baseballPlayer.setOverallRank("overallRank");
        baseballPlayer.setPlatoon("platoon");
        baseballPlayer.setPosition("position");
        baseballPlayer.setMlbamid("667577");
        baseballPlayer.setPlayingLevel("playingLevel");
        baseballPlayer.setRole("role");
        baseballPlayer.setTeamId("teamId");
        assertEquals("10", baseballPlayer.getAge());
        assertEquals("Left", baseballPlayer.getHanded());
        assertEquals("667577", baseballPlayer.getMlbamid());
        assertEquals("2001-01-10", baseballPlayer.getInjuryDate());
        assertEquals("injury", baseballPlayer.getInjuryNotes());
        assertEquals("mlbEta", baseballPlayer.getMlbEta());
        assertEquals("playername", baseballPlayer.getPlayerName());
        assertEquals("orgRank", baseballPlayer.getOrganizationalRank());
        assertEquals("overallRank", baseballPlayer.getOverallRank());
        assertEquals("platoon", baseballPlayer.getPlatoon());
        assertEquals("position", baseballPlayer.getPosition());
        assertEquals("playingLevel", baseballPlayer.getPlayingLevel());
        assertEquals("role", baseballPlayer.getRole());
        assertEquals("teamId", baseballPlayer.getTeamId());
    }

    @Test
    public void testToString() {
        baseballPlayer.setAge("10");
        baseballPlayer.setHanded("Left");
        baseballPlayer.setInjuryDate("2001-01-10");
        baseballPlayer.setInjuryNotes("injury");
        baseballPlayer.setMlbEta("mlbEta");
        baseballPlayer.setPlayerName("playername");
        baseballPlayer.setOrganizationalRank("orgRank");
        baseballPlayer.setOverallRank("overallRank");
        baseballPlayer.setPlatoon("platoon");
        baseballPlayer.setPosition("position");
        baseballPlayer.setPlayingLevel("playingLevel");
        baseballPlayer.setRole("role");
        baseballPlayer.setTeamId("teamId");

        assertEquals("BaseballPlayer{role='role', position='position', player='playername', age='10', handed='Left', platoon='platoon', mlbEta='mlbEta', injuryNotes='injury', injuryDate='2001-01-10', organizationalRank=orgRank, playingLevel='playingLevel', overallRank='overallRank'}", baseballPlayer.toString());
    }
}

