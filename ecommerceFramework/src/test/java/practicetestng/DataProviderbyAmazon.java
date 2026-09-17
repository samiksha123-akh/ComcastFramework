package practicetestng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
// try to find all elemnt here from amazon bcz i hv copied th epath from sirs code
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProviderbyAmazon {
		@Test
		public void test1(String brandName,String productName) throws InterruptedException
		{
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://amazon.in");
			Thread.sleep(2000);
			//Search product....
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
			 System.out.println("yu passed searching product1");

			 //			//span[contains(text(),'iPhone 16e 128 GB')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span[2]/span[2]
			//capture product info...
			String x="//span[contains(text(),'iPhone 16e 128 GB')]/ancestor::div[@class='puisg-col-inner']//span[@class='a-price-whole']";
			 String price=driver.findElement(By.xpath(x)).getText();
			 System.out.println("yu passed searching product");
		} 
//		this is hardcore data...
//             @DataProvider
//         	public Object[][]getData()
//         	{
//         		Object [][] obj=new Object[3][2];
//         		obj[0][0]="iphone";
//         		obj[0][1]="Apple iphone 12 (128GB) - Black";
//         		obj[1][0]="iphone";
//         		obj[1][1]="Apple iphone 14 (128GB) - Midnight";
//         		obj[2][0]="iphone";
//         		obj[2][1]="Apple iphone 12 (128GB) - Starlight";
//         		return obj;
		//now here we are taking data from excel.....try to learn it .i have confusion here
		@DataProvider
     	public Object[][]getData() throws EncryptedDocumentException, IOException
     	{
			ExcelUtility ei=new ExcelUtility();
			int rowCount=ei.getRowcount("Product");
     		Object [][] obj=new Object[3][2];
     		for (int i = 0; i <rowCount; i++) {
				
     		obj[i][0]=ei.getDataFromExcel("Product", i+1, 0);
     		obj[i][1]=ei.getDataFromExcel("Product", i+1, 1);
     		}
			return obj;
		}
}
