package testcasesAll6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgaanizationWithIndustriesTest {
	public static void main(String[] args) throws InterruptedException, IOException {
		
	//getting data from config.proprties....(notepad)
			FileInputStream fis=new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\config.properties\\commondata.Properties");
			Properties prop=new Properties();
			prop.load(fis);
			String Browser=prop.getProperty("browser");
			String URL=prop.getProperty("url");
			String Username=prop.getProperty("username");
			String Password=prop.getProperty("password");
	        System.out.println(Browser);
	        System.out.println(URL);
	        System.out.println(Username);
	     // random number
	        Random rannum=new Random();
	        int num=rannum.nextInt(50);
	     // accessing test data from excel...
			FileInputStream fis1=new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\excelfiles\\testdata.xlsx");
	        Workbook wb=WorkbookFactory.create(fis1);
	        Sheet sh=wb.getSheet("Organization");
	        Row rw=sh.getRow(4);
	        String orgname=rw.getCell(2).getStringCellValue()+num;
	        String industry=rw.getCell(3).getStringCellValue();
	        String type=rw.getCell(4).getStringCellValue();

	        System.out.println(orgname+"i am orgname");
	        System.out.println(industry+"i am orgname");
	        System.out.println(type+"i am orgname");

	//launch the browser...
	         WebDriver driver=null;
	         if(Browser.equals("Chrome"))
	         {
	        	 driver= new ChromeDriver();
	         }
	         else if(Browser.equals("edge"))
	         {
	        	 driver= new EdgeDriver();
	         }
	//navigate the url.....
	         driver.get(URL);
	         driver.manage().window().maximize();
	         
	//now write here all steps to test the application(actual all test steps are here we hv to write)
	//1. login to application with data which is given by config.properties
	         driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
	         driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
	         Thread.sleep(2500);
	         driver.findElement(By.id("submitButton")).click();
	         Thread.sleep(2500);
	// 2.navigate to the organization.....
	         driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
	         Thread.sleep(2500);
	//3.click on "+" image
	         driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	// 4.create organization with mandatory fields...
	         driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);
	         Thread.sleep(2500);

//	         i am selecting frst dropdown by taking value from excel
	         Select drop1= new Select(driver.findElement(By.xpath("//select[@name=\"industry\"]")));
	         drop1.selectByVisibleText(industry);
	         
//           i am selecting second dropdown by taking cvalue from excel
	         Select drop2= new Select(driver.findElement(By.name("accounttype")));
	         drop2.selectByVisibleText(type);
	         driver.findElement(By.xpath("//input[@value=\"  Save  \" and @accesskey=\"S\"]")).click();

	       //verify industry and type info which we pass from excel
	          Thread.sleep(2500);

	        String ind1=driver.findElement(By.id("dtlview_Industry")).getText();
	        System.out.println(ind1);
	        if(ind1.equals(industry))
	        {
	        	System.out.println(ind1+"  "+"our testcases pass");
	        }
	        else
	        	System.out.println("our test cases got failed");
	        String type1=driver.findElement(By.id("dtlview_Type")).getText();
	        System.out.println(type1);
	        if(type1.equals(type))
	        {
	        	System.out.println(type1+"  "+"our testcases pass");
	        }
	        else
	        	System.out.println("our test cases got failed");
	//logout
//	      driver.quit();  

	
}	
}
