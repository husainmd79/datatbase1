package com.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyReports implements ITestListener{
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		String dateStump=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		String repName="myReport"+dateStump+".html";
		
		spark=new ExtentSparkReporter(repName);
		spark.config().setDocumentTitle("Title of the report");
		spark.config().setReportName("Functional");
		spark.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("host", "localhost");
		extent.setSystemInfo("os", "window");
		extent.setSystemInfo("tester", "husain");
		extent.setSystemInfo("browser", "chrome");
		
		}
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
	}
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
	

}



