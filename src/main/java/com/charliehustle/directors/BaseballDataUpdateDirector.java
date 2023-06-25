package com.charliehustle.directors;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charliehustle.beans.StatKey;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.mappers.JsonMapper;
import com.charliehustle.models.BaseballPlayer;
import com.charliehustle.models.BaseballPlayerSavant;
import com.charliehustle.models.CbsPlayer;
import com.charliehustle.services.BaseballPlayerDataRetrievalService;
import com.charliehustle.services.BaseballPlayerDataUpdateService;
import com.charliehustle.services.BaseballPlayerDataUpdateServiceHelper;
import com.charliehustle.services.UnirestApiService;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class BaseballDataUpdateDirector {

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private BasicObjectFactory basicObjectFactory;

    @Autowired
    private MicrosoftObjectFactory microsoftObjectFactory;

    @Autowired
    private UnirestApiService unirestApiService;

    @Autowired
    private BaseballPlayerDataRetrievalService baseballPlayerDataRetrievalService;

    @Autowired
    private BaseballPlayerDataUpdateService baseballPlayerDataUpdateService;

    @Autowired
    private BaseballPlayerDataUpdateServiceHelper baseballPlayerDataUpdateServiceHelper;

    public String updateBaseballDataSuperAuto ()
       throws IOException, UnirestException, InterruptedException
    {
        Table rosterTable = null;
        try(Database db = microsoftObjectFactory.createAccessDatabaseObject(basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\New Baseball Rankings.accdb"))) {
            rosterTable = db.getTable("RosterSuperAuto");
            baseballPlayerDataUpdateService.removeExistingRowsFromTable(rosterTable);
            Map<StatKey, Double> baseballSavantStatisticalBreakdowns = new HashMap<>();
            List<BaseballPlayer> allBaseballPlayers = baseballPlayerDataRetrievalService.getRosterResourceBaseballPlayerData();
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L", "batter", 0, false, baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L", "pitcher", 0, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","batter", 15, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","pitcher", 15, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","batter", 45, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","pitcher", 45, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","batter", 90, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersL = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","pitcher", 90, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R", "batter", 0, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R", "pitcher", 0, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","batter", 15, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","pitcher", 15, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","batter", 45, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","pitcher", 45, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","batter", 90, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersR = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","pitcher", 90, false,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L", "batter", 0, true, baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L", "pitcher", 0, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","batter", 15, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","pitcher", 15, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","batter", 45, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","pitcher", 45, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","batter", 90, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersLQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("L","pitcher", 90, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantBattersRQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R", "batter", 0, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> allBaseballPlayersSavantPitchersRQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R", "pitcher", 0, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantBattersRQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","batter", 15, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoWeekBaseballPlayersSavantPitchersRQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","pitcher", 15, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantBattersRQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","batter", 45, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> oneMonthBaseballPlayersSavantPitchersRQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","pitcher", 45, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantBattersRQuality  = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","batter", 90, true,baseballSavantStatisticalBreakdowns);
            Map<String, BaseballPlayerSavant> twoMonthBaseballPlayersSavantPitchersRQuality = baseballPlayerDataRetrievalService.getBaseballSavantVariableToDateData("R","pitcher", 90, true,baseballSavantStatisticalBreakdowns);
            List<CbsPlayer> allBatters = baseballPlayerDataRetrievalService.getCbsBaseballPlayerData("batter");
            List<CbsPlayer> allPitchers = baseballPlayerDataRetrievalService.getCbsBaseballPlayerData("pitcher");
            baseballPlayerDataUpdateService.meldDataTogetherAndAddToDatabase(rosterTable, allBaseballPlayers, baseballSavantStatisticalBreakdowns, allBaseballPlayersSavantBattersL, allBaseballPlayersSavantPitchersL, twoWeekBaseballPlayersSavantBattersL, twoWeekBaseballPlayersSavantPitchersL, oneMonthBaseballPlayersSavantBattersL, oneMonthBaseballPlayersSavantPitchersL, twoMonthBaseballPlayersSavantBattersL, twoMonthBaseballPlayersSavantPitchersL, allBaseballPlayersSavantBattersR, allBaseballPlayersSavantPitchersR, twoWeekBaseballPlayersSavantBattersR, twoWeekBaseballPlayersSavantPitchersR, oneMonthBaseballPlayersSavantBattersR, oneMonthBaseballPlayersSavantPitchersR, twoMonthBaseballPlayersSavantBattersR, twoMonthBaseballPlayersSavantPitchersR, allBaseballPlayersSavantBattersLQuality, allBaseballPlayersSavantPitchersLQuality, twoWeekBaseballPlayersSavantBattersLQuality, twoWeekBaseballPlayersSavantPitchersLQuality, oneMonthBaseballPlayersSavantBattersLQuality, oneMonthBaseballPlayersSavantPitchersLQuality, twoMonthBaseballPlayersSavantBattersLQuality, twoMonthBaseballPlayersSavantPitchersLQuality, allBaseballPlayersSavantBattersRQuality, allBaseballPlayersSavantPitchersRQuality, twoWeekBaseballPlayersSavantBattersRQuality, twoWeekBaseballPlayersSavantPitchersRQuality, oneMonthBaseballPlayersSavantBattersRQuality, oneMonthBaseballPlayersSavantPitchersRQuality, twoMonthBaseballPlayersSavantBattersRQuality, twoMonthBaseballPlayersSavantPitchersRQuality, allBatters, allPitchers);
        }

        return null;
    }
}
