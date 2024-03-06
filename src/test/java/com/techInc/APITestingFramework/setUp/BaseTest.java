package com.techInc.APITestingFramework.setUp;

import com.techInc.APITestingFramework.utilities.ExcelReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.*;

public class BaseTest {

    public static Properties config = new Properties();
    private FileInputStream fis;
    public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");

    @BeforeSuite
    public void setUp() {
        try {
            fis = new FileInputStream("./src/test/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        baseURI = config.getProperty("baseURI");
        basePath = config.getProperty("basePath");
    }

    @AfterSuite
    public void tearDown(){

    }
}
