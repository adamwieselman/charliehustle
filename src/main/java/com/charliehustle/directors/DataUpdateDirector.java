package com.charliehustle.directors;

import com.charliehustle.beans.RequestContext;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public interface DataUpdateDirector {

    boolean supports(RequestContext requestContext);

    RequestContext processRequest() throws Exception;
}
