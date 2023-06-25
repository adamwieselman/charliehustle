package com.charliehustle.mappers;


import com.charliehustle.misfittoys.TemplateService;
import com.charliehustle.models.json.espn.EspnGameBoxScore;
import com.charliehustle.models.json.espn.EspnGamePlayByPlay;
import com.charliehustle.models.json.espn.EspnScoreboard;
import com.charliehustle.models.json.espn.EspnSubSection;
import com.charliehustle.models.json.mlb.MlbGameInfo;
import com.charliehustle.models.json.mlb.MlbScoreboard;
import com.charliehustle.models.json.nba.NbaPlayByPlay;
import com.charliehustle.models.json.nba.NbaScoreboard;
import com.charliehustle.models.json.ufc.FightBreakdown;
import com.charliehustle.models.json.ufc.FightSchedule;
import com.charliehustle.models.json.wnba.WnbaPlayByPlay;
import com.charliehustle.models.json.wnba.WnbaScoreboard;
import com.charliehustle.services.NflDataBreakdownService;
import com.charliehustle.services.UnirestApiService;
import com.charliehustle.services.UnirestApiServiceHelper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JsonMapperNcaaScoreboardTest implements TemplateService {

    private JsonMapper jsonMapper;

    @Test
    @Ignore
    public void textReadValue_UFCFightNight() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();

        FightSchedule fightSchedule = unirestApiService.getWebsiteDataObject("http://dvk92099qvr17.cloudfront.net/V1/901/Fnt.json", null, null, FightSchedule.class);
         unirestApiService.shutdownUnirest();

        assertEquals("Adelaide", fightSchedule.getFmLiveFeed().getCity());
        assertEquals("Adelaide Entertainment Centre", fightSchedule.getFmLiveFeed().getVenue());
        assertEquals("2018-12-02T00:00Z", fightSchedule.getFmLiveFeed().getEventTime());
        assertEquals("901", fightSchedule.getFmLiveFeed().getEventId());
        assertEquals("Australia", fightSchedule.getFmLiveFeed().getCountry());
        assertEquals("2", fightSchedule.getFmLiveFeed().getFights().get(0).getEndingRoundNumber());
        assertEquals("7522", fightSchedule.getFmLiveFeed().getFights().get(0).getFightId());
        assertEquals("KO/TKO", fightSchedule.getFmLiveFeed().getFights().get(0).getMethod());
        assertEquals("5", fightSchedule.getFmLiveFeed().getFights().get(0).getPossibleRounds());
        assertEquals("1", fightSchedule.getFmLiveFeed().getFights().get(0).getWeightClassId());
        assertEquals("Blue", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getCornerColor());
        assertEquals("3015", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getFighterId());
        assertEquals("Tai", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getFirstName());
        assertEquals("Tuivasa", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getLastName());
        assertEquals("Tai Tuivasa", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getFullName());
        assertEquals("74", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getHeight());
        assertEquals("Southpaw", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getStance());
        assertEquals("264", fightSchedule.getFmLiveFeed().getFights().get(0).getFighters().get(0).getWeight());
    }

    @Test
    @Ignore
    public void textReadValue_UFCIndivFight() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();

        FightBreakdown fightBreakdown = unirestApiService.getWebsiteDataObject("https://dvk92099qvr17.cloudfront.net/V2/627/4336/Stats.json", null, null, FightBreakdown.class);
        unirestApiService.shutdownUnirest();

        assertEquals("974", fightBreakdown.getFightBreakdownFeed().getEventId());
        assertEquals("8493", fightBreakdown.getFightBreakdownFeed().getFightId());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getCurrentRound());
        assertEquals("02:22", fightBreakdown.getFightBreakdownFeed().getCurrentRoundTime());
        assertEquals("3", fightBreakdown.getFightBreakdownFeed().getMaxRounds());
        assertEquals("Rich Mitchell", fightBreakdown.getFightBreakdownFeed().getReferee());
        assertEquals("Women's Flyweight", fightBreakdown.getFightBreakdownFeed().getWeightClass());
        assertEquals("2305", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getFighterId());

        assertEquals(null, fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getReversalsLandedAttempted().getAttempted());
        assertEquals(null, fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getStandupsLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getSubmissionsLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getTakedownsLandedAttempted().getAttempted());

        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getReversalsLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getStandupsLandedAttempted().getLanded());
        assertEquals(null, fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getSubmissionsLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getGrapplingData().getTakedownsLandedAttempted().getLanded());

        assertEquals(null, fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getKnockdownLandedAttempted().getAttempted());
        assertEquals("5", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getSignificantStrikesLandedAttempted().getAttempted());
        assertEquals("6", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getTotalStrikesLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getPunchesLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getKicksLandedAttempted().getAttempted());
        assertEquals("4", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceStrikesLandedAttempted().getAttempted());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchSignificantStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundSignificantStrikesLandedAttempted().getAttempted());
        assertEquals("2", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchTotalStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundTotalStrikesLandedAttempted().getAttempted());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getHeadSignificantStrikesLandedAttempted().getAttempted());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getBodySignificantStrikesLandedAttempted().getAttempted());
        assertEquals("3", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getLegsSignificantStrikesLandedAttempted().getAttempted());
        assertEquals("2", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getHeadTotalStrikesLandedAttempted().getAttempted());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getBodyTotalStrikesLandedAttempted().getAttempted());
        assertEquals("3", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getLegsTotalStrikesLandedAttempted().getAttempted());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceHeadStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceBodyStrikesLandedAttempted().getAttempted());
        assertEquals("3", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceLegStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchHeadStrikesLandedAttempted().getAttempted());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchBodyStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchLegStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundHeadStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundBodyStrikesLandedAttempted().getAttempted());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundLegStrikesLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceHeadKicksLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceBodyKicksLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceLegKicksLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceHeadPunchesLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceBodyPunchesLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchSignificantKicksLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchSignificantPunchesLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundSignificantKicksLandedAttempted().getAttempted());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundSignificantPunchesLandedAttempted().getAttempted());

        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getKnockdownLandedAttempted().getLanded());
        assertEquals("3", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getSignificantStrikesLandedAttempted().getLanded());
        assertEquals("4", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getTotalStrikesLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getPunchesLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getKicksLandedAttempted().getLanded());
        assertEquals("3", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchSignificantStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundSignificantStrikesLandedAttempted().getLanded());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchTotalStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundTotalStrikesLandedAttempted().getLanded());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getHeadSignificantStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getBodySignificantStrikesLandedAttempted().getLanded());
        assertEquals("2", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getLegsSignificantStrikesLandedAttempted().getLanded());
        assertEquals("2", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getHeadTotalStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getBodyTotalStrikesLandedAttempted().getLanded());
        assertEquals("2", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getLegsTotalStrikesLandedAttempted().getLanded());
        assertEquals("1", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceHeadStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceBodyStrikesLandedAttempted().getLanded());
        assertEquals("2", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceLegStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchHeadStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchBodyStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchLegStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundHeadStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundBodyStrikesLandedAttempted().getLanded());
        assertEquals("0", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundLegStrikesLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceHeadKicksLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceBodyKicksLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceLegKicksLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceHeadPunchesLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getDistanceBodyPunchesLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchSignificantKicksLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getClinchSignificantPunchesLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundSignificantKicksLandedAttempted().getLanded());
        assertEquals("", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getStrikingData().getGroundSignificantPunchesLandedAttempted().getLanded());        
        
        
        assertEquals("00:54", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getStandingTime());
        assertEquals("01:27", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getGroundTime());
        assertEquals("00:32", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getControlTime());
        assertEquals("00:41", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getNeutralTime());
        assertEquals("00:24", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getGroundControlTime());
        assertEquals("00:39", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getDistanceTime());
        assertEquals("00:15", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getClinchTime());
        assertEquals("00:24", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getMiscGroundControlTime());
        assertEquals("00:00", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getGuardControlTime());
        assertEquals("00:00", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getHalfGuardControlTime());
        assertEquals("00:00", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getSideControlTime());
        assertEquals("00:00", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getMountControlTime());
        assertEquals("00:00", fightBreakdown.getFightBreakdownFeed().getRoundStats().getRound1().getBlueFighterData().getTimeBreakdown().getBackControlTime());
    }

    @Test
    @Ignore
    public void textReadValue_baseballEverything() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        MlbGameInfo mlbGameInfo = unirestApiService.getWebsiteDataObject("http://statsapi.mlb.com//api/v1/game/529572/feed/live", null, null, MlbGameInfo.class);
        unirestApiService.shutdownUnirest();

        assertEquals("4", mlbGameInfo.getMlbGameData().getMlbVenue().getId());
        assertEquals("Chicago, IL", mlbGameInfo.getMlbGameData().getMlbVenue().getLocation());
        assertEquals("Guaranteed Rate Field", mlbGameInfo.getMlbGameData().getMlbVenue().getName());
        assertEquals("day", mlbGameInfo.getMlbGameData().getMlbDateTime().getDayNight());
        assertEquals("2018/04/10", mlbGameInfo.getMlbGameData().getMlbDateTime().getOriginalDate());
        assertEquals("2:10", mlbGameInfo.getMlbGameData().getMlbDateTime().getTime());
        assertEquals("139", mlbGameInfo.getMlbGameData().getMlbTeams().getAway().getTeamId());
        assertEquals("Tampa Bay Rays", mlbGameInfo.getMlbGameData().getMlbTeams().getAway().getMlbName().getFull());
        assertEquals("43", mlbGameInfo.getMlbGameData().getMlbWeather().getTemp());
        assertEquals("Partly Cloudy", mlbGameInfo.getMlbGameData().getMlbWeather().getCondition());
        assertEquals("7mph R To L", mlbGameInfo.getMlbGameData().getMlbWeather().getWind());
        assertEquals("Denard Span lines out to center fielder Adam Engel.  ", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbResult().getDescription());
        assertEquals("atBat", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbResult().getType());
        assertEquals("Lineout", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbResult().getEvent());
        assertEquals("1", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbAbout().getInning());
        assertEquals("top", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbAbout().getHalfInning());
        assertEquals("Walk", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(1).getMlbRunners().get(0).getMlbRunnerDetails().getEvent());
        assertEquals("621563", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(1).getMlbRunners().get(0).getMlbRunnerDetails().getRunner());
        assertEquals("1B", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(1).getMlbRunners().get(0).getMlbMovement().getEnd());
        assertEquals("", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(1).getMlbRunners().get(0).getMlbMovement().getStart());
        assertEquals(1, mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getPitchNum());
        assertEquals(true, mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).isPitch());
        assertEquals("S", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getMlbPitchDetails().getCall());
        assertEquals("C", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getMlbPitchDetails().getCode());
        assertEquals("Four-Seam Fastball", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getMlbPitchDetails().getDisplayName());
        assertEquals("Called Strike", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getMlbPitchDetails().getDescription());
        assertEquals("FF", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getMlbPitchDetails().getType());
        assertEquals("83.2", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getEndSpeed());
        assertEquals("91.9", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getStartSpeed());
        assertEquals("66", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getNastyFactor());
        assertEquals("26.5", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbBreaks().getBreakAngle());
        assertEquals("3.8", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbBreaks().getBreakLength());
        assertEquals(null, mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbBreaks().getBreakX());
        assertEquals("23.8", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbBreaks().getBreakY());
        assertEquals(null, mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbBreaks().getBreakZ());
        assertEquals("-8.70964942916443", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getAx());
        assertEquals("29.6478971999677", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getAy());
        assertEquals("-14.3490650157281", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getAz());
        assertEquals("-4.829451259929336", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getPfx_x());
        assertEquals("9.883852377640789", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getPfx_z());
        assertEquals("-0.681398332782136", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getPx());
        assertEquals("3.23450367081054", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getPz());
        assertEquals("5.19287885995412", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getVx0());
        assertEquals("-3.77782466433142", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getVz0());
        assertEquals("-133.662359250789", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getVy0());
        assertEquals("-2.02481139142544", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getX0());
        assertEquals("50.0000000000001", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getY0());
        assertEquals("5.70097009481264", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getZ0());
        assertEquals("142.95", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getX());
        assertEquals("151.5", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(0).getStats().getMlbCoordinates().getY());
        assertEquals("20.08", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(1).getHitData().getLaunchAngle());
        assertEquals("95.44", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(1).getHitData().getLaunchSpeed());
        assertEquals("337", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbPlayEvents().get(1).getHitData().getTotalDistance());
        assertEquals("452655", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbMatchup().getBatter());
        assertEquals("608334", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbMatchup().getPitcher());
        assertEquals("L", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbMatchup().getMlbRightLeft().getBatter());
        assertEquals("R", mlbGameInfo.getMlbLiveData().getMlbPlays().getMlbPlayList().get(0).getMlbMatchup().getMlbRightLeft().getPitcher());
    }

    @Test
    @Ignore
    public void testReadValue_baseballScoreboard() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        MlbScoreboard mlbScoreboard = unirestApiService.getWebsiteDataObject("http://statsapi.mlb.com/api/v1/schedule/games/?sportId=1&date=04/10/2018", null, null, MlbScoreboard.class);
        unirestApiService.shutdownUnirest();

        assertEquals(15, mlbScoreboard.getTotalItems());
        assertEquals(15, mlbScoreboard.getTotalGames());
        assertEquals("2018-04-10", mlbScoreboard.getMlbGameDates().get(0).getDate());
        assertEquals("/api/v1.1/game/529572/feed/live", mlbScoreboard.getMlbGameDates().get(0).getMlbGames().get(0).getLink());
        assertEquals("R", mlbScoreboard.getMlbGameDates().get(0).getMlbGames().get(0).getGameType());
        assertEquals(529572, mlbScoreboard.getMlbGameDates().get(0).getMlbGames().get(0).getGamePk());
        assertEquals("2018-04-10T18:10:00Z", mlbScoreboard.getMlbGameDates().get(0).getMlbGames().get(0).getGameDate());
        assertEquals("day", mlbScoreboard.getMlbGameDates().get(0).getMlbGames().get(0).getDayNight());
        assertEquals("Final", mlbScoreboard.getMlbGameDates().get(0).getMlbGames().get(0).getMlbStatus().getDetailedState());
        assertEquals("F", mlbScoreboard.getMlbGameDates().get(0).getMlbGames().get(0).getMlbStatus().getStatusCode());
    }

    @Test
    @Ignore
    public void testReadValue_wnbaPlayByPlay() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        WnbaPlayByPlay wnbaPlayByPlay = unirestApiService.getWebsiteDataObject("https://data.wnba.com/data/5s/v2015/json/mobile_teams/wnba/2019/scores/pbp/1011900004_1_pbp.json", null, null, WnbaPlayByPlay.class);
        unirestApiService.shutdownUnirest();

        assertEquals("1011900004", wnbaPlayByPlay.getWnbaGame().getGameId());
        assertEquals("09:21", wnbaPlayByPlay.getWnbaGame().getWnbaPlays().get(4).getClock());
        assertEquals(203017, wnbaPlayByPlay.getWnbaGame().getWnbaPlays().get(1).getPlayerId());
    }

    @Test
    @Ignore
    public void testReadValue_wnbaScoreboard() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        WnbaScoreboard wnbaScoreboard = unirestApiService.getWebsiteDataObject("https://data.wnba.com/data/5s/v2015/json/mobile_teams/wnba/2019/league/10_full_schedule.json", null, null, WnbaScoreboard.class);
        unirestApiService.shutdownUnirest();

        assertEquals("1011900001", wnbaScoreboard.getWnbaLeagueSchedules().get(0).getWnbaMonthGameSchedule().getGames().get(0).getGameId());
        assertEquals("China National Team", wnbaScoreboard.getWnbaLeagueSchedules().get(0).getWnbaMonthGameSchedule().getGames().get(0).getVistorTeam().getTeamName());
        assertEquals("Barclays Center", wnbaScoreboard.getWnbaLeagueSchedules().get(0).getWnbaMonthGameSchedule().getGames().get(0).getArena());
    }

    @Test
    @Ignore
    public void testReadValue_ncaaBoxscore() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnSubSection espnSubSection = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/mens-college-basketball/boxscore?gameId=400988595&xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnSubSection.class);
        unirestApiService.shutdownUnirest();

        assertEquals("boxscore", espnSubSection.getType());
        assertEquals("400988595", espnSubSection.getGameId());
        assertEquals("mens-college-basketball", espnSubSection.getEspnContent().getLeague());
        assertNotNull(espnSubSection.getEspnContent().getHtml());

        Document doc = Jsoup.parse(espnSubSection.getEspnContent().getHtml());
        Element awayTeamBoxscore = doc.getElementsByClass("gamepackage-away-wrap").first();
        Element homeTeamBoxscore = doc.getElementsByClass("gamepackage-home-wrap").first();
        Elements awayTeamName = awayTeamBoxscore.getElementsByClass("name");
        Elements awayTeamMin = awayTeamBoxscore.getElementsByClass("min");
        Elements awayTeamFg = awayTeamBoxscore.getElementsByClass("fg");
        Elements awayTeam3pt = awayTeamBoxscore.getElementsByClass("3pt");
        Elements awayTeamFt = awayTeamBoxscore.getElementsByClass("ft");
        Elements awayTeamOreb = awayTeamBoxscore.getElementsByClass("oreb");
        Elements awayTeamDreb = awayTeamBoxscore.getElementsByClass("dreb");
        Elements awayTeamAst = awayTeamBoxscore.getElementsByClass("ast");
        Elements awayTeamStl = awayTeamBoxscore.getElementsByClass("stl");
        Elements awayTeamBlk = awayTeamBoxscore.getElementsByClass("blk");
        Elements awayTeamTo = awayTeamBoxscore.getElementsByClass("to");
        Elements awayTeamPf = awayTeamBoxscore.getElementsByClass("pf");
        Elements awayTeamPts = awayTeamBoxscore.getElementsByClass("pts");

        JSONObject boxScore = new JSONObject();
        JSONArray playerResults = new JSONArray();

        for (int i = 0; i < awayTeamName.size() - 2; i++) {
            if(i != 0 && i != 6) {
                String playerName = awayTeamName.get(i).getElementsByTag("span").get(0).text();
                String playerPosition = awayTeamName.get(i).getElementsByClass("position").get(0).text();
                String playerMin = awayTeamMin.get(i).text();
                String playerFg = awayTeamFg.get(i).text();
                String player3pt = awayTeam3pt.get(i).text();
                String playerFt = awayTeamFt.get(i).text();
                String playerOreb = awayTeamOreb.get(i).text();
                String playerDreb = awayTeamDreb.get(i).text();
                String playerAst = awayTeamAst.get(i).text();
                String playerStl = awayTeamStl.get(i).text();
                String playerBlk = awayTeamBlk.get(i).text();
                String playerTo = awayTeamTo.get(i).text();
                String playerPf = awayTeamPf.get(i).text();
                String playerPts = awayTeamPts.get(i).text();

                JSONObject playerResult = new JSONObject();
                playerResult.put("playerName", playerName);
                playerResult.put("playerPosition", playerPosition);
                playerResult.put("playerMin", playerMin);
                playerResult.put("playerFg", playerFg);
                playerResult.put("player3pt", player3pt);
                playerResult.put("playerFt", playerFt);
                playerResult.put("playerOreb", playerOreb);
                playerResult.put("playerDreb", playerDreb);
                playerResult.put("playerAst", playerAst);
                playerResult.put("playerStl", playerStl);
                playerResult.put("playerBlk", playerBlk);
                playerResult.put("playerTo", playerTo);
                playerResult.put("playerPf", playerPf);
                playerResult.put("playerPts", playerPts);

                playerResults.put(playerResult);
            }
        }

        boxScore.put("game-boxscores", playerResults);
        EspnGameBoxScore espnGameBoxScore = jsonMapper.readValue(boxScore.toString(), EspnGameBoxScore.class);
        assertEquals("T. Hegner", espnGameBoxScore.getEspnBoxScores().get(0).getPlayerName());
        assertEquals("K. Thomas", espnGameBoxScore.getEspnBoxScores().get(3).getPlayerName());
    }

    @Test
    @Ignore
    public void testReadValue_ncaaScoreboard() throws IOException, UnirestException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnScoreboard espnScoreboard = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/mens-college-basketball/scoreboard/_/group/50/date/20200109?xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnScoreboard.class);
        unirestApiService.shutdownUnirest();

        assertEquals("scoreboard", espnScoreboard.getType());
        assertEquals("mens-college-basketball", espnScoreboard.getEspnContent().getLeague());
        assertEquals("NCAAM Basketball", espnScoreboard.getEspnContent().getEspnSbGroup().getPageTitle());
        assertEquals("NCAA Men's Basketball", espnScoreboard.getEspnContent().getEspnSbGroup().getAltTitle());
        assertEquals("2002-10-10", espnScoreboard.getEspnContent().getEspnSbGroup().getScheduleStartDate());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbGroup().isCollege());
        assertEquals("mens-college-basketball", espnScoreboard.getEspnContent().getEspnSbGroup().getLeague());
        assertEquals("basketball", espnScoreboard.getEspnContent().getEspnSbGroup().getSport());
        assertEquals("2018-11-10T00:00Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getDate());
        assertEquals("s:40~l:41~e:401083123", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getUid());
        assertEquals("Southern Illinois Salukis at Kentucky Wildcats", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getName());
        assertEquals("401083123", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getId());
        assertEquals("SIU @ UK", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getShortName());
        assertEquals(2, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getPeriod());
        assertEquals("0:00", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getDisplayClock());
        assertEquals(0, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getClock());
        assertEquals("STATUS_FINAL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getName());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getDescription());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getId());
        assertEquals("post", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getState());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getCompleted());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getShortDetail());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getDetail());
        assertEquals("2018-11-10T00:00Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getDate());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isConferenceCompetition());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isTimeValid());
        assertEquals("401083123", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getId());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isNeutralSite());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isRecent());
        assertEquals(20277, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getAttendance());
        assertEquals("2018-11-10T00:00Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getStartDate());
        assertEquals(2, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getPeriod());
        assertEquals("0:00", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getDisplayClock());
        assertEquals(0, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getClock());
        assertEquals("STATUS_FINAL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getName());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getDescription());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getId());
        assertEquals("post", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getState());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getCompleted());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getShortDetail());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getDetail());
        assertEquals("Rupp Arena", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getFullName());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().isIndoor());
        assertEquals("251", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getId());
        assertEquals(20500, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getCapacity());
        assertEquals("Lexington", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getEspnAddress().getCity());
        assertEquals("KY", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getEspnAddress().getState());
        assertEquals("team", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getType());
        assertEquals("s:40~l:41~t:96", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getUid());
        assertEquals("home", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getHomeAway());
        assertEquals("71", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getScore());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).isWinner());
        assertEquals("96", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getId());
        assertEquals(31, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnLineScores().get(0).getValue());
        assertEquals("ffffff", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getAlternateColor());
        assertEquals("251", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getEspnVenue().getId());
        assertEquals("005DAA", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getColor());
        assertEquals("Kentucky Wildcats", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getDisplayName());
        assertEquals("UK", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getAbbreviation());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().isActive());
        assertEquals("Kentucky", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getShortDisplayName());
        assertEquals("s:40~l:41~t:96", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getUid());
        assertEquals("23", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getConferenceId());
        assertEquals("Wildcats", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getName());
        assertEquals("https://a.espncdn.com/i/teamlogos/ncaa/500/96.png", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getLogo());
        assertEquals("Kentucky", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getLocation());
        assertEquals("96", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getId());
