package com.SDET34L1.genericUtility;

import java.util.Random;

public class MainJavaUtility {
	/**
	 * This method is used to convert string value to long datatype.
	 * 
	 * 
	 */

	public long stringToLong(String timeout) {
		return Long.parseLong(timeout);
	}

	/**
	 * This method is used to get the random number.
	 */

	public int getRandomNumber(int limit) {
		Random ran=new Random();
		return ran.nextInt(limit);
	}

	/**
	 * This method is used to print the statement.
	 * @param message
	 */

	public static void printTheStatement(String message) 
	{
		System.out.println(message);

	}


	/** this method is used to validate the data by using if condition.
	 * 
	 * @param actualResult
	 * @param expectedResult
	 * @param testCaseName
	 */


	public  void ifConditionForValidation(String actualResult, String expectedResult, String testCaseName) {
		if(actualResult.equalsIgnoreCase(expectedResult))
		{
			System.out.println(testCaseName+"Created Successfully");	
			System.out.println("Tc Pass");
		}
		
		
	}
	




}
