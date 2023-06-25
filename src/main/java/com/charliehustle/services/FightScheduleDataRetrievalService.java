package com.charliehustle.services;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.json.ufc.FightSchedule;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FightScheduleDataRetrievalService {

    @Autowired
    public UnirestApiService unirestApiService;

    @Autowired
    public BasicObjectFactory basicObjectFactory;

    public List<FightSchedule> getFightScheduleData() throws IOException {
        List<FightSchedule> allFightSchedules = basicObjectFactory.createFightScheduleList();
        unirestApiService.setUpUnirest();
        Map<String, String> headerData = basicObjectFactory.createKeyValueMap();
        headerData.put("accept", "application/json");
        Map<String, Object> queryStringData = basicObjectFactory.createKeyObjectMap();

        for (int eventNumber = 627; eventNumber <= 1010; ++eventNumber) {
            try {
                FightSchedule fightSchedule = unirestApiService.getWebsiteDataObject("http://dvk92099qvr17.cloudfront.net/V1/" + eventNumber + "/Fnt.json", headerData, queryStringData, FightSchedule.class);
                if (fightSchedule != null) {
                    allFightSchedules.add(fightSchedule);
                }
            }catch(UnirestException e){
                System.out.println("event " + eventNumber + " didn't exist");
            }
        }

        unirestApiService.shutdownUnirest();

        return allFightSchedules;
    }
}
