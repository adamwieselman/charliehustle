package com.charliehustle.models;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class NbaWnbaVenueTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public Venue venue = new Venue();

    @Test
    public void testSetsGets() {
        venue.setId(258L);
        venue.setEspnVenueId("espnVenueId");
        venue.setFullName("fullName");
        venue.setCity("city");
        venue.setState("state");

        assertEquals(new Long(258), venue.getId());
        assertEquals("espnVenueId", venue.getEspnVenueId());
        assertEquals("fullName", venue.getFullName());
        assertEquals("city", venue.getCity());
        assertEquals("state", venue.getState());
    }
}

