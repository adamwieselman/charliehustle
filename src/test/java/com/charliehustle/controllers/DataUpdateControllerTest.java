package com.charliehustle.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.ResponseEntity;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.directors.BaseballDataUpdateDirector;
import com.charliehustle.directors.DataUpdateDirector;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.DirectorFactory;
import com.charliehustle.validators.DataUpdateRequestValidator;

public class DataUpdateControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BaseballDataUpdateDirector baseballDataUpdateDirector;

    @Mock
    RequestContext request;

    @Mock
    RequestContext.RequestInfo requestInfo;

    @Mock
    RequestContext.ResponseInfo responseInfo;

    @Mock
    DataUpdateDirector dataUpdateDirector;

    @Mock
    DataUpdateRequestValidator dataUpdateRequestValidator;

    @Mock
    DirectorFactory directorFactory;

    @Mock
    BasicObjectFactory objectFactory;

    @InjectMocks
    public DataUpdateController dataUpdateController = new DataUpdateController();

//    @Test
//    public void testBaseballUpdateTeamData_happyPath() throws IOException, UnirestException {
//
//        Mockito.when(baseballDataUpdateDirector.updateBaseballData("players")).thenReturn("playerString");
//        ResponseEntity<String> response = dataUpdateController.updateFantasyBaseballTeamData("players");
//        assertEquals("Baseball fantasy roster update complete \nThese players were not found \nplayerString", response.getBody());
//    }

    @Test
    public void testUpdateDataFromBeginningBasicPath() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.hasResponseErrors()).thenReturn(false);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.getCompletionMessage()).thenReturn("This is a return message");
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromBeginning("sport", "scoreboard", "overWrite");
        assertEquals("This is a return message", response.getBody());
    }

    @Test
    public void testUpdateDataFromBeginningInitialRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.hasRequestErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(requestInfo.getRequestErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromBeginning("sport", "scoreboard", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());

        Mockito.verify(dataUpdateDirector, Mockito.times(0)).processRequest();
    }

    @Test
    public void testUpdateDataFromBeginningCompletedRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.hasResponseErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(request.getResponseInfo()).thenReturn(responseInfo);
        Mockito.when(responseInfo.getResponseErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromBeginning("sport", "scoreboard", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());
    }

    @Test
    public void testUpdateDataFromYearBasicPath() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.getCompletionMessage()).thenReturn("This is a return message");
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromYear("sport", "scoreboard",  "2009", "overWrite");
        assertEquals("This is a return message", response.getBody());
    }

    @Test
    public void testUpdateDataFromYearInitialRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.hasRequestErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(requestInfo.getRequestErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromYear("sport", "scoreboard",  "1999", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());

        Mockito.verify(dataUpdateDirector, Mockito.times(0)).processRequest();
    }

    @Test
    public void testUpdateDataFromYearCompletedRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.hasResponseErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(request.getResponseInfo()).thenReturn(responseInfo);
        Mockito.when(responseInfo.getResponseErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromYear("sport", "scoreboard", "2018", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());
    }

    @Test
    public void testUpdateDataFromYearAndWeekBasicPath() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.hasResponseErrors()).thenReturn(false);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.getCompletionMessage()).thenReturn("This is a return message");
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromYearAndWeek("sport", "scoreboard",  "2009", "7", "overWrite");
        assertEquals("This is a return message", response.getBody());
    }

    @Test
    public void testUpdateDataFromYearAndWeekInitialRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.hasRequestErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(requestInfo.getRequestErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromYearAndWeek("sport", "scoreboard",  "1999", "4", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());

        Mockito.verify(dataUpdateDirector, Mockito.times(0)).processRequest();
    }

    @Test
    public void testUpdateDataFromYearAndWeekCompletedRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.hasResponseErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(request.getResponseInfo()).thenReturn(responseInfo);
        Mockito.when(responseInfo.getResponseErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromYearAndWeek("sport", "scoreboard", "2018", "14", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());
    }

    @Test
    public void testUpdateDataFromDateBasicPath() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.hasResponseErrors()).thenReturn(false);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.getCompletionMessage()).thenReturn("This is a return message");
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromDate("sport", "scoreboard",  "20090729", "overWrite");
        assertEquals("This is a return message", response.getBody());
    }

    @Test
    public void testUpdateDataFromDateInitialRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(request.hasRequestErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(requestInfo.getRequestErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromDate("sport", "scoreboard",  "19990416", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());

        Mockito.verify(dataUpdateDirector, Mockito.times(0)).processRequest();
    }

    @Test
    public void testUpdateDataFromDateCompletedRequestHasErrors() throws Exception {
        Mockito.when(objectFactory.createRequestContext()).thenReturn(request);
        Mockito.when(directorFactory.returnDataUpdateDirector(request)).thenReturn(dataUpdateDirector);
        Mockito.when(dataUpdateDirector.processRequest()).thenReturn(request);
        Mockito.when(request.hasRequestErrors()).thenReturn(false);
        Mockito.when(request.hasResponseErrors()).thenReturn(true);
        Mockito.when(request.getRequestInfo()).thenReturn(requestInfo);
        Mockito.when(request.getResponseInfo()).thenReturn(responseInfo);
        Mockito.when(responseInfo.getResponseErrors()).thenReturn(new ArrayList<>());
        Mockito.doNothing().when(dataUpdateRequestValidator).validate(request);
        ResponseEntity<String> response = dataUpdateController.updateDataFromDate("sport", "scoreboard", "20180910", "overWrite");
        assertEquals("There were errors within the request - []", response.getBody());
    }
}

