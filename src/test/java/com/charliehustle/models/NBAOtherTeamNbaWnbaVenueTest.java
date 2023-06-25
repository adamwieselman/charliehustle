package com.charliehustle.models;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class NBAOtherTeamNbaWnbaVenueTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public TeamVenue teamVenue  = new TeamVenue();

    @Test
    public void testSetsGets() {
        LocalDate startDate = LocalDate.of(2018, 4, 5);
        LocalDate endDate = LocalDate.of(2019, 10, 14);
        teamVenue.setId(675L);
        teamVenue.setEspnTeamId("968");
        teamVenue.setEspnVenueId("2388");
        teamVenue.setStartDate(startDate);
        teamVenue.setEndDate(endDate);

        assertEquals(new Long(675), teamVenue.getId());
        assertEquals("968", teamVenue.getEspnTeamId());
        assertEquals("2388", teamVenue.getEspnVenueId());
        assertEquals(startDate, teamVenue.getStartDate());
        assertEquals(endDate, teamVenue.getEndDate());
    }
}

