package com.charliehustle.services;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.models.FighterInfoData;
import com.charliehustle.models.json.ufc.Fight;
import com.charliehustle.models.json.ufc.FightSchedule;
import com.charliehustle.models.json.ufc.Fighter;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FighterInfoDataRetrievalService {

    @Autowired
    public UnirestApiService unirestApiService;

    @Autowired
    public BasicObjectFactory basicObjectFactory;


    public Map<String, FighterInfoData> getFighterInfoData(List<FightSchedule> allFightsScheduled) throws UnirestException {
        Map<String, FighterInfoData> allFighters = new HashMap<String, FighterInfoData>();
        unirestApiService.setUpUnirest();
        Map<String, String> headerData = basicObjectFactory.createKeyValueMap();
        headerData.put("accept", "application/json");
        Map<String, Object> queryStringData = basicObjectFactory.createKeyObjectMap();

        for (FightSchedule event : allFightsScheduled) {
            for(Fight fight : event.getFmLiveFeed().getFights()) {
                for(Fighter fighter : fight.getFighters()){
                    //check for fighter name in map
                    String fighterId = fighter.getFighterId();
                    String fighterName = fighter.getFullName();
                    System.out.println(fighterName);
                    String httpLookupFighterName = fighter.getFullName().toLowerCase().replace(" ", "-" );
                    if(!allFighters.containsKey(fighterName)) {
                        try {
                            String fighterData = unirestApiService.getWebsiteDataString("https://www.ufc.com/athlete/" + httpLookupFighterName, headerData, queryStringData);
                            Document doc = Jsoup.parse(fighterData);
                            Elements bioLabel = doc.getElementsByClass("c-bio__label");
                            Elements bioText = doc.getElementsByClass("c-bio__text");
                            Elements bioAge = doc.getElementsByClass("field--name-age");
                            FighterInfoData fighterInfoData = new FighterInfoData();
                            fighterInfoData.setFighterId(fighterId);
                            fighterInfoData.setFighterName(fighterName);
                            for(int x = 0; x < bioLabel.size(); ++x) {
                                switch(bioLabel.get(x).text()){
                                    case "Status":
                                        System.out.println("status");
                                        fighterInfoData.setStatus(bioText.get(x).text());
                                        break;
                                    case "Hometown":
                                        System.out.println("Hometown");
                                        fighterInfoData.setHometown(bioText.get(x).text());
                                        break;
                                    case "Age":
                                        System.out.println("Age");
                                        fighterInfoData.setAge(bioAge.get(0).text());
                                        break;
                                    case "Trains at":
                                        System.out.println("Trains At");
                                        fighterInfoData.setTrainsAt(bioText.get(x).text());
                                        break;
                                    case "Fighting style":
                                        System.out.println("Fighting style");
                                        fighterInfoData.setFightingStyle(bioText.get(x).text());
                                        break;
                                    case "Height":
                                        System.out.println("Height");
                                        fighterInfoData.setHeight(bioText.get(x).text());
                                        break;
                                    case "Weight":
                                        System.out.println("Weight");
                                        fighterInfoData.setWeight(bioText.get(x).text());
                                        break;
                                    case "Leg reach":
                                        System.out.println("Leg Reach");
                                        fighterInfoData.setLegReach(bioText.get(x).text());
                                        break;
                                    case "Reach":
                                        System.out.println("Reach");
                                        fighterInfoData.setReach(bioText.get(x).text());
                                        break;
                                }
                            }
                            System.out.println(fighterName + " complete");
                            allFighters.put(fighterName, fighterInfoData);
                        } catch (UnirestException e) {
                            System.out.println("fighter " + fighterName + " doesn't exist");
                        }
                    }
                }
            }
        }

        return allFighters;
    }
}
