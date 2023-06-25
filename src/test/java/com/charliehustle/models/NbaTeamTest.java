package com.charliehustle.models;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

public class NbaTeamTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public Team team = new Team();

    @Test
    public void testSetsGets() {
        team.setId("id");
        team.setEspnTeamId("espnTeamId");
        team.setName("name");
        team.setShortName("shortname");

        assertEquals("espnTeamId", team.getEspnTeamId());
        assertEquals("name", team.getName());
        assertEquals("id", team.getId());
        assertEquals("shortname", team.getShortName());
    }
}

