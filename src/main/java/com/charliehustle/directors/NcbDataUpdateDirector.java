package com.charliehustle.directors;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.enums.GameSport;
import com.charliehustle.mappers.JsonMapper;
import com.charliehustle.models.json.espn.*;
import com.charliehustle.services.UnirestApiService;
import com.charliehustle.services.UnirestApiServiceHelper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class NcbDataUpdateDirector implements DataUpdateDirector {


    private RequestContext requestContext;

    @Override
    public boolean supports(RequestContext requestContext) {

        if(requestContext.getRequestInfo().getSport().equals(GameSport.COLLEGE_BASKETBALL.getSport()) && requestContext.getRequestInfo().getDataType().equals("schedule")) {
            //set the context and return true
            this.requestContext = requestContext;

            return true;
        }
        return false;
    }

    @Override
    public RequestContext processRequest() throws Exception {

        LocalDate currentDate = LocalDate.of(2020, 11, 1);
        //LocalDate endDate = LocalDate.of(2020, 11, 26);
        LocalDate endDate = LocalDate.now();


        while (!currentDate.equals(endDate)) {
            // pull data from the date
            UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
            JsonMapper jsonMapper = new JsonMapper();
            UnirestApiService unirestApiService = new UnirestApiService();
            unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
            unirestApiService.jsonMapper = jsonMapper;
            unirestApiService.setUpUnirest();
            String url = "http://cdn.espn.com/core/mens-college-basketball/scoreboard/_/group/50/date/" + currentDate.getYear() + String.format("%02d", currentDate.getMonthValue()) + String.format("%02d", currentDate.getDayOfMonth()) + "?xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full";
            EspnScoreboard espnScoreboard = unirestApiService.getWebsiteDataObject(url, null, null, EspnScoreboard.class);
            unirestApiService.shutdownUnirest();

            List<EspnEvent> espnEventsList = espnScoreboard.getEspnContent().getEspnSbData().getEspnEvents();
            // if no games skip to next game
            if(espnEventsList.size() != 0) {
                // for each game available on a day
                for(EspnEvent espnEvent : espnEventsList) {
                    // verify that not cancelled or postponed or active
                    if ("STATUS_FINAL".equals(espnEvent.getEspnStatus().getEspnType().getName())) {
                        System.out.println(espnEvent.getId());
                        System.out.println(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getId());
                        Integer homeId = Integer.parseInt(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getId());
                        System.out.println(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getName());
                        System.out.println(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getConferenceId());
                        System.out.println(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(1).getEspnTeam().getId());
                        Integer awayId = Integer.parseInt(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(1).getEspnTeam().getId());
                        System.out.println(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(1).getEspnTeam().getName());
                        System.out.println(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(1).getEspnTeam().getConferenceId());
                        if(espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(0).getEspnTeam().getConferenceId() != null && espnEvent.getEspnCompetitions().get(0).getEspnCompetitors().get(1).getEspnTeam().getConferenceId() != null) {
                            UnirestApiServiceHelper unirestApiServiceHelper1 = new UnirestApiServiceHelper();
                            UnirestApiService unirestApiService1 = new UnirestApiService();
                            unirestApiService1.unirestApiServiceHelper = unirestApiServiceHelper1;
                            unirestApiService1.jsonMapper = jsonMapper;
                            unirestApiService1.setUpUnirest();
                            EspnSubSection espnSubSection = unirestApiService1.getWebsiteDataObject("http://cdn.espn.com/core/mens-college-basketball/playbyplay?gameId=" + espnEvent.getId() + "&xhr=1&render=true&device=desktop&country=us&lang=en&region=us&site=espn&edition-host=espn.com&one-site=true&site-type=full", null, null, EspnSubSection.class);
                            unirestApiService1.shutdownUnirest();

                            // pull play by play data from the game
                            Document doc = Jsoup.parse(espnSubSection.getEspnContent().getHtml());
                            Element pbpTableFirstHalf = doc.select("#gp-quarter-1").first();
                            Element pbpTableSecondHalf = doc.select("#gp-quarter-2").first();
                            JSONObject game = new JSONObject();
                            JSONArray plays = new JSONArray();

                            if (pbpTableFirstHalf != null ) {
                                Elements timeStampsFirst = pbpTableFirstHalf.getElementsByClass("time-stamp");
                                Elements teamLogosFirst = pbpTableFirstHalf.getElementsByClass("team-logo");
                                Elements gameDetailsFirst = pbpTableFirstHalf.getElementsByClass("game-details");
                                Elements combinedScoresFirst = pbpTableFirstHalf.getElementsByClass("combined-score");

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
                                    play.put("game-half", "1");

                                    plays.put(play);
                                }
                            }

                            if(pbpTableSecondHalf != null) {
                                Elements timeStampsSecond = pbpTableSecondHalf.getElementsByClass("time-stamp");
                                Elements teamLogosSecond = pbpTableSecondHalf.getElementsByClass("team-logo");
                                Elements gameDetailsSecond = pbpTableSecondHalf.getElementsByClass("game-details");
                                Elements combinedScoresSecond = pbpTableSecondHalf.getElementsByClass("combined-score");

                                for (int i = 0, l = timeStampsSecond.size(); i < l; i++) {
                                    String timeStampValue = timeStampsSecond.get(i).text();
                                    String teamLogoValue = teamLogosSecond.get(i).attr("src");
                                    String gameDetailValue = gameDetailsSecond.get(i).text();
                                    String combinedScoreValue = combinedScoresSecond.get(i).text();

                                    JSONObject play = new JSONObject();
                                    play.put("time-stamp", timeStampValue);
                                    play.put("team-logo", teamLogoValue);
                                    play.put("game-detail", gameDetailValue);
                                    play.put("combined-score", combinedScoreValue);
                                    play.put("game-half", "2");

                                    plays.put(play);
                                }
                            }

                            game.put("game-plays", plays);

                            EspnGamePlayByPlay espnGamePlayByPlay = jsonMapper.readValue(game.toString(), EspnGamePlayByPlay.class);

                            Integer homeMissed3Pointers = 0;
                            Integer awayMissed3Pointers = 0;
                            // for each play
                            for (EspnPlayByPlay pbp : espnGamePlayByPlay.getEspnPlayByPlays()) {
                                String[] timeparts = pbp.getTimeStamp().split(":");

                                int timeSeconds = 0;

                                if(pbp.getGameHalf() == "1"){
                                    timeSeconds = (Integer.parseInt(timeparts[0]) + 20) * 60 + Integer.parseInt(timeparts[1]);
                                }else{
                                    timeSeconds = Integer.parseInt(timeparts[0]) * 60 + Integer.parseInt(timeparts[1]);
                                }

                                System.out.println(timeSeconds + " seconds remaining");

                                int pngSpot = pbp.getTeamLogo().indexOf(".png");
                                int slashSpot = pbp.getTeamLogo().lastIndexOf("/", pngSpot);

                                Integer teamNumber = (Integer.parseInt(pbp.getTeamLogo().substring(slashSpot + 1, pngSpot)));
                                System.out.println(teamNumber + " team number");

                                String detail = pbp.getGameDetail();

                                if(detail.contains(" missed Three Point Jumper")){
                                    if(teamNumber.equals(homeId)){
                                        ++homeMissed3Pointers;
                                    }else{
                                        ++awayMissed3Pointers;
                                    }

                                    String player = detail.substring(0, detail.indexOf(" missed Three Point Jumper"));
                                    System.out.println("Missed 3 player " + player);
                                }

                                String[] scorePoints = pbp.getCombinedScore().split("-");
                                BigDecimal possesionsDiff = new BigDecimal((Integer.parseInt(scorePoints[0].trim()) - Integer.parseInt(scorePoints[1].trim()))/3);
                                System.out.println(possesionsDiff);
                            }
                            System.out.println("Away Total missed 3's" + awayMissed3Pointers);
                            System.out.println("Home Total missed 3's" + homeMissed3Pointers);
                        }else{
                            System.out.println("Not Div 1");
                        }
                    }else{
                        System.out.println("This was a different status " + espnEvent.getEspnStatus().getEspnType().getName() );
                    }
                }
            }
            currentDate = currentDate.plusDays(1);
        }

        return requestContext;
    }
}
