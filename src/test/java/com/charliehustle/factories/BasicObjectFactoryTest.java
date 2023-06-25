package com.charliehustle.factories;

import com.charliehustle.mappers.JsonMapper;
import com.charliehustle.models.*;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class BasicObjectFactoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public BasicObjectFactory basicObjectFactory = new BasicObjectFactory();

    @Test
    public void testCreateJsonMapper() {
        assertTrue(basicObjectFactory.createJsonMapper() instanceof JsonMapper);
    }

    @Test
    public void testCreateBaseballPlayerList(){
        assertTrue(basicObjectFactory.createBaseballPlayerList() instanceof List);
    }

    @Test
    public void testCreateFile(){
        assertTrue(basicObjectFactory.createFile("blah") instanceof File);
    }

    @Test
    public void testCreateDatabaseRowMap(){
        assertTrue(basicObjectFactory.createDatabaseRowMap() instanceof Map);
    }

    @Test
    public void testCreateKeyValueMap(){
        assertTrue(basicObjectFactory.createKeyValueMap() instanceof Map);
    }

    @Test
    public void testCreateKeyObjectMap(){assertTrue(basicObjectFactory.createKeyObjectMap() instanceof Map);}

    @Test
    public void testCreateGameDataInfo() {assertTrue(basicObjectFactory.createGameDataInfo() instanceof GameData);}

    @Test
    public void testCreateVenue() {assertTrue(basicObjectFactory.createVenue() instanceof Venue);}

    @Test
    public void testCreateTeam() {assertTrue(basicObjectFactory.createTeam() instanceof Team);}

    @Test
    public void testCreateConference() {assertTrue(basicObjectFactory.createConference() instanceof Conference);}

    @Test
    public void testCreateGameStatus() {assertTrue(basicObjectFactory.createCurrentGameStatus() instanceof CurrentGameStatus);}

    @Test
    public void testCreateGameDataInfoTeam() {assertTrue(basicObjectFactory.createGameDataInfoTeam() instanceof GameDataTeam);}

    @Test
    public void testCreateTeamVenue() {assertTrue(basicObjectFactory.createTeamVenue() instanceof TeamVenue);}

    @Test
    public void testCreateConferenceTeam() {assertTrue(basicObjectFactory.createConferenceTeam() instanceof ConferenceTeam);}

    @Test
    public void testCreateFileInputStream() throws FileNotFoundException {
        File file = basicObjectFactory.createFile("C:\\Users\\Owner\\Downloads\\football.xlsx");
        try(FileInputStream fis = basicObjectFactory.createFileInputStream(file)){
            assertTrue(fis instanceof FileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

