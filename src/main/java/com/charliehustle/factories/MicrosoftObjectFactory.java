package com.charliehustle.factories;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class MicrosoftObjectFactory {

    @Autowired
    BasicObjectFactory basicObjectFactory;

    public Database createAccessDatabaseObject(File file) throws IOException {
        return DatabaseBuilder.open(file);
    }

    public XSSFWorkbook createXSSFWorkbook(FileInputStream fis) throws IOException {
       return new XSSFWorkbook(fis);
    }

    public XSSFSheet createXSSFSheet(XSSFWorkbook myWorkBook, int i) {
        return myWorkBook.getSheetAt(i);
    }
}

