package practicetestng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAndAfterMethod {
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

}
