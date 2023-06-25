package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.Conference;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ConferenceJsonHandler {

    @Autowired
    ConferenceJsonHandlerHelper conferenceJsonHandlerHelper;

    @Autowired
    ConferenceService conferenceService;

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public List<Conference> processConferenceInfo(JSONObject gameDataJsonObject, JSONObject competition) {

        List<Conference> conferences = basicObjectFactory.createConferenceList();
        JSONArray competitorArray = competition.getJSONArray("competitors");
        for(int competitor = 0; competitor < competitorArray.length(); ++competitor) {
            String conferenceId = competitorArray.getJSONObject(competitor).getJSONObject("team").getString("conferenceId");
            Conference conference = conferenceService.findByEspnConferenceId(conferenceId);
            if (conference == null) {
                JSONArray conferenceArray = gameDataJsonObject.getJSONObject("content").getJSONObject("altSbDropdown").getJSONArray("options");
                for (int conf = 0; conf < conferenceArray.length(); ++conf) {
                    if (conferenceId.equals(conferenceArray.getJSONObject(conf).getJSONObject("data").getString("group"))) {
                        conference = conferenceService.saveConference(conferenceJsonHandlerHelper.createConferenceObject(gameDataJsonObject, conf));
                    }
                }
            }
            conferences.add(conference);
        }

        return conferences;
    }
}
