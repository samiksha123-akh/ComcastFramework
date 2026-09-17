package practicetestng;

import org.testng.annotations.Test;

public class invocationCount {
	@Test(invocationCount = 7)
	public void test1()
	{
		System.out.println("execute test");
	}
	@Test
	public void test2()
	{
		System.out.println("execute test2");
	}

}
