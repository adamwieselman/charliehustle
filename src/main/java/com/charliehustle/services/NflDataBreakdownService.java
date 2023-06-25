package com.charliehustle.services;

import com.charliehustle.beans.PlayContext;
import com.charliehustle.enums.PlayType;
import com.charliehustle.models.json.nfl.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NflDataBreakdownService {


    public List<PlayContext> breakdownPlayByPlay(NflPlayByPlay nflPlayByPlayData) {

        List<PlayContext> playContexts = new ArrayList<>();

        List<NflPlayByPlayDrive> drives = nflPlayByPlayData.getData().getViewer().getGameDetails().getDrives();
        List<NflPlayByPlayPlay> plays = nflPlayByPlayData.getData().getViewer().getGameDetails().getPlays();
        NflPlayByPlayDataViewerGameDetails gameDetails = nflPlayByPlayData.getData().getViewer().getGameDetails();

        Integer homeScore = 0;
        Integer visitorScore = 0;

        for (NflPlayByPlayPlay play : plays){
            PlayContext playContext = new PlayContext();

            // populate context with general statistics on play
            playContext.setPlayDescription(play.getPlayDescription());
            playContext.setHomeTeam(gameDetails.getHomeTeam().getAbbreviatiion());
            playContext.setVisitorTeam(gameDetails.getVisitorTeam().getAbbreviatiion());
            playContext.setWeek(gameDetails.getWeek());
            playContext.setYear(gameDetails.getYear());
            playContext.setDate(gameDetails.getDate());

            playContext.setQuarter(play.getQuarter());
            playContext.setClockTime(play.getClockTime());
            playContext.setPlayClock(play.getPlayClock());
            playContext.setDown(play.getDown());
            playContext.setYardsToGo(play.getYardsToGo());
            playContext.setHomeScore(homeScore);
            playContext.setVisitorScore(visitorScore);

            if(play.getPossessionTeam() != null) {
                playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                    playContext.setDefensiveTeam(gameDetails.getVisitorTeam().getAbbreviatiion());
                    playContext.setScoreDiff(homeScore - visitorScore);
                } else {
                    playContext.setDefensiveTeam(gameDetails.getHomeTeam().getAbbreviatiion());
                    playContext.setScoreDiff(visitorScore - homeScore);
                }

                playContext.setYardsToGoal(breakdownDownDistanceLocation(play.getYardLine(), play.getPossessionTeam().getAbbreviatiion()));
            }

            playContext.setPenaltyOnPlay(play.isPenaltyOnPlay());
            playContext.setPlayDeleted(play.isPlayDeleted());
            playContext.setPlayType(play.getPlayType());
            playContext.setScoringPlay(play.isScoringPlay());
            playContext.setScoringPlayType(play.getScoringPlayType());

            int x = 0;
            for(NflPlayByPlayPlayStats playStat : play.getPlayStats()) {
                Integer statId = playStat.getStatId();
                PlayType playType = PlayType.get(statId);

                if (playType == PlayType.RUSH_YARDS) {
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                }

                if (playType == PlayType.PASSING_YARDS) {
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                }

                if (playType == PlayType.AIR_YARDS_COMPLETE || playType == PlayType.AIR_YARDS_INCOMPLETE) {
                    playContext.setAirYards(playStat.getYards());
                }

                if (playType == PlayType.PASS_DEFENSE_PLAYER) {
                    if (playContext.getPrimaryPassDefender() != null) {
                        playContext.setSecondaryPassDefender(playStat.getPlayerName());
                    } else {
                        playContext.setPrimaryPassDefender(playStat.getPlayerName());
                    }
                }

                if (playType == PlayType.SACK_YARDS) {
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                }

                if (playType == PlayType.QB_HIT) {
                    playContext.setPrimaryQbHitter(playStat.getPlayerName());
                }

                if (playType == PlayType.INCOMPLETE_PASS) {
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(0);
                    playContext.setPassIncomplete(true);
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                }

                if (playType == PlayType.INTERCEPTION) {
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(0);
                    playContext.setPassIntercepted(true);
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                }

                if (playType == PlayType.INTERCEPTION_RETURN_YARDS) {
                    playContext.setPrimaryPassIntecepter(playStat.getPlayerName());
                }

                if (playType == PlayType.TARGETED_RECEIVER || playType == PlayType.TWO_POINT_PASS_RECEPTION_FAILED || playType == PlayType.TWO_POINT_PASS_RECEPTION_GOOD){
                    playContext.setSecondaryOffensivePlayer(playStat.getPlayerName());
                }

                if (playType == PlayType.YARDS_AFTER_CATCH) {
                    playContext.setYardsAfterCatch(playStat.getYards());
                }

                if (playType == PlayType.SOLO_TACKLE || playType == PlayType.ASSISTED_TACKLE) {
                    playContext.setPrimaryTackler(playStat.getPlayerName());
                }

                if (playType == PlayType.TACKLE_ASSIST) {
                    if (playContext.getPrimaryTackler() == null) {
                        playContext.setPrimaryTackler(playStat.getPlayerName());
                    } else {
                        playContext.setSecondaryTackler(playStat.getPlayerName());
                    }
                }

                if (playType == PlayType.ASSIST_SACK_YARDS){
                    if (playContext.getPrimaryTackler() == null) {
                        playContext.setPrimaryTackler(playStat.getPlayerName());
                    } else {
                        playContext.setSecondaryTackler(playStat.getPlayerName());
                    }
                }

                if (playType == PlayType.FUMBLE_FORCED || playType == PlayType.FUMBLE_NOT_FORCED || playType == PlayType.FUMBLE_OUT_OF_BOUNDS) {
                    playContext.setFumbled(true);
                }

                if (playType == PlayType.FORCED_FUMBLE_PLAYER) {
                    playContext.setPrimaryForcedFumbler(playStat.getPlayerName());
                }

                if(playType == PlayType.FIELD_GOAL_BLOCKED_PLAYER || playType == PlayType.PUNT_BLOCKED_PLAYER || playType == PlayType.EXTRA_POINT_BLOCKED_PLAYER){
                    playContext.setPrimaryKickBlocker(playStat.getPlayerName());
                }

                if (playType == PlayType.FUMBLE_LOST){
                    playContext.setFumbleLost(true);
                }

                if (playType == PlayType.PENALTY_YARDS) {
                    playContext.setPenaltyPlayer(playStat.getPlayerName());
                    playContext.setPenaltyOnPlay(true);
                    playContext.setPenaltyTeamAgainst(playStat.getTeam().getAbbreviatiion());
                    playContext.setPenaltyYards(playStat.getYards());

                    if(play.getPlayDescription().toLowerCase().contains("no play")){
                        playContext.setPenaltyNoPlay(true);
                    }

                }

                if (playType == PlayType.KICKOFF_YARD_LENGTH || playType == PlayType.KICKOFF_YARDS || playType == PlayType.KICKOFF_IN_ENDZONE) {
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setKickYards(playStat.getYards());
                }

                if (playType == PlayType.KICKOFF_RETURN_YARDS) {
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                }

                if (playType == PlayType.KICKOFF_FAIR_CATCH || playType == PlayType.KICKOFF_OUT_OF_BOUNDS || playType == PlayType.KICKOFF_TOUCHBACK_RECEIVING){
                    playContext.setYards(0);
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                }

                if (playType == PlayType.PUNTING_YARDS || playType == PlayType.PUNT_TOUCHBACK_KICKING) {
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setKickYards(playStat.getYards());
                }

                if (playType == PlayType.PUNT_DOWNED || playType == PlayType.PUNT_FAIR_CATCH || playType == PlayType.PUNT_RETURN_YARDS || playType == PlayType.PUNT_OUT_OF_BOUNDS || playType == PlayType.PUNT_TOUCHBACK_RECEIVING){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                }




                if(playType == PlayType.PASSING_YARDS_TD){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                    playContext.setTouchdown(true);

                    if(play.getPossessionTeam() != null) {

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            homeScore = homeScore + 6;
                        } else {
                            visitorScore = visitorScore + 6;
                        }
                    }
                }

                if(playType == PlayType.RUSH_YARDS_TD){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                    playContext.setTouchdown(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            homeScore = homeScore + 6;
                        } else {
                            visitorScore = visitorScore + 6;
                        }
                    }
                }

                if(playType == PlayType.LATERAL_RUSHING_YARDS_TD){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setTouchdown(true);
                }

                if(playType == PlayType.PUNT_RETURN_YARDS_TD){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setTouchdown(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            visitorScore = visitorScore + 6;
                        } else {
                            homeScore = homeScore + 6;
                        }
                    }
                }

                if(playType == PlayType.PUNT_BLOCKED){
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setKickYards(playStat.getYards());
                    playContext.setPuntBlocked(true);
                }

                if(playType == PlayType.KICKOFF_RETURN_YARDS_TD){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setTouchdown(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            visitorScore = visitorScore + 6;
                        } else {
                            homeScore = homeScore + 6;
                        }
                    }
                }

                if(playType == PlayType.FIELD_GOAL_YARDS_MADE){
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setYards(playStat.getYards());
                    playContext.setFieldGoal(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            homeScore = homeScore + 3;
                        } else {
                            visitorScore = visitorScore + 3;
                        }
                    }
                }

                if(playType == PlayType.FIELD_GOAL_YARDS_MISSED) {
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setKickYards(playStat.getYards());
                    playContext.setFieldGoalMissed(true);
                }


                if(playType == PlayType.FIELD_GOAL_YARDS_BLOCKED) {
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setKickYards(playStat.getYards());
                    playContext.setFieldGoalBlocked(true);
                }

                if(playType == PlayType.EXTRA_POINT_GOOD){
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setExtraPoint(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            homeScore = homeScore + 1;
                        } else {
                            visitorScore = visitorScore + 1;
                        }
                    }
                }

                if(playType == PlayType.EXTRA_POINT_FAILED){
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setExtraPointMissed(true);
                }

                if(playType == PlayType.EXTRA_POINT_BLOCKED){
                    playContext.setPrimaryKicker(playStat.getPlayerName());
                    playContext.setExtraPointBlocked(true);
                }

                if  (playType == PlayType.TWO_POINT_PASS_GOOD || playType == PlayType.TWO_POINT_RUSH_GOOD){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(0);
                    playContext.setTwoPointConversion(true);
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            homeScore = homeScore + 2;
                        } else {
                            visitorScore = visitorScore + 2;
                        }
                    }
                }

                if  (playType == PlayType.TWO_POINT_PASS_FAILED || playType == PlayType.TWO_POINT_RUSH_FAILED){
                    playContext.setPrimaryOffensivePlayer(playStat.getPlayerName());
                    playContext.setYards(0);
                    playContext.setTwoPointConversionFailed(true);
                    playContext.setPlayDetailType(getPlayDetailType(play.getPlayDescription(), play.getPlayType()));
                }

                if  (playType == PlayType.SAFETY_TACKLE){
                    playContext.setSafety(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            visitorScore = visitorScore + 2;
                        } else {
                            homeScore = homeScore + 2;
                        }
                    }
                }

                if  (playType == PlayType.INTERCEPTION_RETURN_YARDS_TD){
                    playContext.setPrimaryPassIntecepter(playStat.getPlayerName());
                    playContext.setDefensiveTouchdown(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            visitorScore = visitorScore + 6;
                        } else {
                            homeScore = homeScore + 6;
                        }
                    }
                }

                if  (playType == PlayType.OPP_FUMBLE_RECOVERY_YARDS_TD){
                    playContext.setDefensiveTouchdown(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            visitorScore = visitorScore + 6;
                        } else {
                            homeScore = homeScore + 6;
                        }
                    }
                }

                if (playType == PlayType.OWN_FUMBLE_RECOVERY_YARDS_TD){
                    playContext.setTouchdown(true);

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if (play.getPossessionTeam().getAbbreviatiion().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            homeScore = homeScore + 6;
                        } else {
                            visitorScore = visitorScore + 6;
                        }
                    }
                }

                if (playType == PlayType.MISCELLANEOUS_YARDS_TD){

                    if(play.getPossessionTeam() != null) {
                        playContext.setPossessionTeam(play.getPossessionTeam().getAbbreviatiion());

                        if(play.getPossessionTeam().getAbbreviatiion().equals(playStat.getTeam())){
                            playContext.setTouchdown(true);
                        }else{
                            playContext.setDefensiveTouchdown(true);
                        }

                        if (playStat.getTeam().equals(gameDetails.getHomeTeam().getAbbreviatiion())) {
                            homeScore = homeScore + 6;
                        } else {
                            visitorScore = visitorScore + 6;
                        }
                    }
                }

                if(playType == null){
                    System.out.println(play.getPlayDescription());
                    System.out.println("Play " + x + " " + statId + " needs to available and dealt with " + play.getPlayType());
                }

                ++x;
            }

            playContexts.add(playContext);
        }

        return playContexts;
    }

    private String getPlayDetailType(String playDescription, String playType) {

        if(playType.equals("RUSH")){
            if (playDescription.contains("left end")){
                return "01";
            }

            if (playDescription.contains("left tackle")){
                return "02";
            }

            if (playDescription.contains("left guard")){
                return "03";
            }

            if (playDescription.contains("up the middle")){
                return "04";
            }

            if (playDescription.contains("right guard")){
                return "05";
            }

            if (playDescription.contains("right tackle")){
                return "06";
            }

            if (playDescription.contains("right end")){
                return "07";
            }

            if (playDescription.contains("kneels")){
                return "16";
            }
        }

        if(playType.equals("PASS")){
            if (playDescription.contains("short left")){
                return "08";
            }

            if (playDescription.contains("short middle")){
                return "09";
            }

            if (playDescription.contains("short right")){
                return "10";
            }

            if (playDescription.contains("deep left")){
                return "11";
            }

            if (playDescription.contains("deep middle")){
                return "12";
            }

            if (playDescription.contains("deep right")){
                return "13";
            }

            if (playDescription.contains("spiked")){
                return "14";
            }
        }

        if(playType.equals("SACK")){
            return "15";
        }

        return "00";
    }

    private Integer breakdownTimeLeftAndQuarter(String timeLeft) {

        String[] timeLeftBreakdown = timeLeft.split(":");

        return Integer.parseInt(timeLeftBreakdown[0]) * 60 + Integer.parseInt(timeLeftBreakdown[1]);
    }



    private Integer breakdownDownDistanceLocation(String playLocation, String possessionTeam) {

        CharSequence input = playLocation;
        String teamPart = null;
        Integer yardMarker = 0;

        for(int i = 0; i < input.length(); i++){
            final char c = input.charAt(i);
            if(c > 47 && c < 58){
                if(i != 0) {
                    teamPart = input.subSequence(0, i - 1).toString();
                }
                yardMarker = Integer.parseInt(input.subSequence(i, input.length()).toString());
                i = input.length();
            }
        }

        if(yardMarker == 50){
            return 50;
        }else {
            if (teamPart.equals(possessionTeam)) {
                return 100 - yardMarker;
            } else {
                return yardMarker;
            }
        }
    }
}
