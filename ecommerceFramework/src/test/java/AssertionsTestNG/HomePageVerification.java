package AssertionsTestNG;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageVerification {

  @Test
  public void homepageTest()
  {
	  String expecytedPage="Home";
  
	WebDriver driver=new ChromeDriver()   ;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.get("http://49.249.29.4:8888");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.name("submitButton")).click();

	String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	if(actTitle.trim().equals(expecytedPage))
	{
		System.out.println("yes both are same and test cases passed and verified");
	}
	else
	{
		System.out.println("testcases got failed");
	}
	//half i hv done while revision i hv to complete it
  }	
}
