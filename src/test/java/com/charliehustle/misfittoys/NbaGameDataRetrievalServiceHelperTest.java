package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class NbaGameDataRetrievalServiceHelperTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @InjectMocks
    public GameDataInfoRetrievalServiceHelper gameDataInfoRetrievalServiceHelper = new GameDataInfoRetrievalServiceHelper();

    @Test
    public void testGetApplicationJsonHeaderData() {
        Mockito.when(basicObjectFactory.createKeyValueMap()).thenReturn(new TreeMap<String, String>());
        Map<String, String> headerMap = gameDataInfoRetrievalServiceHelper.getApplicationJsonHeaderData();
        assertEquals("application/json", headerMap.get("accept"));
    }

    @Test
    public void testGetGameDataInfoQueryStringData(){
        Mockito.when(basicObjectFactory.createKeyObjectMap()).thenReturn(new TreeMap<String, Object>());
        Map<String, Object> queryStringMap = gameDataInfoRetrievalServiceHelper.getGameDataInfoQueryStringData();
        assertEquals(1, queryStringMap.get("xhr"));
        assertEquals(true, queryStringMap.get("render"));
        assertEquals("desktop", queryStringMap.get("device"));
        assertEquals("us", queryStringMap.get("country"));
        assertEquals("en", queryStringMap.get("lang"));
        assertEquals("us", queryStringMap.get("region"));
        assertEquals("espn", queryStringMap.get("site"));
        assertEquals("espn.com", queryStringMap.get("edition-host"));
        assertEquals(true, queryStringMap.get("one-site"));
        assertEquals("full", queryStringMap.get("site-type"));
    }

}
