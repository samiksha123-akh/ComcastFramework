package com.cre.generic.baseutilitylity;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	  public void BS()
	  {
		  System.out.println("hii i am before suite and my work is to connect todatabase");
	  }
	@BeforeClass
	  public void Bc()
	  {
		  System.out.println("hii i am before class i hv to launch the browser");
	  }
	 @BeforeMethod
	  public void BM()
	  {
		  System.out.println("hii i am before method i hv to login to application");
	  }
	 
	 @AfterMethod
	  public void AM()
	  {
		  System.out.println("hii i am After method i hv to logout to application");
	  }
	 
	 @AfterClass
	  public void Ac()
	  {
		  System.out.println("hii i am After class i hv to close the browser");
	  }
	  
	@AfterSuite
	  public void AS()
	  {
		  System.out.println("hii i am After suite and i hve to close db");
	  }	  
}
