package com.charliehustle.models;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class CurrentNbaGameStatusTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public CurrentGameStatus currentGameStatus = new CurrentGameStatus();

    @Test
    public void testSetsGets() {
        currentGameStatus.setCurrentClock("0:00");
        currentGameStatus.setCurrentGameStatus("final");
        currentGameStatus.setCurrentPeriod(1);
        currentGameStatus.setCurrentState("post");

        assertEquals("0:00", currentGameStatus.getCurrentClock());
        assertEquals("post", currentGameStatus.getCurrentState());
        assertEquals(new Integer(1), currentGameStatus.getCurrentPeriod());
        assertEquals("final", currentGameStatus.getCurrentGameStatus());
    }
}

