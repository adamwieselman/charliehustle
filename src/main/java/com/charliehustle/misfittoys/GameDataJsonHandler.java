package com.charliehustle.misfittoys;


import com.charliehustle.factories.JsonObjectFactory;
import com.charliehustle.models.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GameDataJsonHandler {

    @Autowired
    JsonObjectFactory jsonObjectFactory;

    @Autowired
    GameDataService gameDataService;

    @Autowired
    VenueJsonHandler venueJsonHandler;

    @Autowired
    TeamJsonHandler teamJsonHandler;

    @Autowired
    ConferenceJsonHandler conferenceJsonHandler;

    @Autowired
    ConferenceTeamJsonHandler conferenceTeamJsonHandler;

    @Autowired
    TeamVenueJsonHandler teamVenueJsonHandler;

    @Autowired
    GameDataTeamJsonHandler gameDataTeamJsonHandler;

    @Autowired
    GameDataJsonHandlerHelper gameDataJsonHandlerHelper;

    public void processGameDataInfo(String websiteDataString) throws Exception {
        JSONObject gameDataJsonObject =  jsonObjectFactory.createJSONObject(websiteDataString);
        JSONArray events = gameDataJsonObject.getJSONObject("content").getJSONObject("sbData").getJSONArray("events");
        for(int event = 0; event < events.length(); ++event){
            JSONObject competition = events.getJSONObject(event).getJSONArray("competitions").getJSONObject(0);
            CurrentGameStatus currentGameStatus = gameDataJsonHandlerHelper.createGameStatus(competition);
            if("STATUS_FINAL".equals(currentGameStatus.getCurrentGameStatus())) {
                GameData gameData = gameDataService.findByEspnGameId(competition.getString("id"));
                if (gameData == null) {
                    gameData = gameDataService.saveGameDataInfo(gameDataJsonHandlerHelper.createGameDataObject(competition));
                    Venue venue = venueJsonHandler.processVenueInfo(competition);
                    List<Team> teams = teamJsonHandler.processTeamInfo(competition);
                    List<Conference> conferences = conferenceJsonHandler.processConferenceInfo(gameDataJsonObject, competition);
                    conferenceTeamJsonHandler.processConferenceTeamInfo(teams, conferences, gameData);
                    teamVenueJsonHandler.processTeamVenueInfo(teams, venue, gameData);
                    gameDataTeamJsonHandler.processGameDataTeamInfo(teams, gameData);
                }else{
                    System.out.println("Game info already exists - skipping game");
                }
            }
        }
    }
}
