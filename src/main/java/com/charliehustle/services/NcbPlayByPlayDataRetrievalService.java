package com.charliehustle.services;

import com.charliehustle.mappers.JsonMapper;
import com.charliehustle.models.json.nfl.NflPlayByPlay;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NcbPlayByPlayDataRetrievalService {

    @Autowired
    public JsonMapper jsonMapper;

    public NflPlayByPlay getNflPlayByPlay(String fileName) throws Exception {

        String json = readFileAsString(fileName);

        NflPlayByPlay nflPlayByPlay = jsonMapper.deserializeResponse(json, "", NflPlayByPlay.class);

        return nflPlayByPlay;
    }

    public String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
