package com.charliehustle.factories;

import org.json.JSONObject;

public class JsonObjectFactory {
    public JSONObject createJSONObject(String websiteDataString) throws Exception {
        return new JSONObject(websiteDataString);
    }
}
