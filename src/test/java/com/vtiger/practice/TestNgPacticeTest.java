package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgPacticeTest extends TestNgBasicConfigAnnotionPracticeTest{
	@Test
	public static void practiceTest()
	{
		Reporter.log("hi",true);
	}

	@Test
	public static void practiceTest1()
	{
		Reporter.log("bye",true);
	}
	
	@Test
	public static void practiceTest2()
	{
		Reporter.log("gudbye");
	}
}
