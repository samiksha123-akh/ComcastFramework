package practicetestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeClassAndAfterClass {
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

}



