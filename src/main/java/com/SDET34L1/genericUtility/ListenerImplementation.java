package com.SDET34L1.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;



	@Override
	public void onStart(ITestContext context) {

		System.out.println("==========onStart==========="+Thread.currentThread().getId());
		ExtentSparkReporter spark=new ExtentSparkReporter("./executeReport/extentReport.html");
		spark.config().setDocumentTitle("DocumentsTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReporterName");

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("Report Name", "Santosh Masti");
		report.setSystemInfo("PlatForm", "Windows 10");
		report.setSystemInfo("Unit testing Tool", "TestNT");
		report.setSystemInfo("Build Management Tool", "Maven");
		report.setSystemInfo("Automation Tool", "Selenium");


	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==========onTestStart==========="+Thread.currentThread().getId());
		 test = report.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==========onTestSuccess==========="+Thread.currentThread().getId());
		test.log(Status.PASS, result.getMethod().getMethodName()+"Is Pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("==========onTestFailure==========="+Thread.currentThread().getId());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"Is Failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(result.getMethod().getMethodName(),null); 

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("==========onTestSkipped==========="+Thread.currentThread().getId());
		test.log(Status.SKIP, result.getMethod().getMethodName()+"Is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("==========onTestFailedButWithinSuccessPercentage==========="+Thread.currentThread().getId());

	}



	@Override
	public void onFinish(ITestContext context) {
		System.out.println("==========onFinish==========="+Thread.currentThread().getId());
		report.flush();

	}


}
