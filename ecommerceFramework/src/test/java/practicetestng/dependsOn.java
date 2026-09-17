package practicetestng;

import org.testng.annotations.Test;

public class dependsOn {
	@Test(dependsOnMethods = "test2")
	public void aest1()
	{
		System.out.println("execute test");
	}
	@Test
	public void test2()
	{
		System.out.println("execute test2");
	}


}
