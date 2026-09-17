package practicetestng;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	// here code whatever we hv written for extent report that code we hv to write inside listener in utility package
//	in onstart method   
	 public ExtentReports report;
@BeforeSuite  //this code we hv to write inside base class not in test script
public void configBS()
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
}
@AfterSuite   // this also we hv to write inside listener class in  onfinish method not in out test script
public void  configAS()
{
	    report.flush();

}
	
@Test
public void createContactTest()
{
	// how to add screenshot to extent report.... this screenshot code we dont hv to write inside our testscript
//	we hv to write inside our listener class in on faiilure method
	WebDriver driver= new ChromeDriver();
	driver.get("http://49.249.29.4:8888");
	TakesScreenshot ts=(TakesScreenshot)driver;
	String Source=ts.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test=report.createTest("createContactTest");
	
	
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO,"navigate to contact page");
	test.log(Status.INFO,"create contact");
	if("HsFC".equals("HDFC"))
	{
		test.log(Status.PASS,"contact is created and test cases pass");
	}
	else
	{
//		test.log(Status.FAIL,"contact is not created and test cases fail");
		test.addScreenCaptureFromBase64String(Source,"ErrorFile");
	}
}
	//for saving the report we hv to us ethis flush if we dont use it will not save the report
	
	  @Test
	  public void createContactWithOrg()
	  {
	  	
	  	ExtentTest test=report.createTest("createContactWithOrg");
	  	
	  	
	  	test.log(Status.INFO, "login to app");
	  	test.log(Status.INFO,"navigate to contact page");
	  	test.log(Status.INFO,"create contact");
	  	if("HDFC1".equals("HDFC1"))
	  	{
	  		test.log(Status.PASS,"contactWithOrg is created and test cases pass");
	  	}
	  	else
	  	{
	  		test.log(Status.FAIL,"contactWithOrg is not created and test cases fail");
	  	}
      }	
  }
