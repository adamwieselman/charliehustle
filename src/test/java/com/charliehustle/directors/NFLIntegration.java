package com.charliehustle.directors;

import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.mappers.JsonMapper;
import com.charliehustle.services.AccessDatabaseService;
import com.charliehustle.services.NflDataBreakdownService;
import com.charliehustle.services.NflDataUpdateService;
import com.charliehustle.services.NflPlayByPlayDataRetrievalService;
import com.charliehustle.services.UnirestApiService;
import com.charliehustle.services.UnirestApiServiceHelper;

public class NFLIntegration {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public NflDataUpdateDirector director = new NflDataUpdateDirector();



    public void nflIntegrationTest() throws Exception {

        NflDataUpdateService nflDataUpdateService = new NflDataUpdateService();
        BasicObjectFactory basicObjectFactory = new BasicObjectFactory();
        NflDataBreakdownService nflDataBreakdownService = new NflDataBreakdownService();
        NflPlayByPlayDataRetrievalService nflPlayByPlayDataRetrievalService = new NflPlayByPlayDataRetrievalService();
        MicrosoftObjectFactory microsoftObjectFactory = new MicrosoftObjectFactory();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        AccessDatabaseService accessDatabaseService = new AccessDatabaseService();
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        nflDataUpdateService.basicObjectFactory = basicObjectFactory;
        nflDataUpdateService.accessDatabaseService = accessDatabaseService;
        nflPlayByPlayDataRetrievalService.jsonMapper = jsonMapper;

        director.nflDataUpdateService = nflDataUpdateService;
        director.basicObjectFactory = basicObjectFactory;
        director.nflPlayByPlayDataRetrievalService = nflPlayByPlayDataRetrievalService;
        director.microsoftObjectFactory = microsoftObjectFactory;
        director.nflDataBreakdownService = nflDataBreakdownService;

        director.processRequest();

    }
}
