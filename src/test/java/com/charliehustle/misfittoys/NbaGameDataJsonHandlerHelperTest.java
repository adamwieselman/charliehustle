package com.charliehustle.misfittoys;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.CurrentGameStatus;
import com.charliehustle.models.GameData;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class NbaGameDataJsonHandlerHelperTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @InjectMocks
    public GameDataJsonHandlerHelper gameDataJsonHandlerHelper = new GameDataJsonHandlerHelper();

    @Test
    public void testCreateGameDataObject_HappyPath(){
        String competitionString = "{\"date\": \"2018-11-10T00:00Z\",\"conferenceCompetition\": false,\"neutralSite\": true,\"id\": \"001\",\"venue\":{\"address\": {\"city\": \"Lexington\",\"state\": \"KY\"},\"fullName\": \"Rupp Arena\",\"indoor\": true,\"id\": \"251\",\"capacity\": 0}}";
        JSONObject competition = new JSONObject(competitionString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
        Mockito.when(basicObjectFactory.createGameDataInfo()).thenReturn(new GameData());
        GameData gameData = gameDataJsonHandlerHelper.createGameDataObject(competition);

        assertEquals("2018-11-10T00:00Z", gameData.getGameDateTime().format(formatter));
        assertEquals("001", gameData.getEspnGameId());
        assertEquals(false, gameData.isConferenceCompetition());
        assertEquals(true, gameData.isNeutralSite());
    }

//    @Test
//    public void testCreateVenueObject_HappyPath(){
//        String competitionString = "{\"venue\":{\"address\": {\"city\": \"Lexington\",\"state\": \"KY\"},\"fullName\": \"Rupp Arena\",\"indoor\": true,\"id\": \"251\",\"capacity\": 0}}";
//        JSONObject competition = new JSONObject(competitionString);
//        Mockito.when(basicObjectFactory.createVenue()).thenReturn(new Venue());
//        Venue venue = gameDataInfoJsonHandlerHelper.createVenueObject(competition);
//
//        assertEquals("251", venue.getEspnVenueId());
//        assertEquals("Rupp Arena", venue.getFullName());
//        assertEquals("Lexington", venue.getCity());
//        assertEquals("KY", venue.getState());
//    }
//
    @Test
    public void testCreateCurrentGameStatusObject_HappyPath(){
        String competitionString = "{\"date\": \"2018-11-10T00:00Z\",\"conferenceCompetition\": false,\"notes\": [],\"timeValid\": true,\"uid\": \"s:40~l:41~e:401083123~c:401083123\"," +
                "\"id\": \"401083123\",\"neutralSite\": false,\"recent\": false,\"attendance\": 20277,\"startDate\": \"2018-11-10T00:00Z\",\"status\": {\"period\": 2," +
                "\"displayClock\": \"0:00\",\"clock\": 0,\"type\": {\"name\": \"STATUS_FINAL\",\"description\": \"Final\",\"id\": \"3\",\"state\": \"post\",\"completed\": true," +
                "\"detail\": \"Final\",\"shortDetail\": \"Final\"}}}";
        JSONObject competition = new JSONObject(competitionString);
        Mockito.when(basicObjectFactory.createCurrentGameStatus()).thenReturn(new CurrentGameStatus());
        CurrentGameStatus currentGameStatus = gameDataJsonHandlerHelper.createGameStatus(competition);

        assertEquals("0:00", currentGameStatus.getCurrentClock());
        assertEquals("STATUS_FINAL", currentGameStatus.getCurrentGameStatus());
        assertEquals("post", currentGameStatus.getCurrentState());
        assertEquals(new Integer(2), currentGameStatus.getCurrentPeriod());
    }

//    @Test
//    public void testConferenceObject_HappyPath(){
//        String conferenceString = "{\"type\": \"scoreboard\",\"content\": {\"league\": \"mens-college-basketball\",\"altSbDropdown\": {\"options\": [" +
//                "{\"isSelected\": true,\"data\": {\"week\": \"null-null-null\",\"group\": \"50\"},\"label\": \"Division I\",\"value\": \"#\"}," +
//                "{\"isSelected\": false,\"data\": {\"week\": \"null-null-null\",\"group\": \"3\"},\"label\": \"A 10\",\"value\": \"#\"}," +
//                "{\"isSelected\": false,\"data\": {\"week\": \"null-null-null\",\"group\": \"2\"},\"label\": \"ACC\",\"value\": \"#\"}," +
//                "{\"isSelected\": false,\"data\": {\"week\": \"null-null-null\",\"group\": \"46\"},\"label\": \"ASUN\",\"value\": \"#\"}]}}}";
//        JSONObject conferenceStringObject = new JSONObject(conferenceString);
//        Mockito.when(basicObjectFactory.createConference()).thenReturn(new Conference());
//        Conference conference = gameDataInfoJsonHandlerHelper.createConferenceObject(conferenceStringObject, 3);
//
//        assertEquals("46", conference.getEspnConferenceId());
//        assertEquals("ASUN", conference.getName());
//    }
//
//    @Test
//    public void testConferenceTeamObject_HappyPath() {
//        Mockito.when(basicObjectFactory.createConferenceTeam()).thenReturn(new ConferenceTeam());
//        Conference conference = new Conference();
//        Team team = new Team();
//        GameDataInfo gameDataInfo = new GameDataInfo();
//        LocalDateTime localDateTime = LocalDateTime.of(2014, 12, 11, 5, 12, 12);
//        conference.setEspnConferenceId("46");
//        team.setEspnTeamId("148");
//        gameDataInfo.setGameDateTime(localDateTime);
//        ConferenceTeam conferenceTeam = gameDataInfoJsonHandlerHelper.createConferenceTeamObject(conference, team, gameDataInfo);
//
//        assertEquals("46", conferenceTeam.getEspnConferenceId());
//        assertEquals("148", conferenceTeam.getEspnTeamId());
//        assertEquals(localDateTime.toLocalDate(), conferenceTeam.getStartDate());
//    }
}
