package com.employee_api.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee_api.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Employee extends TestBase {

	@BeforeClass
	void getemployee() throws InterruptedException
	{
		logger.info("Starting TestCase 002");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";
		httprequest=RestAssured.given();
		
		response=httprequest.request(Method.GET,"/"+empId);
		
		System.out.println(" response body" + response.getBody().asString());
		
		Thread.sleep(3000);
	}
	
	
	@Test
	void checkEmployeeIdinResponse()
	{
		String responsebody=response.getBody().asString();
	Assert.assertTrue(responsebody.contains(empId));
    }
	@Test
	void checkStatusCode()
	{
		logger.info("Checking status code");
		System.out.println("Check stats code" + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
    @Test
	void checkStatusLine()
	{
	logger.info("Checking Status line");
	String statusline=response.getStatusLine();
	
	System.out.println("Status line is"+ statusline);
	Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
	
	}
	
	@Test
	void checkResponseTime()
	{
	logger.info("Checking response time");
	
	long responsetime=response.getTime();
	System.out.println("response time is"+ responsetime);
	
	if(responsetime>2000)
	      logger.warn("Response time is greater than 2000");
	
	
	Assert.assertTrue(responsetime<10000);
	}
	
	
	@Test
	void contentType()
	{
	
	logger.info("Checking Content Type");
	String contentype=response.header("Content-Type");

	System.out.println("Content Type is"+ contentype);
	Assert.assertEquals(contentype,"application/json");
    }
	
	@Test
	void checkServerType()
	{
		logger.info("Checking server type");
		String server=response.getHeader("server");
		System.out.println("Server Type is"+ server);

		Assert.assertEquals(server,"cloudflare");
	}
	
	@Test
	void checkContentEncoding()
	{
		logger.info("Checking content encoding");
		
		String contentencoding=response.header("Content-Encoding");
		
		System.out.println("Content encoding is"+ contentencoding );
		Assert.assertEquals(contentencoding,"gzip");
	}
	
	@Test
	void checkContentLength()
	{
		logger.info("Checking content length");
		String contentlength=response.header("Content-Length");
		int contentlen=Integer.parseInt(contentlength);
		System.out.println("Content-length is"+ contentlen );
		if(contentlen<100)
			logger.warn("content len is less than 100");
		Assert.assertTrue(contentlen>100);
	}
	
	
	  @AfterClass
	  void teardown()
	  {
		  logger.info("Test Cases finished");
	  }

	
	
}