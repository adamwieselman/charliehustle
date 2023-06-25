package com.charliehustle.directors;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.enums.GameSport;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.models.json.ufc.FightSchedule;
import com.charliehustle.services.FightBreakdownDataRetrievalService;
import com.charliehustle.services.FightScheduleDataRetrievalService;
import com.charliehustle.services.FighterInfoDataRetrievalService;
import com.charliehustle.services.UfcDataUpdateService;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class UfcEventDataUpdateDirector implements DataUpdateDirector {

    @Autowired
    protected BasicObjectFactory basicObjectFactory;

    @Autowired
    MicrosoftObjectFactory microsoftObjectFactory;

    @Autowired
    FightScheduleDataRetrievalService fightScheduleDataRetrievalService;

    @Autowired
    FightBreakdownDataRetrievalService fightBreakdownDataRetrievalService;

    @Autowired
    FighterInfoDataRetrievalService fighterInfoDataRetrievalService;

    @Autowired
    UfcDataUpdateService ufcDataUpdateService;


    private RequestContext requestContext;

    @Override
    public boolean supports(RequestContext requestContext) {

        if(requestContext.getRequestInfo().getSport().equals(GameSport.UFC.getSport()) && requestContext.getRequestInfo().getDataType().equals("schedule")) {
            //set the context and return true
            this.requestContext = requestContext;

            return true;
        }
        return false;
    }

    @Override
    public RequestContext processRequest() throws IOException, UnirestException {
        List<FightSchedule> allFightEvents = fightScheduleDataRetrievalService.getFightScheduleData();
        System.out.println(allFightEvents.size() + " events");
//        List<FightBreakdown> allFights = fightBreakdownDataRetrievalService.getFightBreakdownData(allFightEvents);
//        System.out.println(allFights.size() +  " fights");
//        Map<String, FighterInfoData> allFighters = fighterInfoDataRetrievalService.getFighterInfoData(allFightEvents);
//        System.out.println(allFighters.size() +  " fighters");

        Map<String, Row> currentEventRows = basicObjectFactory.createDatabaseRowMap();
        Map<String, Row> currentFighterRows = basicObjectFactory.createDatabaseRowMap();
        Map<String, Row> currentFightRows = basicObjectFactory.createDatabaseRowMap();
        Table fighterTable = null;
        Table fightTable = null;
        Table eventTable = null;

        try(Database db = microsoftObjectFactory.createAccessDatabaseObject(basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\UFC Breakdown.accdb"))) {
            fighterTable = db.getTable("tblFighters");
            fightTable = db.getTable("tblFights");
            eventTable = db.getTable("tblEvents");

           // ufcDataUpdateService.setupFighterMap(fighterTable, currentFighterRows);
            System.out.println("update access table");
            ufcDataUpdateService.updateEvents(eventTable, currentEventRows, allFightEvents);
//            ufcDataUpdateService.updateFights(fightTable, currentFightRows, allFights);
//            ufcDataUpdateService.updateFighters(fighterTable, currentFighterRows, allFighters);

        }

        return requestContext;
    }
}
