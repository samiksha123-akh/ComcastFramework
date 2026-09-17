package practicetestng;

import org.testng.annotations.Test;

public class Groupsexecution {
    @Test
	public void test2()
	{
		System.out.println("execute test2");
	}
    @Test(groups = "smoke test")
	public void test3()
	{
		System.out.println("execute test3");
	}
    @Test(groups="regretion test")
    public void test4()
	{
		System.out.println("execute test4");
	}
}
