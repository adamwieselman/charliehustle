package com.charliehustle.models;


import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class NbaGameDataTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public GameData gameData = new GameData();

    @Test
    public void testSetsGets() {
        LocalDateTime time = LocalDateTime.now();
        gameData.setGameDateTime(time);
        gameData.setEspnGameId("espnGameId");
        gameData.setNeutralSite(true);
        gameData.setConferenceCompetition(false);
        gameData.setVenueId(6L);
        gameData.setId(100L);

        assertEquals(time, gameData.getGameDateTime());
        assertEquals("espnGameId", gameData.getEspnGameId());
        assertEquals(true, gameData.isNeutralSite());
        assertEquals(false, gameData.isConferenceCompetition());
        assertEquals(new Long(6), gameData.getVenueId());
        assertEquals(new Long(100), gameData.getId());
    }
}

