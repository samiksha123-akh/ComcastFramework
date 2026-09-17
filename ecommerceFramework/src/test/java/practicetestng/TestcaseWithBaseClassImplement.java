package practicetestng;

import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;

public class TestcaseWithBaseClassImplement extends BaseClass{
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
}