//        assertEquals("NIT", espnScoreboard.getContent().getAltSbDropdown().getLabel());
//        assertEquals("conference", espnScoreboard.getContent().getAltSbDropdown().getType());
//        assertEquals(false, espnScoreboard.getContent().getAltSbDropdown().getOptions().get(0).isSelected());
//        assertEquals("NCAA Tournament", espnScoreboard.getContent().getAltSbDropdown().getOptions().get(0).getLabel());
//        assertEquals("#", espnScoreboard.getContent().getAltSbDropdown().getOptions().get(0).getValue());
//        assertEquals("null-null-null", espnScoreboard.getContent().getAltSbDropdown().getOptions().get(0).getData().getWeek());
//        assertEquals("100", espnScoreboard.getContent().getAltSbDropdown().getOptions().get(0).getData().getGroup());
        assertEquals("Division I", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getLabel());
        assertEquals("conference", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getType());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).isSelected());
        assertEquals("Division I", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).getLabel());
        assertEquals("#", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).getValue());
        assertEquals("null-null-null", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).getEspnData().getWeek());
        assertEquals("50", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).getEspnData().getGroup());
    }

    @Test
    @Ignore
    public void testReadValue_ncaaFootballScoreboard() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnScoreboard espnScoreboard = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/college-football/scoreboard/_/group/80/year/2019/seasontype/2/week/1?xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnScoreboard.class);
        unirestApiService.shutdownUnirest();

        assertEquals("scoreboard", espnScoreboard.getType());
        assertEquals("college-football", espnScoreboard.getEspnContent().getLeague());
        assertEquals("NCAAF", espnScoreboard.getEspnContent().getEspnSbGroup().getPageTitle());
        assertEquals("NCAA College Football", espnScoreboard.getEspnContent().getEspnSbGroup().getAltTitle());
        assertEquals("2002-08-01", espnScoreboard.getEspnContent().getEspnSbGroup().getScheduleStartDate());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbGroup().isCollege());
        assertEquals("college-football", espnScoreboard.getEspnContent().getEspnSbGroup().getLeague());
        assertEquals("football", espnScoreboard.getEspnContent().getEspnSbGroup().getSport());
        assertEquals(1, espnScoreboard.getEspnContent().getEspnSbData().getEspnWeek().getNumber());
        assertEquals(2019, espnScoreboard.getEspnContent().getEspnSbData().getEspnSeason().getYear());
        assertEquals(2, espnScoreboard.getEspnContent().getEspnSbData().getEspnSeason().getType());
        assertEquals("2019-08-24T23:00Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getDate());
        assertEquals("s:20~l:23~e:401110723", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getUid());
        assertEquals("Miami Hurricanes at Florida Gators", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getName());
        assertEquals("401110723", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getId());
        assertEquals("MIA @ FLA", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getShortName());
        assertEquals(4, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getPeriod());
        assertEquals("0:00", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getDisplayClock());
        assertEquals(0, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getClock());
        assertEquals("STATUS_FINAL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getName());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getDescription());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getId());
        assertEquals("post", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getState());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getCompleted());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getShortDetail());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getDetail());
        assertEquals("2019-08-24T23:00Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getDate());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isConferenceCompetition());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isTimeValid());
        assertEquals("401110723", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getId());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isNeutralSite());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isRecent());
        assertEquals(66543, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getAttendance());
        assertEquals("2019-08-24T23:00Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getStartDate());
        assertEquals(4, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getPeriod());
        assertEquals("0:00", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getDisplayClock());
        assertEquals(0, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getClock());
        assertEquals("STATUS_FINAL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getName());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getDescription());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getId());
        assertEquals("post", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getState());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getCompleted());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getShortDetail());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getDetail());
        assertEquals("Camping World Stadium", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getFullName());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().isIndoor());
        assertEquals("4013", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getId());
        assertEquals(70000, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getCapacity());
        assertEquals("Orlando", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getEspnAddress().getCity());
        assertEquals("FL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getEspnAddress().getState());
        assertEquals("team", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getType());
        assertEquals("s:20~l:23~t:57", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getUid());
        assertEquals("home", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getHomeAway());
        assertEquals("24", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getScore());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).isWinner());
        assertEquals("57", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getId());
        assertEquals(7, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnLineScores().get(0).getValue());
        assertEquals("0021a5", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getAlternateColor());
        assertEquals("3634", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getEspnVenue().getId());
        assertEquals("0021A5", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getColor());
        assertEquals("Florida Gators", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getDisplayName());
        assertEquals("FLA", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getAbbreviation());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().isActive());
        assertEquals("Gators", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getShortDisplayName());
        assertEquals("s:20~l:23~t:57", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getUid());
        assertEquals("8", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getConferenceId());
        assertEquals("Gators", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getName());
        assertEquals("https://a.espncdn.com/i/teamlogos/ncaa/500/57.png", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getLogo());
        assertEquals("Florida", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getLocation());
        assertEquals("57", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getId());
        assertEquals("FBS (I-A)", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getLabel());
        assertEquals("conference", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getType());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).isSelected());
        assertEquals("Top 25", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).getLabel());
        assertEquals("#", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).getValue());
        assertEquals("2019-1-2", espnScoreboard.getEspnContent().getEspnAltSbDropdown().getEspnOptions().get(0).getEspnData().getWeek());
    }

    @Test
    @Ignore
    public void testReadValue_nflFootballScoreboard() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnScoreboard espnScoreboard = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/nfl/scoreboard/_/year/2019/seasontype/2/week/1?xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnScoreboard.class);
        unirestApiService.shutdownUnirest();

        assertEquals("scoreboard", espnScoreboard.getType());
        assertEquals("nfl", espnScoreboard.getEspnContent().getLeague());
        assertEquals("NFL", espnScoreboard.getEspnContent().getEspnSbGroup().getPageTitle());
        assertEquals("National Football League", espnScoreboard.getEspnContent().getEspnSbGroup().getAltTitle());
        assertEquals("2002-08-01", espnScoreboard.getEspnContent().getEspnSbGroup().getScheduleStartDate());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbGroup().isCollege());
        assertEquals("nfl", espnScoreboard.getEspnContent().getEspnSbGroup().getLeague());
        assertEquals("football", espnScoreboard.getEspnContent().getEspnSbGroup().getSport());
        assertEquals(1, espnScoreboard.getEspnContent().getEspnSbData().getEspnWeek().getNumber());
        assertEquals(2019, espnScoreboard.getEspnContent().getEspnSbData().getEspnSeason().getYear());
        assertEquals(2, espnScoreboard.getEspnContent().getEspnSbData().getEspnSeason().getType());
        assertEquals("2019-09-06T00:20Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getDate());
        assertEquals("s:20~l:28~e:401127913", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getUid());
        assertEquals("Green Bay Packers at Chicago Bears", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getName());
        assertEquals("401127913", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getId());
        assertEquals("GB @ CHI", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getShortName());
        assertEquals(4, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getPeriod());
        assertEquals("0:00", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getDisplayClock());
        assertEquals(0, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getClock());
        assertEquals("STATUS_FINAL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getName());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getDescription());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getId());
        assertEquals("post", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getState());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getCompleted());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getShortDetail());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnStatus().getEspnType().getDetail());
        assertEquals("2019-09-06T00:20Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getDate());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isConferenceCompetition());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isTimeValid());
        assertEquals("401127913", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getId());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isNeutralSite());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).isRecent());
        assertEquals(62435, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getAttendance());
        assertEquals("2019-09-06T00:20Z", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getStartDate());
        assertEquals(4, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getPeriod());
        assertEquals("0:00", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getDisplayClock());
        assertEquals(0, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getClock());
        assertEquals("STATUS_FINAL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getName());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getDescription());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getId());
        assertEquals("post", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getState());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getCompleted());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getShortDetail());
        assertEquals("Final", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnStatus().getEspnType().getDetail());
        assertEquals("Soldier Field", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getFullName());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().isIndoor());
        assertEquals("3933", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getId());
        assertEquals(61500, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getCapacity());
        assertEquals("Chicago", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getEspnAddress().getCity());
        assertEquals("IL", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnVenue().getEspnAddress().getState());
        assertEquals("team", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getType());
        assertEquals("s:20~l:28~t:3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getUid());
        assertEquals("home", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getHomeAway());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getScore());
        assertEquals(false, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).isWinner());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getId());
        assertEquals(3, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnLineScores().get(0).getValue());
        assertEquals("0b162a", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getAlternateColor());
        assertEquals("3933", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getEspnVenue().getId());
        assertEquals("152644", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getColor());
        assertEquals("Chicago Bears", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getDisplayName());
        assertEquals("CHI", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getAbbreviation());
        assertEquals(true, espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().isActive());
        assertEquals("Bears", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getShortDisplayName());
        assertEquals("s:20~l:28~t:3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getUid());
        assertEquals("Bears", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getName());
        assertEquals("https://a.espncdn.com/i/teamlogos/nfl/500/scoreboard/chi.png", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getLogo());
        assertEquals("Chicago", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getLocation());
        assertEquals("3", espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents().get(0).getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getId());
   }

    @Test
    @Ignore
    public void testReadValue_nbaScoreboard() throws UnirestException, IOException {

        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        NbaScoreboard nbaScoreboard = unirestApiService.getWebsiteDataObject("https://data.nba.net/prod/v2/20200306/scoreboard.json", null, null, NbaScoreboard.class);
        unirestApiService.shutdownUnirest();


        assertEquals(10, nbaScoreboard.getNumGames());
        assertEquals(2, nbaScoreboard.getNbaGames().get(0).getSeasonStageId());
        assertEquals("2019", nbaScoreboard.getNbaGames().get(0).getSeasonYear());
        assertEquals("standard", nbaScoreboard.getNbaGames().get(0).getLeagueName());
        assertEquals("0021900930", nbaScoreboard.getNbaGames().get(0).getGameId());
        assertEquals("Capital One Arena", nbaScoreboard.getNbaGames().get(0).getNbaArena().getName());
        assertEquals(true, nbaScoreboard.getNbaGames().get(0).getNbaArena().isDomestic());
        assertEquals("Washington", nbaScoreboard.getNbaGames().get(0).getNbaArena().getCity());
        assertEquals("DC", nbaScoreboard.getNbaGames().get(0).getNbaArena().getStateAbbr());
        assertEquals("USA", nbaScoreboard.getNbaGames().get(0).getNbaArena().getCountry());
        assertEquals(3, nbaScoreboard.getNbaGames().get(0).getStatusNum());
        assertEquals("7:00 PM ET", nbaScoreboard.getNbaGames().get(0).getStartTimeEastern());
        assertEquals("2020-03-07T00:00:00.000Z", nbaScoreboard.getNbaGames().get(0).getStartTimeUTC());
        assertEquals("2020-03-07T02:54:00.000Z", nbaScoreboard.getNbaGames().get(0).getEndTimeUTC());
        assertEquals("20200306/ATLWAS", nbaScoreboard.getNbaGames().get(0).getGameUrlCode());
        assertEquals("17856", nbaScoreboard.getNbaGames().get(0).getAttendance());
        assertEquals(true, nbaScoreboard.getNbaGames().get(0).isGameBookPdf());
        assertEquals("2", nbaScoreboard.getNbaGames().get(0).getNbaGameDuration().getHours());
        assertEquals("17", nbaScoreboard.getNbaGames().get(0).getNbaGameDuration().getMinutes());
        assertEquals(4, nbaScoreboard.getNbaGames().get(0).getNbaPeriod().getCurrent());
        assertEquals(0, nbaScoreboard.getNbaGames().get(0).getNbaPeriod().getType());
        assertEquals(4, nbaScoreboard.getNbaGames().get(0).getNbaPeriod().getMaxRegular());
        assertEquals(false, nbaScoreboard.getNbaGames().get(0).getNbaPeriod().isHalftime());
        assertEquals(false, nbaScoreboard.getNbaGames().get(0).getNbaPeriod().isEndOfPeriod());
        assertEquals("1610612737", nbaScoreboard.getNbaGames().get(0).getvNbaTeam().getId());
        assertEquals("ATL", nbaScoreboard.getNbaGames().get(0).getvNbaTeam().getShortDisplayName());
        assertEquals("112", nbaScoreboard.getNbaGames().get(0).getvNbaTeam().getScore());
        assertEquals("34", nbaScoreboard.getNbaGames().get(0).getvNbaTeam().getNbaLineScores().get(0).getScore());
    }

    @Test
    @Ignore
    public void testReadValue_ncaaPlayByPlay() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnSubSection espnSubSection = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/mens-college-basketball/playbyplay?gameId=400988595&xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnSubSection.class);
        unirestApiService.shutdownUnirest();

        assertEquals("playbyplay", espnSubSection.getType());
        assertEquals("400988595", espnSubSection.getGameId());
        assertEquals("mens-college-basketball", espnSubSection.getEspnContent().getLeague());
        assertNotNull(espnSubSection.getEspnContent().getHtml());

        Document doc = Jsoup.parse(espnSubSection.getEspnContent().getHtml());
        Element pbpTableFirstHalf = doc.select("#gp-quarter-1").first();
        Element pbpTableSecondHalf = doc.select("#gp-quarter-2").first();
        Elements timeStampsFirst = pbpTableFirstHalf.getElementsByClass("time-stamp");
        Elements teamLogosFirst = pbpTableFirstHalf.getElementsByClass("team-logo");
        Elements gameDetailsFirst = pbpTableFirstHalf.getElementsByClass("game-details");
        Elements combinedScoresFirst = pbpTableFirstHalf.getElementsByClass("combined-score");
        Elements timeStampsSecond = pbpTableSecondHalf.getElementsByClass("time-stamp");
        Elements teamLogosSecond = pbpTableSecondHalf.getElementsByClass("team-logo");
        Elements gameDetailsSecond = pbpTableSecondHalf.getElementsByClass("game-details");
        Elements combinedScoresSecond = pbpTableSecondHalf.getElementsByClass("combined-score");

        JSONObject game = new JSONObject();
        JSONArray plays = new JSONArray();

        for (int i = 0, l = timeStampsFirst.size(); i < l; i++) {
            String timeStampValue = timeStampsFirst.get(i).text();
            String teamLogoValue = teamLogosFirst.get(i).attr("src");
            String gameDetailValue = gameDetailsFirst.get(i).text();
            String combinedScoreValue = combinedScoresFirst.get(i).text();

            JSONObject play = new JSONObject();
            play.put("time-stamp", timeStampValue);
            play.put("team-logo", teamLogoValue);
            play.put("game-detail", gameDetailValue);
            play.put("combined-score", combinedScoreValue);

            plays.put(play);
        }

        game.put("game-plays", plays);

        EspnGamePlayByPlay espnGamePlayByPlay = jsonMapper.readValue(game.toString(), EspnGamePlayByPlay.class);

        assertEquals("20:00", espnGamePlayByPlay.getEspnPlayByPlays().get(0).getTimeStamp());
        assertEquals("Jump Ball won by Villanova", espnGamePlayByPlay.getEspnPlayByPlays().get(0).getGameDetail());
    }

    @Test
    @Ignore
    public void testReadValue_nflPlayByPlay() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnSubSection espnSubSection = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/nfl/playbyplay?gameId=401220225&xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnSubSection.class);
        unirestApiService.shutdownUnirest();

        assertEquals("playbyplay", espnSubSection.getType());
        assertEquals("401220225", espnSubSection.getGameId());
        assertEquals("nfl", espnSubSection.getEspnContent().getLeague());
        assertNotNull(espnSubSection.getEspnContent().getHtml());

        Document doc = Jsoup.parse(espnSubSection.getEspnContent().getHtml());

        Element pbpTableFirstHalf = doc.getElementById("gamepackage-play-by-play");
        Elements downAndDistance = pbpTableFirstHalf.getElementsByTag("h3");
        Elements postPlay = pbpTableFirstHalf.getElementsByClass("post-play");

        JSONObject game = new JSONObject();
        JSONArray plays = new JSONArray();

        for (int i = 0, l = postPlay.size(); i < l; i++) {
            String gameDetailValue = postPlay.get(i).text();
            if(gameDetailValue.equals("END QUARTER 2")){
                postPlay.remove(i);
                break;
            }
        }

        for (int i = 0, l = postPlay.size(); i < l; i++) {
            String timeStampValue = downAndDistance.get(i).text();
            String gameDetailValue = postPlay.get(i).text();

            JSONObject play = new JSONObject();
            play.put("play-location", timeStampValue);
            play.put("game-detail", gameDetailValue);

            plays.put(play);
        }

        game.put("game-plays", plays);

        EspnGamePlayByPlay espnGamePlayByPlay = jsonMapper.readValue(game.toString(), EspnGamePlayByPlay.class);

        assertEquals("", espnGamePlayByPlay.getEspnPlayByPlays().get(0).getPlayLocation());
        assertEquals("(15:00 - 1st) E.Pineiro kicks 65 yards from CHI 35 to end zone, Touchback.", espnGamePlayByPlay.getEspnPlayByPlays().get(0).getGameDetail());
    }

    @Test
    @Ignore
    public void testReadValue_ncaaFootballPlayByPlay() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnSubSection espnSubSection = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/college-football/playbyplay?gameId=401019470&xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnSubSection.class);
        unirestApiService.shutdownUnirest();

        assertEquals("playbyplay", espnSubSection.getType());
        assertEquals("401019470", espnSubSection.getGameId());
        assertEquals("college-football", espnSubSection.getEspnContent().getLeague());
        assertNotNull(espnSubSection.getEspnContent().getHtml());

        Document doc = Jsoup.parse(espnSubSection.getEspnContent().getHtml());

        Element pbpTableFirstHalf = doc.getElementById("gamepackage-play-by-play");
        Elements downAndDistance = pbpTableFirstHalf.getElementsByTag("h3");
        Elements postPlay = pbpTableFirstHalf.getElementsByClass("post-play");

        JSONObject game = new JSONObject();
        JSONArray plays = new JSONArray();

        for (int i = 0, l = postPlay.size(); i < l; i++) {
            String gameDetailValue = postPlay.get(i).text();
            if(gameDetailValue.equals("End of 2nd Quarter")){
                postPlay.remove(i);
                break;
            }
        }

        for (int i = 0, l = postPlay.size(); i < l; i++) {
            String timeStampValue = downAndDistance.get(i).text();
            String gameDetailValue = postPlay.get(i).text();

            JSONObject play = new JSONObject();
            play.put("play-location", timeStampValue);
            play.put("game-detail", gameDetailValue);

            plays.put(play);
        }

        game.put("game-plays", plays);
        EspnGamePlayByPlay espnGamePlayByPlay = jsonMapper.readValue(game.toString(), EspnGamePlayByPlay.class);

        assertEquals("", espnGamePlayByPlay.getEspnPlayByPlays().get(0).getPlayLocation());
        assertEquals("(15:00 - 1st) Matthew Wright kickoff for 65 yds , Keyion Dixon return for 16 yds to the UConn 16", espnGamePlayByPlay.getEspnPlayByPlays().get(0).getGameDetail());
    }

    @Test
    @Ignore
    public void testReadValue_nbaPlayByPlay() throws UnirestException, IOException {
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        NbaPlayByPlay nbaPlayByPlay = unirestApiService.getWebsiteDataObject("http://data.nba.com/data/10s/v2015/json/mobile_teams/nba/2019/scores/pbp/0021900729_full_pbp.json", null, null, NbaPlayByPlay.class);
        unirestApiService.shutdownUnirest();

        assertEquals("0021900729", nbaPlayByPlay.getNbaGame().getGameId());
        assertEquals("20200201/MIAORL", nbaPlayByPlay.getNbaGame().getGameUrlCode());
        assertEquals(2, nbaPlayByPlay.getNbaGame().getNbaPlaysPeriods().get(0).getNbaPlays().get(0).getEvent());
        assertEquals("12:00", nbaPlayByPlay.getNbaGame().getNbaPlaysPeriods().get(0).getNbaPlays().get(0).getClock());
        assertEquals("Start Period", nbaPlayByPlay.getNbaGame().getNbaPlaysPeriods().get(0).getNbaPlays().get(0).getDescription());
        assertEquals(12, nbaPlayByPlay.getNbaGame().getNbaPlaysPeriods().get(0).getNbaPlays().get(0).getEventType());
    }

    @Test
    @Ignore
    public void testBreakingDownNFLPlays() throws UnirestException, IOException {

        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        unirestApiService.setUpUnirest();
        EspnSubSection espnSubSection = unirestApiService.getWebsiteDataObject("http://cdn.espn.com/core/nfl/playbyplay?gameId=401030970&xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnSubSection.class);
        unirestApiService.shutdownUnirest();

        assertEquals("playbyplay", espnSubSection.getType());
        assertEquals("401030970", espnSubSection.getGameId());
        assertEquals("nfl", espnSubSection.getEspnContent().getLeague());
        assertNotNull(espnSubSection.getEspnContent().getHtml());

        Document doc = Jsoup.parse(espnSubSection.getEspnContent().getHtml());

        Element pbpTableFirstHalf = doc.getElementById("gamepackage-play-by-play");
        Elements downAndDistance = pbpTableFirstHalf.getElementsByTag("h3");
        Elements postPlay = pbpTableFirstHalf.getElementsByClass("post-play");

        JSONObject game = new JSONObject();
        JSONArray plays = new JSONArray();

        for (int i = 0, l = postPlay.size(); i < l; i++) {
            String gameDetailValue = postPlay.get(i).text();
            if(gameDetailValue.equals("END QUARTER 2")){
                postPlay.remove(i);
                break;
            }
        }

        for (int i = 0, l = postPlay.size(); i < l; i++) {
            String timeStampValue = downAndDistance.get(i).text();
            String gameDetailValue = postPlay.get(i).text();

            JSONObject play = new JSONObject();
            play.put("play-location", timeStampValue);
            play.put("game-detail", gameDetailValue);

            plays.put(play);
        }

        game.put("game-plays", plays);

        EspnGamePlayByPlay espnGamePlayByPlay = jsonMapper.readValue(game.toString(), EspnGamePlayByPlay.class);

        NflDataBreakdownService breakdownService = new NflDataBreakdownService();
       // List<PlayContext> brokenDownPlays = breakdownService.breakdownPlayByPlay(espnGamePlayByPlay.getEspnPlayByPlays(), null);

       // assertEquals("", brokenDownPlays.get(0).getDistance());
//        assertEquals("", brokenDownPlays.get(0).getDown());
//        assertEquals("", brokenDownPlays.get(0).getFieldLocation());
//        assertEquals("10", brokenDownPlays.get(1).getDistance());
//        assertEquals("1st", brokenDownPlays.get(1).getDown());
//        assertEquals("HOU 25", brokenDownPlays.get(1).getFieldLocation());
//        assertEquals("15:00", brokenDownPlays.get(1).getQuarterTimeLeft());
//        assertEquals("1st", brokenDownPlays.get(1).getQuarter());
//        assertEquals(false, brokenDownPlays.get(18).isNoHuddle());
//        assertEquals(false, brokenDownPlays.get(18).isShotgun());
//        assertEquals(false, brokenDownPlays.get(128).isNoHuddle());
//        assertEquals(true, brokenDownPlays.get(128).isShotgun());
//        assertEquals(true, brokenDownPlays.get(123).isNoHuddle());
//        assertEquals(true, brokenDownPlays.get(123).isShotgun());
//        assertEquals("Pass", brokenDownPlays.get(123).getPlayType());
//        assertEquals("D.Watson", brokenDownPlays.get(123).getPrimaryPlayer());
//        assertEquals("W.Fuller", brokenDownPlays.get(123).getSecondaryPlayer());
    }
}