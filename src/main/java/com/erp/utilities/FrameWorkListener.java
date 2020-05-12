package com.erp.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.erp.newproject.BaseClass;

public class FrameWorkListener extends TestListenerAdapter
{
//step1 create reference variable
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext rv)
	{
	//step 2 define report name
	String date=new SimpleDateFormat("ddMMyyyy-hhmmss").format(new Date());
	String reportName="Test-Report"+date+".html";
	//step 3 define report location-----we should object of ExtenHtmlReporter,inside the object
	//we should define the location
	reporter=new ExtentHtmlReporter("C:/Users/DELL/eclipse-workspace/Selenium/test-output"+reportName);
	//step 4 define the report title
	reporter.config().setDocumentTitle("DemoTitle");
	//step 5 define the report name
	reporter.config().setReportName("Build 1 result");
	//step 6 set the theme
	reporter.config().setTheme(Theme.DARK);
	//step 7 give the report access to ExtentReports class
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	//step 8 enter user details inside the report
	extent.setSystemInfo("QA","Vanitha");
	extent.setSystemInfo("Browser","Chrome 58");
	extent.setSystemInfo("OS","Win7");	
	}
	public void onFinish(ITestContext rv)
	{
		//step 14 save the changes
		extent.flush();
	}
	public void onTestStart(ITestContext rv)
	{
		//step 9 enter the test method name inside the report
		test=extent.createTest(rv.getName());
	}
	public void onTestSucess(ITestContext rv)
	{
	//step 10 if method is pass enter the status and message inside the report
		test.log(Status.PASS,MarkupHelper.createLabel("Sucessfully Executed",ExtentColor.GREEN));
	}
	public void onTestFailure(ITestContext rv)
	{
		//step 11 if method is fail enter the status and message inside the report
				test.log(Status.FAIL,MarkupHelper.createLabel("Method Failed",ExtentColor.RED));
		//step 12 take the SS,attach the SS inside the report
				EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.driver);
				File f1=efwd.getScreenshotAs(OutputType.FILE);
				String date=new SimpleDateFormat("ddMMyyyy-hhmmss").format(new Date());
				String path="C:/Users/DELL/eclipse-workspace/Mavenproject/ScreenShots"+date+".jpg";
				File f2=new File(path);
				try {
					FileUtils.copyFile(f1,f2);
					test.addScreenCaptureFromPath(path);
				}catch(IOException e) {
					e.printStackTrace();
				}
	}
	public void onTestSkipped(ITestContext rv)
	{
		//step 13 if method skips add the status and message inside the report
		test.log(Status.SKIP,MarkupHelper.createLabel("Method is skipped",ExtentColor.ORANGE));
	}
	
}