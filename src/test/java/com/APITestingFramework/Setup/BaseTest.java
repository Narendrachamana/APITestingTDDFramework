package com.APITestingFramework.Setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.APITestingFramework.utility.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {

	
	public Properties pr=new Properties();
	private FileInputStream fis;
	public static ExcelReader excel=new ExcelReader(".\\src\\test\\resource\\excel\\testData.xlsx");
	
	@BeforeSuite
	public void setUp() 
	{
		try {
			fis=new FileInputStream(".\\src\\test\\resource\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pr.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		RestAssured.baseURI=pr.getProperty("baseURI");
		RestAssured.basePath=pr.getProperty("basePath");
		
	}
	@AfterSuite
	public void tearDown()
	{
		
		
	}
	
}
