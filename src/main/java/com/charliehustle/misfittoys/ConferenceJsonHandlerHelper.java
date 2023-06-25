package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.Conference;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class ConferenceJsonHandlerHelper {

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public Conference createConferenceObject(JSONObject gameDataJsonObject, int conf) {
        Conference conference = basicObjectFactory.createConference();
        JSONObject conferenceData = gameDataJsonObject.getJSONObject("content").getJSONObject("altSbDropdown").getJSONArray("options").getJSONObject(conf);
        conference.setEspnConferenceId(conferenceData.getJSONObject("data").getString("group"));
        conference.setName(conferenceData.getString("label"));

        return conference;
    }
}
