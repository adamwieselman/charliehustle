package com.charliehustle.services;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UnirestApiServiceHelper{

    public GetRequest generateGetRequest(String url, Map<String, String> headerData, Map<String, Object> queryStringData) {

        if(url == null){
            return null;
        }

        GetRequest getRequest = Unirest.get(url);

        if(headerData != null){
            getRequest.headers(headerData);
        }

        if(queryStringData != null){
            getRequest.queryString(queryStringData);
        }

        return getRequest;
    }
}
