package com.charliehustle.services;


import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccessServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Table rosterTable;

    @Mock
    Row row;

    @Mock
    Map map;

    @InjectMocks
    public AccessDatabaseService accessDatabaseService = new AccessDatabaseService();

    @Test
    public void testupdateRow() throws IOException {
        Map<String, String> columnValues = new HashMap<>();
        columnValues.put("column", "value");

        Mockito.when(row.put("column", "value")).thenReturn("stuff");
        Mockito.when(rosterTable.updateRow(row)).thenReturn(row);
        accessDatabaseService.updateRow(rosterTable, row, columnValues);
    }

    @Test
    public void testAddRow() throws UnirestException, IOException {
        Mockito.when(map.get(Mockito.anyString())).thenReturn("value");
        Mockito.when(rosterTable.addRow("value", "value", "value", "value", "value", "ZZ",null, null, null, "value", "value", "value", null, "value", "value")).thenReturn(new Object[1]);
        accessDatabaseService.addRowFantasyBaseball(rosterTable, map);
    }
}