package com.charliehustle.directors;

import java.io.File;

import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.charliehustle.factories.BasicObjectFactory;
import com.charliehustle.factories.MicrosoftObjectFactory;
import com.charliehustle.services.BaseballPlayerDataRetrievalService;
import com.charliehustle.services.BaseballPlayerDataUpdateService;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;

public class BaseballDataUpdateDirectorTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    BasicObjectFactory basicObjectFactory;

    @Mock
    MicrosoftObjectFactory microsoftObjectFactory;

    @Mock
    BaseballPlayerDataRetrievalService baseballPlayerDataRetrievalService;

    @Mock
    BaseballPlayerDataUpdateService baseballPlayerDataUpdateService;

    @Mock
    File file;

    @Mock
    Database db;

    @Mock
    Table table;

    @InjectMocks
    public BaseballDataUpdateDirector baseballDataUpdateDirector = new BaseballDataUpdateDirector();

//    @Test
//    public void testUpdateBaseballData_happyPath() throws IOException, UnirestException {
//        String fileName = "C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\New Baseball Rankings.accdb";
//        Mockito.when(basicObjectFactory.createDatabaseRowMap()).thenReturn(new HashMap<>());
//        Mockito.when(basicObjectFactory.createFile(fileName)).thenReturn(file);
//        Mockito.when(microsoftObjectFactory.createAccessDatabaseObject(file)).thenReturn(db);
//        Mockito.when(db.getTable("Rosters")).thenReturn(table);
//        doNothing().when(baseballPlayerDataUpdateService).setupRosterMaps(Mockito.any(Table.class), Mockito.anyMap(), Mockito.anyMap());
//        Mockito.when(baseballPlayerDataRetrievalService.getRosterResourceBaseballPlayerData()).thenReturn(new ArrayList<BaseballPlayer>());
//        doNothing().when(baseballPlayerDataUpdateService).addFanGraphsData(Mockito.any(Table.class), Mockito.anyMap(), Mockito.anyList());
//        Mockito.when(baseballPlayerDataUpdateService.addCbsData(Mockito.any(Table.class), Mockito.anyMap(), Mockito.anyMap(), Mockito.anyString())).thenReturn("no players");
//
//        String players = baseballDataUpdateDirector.updateBaseballData("fileName");
//        assertEquals("no players", players);
//    }

}

