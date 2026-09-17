package propertyFileDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrgTest {
//public static void main(String[] args) throws InterruptedException, IOException {
//	// step 1:get the java representation object of physical file
//			FileInputStream fis=new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\commondata.properties");
//			
//			//step 2: using properties class and load all the key
//			Properties prop= new Properties();
//			prop.load(fis);
//			
//			// step 3: get the value based on key
//			String browser=prop.getProperty("Browser");
//			String url=prop.getProperty("URL");
//			String username=prop.getProperty("username");
//			String password=prop.getProperty("password");
//			System.out.println(browser);
//			System.out.println(url);
//			System.out.println(username);
//			System.out.println(password);
	@Test
	public void createOrgtest()throws Throwable {
	String URL=System.getProperty("url");

	String Browser=System.getProperty("browser");
	String Username=System.getProperty("username");
	String Password=System.getProperty("password");

	System.out.println("browser="+Browser);
	System.out.println("username="+Username);
	System.out.println("password="+Password);

		     WebDriver driver=null; 

			if(Browser.equals("chrome")) {
				 driver=new ChromeDriver();
			System.out.println(Browser);
			}
			else if(Browser.equals("Firefox"))
			{
				driver=new FirefoxDriver();

				System.out.println(Browser);
			}
			else if(Browser.equals("edge"))
			{
				driver=new EdgeDriver();

				System.out.println(Browser);
			}
			
			
		     driver.get(URL);
			 driver.findElement(By.name("user_name")).sendKeys(Username);
			 Thread.sleep(2000);
			 driver.findElement(By.name("user_password")).sendKeys(Password);
			 Thread.sleep(2000);
			 driver.findElement(By.id("submitButton")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.linkText("Organizations")).click();
			 Thread.sleep(2000);
			 driver.quit();
			 
}
}
