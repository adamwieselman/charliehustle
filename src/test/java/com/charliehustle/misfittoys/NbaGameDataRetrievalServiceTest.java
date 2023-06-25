package com.charliehustle.misfittoys;

import com.charliehustle.services.UnirestApiService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NbaGameDataRetrievalServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    GameDataInfoRetrievalServiceHelper gameDataInfoRetrievalServiceHelper;

    @Mock
    UnirestApiService unirestApiService;

    @Mock
    GameDataJsonHandler gameDataJsonHandler;

    @InjectMocks
    public GameDataInfoRetrievalService gameDataInfoRetrievalService = new GameDataInfoRetrievalService();

    Map<String, String> headerDataMap;
    Map<String, Object> queryStringDataMap;

    @Before
    public void setup(){
        headerDataMap = new TreeMap<>();
        queryStringDataMap = new TreeMap<>();

        headerDataMap.put("accept", "application/json");
        queryStringDataMap.put("Stuff", "Stuff");
    }

    @Test
    public void testGetGameDataInfo_UnirestApiServiceThrowsException_shouldThrowException() throws UnirestException {
        Mockito.when(gameDataInfoRetrievalServiceHelper.getApplicationJsonHeaderData()).thenReturn(headerDataMap);
        Mockito.when(gameDataInfoRetrievalServiceHelper.getGameDataInfoQueryStringData()).thenReturn(queryStringDataMap);
        Mockito.when(unirestApiService.getWebsiteDataString("https://cdn.espn.com/core/mens-college-basketball/scoreboard/_/group/50/date/gameDate", headerDataMap, queryStringDataMap)).thenThrow(new UnirestException("UnirestApiService Exception: Horribleness"));

        try{
            gameDataInfoRetrievalService.getGameDataInfo("gameDate");
            fail();
        }catch(Exception e){
            assertEquals("UnirestApiService Exception: Horribleness", e.getMessage());
        }
    }

    @Test
    public void testGetGameDataInfo_happyPath() throws Exception {
        Mockito.when(gameDataInfoRetrievalServiceHelper.getApplicationJsonHeaderData()).thenReturn(headerDataMap);
        Mockito.when(gameDataInfoRetrievalServiceHelper.getGameDataInfoQueryStringData()).thenReturn(queryStringDataMap);
        Mockito.when(unirestApiService.getWebsiteDataString("https://cdn.espn.com/core/mens-college-basketball/scoreboard/_/group/50/date/gameDate", headerDataMap, queryStringDataMap)).thenReturn("gameDataInfo");

        try{
            gameDataInfoRetrievalService.getGameDataInfo("gameDate");
        }catch(Exception e){
            fail();
        }
    }

    public class GameDataInfoRetrievalService {

        private static final String ESPN_GAMEDATA_URL = "https://cdn.espn.com/core/mens-college-basketball/scoreboard/_/group/50/date/";

        @Autowired
        UnirestApiService unirestApiService;

        @Autowired
        GameDataJsonHandler gameDataJsonHandler;

        public void getGameDataInfo(String gameDate) throws Exception {
            unirestApiService.setUpUnirest();
            gameDataJsonHandler.processGameDataInfo(unirestApiService.getWebsiteDataString(ESPN_GAMEDATA_URL + gameDate, gameDataInfoRetrievalServiceHelper.getApplicationJsonHeaderData(), gameDataInfoRetrievalServiceHelper.getGameDataInfoQueryStringData()));
            unirestApiService.shutdownUnirest();
        }
    }

}
