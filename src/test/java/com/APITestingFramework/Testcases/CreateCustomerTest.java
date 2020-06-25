package com.APITestingFramework.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.APITestingFramework.Setup.BaseTest;
import com.APITestingFramework.utility.DataUtil;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateCustomerTest extends BaseTest {
	
	
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerWithValidSecretKey(String name,String email,String description)
	{
		
		Response response=given().auth().basic(pr.getProperty("validSecretkey"),"")
				.formParam("email",email).formParam("description",description).formParam("name", name)
		        .post(pr.getProperty("customerAPIEndPoint"));
		
		
		response.prettyPrint();
		System.out.println(response.statusCode());
	}

	
	
	
}
