package practicetestng;

import org.testng.annotations.Test; 
import org.testng.annotations.DataProvider; 
public class DataProviderr {
	@Test(dataProvider = "getData")
	public void test1(String firstname,String lastname)
	{
		System.out.println("firstname+lastname"+"  "+firstname+"  "+lastname);
	}
	 @DataProvider
	public Object[][]getData()
	{
		Object [][] obj=new Object[3][2];
		obj[0][0]="deepak";
		obj[0][1]="hr";
		obj[1][0]="sam";
		obj[1][1]="sh";
		obj[2][0]="jhon";
		obj[2][1]="smith";
		return obj;
	}
}
