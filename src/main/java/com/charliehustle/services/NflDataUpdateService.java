package com.charliehustle.services;

import com.charliehustle.beans.PlayContext;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.json.espn.EspnEvent;
import com.charliehustle.models.json.espn.EspnPlayByPlay;
import com.healthmarketscience.jackcess.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class NflDataUpdateService {

    @Autowired
    public BasicObjectFactory basicObjectFactory;

    @Autowired
    public AccessDatabaseService accessDatabaseService;

    public void updateGames(Table gameTable, EspnEvent espnEvent) throws IOException {

        Map<String, String> playDataUpdateMap = basicObjectFactory.createKeyValueMap();
        playDataUpdateMap.put("Game_Date", espnEvent.getDate());
        playDataUpdateMap.put("Game_Id", espnEvent.getId());
        playDataUpdateMap.put("Game_Name", espnEvent.getName());

        accessDatabaseService.addRowNflEvent(gameTable, playDataUpdateMap);

    }

    public void updatePlaysEspn(Table playTable, List<EspnPlayByPlay> gamePlayByPlays, String id) throws IOException {
        for(EspnPlayByPlay play : gamePlayByPlays){
            Map<String, String> playDataUpdateMap = basicObjectFactory.createKeyValueMap();
            playDataUpdateMap.put("Game_Detail", play.getGameDetail());
            accessDatabaseService.addRowNflPlays(playTable, playDataUpdateMap);
        }
    }

    public void updatePlays(Table playTable, List<PlayContext> gamePlayByPlays) throws IOException {
        for(PlayContext play : gamePlayByPlays){
            Map<String, String> playDataUpdateMap = basicObjectFactory.createKeyValueMap();
            playDataUpdateMap.put("Game_Detail", play.getPlayDescription());
            playDataUpdateMap.put("Year", play.getYear()== null? null :play.getYear().toString());
            playDataUpdateMap.put("Week", play.getWeek()== null? null :play.getWeek().toString());
            playDataUpdateMap.put("Date", play.getDate());
            playDataUpdateMap.put("Home_Team", play.getHomeTeam());
            playDataUpdateMap.put("Visitor_Team", play.getVisitorTeam());
            playDataUpdateMap.put("Clock_Time", play.getClockTime());
            playDataUpdateMap.put("Play_Clock", play.getPlayClock());
            playDataUpdateMap.put("Quarter", play.getQuarter()== null? null :play.getQuarter().toString());
            playDataUpdateMap.put("Down", play.getDown()== null? null :play.getDown().toString());
            playDataUpdateMap.put("Yards_To_Go", play.getYardsToGo()== null? null :play.getYardsToGo().toString());
            playDataUpdateMap.put("Yards_To_Goal", play.getYardsToGoal()==null? null :play.getYardsToGoal().toString());
            playDataUpdateMap.put("Possession_Team", play.getPossessionTeam());
            playDataUpdateMap.put("Defensive_Team", play.getDefensiveTeam());



            playDataUpdateMap.put("Primary_Offensive_Player", play.getPrimaryOffensivePlayer());
            playDataUpdateMap.put("Secondary_Offensive_Player", play.getSecondaryOffensivePlayer());
            playDataUpdateMap.put("Primary_Tackler", play.getPrimaryTackler());
            playDataUpdateMap.put("Secondary_Tackler", play.getSecondaryTackler());
            playDataUpdateMap.put("Primary_Kicker", play.getPrimaryKicker());
            playDataUpdateMap.put("Primary_Kick_Blocker", play.getPrimaryKickBlocker());
            playDataUpdateMap.put("Primary_Pass_Defender", play.getPrimaryPassDefender());
            playDataUpdateMap.put("Secondary_Pass_Defender", play.getSecondaryPassDefender());
            playDataUpdateMap.put("Primary_Pass_Intercepter", play.getPrimaryPassIntecepter());
            playDataUpdateMap.put("Primary_Qb_Hitter", play.getPrimaryQbHitter());
            playDataUpdateMap.put("Primary_Forced_Fumbler", play.getPrimaryForcedFumbler());
            playDataUpdateMap.put("Penalty_Player", play.getPenaltyPlayer());
            playDataUpdateMap.put("Penalty_Team_Against", play.getPenaltyTeamAgainst());


            playDataUpdateMap.put("Play_Type", play.getPlayType());
            playDataUpdateMap.put("Scoring_Play_Type", play.getScoringPlayType());
            playDataUpdateMap.put("Play_Detail_Type", play.getPlayDetailType());
            playDataUpdateMap.put("Yards", play.getYards()==null? null :play.getYards().toString());
            playDataUpdateMap.put("Air_Yards", play.getAirYards()==null? null :play.getAirYards().toString());
            playDataUpdateMap.put("Yards_After_Catch", play.getYardsAfterCatch()==null? null :play.getYardsAfterCatch().toString());
            playDataUpdateMap.put("Kick_Yards", play.getKickYards()==null? null :play.getKickYards().toString());
            playDataUpdateMap.put("Penalty_Yards", play.getPenaltyYards()==null? null :play.getPenaltyYards().toString());


            playDataUpdateMap.put("Penalty_OnPlay", play.isPenaltyOnPlay()? "true" : "false");
            playDataUpdateMap.put("Penalty_NoPlay", play.isPenaltyNoPlay()? "true" : "false");
            playDataUpdateMap.put("Play_Deleted", play.isPlayDeleted()? "true" : "false");
            playDataUpdateMap.put("Scoring_Play", play.isScoringPlay()? "true" : "false");
            playDataUpdateMap.put("Pass_Incomplete", play.isPassIncomplete()? "true" : "false");
            playDataUpdateMap.put("Pass_Intercepted", play.isPassIntercepted()? "true" : "false");
            playDataUpdateMap.put("Fumbled", play.isFumbled()? "true" : "false");
            playDataUpdateMap.put("Fumble_Lost", play.isFumbleLost()? "true" : "false");
            playDataUpdateMap.put("Touchdown", play.isTouchdown()? "true" : "false");
            playDataUpdateMap.put("Defensive_Touchdown", play.isDefensiveTouchdown()? "true" : "false");
            playDataUpdateMap.put("Field_Goal", play.isFieldGoal()? "true" : "false");
            playDataUpdateMap.put("Field_Goal_Missed", play.isFieldGoalMissed()? "true" : "false");
            playDataUpdateMap.put("Field_Goal_Blocked", play.isFieldGoalBlocked()? "true" : "false");
            playDataUpdateMap.put("Punt_Blocked", play.isPuntBlocked()? "true" : "false");
            playDataUpdateMap.put("Extra_Point", play.isExtraPoint()? "true" : "false");
            playDataUpdateMap.put("Extra_Point_Missed", play.isExtraPointMissed()? "true" : "false");
            playDataUpdateMap.put("Extra_Point_Blocked", play.isExtraPointBlocked()? "true" : "false");
            playDataUpdateMap.put("Two_Point_Conversion", play.isTwoPointConversion()? "true" : "false");
            playDataUpdateMap.put("Two_Point_Conversion_Failed", play.isTwoPointConversionFailed()? "true" : "false");
            playDataUpdateMap.put("Safety", play.isSafety()? "true" : "false");

            playDataUpdateMap.put("Home_Score", play.getHomeScore()==null? null :play.getHomeScore().toString());
            playDataUpdateMap.put("Visitor_Score", play.getVisitorScore()==null? null :play.getVisitorScore().toString());
            playDataUpdateMap.put("Score_Diff", play.getScoreDiff()==null? null :play.getScoreDiff().toString());

            accessDatabaseService.addRowNflPlays(playTable, playDataUpdateMap);
        }
    }
}
