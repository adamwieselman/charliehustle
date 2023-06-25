package com.charliehustle.services;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.json.ufc.Fight;
import com.charliehustle.models.json.ufc.FightBreakdown;
import com.charliehustle.models.json.ufc.FightSchedule;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FightBreakdownDataRetrievalService {

    @Autowired
    public UnirestApiService unirestApiService;

    @Autowired
    public BasicObjectFactory basicObjectFactory;


    public List<FightBreakdown> getFightBreakdownData(List<FightSchedule> allFightEvents) throws UnirestException {
        List<FightBreakdown> allFights = new ArrayList<>();
        unirestApiService.setUpUnirest();
        Map<String, String> headerData = basicObjectFactory.createKeyValueMap();
        headerData.put("accept", "application/json");
        Map<String, Object> queryStringData = basicObjectFactory.createKeyObjectMap();

        for (FightSchedule event : allFightEvents) {
            for (Fight fight : event.getFmLiveFeed().getFights()) {
                System.out.println(event.getFmLiveFeed().getEventId());
                System.out.println(fight.getFightId());
                try{
                    FightBreakdown fightBreakdown = unirestApiService.getWebsiteDataObject("https://dvk92099qvr17.cloudfront.net/V2/" + event.getFmLiveFeed().getEventId() + "/" + fight.getFightId() + "/Stats.json", headerData, queryStringData, FightBreakdown.class);
                    allFights.add(fightBreakdown);
                }catch(UnirestException e){
                    System.out.println("fight " + fight.getFightId() + " didn't exist");
                }
            }
        }

        return allFights;
    }
}
