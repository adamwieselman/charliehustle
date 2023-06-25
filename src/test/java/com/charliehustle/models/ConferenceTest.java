package com.charliehustle.models;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class ConferenceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public Conference conference = new Conference();

    @Test
    public void testSetsGets() {
        conference.setId(345L);
        conference.setName("competitorName");
        conference.setEspnConferenceId("789456");

        assertEquals(new Long(345), conference.getId());
        assertEquals("competitorName", conference.getName());
        assertEquals("789456", conference.getEspnConferenceId());
    }
}

