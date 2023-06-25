package com.charliehustle.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charliehustle.beans.StatKey;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.BaseballPlayer;
import com.charliehustle.models.BaseballPlayerSavant;
import com.charliehustle.models.BaseballSavantData;
import com.charliehustle.models.CbsPlayer;
import com.charliehustle.models.CbsPlayerData;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class BaseballPlayerDataRetrievalService {

    @Autowired
    private UnirestApiService unirestApiService;

    @Autowired
    private BasicObjectFactory basicObjectFactory;

    @Autowired
    private AccessDatabaseService accessDatabaseService;

    @Autowired
    private HtmlExtractionService htmlExtractionService;

    public List<BaseballPlayer> getRosterResourceBaseballPlayerData() throws IOException, UnirestException {
        List<BaseballPlayer> allBaseballPlayers = basicObjectFactory.createBaseballPlayerList();
        unirestApiService.setUpUnirest();
        Map<String, String> headerData = basicObjectFactory.createKeyValueMap();
        headerData.put("accept", "application/json");

        for (int i = 1; i <= 30; ++i) {
            Map<String, Object> queryStringData = basicObjectFactory.createKeyObjectMap();
            queryStringData.put("teamid", i);
            List<BaseballPlayer> players = Arrays.asList(unirestApiService.getWebsiteDataObject("https://www.fangraphs.com/api/depth-charts/roster", headerData, queryStringData, BaseballPlayer[].class));
            System.out.println("adding " + i + " group of players from fangraphs to master list");
            allBaseballPlayers.addAll(players);
        }

        unirestApiService.shutdownUnirest();
        return allBaseballPlayers;
    }

    public Map<String, BaseballPlayerSavant> getBaseballSavantVariableToDateData (String opponentHand,
                                                                                  String batterPitcher,
                                                                                  Integer daysBack,
                                                                                  boolean hitQuality,
                                                                                  Map<StatKey, Double> baseballSavantStatisticalBreakdowns)
       throws UnirestException, IOException, InterruptedException
    {
        System.out.println("Opponent Hand" + opponentHand + "/ Daysback " + daysBack + " / playerType " + batterPitcher + " / hitQuality " + hitQuality);

        DescriptiveStatistics descriptiveStatisticsKPercentL = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsBBPercentL  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXBaL  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXSlgL  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXIsoL = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXObpL  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXWobaL  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsKPercentR = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsBBPercentR  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXBaR  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXSlgR  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXIsoR = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXObpR  = new DescriptiveStatistics();
        DescriptiveStatistics descriptiveStatisticsXWobaR  = new DescriptiveStatistics();

        BaseballSavantData baseballSavantData = new BaseballSavantData();

        Map<String, BaseballPlayerSavant> baseballPlayerSavantData = basicObjectFactory.createBaseballPlayerSavantMap();

        baseballSavantData = htmlExtractionService.extractBaseballSavantVariableTimeframeJson(opponentHand, batterPitcher, daysBack, hitQuality);

        for(BaseballPlayerSavant baseballPlayerSavant : baseballSavantData.getBaseballPlayerSavantList()) {
            baseballPlayerSavantData.put(baseballPlayerSavant.getPlayerId(), baseballPlayerSavant);

            if(opponentHand == "L"){
                if (!baseballPlayerSavant.getkPercent().isEmpty()) {
                    descriptiveStatisticsKPercentL.addValue(Double.parseDouble(baseballPlayerSavant.getkPercent()));
                }

                if (!baseballPlayerSavant.getBbPercent().isEmpty()) {
                    descriptiveStatisticsBBPercentL.addValue(Double.parseDouble(baseballPlayerSavant.getBbPercent()));
                }

                if (!baseballPlayerSavant.getExpectedBa().isEmpty()) {
                    descriptiveStatisticsXBaL.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedBa()));
                }

                if (!baseballPlayerSavant.getExpectedSlg().isEmpty()) {
                    descriptiveStatisticsXSlgL.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedSlg()));
                }

                if(!baseballPlayerSavant.getExpectedBa().isEmpty() && !baseballPlayerSavant.getExpectedSlg().isEmpty()){
                    descriptiveStatisticsXIsoL.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedSlg())-Double.parseDouble(baseballPlayerSavant.getExpectedBa()));
                }

                if (!baseballPlayerSavant.getExpectedObp().isEmpty()) {
                    descriptiveStatisticsXObpL.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedObp()));
                }

                if (!baseballPlayerSavant.getExpectedWoba().isEmpty()) {
                    descriptiveStatisticsXWobaL.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedWoba()));
                }
            }else {  //R

                if (!baseballPlayerSavant.getkPercent().isEmpty()) {
                    descriptiveStatisticsKPercentR.addValue(Double.parseDouble(baseballPlayerSavant.getkPercent()));
                }

                if (!baseballPlayerSavant.getBbPercent().isEmpty()) {
                    descriptiveStatisticsBBPercentR.addValue(Double.parseDouble(baseballPlayerSavant.getBbPercent()));
                }

                if (!baseballPlayerSavant.getExpectedBa().isEmpty()) {
                    descriptiveStatisticsXBaR.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedBa()));
                }

                if (!baseballPlayerSavant.getExpectedSlg().isEmpty()) {
                    descriptiveStatisticsXSlgR.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedSlg()));
                }

                if(!baseballPlayerSavant.getExpectedBa().isEmpty() && !baseballPlayerSavant.getExpectedSlg().isEmpty()){
                    descriptiveStatisticsXIsoR.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedSlg())-Double.parseDouble(baseballPlayerSavant.getExpectedBa()));
                }

                if (!baseballPlayerSavant.getExpectedObp().isEmpty()) {
                    descriptiveStatisticsXObpR.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedObp()));
                }

                if (!baseballPlayerSavant.getExpectedWoba().isEmpty()) {
                    descriptiveStatisticsXWobaR.addValue(Double.parseDouble(baseballPlayerSavant.getExpectedWoba()));
                }
            }
        }

        if(opponentHand == "L") {
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "KPct", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsKPercentL.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "KPct", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsKPercentL.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "BBPct", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsBBPercentL.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "BBPct", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsBBPercentL.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xba", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXBaL.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xba", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXBaL.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xslg", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXSlgL.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xslg", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXSlgL.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xiso", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXIsoL.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xiso", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXIsoL.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xobp", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXObpL.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xobp", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXObpL.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xwoba", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXWobaL.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("L", "Xwoba", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXWobaL.getStandardDeviation());
        }else {
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "KPct", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsKPercentR.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "KPct", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsKPercentR.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "BBPct", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsBBPercentR.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "BBPct", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsBBPercentR.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xba", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXBaR.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xba", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXBaR.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xslg", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXSlgR.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xslg", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXSlgR.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xiso", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXIsoR.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xiso", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXIsoR.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xobp", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXObpR.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xobp", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXObpR.getStandardDeviation());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xwoba", "Avg", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXWobaR.getMean());
            baseballSavantStatisticalBreakdowns.put(new StatKey("R", "Xwoba", "StDev", batterPitcher, daysBack, hitQuality), descriptiveStatisticsXWobaR.getStandardDeviation());
        }
        return baseballPlayerSavantData;
    }

    public List<CbsPlayer> getCbsBaseballPlayerData (String batterPitcher)
       throws UnirestException, IOException, InterruptedException
    {
        CbsPlayerData cbsPlayerData = htmlExtractionService.extractCbsPlayerData(batterPitcher);
        return cbsPlayerData.getCbsPlayerList();
    }
}
