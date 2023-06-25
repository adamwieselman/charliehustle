package com.charliehustle.directors;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.mappers.JsonMapper;
import com.charliehustle.services.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

public class UFCIntegration {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public UfcEventDataUpdateDirector director = new UfcEventDataUpdateDirector();

    @Test
    @Ignore
    public void ufcIntegrationTest() throws IOException, UnirestException {

        UfcDataUpdateService ufcDataUpdateService = new UfcDataUpdateService();
        BasicObjectFactory basicObjectFactory = new BasicObjectFactory();
        FighterInfoDataRetrievalService fighterInfoDataRetrievalService = new FighterInfoDataRetrievalService();
        FightScheduleDataRetrievalService fightScheduleDataRetrievalService = new FightScheduleDataRetrievalService();
        FightBreakdownDataRetrievalService fightBreakdownDataRetrievalService = new FightBreakdownDataRetrievalService();
        MicrosoftObjectFactory microsoftObjectFactory = new MicrosoftObjectFactory();
        JsonMapper jsonMapper = new JsonMapper();
        UnirestApiService unirestApiService = new UnirestApiService();
        AccessDatabaseService accessDatabaseService = new AccessDatabaseService();
        UnirestApiServiceHelper unirestApiServiceHelper = new UnirestApiServiceHelper();
        fightScheduleDataRetrievalService.basicObjectFactory = basicObjectFactory;
        fightScheduleDataRetrievalService.unirestApiService = unirestApiService;
        unirestApiService.unirestApiServiceHelper = unirestApiServiceHelper;
        unirestApiService.jsonMapper = jsonMapper;
        fighterInfoDataRetrievalService.basicObjectFactory = basicObjectFactory;
        fighterInfoDataRetrievalService.unirestApiService = unirestApiService;
        fightBreakdownDataRetrievalService.basicObjectFactory = basicObjectFactory;
        fightBreakdownDataRetrievalService.unirestApiService = unirestApiService;
        ufcDataUpdateService.accessDatabaseService = accessDatabaseService;
        ufcDataUpdateService.basicObjectFactory = basicObjectFactory;

        director.ufcDataUpdateService = ufcDataUpdateService;
        director.basicObjectFactory = basicObjectFactory;
        director.fightBreakdownDataRetrievalService = fightBreakdownDataRetrievalService;
        director.fighterInfoDataRetrievalService = fighterInfoDataRetrievalService;
        director.microsoftObjectFactory = microsoftObjectFactory;
        director.fightScheduleDataRetrievalService = fightScheduleDataRetrievalService;


        director.processRequest();

    }
}
