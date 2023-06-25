package com.charliehustle.directors;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class NCBIntegration {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public NcbDataUpdateDirector director = new NcbDataUpdateDirector();


    @Test
    @Ignore
    public void ncbIntegrationTest() throws Exception {

//        NcbDataUpdateService nflDataUpdateService = new NcbDataUpdateService();
//        BasicObjectFactory basicObjectFactory = new BasicObjectFactory();
//        NcbDataBreakdownService ncbDataBreakdownService = new NcbDataBreakdownService();
//        NcbPlayByPlayDataRetrievalService ncbPlayByPlayDataRetrievalService = new NcbPlayByPlayDataRetrievalService();
//        MicrosoftObjectFactory microsoftObjectFactory = new MicrosoftObjectFactory();
 //       JsonMapper jsonMapper = new JsonMapper();
   //     UnirestApiService unirestApiService = new UnirestApiService();
  //      UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
  //      unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
  //      unirestApiService.jsonMapper = jsonMapper;
//        ncbDataUpdateService.basicObjectFactory = basicObjectFactory;
        //ncbPlayByPlayDataRetrievalService.jsonMapper = jsonMapper;

 //       director.ncbDataUpdateService = nflDataUpdateService;
  //      director.basicObjectFactory = basicObjectFactory;
 //       director.ncbPlayByPlayDataRetrievalService = ncbPlayByPlayDataRetrievalService;
 //       director.microsoftObjectFactory = microsoftObjectFactory;
 //       director.ncbDataBreakdownService = ncbDataBreakdownService;

        director.processRequest();

    }
}
