package com.charliehustle.services;
import com.mashape.unirest.request.GetRequest;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.*;

import static org.junit.Assert.*;

public class UnirestApiServiceHelperTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();



    @InjectMocks
    UnirestApiServiceHelper  webAccessServiceHelper = new UnirestApiServiceHelper();

    @Test
    public void testGenerateGetRequest_noUrl_returnNull(){

        GetRequest getRequest = webAccessServiceHelper.generateGetRequest(null, null, null);
        assertNull(getRequest);
    }

    @Test
    public void testGenerateGetRequest_url_returnGetRequest(){

        GetRequest getRequest = webAccessServiceHelper.generateGetRequest("www.google.com", null, null);
        assertNotNull(getRequest);
        assertEquals("www.google.com", getRequest.getUrl());
    }

    @Test
    public void testGenerateGetRequest_headerData_returnGetRequest(){
        Map<String, String> headerData = new TreeMap<>();
        headerData.put("accept", "application/json");

        GetRequest getRequest = webAccessServiceHelper.generateGetRequest("www.google.com", headerData, null);
        assertNotNull(getRequest);
        assertEquals("www.google.com", getRequest.getUrl());
        assertEquals("application/json", getRequest.getHeaders().get("accept").get(0));
    }

    @Test
    public void testGenerateGetRequest_queryStringData_1thing_returnGetRequest(){
        Map<String, String> headerData = new TreeMap<>();
        headerData.put("accept", "application/json");

        Map<String, Object> queryStringData = new TreeMap<>();
        queryStringData.put("teamid", 2);

        GetRequest getRequest = webAccessServiceHelper.generateGetRequest("www.google.com", headerData, queryStringData);
        assertNotNull(getRequest);
        assertEquals("www.google.com?teamid=2", getRequest.getUrl());
        assertEquals("application/json", getRequest.getHeaders().get("accept").get(0));
    }

    @Test
    public void testGenerateGetRequest_queryStringData_moreThan1thing_returnGetRequest(){
        Map<String, String> headerData = new TreeMap<>();
        headerData.put("accept", "application/json");

        Map<String, Object> queryStringData = new TreeMap<>();
        queryStringData.put("teamid", 2);
        queryStringData.put("foo", "bar");
        queryStringData.put("string", "");

        GetRequest getRequest = webAccessServiceHelper.generateGetRequest("www.google.com", headerData, queryStringData);
        assertNotNull(getRequest);
        assertEquals("www.google.com?foo=bar&string=&teamid=2", getRequest.getUrl());
        assertEquals("application/json", getRequest.getHeaders().get("accept").get(0));
    }
}