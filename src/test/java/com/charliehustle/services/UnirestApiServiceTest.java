package com.charliehustle.services;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import static org.junit.Assert.*;

public class UnirestApiServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private GetRequest getRequest;

    @Mock
    private HttpResponse<String> response;

    @Mock
    private HttpResponse<Object> objectResponse;

    @Mock
    private UnirestApiServiceHelper webAccessServiceHelper;

    @InjectMocks
    public UnirestApiService unirestApiService = new UnirestApiService();

    @Test
    public void testGetWebsiteDataString_getRequestNull_returnNull(){
        Mockito.when(webAccessServiceHelper.generateGetRequest(null, null, null)).thenReturn(null);

        try {
            String webData = unirestApiService.getWebsiteDataString(null, null, null);
            assertNull(webData);
        } catch (UnirestException e) {
            fail();
        }
    }

    @Test
    public void testGetWebsiteDataString_getRequestHasUrl_returnValue() throws UnirestException {
        Mockito.when(webAccessServiceHelper.generateGetRequest("fakeUrl", null, null)).thenReturn(getRequest);
        Mockito.when(getRequest.asString()).thenReturn(response);
        Mockito.when(response.getBody()).thenReturn("response Time");

        try {
            String webData = unirestApiService.getWebsiteDataString("fakeUrl", null, null);
            assertNotNull(webData);
            assertEquals("response Time", webData);
        } catch (UnirestException e) {
            fail();
        }
    }

    @Test
    public void testGetWebsiteDataObject_getRequestNull_returnNull(){
        Mockito.when(webAccessServiceHelper.generateGetRequest(null, null, null)).thenReturn(null);

        try {
            Object webData = unirestApiService.getWebsiteDataObject(null, null, null, Object.class);
            assertNull(webData);
        } catch (UnirestException e) {
            fail();
        }
    }

    @Test
    public void testGetWebsiteDataObject_getRequestHasUrl_returnValue() throws UnirestException {
        Mockito.when(webAccessServiceHelper.generateGetRequest("fakeUrl", null, null)).thenReturn(getRequest);
        Mockito.when(getRequest.asObject(Object.class)).thenReturn(objectResponse);
        Mockito.when(objectResponse.getBody()).thenReturn("response Time");

        try {
            Object object =  unirestApiService.getWebsiteDataObject("fakeUrl", null, null, Object.class);
            assertNotNull(object);
            assertEquals("response Time", (String) object);
        } catch (UnirestException e) {
            fail();
        }
    }

    @Test
    public void testShutdownUnirest() {
        ObjectMapper jsonMapper = null;
        try {
            unirestApiService.setUpUnirest();
            unirestApiService.shutdownUnirest();
        }catch(IOException ioe){
            fail();
        }

    }
}