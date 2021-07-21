package com.employee_api.Utillities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String empName()
	{
	
	String generatedstring=RandomStringUtils.randomAlphabetic(3);
	
	return("john"+generatedstring);
    }
   
	public static String empSalary()
	{
		String empSalary=RandomStringUtils.randomNumeric(4);
		return (empSalary);
	}
	
	public static String empAge()
	{
		String empage=RandomStringUtils.randomNumeric(2);
		return (empage);
	}
	
	
}
	
