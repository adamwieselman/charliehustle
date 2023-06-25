package com.charliehustle.services;


import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.BaseballPlayer;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BaseballPlayerDataRetrievalServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @Mock
    UnirestApiService unirestApiService;

    @InjectMocks
    public BaseballPlayerDataRetrievalService baseballPlayerDataRetrievalService = new BaseballPlayerDataRetrievalService();

    @Test
    public void testGetRosterResourceBaseballPlayerData() throws IOException, UnirestException {
        BaseballPlayer player = new BaseballPlayer();
        player.setPlayerName("Fake Player");
        BaseballPlayer[] players = new BaseballPlayer[1];
        players[0] = player;

        Mockito.when(basicObjectFactory.createBaseballPlayerList()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(unirestApiService).setUpUnirest();
        Mockito.doNothing().when(unirestApiService).shutdownUnirest();
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(new HashMap<>());
        Mockito.when(basicObjectFactory.createKeyObjectMap()).thenReturn(new HashMap<>());
        Mockito.when(unirestApiService.getWebsiteDataObject(Mockito.anyString(), Mockito.anyMap(), Mockito.anyMap(), Mockito.any())).thenReturn(players);

        List<BaseballPlayer> allPlayers = baseballPlayerDataRetrievalService.getRosterResourceBaseballPlayerData();
        assertEquals(30, allPlayers.size());
        assertEquals("Fake Player", allPlayers.get(0).getPlayerName());
    }

    @Test
    public void testGetRosterResourceBaseballPlayerDataList() throws IOException, UnirestException {
        BaseballPlayer player = new BaseballPlayer();
        player.setPlayerName("Fake Player");
        BaseballPlayer[] players = new BaseballPlayer[1];
        players[0] = player;

        Mockito.when(basicObjectFactory.createBaseballPlayerList()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(unirestApiService).setUpUnirest();
        Mockito.doNothing().when(unirestApiService).shutdownUnirest();
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(new HashMap<>());
        Mockito.when(basicObjectFactory.createKeyObjectMap()).thenReturn(new HashMap<>());
        Mockito.when(unirestApiService.getWebsiteDataObject(Mockito.anyString(), Mockito.anyMap(), Mockito.anyMap(), Mockito.any())).thenReturn(players);

        List<BaseballPlayer> allPlayers = baseballPlayerDataRetrievalService.getRosterResourceBaseballPlayerData();
        assertEquals(30, allPlayers.size());
        assertEquals("Fake Player", allPlayers.get(0).getPlayerName());
    }

}