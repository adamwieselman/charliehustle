package com.charliehustle.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.mappers.JsonMapper;
import com.charliehustle.models.BaseballPlayer;
import com.charliehustle.models.BaseballPlayerSavant;
import com.charliehustle.models.Conference;
import com.charliehustle.models.ConferenceTeam;
import com.charliehustle.models.CurrentGameStatus;
import com.charliehustle.models.GameData;
import com.charliehustle.models.GameDataTeam;
import com.charliehustle.models.Team;
import com.charliehustle.models.TeamVenue;
import com.charliehustle.models.Venue;
import com.charliehustle.models.json.espn.EspnScoreboard;
import com.charliehustle.models.json.ufc.FightSchedule;
import com.healthmarketscience.jackcess.Row;

@Component
public class BasicObjectFactory {

    public RequestContext createRequestContext() {
        return new RequestContext();
    }

    public JsonMapper createJsonMapper() {
        return new JsonMapper();
    }

    public ArrayList<BaseballPlayer> createBaseballPlayerList() {
        return new ArrayList<BaseballPlayer>();
    }

    public File createFile(String filePath){
        return new File(filePath);
    }

    public Map<String, Row> createDatabaseRowMap(){
        return new HashMap<>();
    }

    public Map<String, String> createKeyValueMap() {
        return new HashMap<>();
    }

    public FileInputStream createFileInputStream(File myFile) throws FileNotFoundException {
        return new FileInputStream(myFile);
    }

    public Map<String, Object> createKeyObjectMap() {
        return new HashMap<>();
    }

    public GameData createGameDataInfo() {
        return new GameData();
    }

    public Venue createVenue() {
        return new Venue();
    }

    public Team createTeam() { return new Team(); }

    public Conference createConference() { return new Conference();
    }

    public CurrentGameStatus createCurrentGameStatus() {
        return new CurrentGameStatus();
    }

    public GameDataTeam createGameDataInfoTeam() {return new GameDataTeam();}

    public TeamVenue createTeamVenue() {return new TeamVenue();}

    public ConferenceTeam createConferenceTeam() {return new ConferenceTeam();}

    public List<Conference> createConferenceList() {
        return new ArrayList<>();
    }

    public List<Team> createTeamList() {
        return new ArrayList<>();
    }

    public List<FightSchedule> createFightScheduleList() { return new ArrayList<>(); }

    public List<EspnScoreboard> createNflGameScheduleList() { return new ArrayList<>();}

   public Map<String, BaseballPlayerSavant> createBaseballPlayerSavantMap ()
   {
       return new HashMap<>();
   }
}

