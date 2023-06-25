package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class GameDataInfoRetrievalServiceHelper {

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public Map<String, String> getApplicationJsonHeaderData() {
        Map<String, String> applicationJsonHeaderData = basicObjectFactory.createKeyValueMap();
        applicationJsonHeaderData.put("accept", "application/json");
        return applicationJsonHeaderData;
    }

    public Map<String, Object> getGameDataInfoQueryStringData() {
        Map<String, Object> queryStringData = basicObjectFactory.createKeyObjectMap();
        queryStringData.put("xhr", 1);
        queryStringData.put("render", true);
        queryStringData.put("device", "desktop");
        queryStringData.put("country", "us");
        queryStringData.put("lang", "en");
        queryStringData.put("region", "us");
        queryStringData.put("site", "espn");
        queryStringData.put("edition-host", "espn.com");
        queryStringData.put("one-site", true);
        queryStringData.put("site-type", "full");
        return queryStringData;
    }
}
