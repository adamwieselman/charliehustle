package com.charliehustle.factories;

import com.healthmarketscience.jackcess.Database;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MicrosoftObjectFactoryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    public MicrosoftObjectFactory microsoftObjectFactory = new MicrosoftObjectFactory();

    @Test
    public void testCreateAccessDatabaseObject() throws IOException {
        BasicObjectFactory basicObjectFactory = new BasicObjectFactory();
        microsoftObjectFactory.basicObjectFactory = basicObjectFactory;
        File file = basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Baseball\\New Baseball Rankings.accdb");
        assertTrue(microsoftObjectFactory.createAccessDatabaseObject(file) instanceof Database);
    }

    @Test
    public void testCreateXSSFWorkbook() throws IOException {
        BasicObjectFactory basicObjectFactory = new BasicObjectFactory();
        microsoftObjectFactory.basicObjectFactory = basicObjectFactory;
        File file = basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Football.xlsx");
        try(FileInputStream fis = new FileInputStream(file)) {
            assertTrue(microsoftObjectFactory.createXSSFWorkbook(fis) instanceof XSSFWorkbook);
        }
    }

    @Test
    public void testCreateXSSFSheet() throws IOException {
        BasicObjectFactory basicObjectFactory = new BasicObjectFactory();
        microsoftObjectFactory.basicObjectFactory = basicObjectFactory;
        File file = basicObjectFactory.createFile("C:\\Users\\Owner\\OneDrive\\Documents\\Football.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = microsoftObjectFactory.createXSSFWorkbook(fis);
        assertTrue(microsoftObjectFactory.createXSSFSheet(workbook, 1) instanceof XSSFSheet);
        fis.close();
    }
}


