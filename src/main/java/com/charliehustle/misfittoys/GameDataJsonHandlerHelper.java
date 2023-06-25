package com.charliehustle.misfittoys;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.CurrentGameStatus;
import com.charliehustle.models.GameData;

public class GameDataJsonHandlerHelper {

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public GameData createGameDataObject(JSONObject competition) {
        GameData gameData = basicObjectFactory.createGameDataInfo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
        gameData.setGameDateTime(LocalDateTime.parse(competition.getString("date"), formatter));
        gameData.setEspnGameId(competition.getString("id"));
        gameData.setNeutralSite(competition.getBoolean("neutralSite"));
        gameData.setConferenceCompetition(competition.getBoolean("conferenceCompetition"));
        JSONObject venueObject = competition.getJSONObject("venue");
//        gameData.setVenueId(new Long(venueObject.getString("id")));
        return gameData;
    }



//    public Conference createConferenceObject(JSONObject competition, Integer i) {
//        Conference conference = basicObjectFactory.createConference();
//        JSONArray competitorArray = competition.getJSONArray("competitors");
//        JSONObject competitorObject = competitorArray.getJSONObject(i);
//        JSONObject competitorTeam = competitorObject.getJSONObject("team");
//        conference.setEspnId(competitorTeam.getString("conferenceId"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
//        conference.setStartDate(LocalDateTime.parse(competition.getString("date"), formatter));
//
//        return conference;
//    }


//            JSONObject firstCompetitorTeamVenue = competitorTeam.getJSONObject("venue");
//            //competitor.setHomeVenue(firstCompetitorTeamVenue.getString("id"));
//
//
//            String competitorTeamHomeAway = competitorTeam.getString("homeAway");
//            String competitorTeamScore = competitorTeam.getString("score");
//            boolean competitorTeamWinner = competitorTeam.getBoolean("winner");
//            return competitor;
//        }

 //   public CompetitorVenue createCompetitorVenue(Team team, Venue venue, GameDataInfo gameDataInfo){
//        return null;
//    }

    public CurrentGameStatus createGameStatus(JSONObject competition) {
       CurrentGameStatus currentGameStatus = basicObjectFactory.createCurrentGameStatus();
       JSONObject status = competition.getJSONObject("status");
       JSONObject statusType = status.getJSONObject("type");
       currentGameStatus.setCurrentPeriod(status.getInt("period"));
       currentGameStatus.setCurrentClock(status.getString("displayClock"));
       currentGameStatus.setCurrentGameStatus(statusType.getString("name"));
       currentGameStatus.setCurrentState(statusType.getString("state"));

       return currentGameStatus;
    }

//    public ConferenceTeam createConferenceTeamObject(Conference conference, Team team, GameData gameData) {
//        ConferenceTeam conferenceTeam = basicObjectFactory.createConferenceTeam();
//        conferenceTeam.setEspnConferenceId(conference.getEspnConferenceId());
//        conferenceTeam.setEspnTeamId(team.getEspnTeamId());
//        conferenceTeam.setStartDate(gameData.getGameDateTime().toLocalDate().withMonth(Month.JUNE.getValue()).withDayOfMonth(1));
//
//        return conferenceTeam;
//    }
}
