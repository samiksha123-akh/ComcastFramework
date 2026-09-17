package com.comcast.crm.baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	@BeforeMethod
	  public void BM()
	  {
		  System.out.println("hii i am before method+ login to application");
	  }
	  @AfterMethod
	  public void AM()
	  {
		  System.out.println("hii i am After method + logout to application");
	  }

	  @BeforeClass
	  public void Bc()
	  {
		  System.out.println("hii i am before class + open the browser");
	  }
	  @AfterClass
	  public void Ac()
	  {
		  System.out.println("hii i am After class + close the browser");
	  }
	  @BeforeSuite
	  public void BS()
	  {
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
		  
		  System.out.println("hii i am before suite + connect to db");
	  }
	  @AfterSuite
	  public void AS()
	  {

		  System.out.println("hii i am After suite + close the db");
	  }

	}

