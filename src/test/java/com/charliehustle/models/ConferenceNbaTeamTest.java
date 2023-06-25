package com.charliehustle.models;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ConferenceNbaTeamTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public ConferenceTeam conferenceTeam = new ConferenceTeam();

    @Test
    public void testSetsGets() {
        LocalDate startDate = LocalDate.of(2018, 4, 5);
        LocalDate endDate = LocalDate.of(2019, 10, 14);
        conferenceTeam.setId(675L);
        conferenceTeam.setEspnTeamId("3345");
        conferenceTeam.setEspnConferenceId("789456");
        conferenceTeam.setStartDate(startDate);
        conferenceTeam.setEndDate(endDate);

        assertEquals(new Long(675), conferenceTeam.getId());
        assertEquals("3345", conferenceTeam.getEspnTeamId());
        assertEquals("789456", conferenceTeam.getEspnConferenceId());
        assertEquals(startDate, conferenceTeam.getStartDate());
        assertEquals(endDate, conferenceTeam.getEndDate());
    }
}

