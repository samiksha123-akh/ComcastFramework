package practicetestng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class TestForScreenShot {
	@Test
	public void  screenShot() throws IOException
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://49.249.29.4:8888");
// createan object of eventFiring webdriver..
//		EventFiringWebDriver sc=new EventFiringWebDriver(driver);..this is removed but sir has ussed it 
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\selenium\\screenshot.png");
		FileUtils.copyFile(Source, des);
		System.out.println("yes done");
		// this task i have done completely but not by sir code my own codee
	}

}
