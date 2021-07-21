package com.employee_api.Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	
	public static RequestSpecification httprequest;
	public static Response response;
	public String empId="6";  //hard coded- input for get details of single employee(GET Request) and update employee (PUT reequest)
	
	public Logger logger;
	
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("EmployeeRestAPI"); // Added logger
		PropertyConfigurator.configure("log4j.properties"); // added log4j property file
		logger.setLevel(Level.DEBUG);
	}
	
}
