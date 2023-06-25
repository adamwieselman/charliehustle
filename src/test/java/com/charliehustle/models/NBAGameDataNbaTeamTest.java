package com.charliehustle.models;


import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class NBAGameDataNbaTeamTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public GameDataTeam gameDataTeam = new GameDataTeam();

    @Test
    public void testSetsGets() {
        LocalDateTime time = LocalDateTime.now();
        gameDataTeam.setEspnGameId("gameid");
        gameDataTeam.setEspnTeamId("teamid");
        gameDataTeam.setId(100L);

        assertEquals("gameid", gameDataTeam.getEspnGameId());
        assertEquals("teamid", gameDataTeam.getEspnTeamId());
        assertEquals(new Long(100), gameDataTeam.getId());
    }
}

