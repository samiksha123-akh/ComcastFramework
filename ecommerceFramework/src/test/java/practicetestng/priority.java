package practicetestng;

import org.testng.annotations.Test;

public class priority {
@Test(priority=1)
public void CreateContactTest()
{
	System.out.println("i am from createcontact");
}
@Test
public void modifyContactTest()
{
	System.out.println("i am from modifyContactTest");
}@Test(priority=0)
public void DeleteteContactTest()
{
	System.out.println("i am from DeleteteContactTest");
}


}
