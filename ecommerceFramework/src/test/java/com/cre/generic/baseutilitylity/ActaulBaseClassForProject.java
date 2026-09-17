package com.cre.generic.baseutilitylity;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.Login;

public class ActaulBaseClassForProject {
	
	DataBaseUtility dblib=new DataBaseUtility();
	FileUtility flib=new FileUtility();
	 WebDriver driver=null; 

	@BeforeClass
	public void configBC() throws Throwable
	{
		System.out.println("launch the browser");
		String BROWSER=flib.getDataFromPropertiesFile("browser");

			
				if(Browser.equals("chrome")) {
					 driver=new ChromeDriver();
				System.out.println(BROWSER);
				}
				else if(Browser.equals("Firefox"))
				{
					driver=new FirefoxDriver();

					System.out.println(BROWSER);
				}
			}
	@BeforeMethod
	public void configBM()
	    {
		System.out.println("login");
		String Url=flib.getDataFromPropertiesFile("url");
		String username=flib.getDataFromPropertiesFile("username");
		String password=flib.getDataFromPropertiesFile("password");

		LoginPage lp=new LoginPage();
		lp.loginToapp(Url,username,password);
		}
		@AfterMethod
		public void configAM() {
		System.out.println("logout");
		HomePage hp= new HomePage();
		hp.logout()
		}
		@After
		public void configA()
		{
			System.out.println("close the browser");
			dblib.closeDBconnection();
		}
	}
	
	//this is implementTION OF BASE CLASS IN REAL PROJECTY WHICH  I AM NOT DOING I WILL DO LATER
	


