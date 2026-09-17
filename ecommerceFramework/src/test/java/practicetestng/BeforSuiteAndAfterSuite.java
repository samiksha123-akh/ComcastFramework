package practicetestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforSuiteAndAfterSuite {
		@Test
		public void test1()
		{
			System.out.println("execute test1");
		}
		@Test
		public void test2()
		{
			System.out.println("execute test2");
		}
	  @BeforeClass
	  public void Bc()
	  {
		  System.out.println("hii i am before class");
	  }
	  @AfterClass
	  public void Ac()
	  {
		  System.out.println("hii i am After class");
	  }
	  @BeforeMethod
	  public void BM()
	  {
		  System.out.println("hii i am before method");
	  }
	  @AfterMethod
	  public void AM()
	  {
		  System.out.println("hii i am After method");
	  }
	  @BeforeSuite
	  public void BS()
	  {
		  System.out.println("hii i am before suite");
	  }
	  @AfterSuite
	  public void AS()
	  {
		  System.out.println("hii i am After suite");
	  }

	}

