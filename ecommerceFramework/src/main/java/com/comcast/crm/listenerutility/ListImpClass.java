package com.comcast.crm.listenerutility;

import java.sql.Date;

import org.openqa.selenium.OutputType;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImpClass implements ITestListener,ISuiteListener {
	 public ExtentReports spark;
	 public ExtentReports report;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// settings for spark config....
	  	
  		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
  		spark.config().setDocumentTitle("CSM Test Suite Result");
  		spark.config().setReportName("CSM Report");
  		spark.config().setTheme(Theme.DARK);
  		
  		// add env information & create test...
  		
  		report=new ExtentReports();
  		report.attachReporter(spark);
  		report.setSystemInfo("os", "Windows-10");
  		report.setSystemInfo("BROWSER","CHROME-100");	
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("report backup");
		ISuiteListener.super.onFinish(suite);
	    report.flush();

	}
	public void onTestFailure(ITestResult result)
	{
		String testname=result.getMethod().getMethodName();
		//TakeScreeshot ts=(TakeScreeshot)BaseClass.sdriver;
		TakeScreeshot ts=(TakeScreeshot)UtilityClassObject.getDriver();
		
		String src=ts.getTakeScreeshotAs(OutputType.BASE64);
		String Time=new Date().toString().replace(" ", "-").replace(":", "-");
		test.addScreenCaptureFromBase64String(src,testname+"-"+time);
		Test.log(Status.FAIL,result.getMethod().getMethodName()+"==>fail");
		
	}

	}
	// only half i hv done i will complete it while revision




