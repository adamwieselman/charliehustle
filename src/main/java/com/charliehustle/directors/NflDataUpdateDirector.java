package com.charliehustle.directors;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charliehustle.beans.PlayContext;
import com.charliehustle.beans.RequestContext;
import com.charliehustle.enums.GameSport;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.models.json.nfl.NflPlayByPlay;
import com.charliehustle.services.NflDataBreakdownService;
import com.charliehustle.services.NflDataUpdateService;
import com.charliehustle.services.NflPlayByPlayDataRetrievalService;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;

@Component
public class NflDataUpdateDirector implements DataUpdateDirector {

    @Autowired
    protected BasicObjectFactory basicObjectFactory;

    @Autowired
    MicrosoftObjectFactory microsoftObjectFactory;

    @Autowired
    NflDataBreakdownService nflDataBreakdownService;

    @Autowired
    NflDataUpdateService nflDataUpdateService;

    @Autowired
    NflPlayByPlayDataRetrievalService nflPlayByPlayDataRetrievalService;


    private RequestContext requestContext;

    @Override
    public boolean supports(RequestContext requestContext) {

        if(requestContext.getRequestInfo().getSport().equals(GameSport.NFL.getSport()) && requestContext.getRequestInfo().getDataType().equals("schedule")) {
            //set the context and return true
            this.requestContext = requestContext;

            return true;
        }
        return false;
    }

    @Override
    public RequestContext processRequest() throws Exception {

        for(int y = 2021; y <= 2021; ++y) {
            for (int x = 1; x <= 6; ++x) {

                Collection<File> filesInFolder = FileUtils.listFiles(new File("C:\\Users\\Owner\\OneDrive\\Documents\\NFL Game Json\\" + y + "\\Week" + x), null, false);

                for (File file : filesInFolder) {

                    String fileName = file.getAbsolutePath();

                    System.out.println("running " + fileName);

                    if (file.length() != 0) {

                        NflPlayByPlay nflPlayByPlay = nflPlayByPlayDataRetrievalService.getNflPlayByPlay(fileName);
                        List<PlayContext> brokendownPlays = nflDataBreakdownService.breakdownPlayByPlay(nflPlayByPlay);

                        //Table gameTable = null;
                        Table playTable = null;

                        try (Database db = microsoftObjectFactory.createAccessDatabaseObject(basicObjectFactory.createFile("C:\\Users\\Owner\\Documents\\Football2020.accdb"))) {
                            //gameTable = db.getTable("tblGames");
                            playTable = db.getTable("tblPlays");

                            //nflDataUpdateService.updateGames(gameTable, espnEvent);
                            nflDataUpdateService.updatePlays(playTable, brokendownPlays);
                        }
                    }
                }
            }
        }
        return requestContext;
    }
}
