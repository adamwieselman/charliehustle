package com.charliehustle.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.charliehustle.beans.RequestContext;
import com.charliehustle.directors.BaseballDataUpdateDirector;
import com.charliehustle.directors.DataUpdateDirector;
import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.DirectorFactory;
import com.charliehustle.validators.DataUpdateRequestValidator;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class DataUpdateController {

    public static final String APPLICATION_JSON = "application/json";

    @Autowired
    BaseballDataUpdateDirector baseballDataUpdateDirector;

    @Autowired
    DirectorFactory directorFactory;

    @Autowired
    DataUpdateRequestValidator dataUpdateRequestValidator;

    @Autowired
    BasicObjectFactory objectFactory;

//    @GetMapping(path = "v1.0/update/mlb/fantasy/team/data/{fileName}", produces = APPLICATION_JSON )
//    public ResponseEntity<String> updateFantasyBaseballTeamData(@PathVariable String fileName) throws IOException, UnirestException {
//
//        System.out.println("in the director");
//        String cantFindPlayers = baseballDataUpdateDirector.updateBaseballData(fileName);
//
//        return new ResponseEntity<String> ("Baseball fantasy roster update complete \nThese players were not found \n" + cantFindPlayers , HttpStatus.OK);
//    }
//
//    @GetMapping(path = "v1.0/update/mlb/fantasy/team/data/auto", produces = APPLICATION_JSON )
//    public ResponseEntity<String> updateFantasyBaseballTeamDataAuto()
//       throws IOException, UnirestException, InterruptedException
//    {
//
//        String cantFindPlayers = baseballDataUpdateDirector.updateBaseballDataAuto();
//
//        return new ResponseEntity<String> ("Baseball fantasy roster update complete \nThese players were not found \n" + cantFindPlayers , HttpStatus.OK);
//    }

    @GetMapping(path = "v1.0/update/mlb/fantasy/team/data/super", produces = APPLICATION_JSON )
    public ResponseEntity<String> updateFantasyBaseballTeamDataSuperAuto()
       throws IOException, UnirestException, InterruptedException
    {

        String cantFindPlayers = baseballDataUpdateDirector.updateBaseballDataSuperAuto();

        return new ResponseEntity<String> ("Baseball fantasy roster update complete \nThese players were not found \n" + cantFindPlayers , HttpStatus.OK);
    }

    @GetMapping(path = "v1.0/update/sport/{sport}/data/{dataType}/overwrite/{overWrite}", produces = APPLICATION_JSON )
    public ResponseEntity<String> updateDataFromBeginning(@PathVariable String sport, @PathVariable String dataType, @PathVariable String overWrite) throws Exception {

        RequestContext request = objectFactory.createRequestContext();
        request.getRequestInfo().setSport(sport);
        request.getRequestInfo().setDataType(dataType);
        request.getRequestInfo().setOverWrite(overWrite);

        dataUpdateRequestValidator.validate(request);

        if(request.hasRequestErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + request.getRequestInfo().getRequestErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        //this might get changed to a transmittor that will use a factory to figure out the http call to the service versus getting the service right now
        DataUpdateDirector dataUpdateDirector = directorFactory.returnDataUpdateDirector(request);
        RequestContext response = dataUpdateDirector.processRequest();

        if(response.hasResponseErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + response.getResponseInfo().getResponseErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String> (response.getCompletionMessage(), HttpStatus.OK);
    }

    @GetMapping(path = "v1.0/update/sport/{sport}/data/{dataType}/year/{year}/overwrite/{overwrite}", produces = APPLICATION_JSON )
    public ResponseEntity<String> updateDataFromYear(@PathVariable String sport, @PathVariable String dataType, @PathVariable String year, @PathVariable String overWrite) throws Exception {

        RequestContext request = objectFactory.createRequestContext();
        request.getRequestInfo().setSport(sport);
        request.getRequestInfo().setDataType(dataType);
        request.getRequestInfo().setYear(year);
        request.getRequestInfo().setOverWrite(overWrite);

        dataUpdateRequestValidator.validate(request);

        if(request.hasRequestErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + request.getRequestInfo().getRequestErrors(), HttpStatus.BAD_REQUEST);
        }

        //this might get changed to a transmittor that will use a factory to figure out the http call to the service versus getting the service right now
        DataUpdateDirector dataUpdateDirector = directorFactory.returnDataUpdateDirector(request);

        if(request.hasRequestErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + request.getRequestInfo().getRequestErrors(), HttpStatus.BAD_REQUEST);
        }

        RequestContext response = dataUpdateDirector.processRequest();

        if(response.hasResponseErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + response.getResponseInfo().getResponseErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String> (response.getCompletionMessage(), HttpStatus.OK);
    }

    @GetMapping(path = "v1.0/update/sport/{sport}/data/{dataType}/year/{year}/week/{week}/overwrite/{overwrite}", produces = APPLICATION_JSON )
    public ResponseEntity<String> updateDataFromYearAndWeek(@PathVariable String sport, @PathVariable String dataType, @PathVariable String year, @PathVariable String week, @PathVariable String overWrite) throws Exception {

        RequestContext request = objectFactory.createRequestContext();    ;
        request.getRequestInfo().setSport(sport);
        request.getRequestInfo().setDataType(dataType);
        request.getRequestInfo().setYear(year);
        request.getRequestInfo().setWeek(week);
        request.getRequestInfo().setOverWrite(overWrite);

        dataUpdateRequestValidator.validate(request);

        if(request.hasRequestErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + request.getRequestInfo().getRequestErrors(), HttpStatus.BAD_REQUEST);
        }

        //this might get changed to a transmittor that will use a factory to figure out the http call to the service versus getting the service right now
        DataUpdateDirector dataUpdateDirector = directorFactory.returnDataUpdateDirector(request);
        RequestContext response = dataUpdateDirector.processRequest();

        if(response.hasResponseErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + response.getResponseInfo().getResponseErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String> (response.getCompletionMessage(), HttpStatus.OK);
    }

    @GetMapping(path = "v1.0/update/sport/{sport}/data/{dataType}/date/{date}/overwrite/{overwrite}", produces = APPLICATION_JSON )
    public ResponseEntity<String> updateDataFromDate(@PathVariable String sport, @PathVariable String dataType, @PathVariable String date, @PathVariable String overWrite) throws Exception {

        RequestContext request = objectFactory.createRequestContext();    ;
        request.getRequestInfo().setSport(sport);
        request.getRequestInfo().setDataType(dataType);
        request.getRequestInfo().setDate(date);
        request.getRequestInfo().setOverWrite(overWrite);

        dataUpdateRequestValidator.validate(request);

        if(request.hasRequestErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + request.getRequestInfo().getRequestErrors(), HttpStatus.BAD_REQUEST);
        }

        //this might get changed to a transmittor that will use a factory to figure out the http call to the service versus getting the service right now
        DataUpdateDirector dataUpdateDirector = directorFactory.returnDataUpdateDirector(request);
        RequestContext response = dataUpdateDirector.processRequest();

        if(response.hasResponseErrors()){
            return new ResponseEntity<String>("There were errors within the request - " + response.getResponseInfo().getResponseErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String> (response.getCompletionMessage(), HttpStatus.OK);
    }

}

