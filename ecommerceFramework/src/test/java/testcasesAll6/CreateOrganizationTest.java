package testcasesAll6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;



public class CreateOrganizationTest {
	public static void main(String[] args) throws IOException, InterruptedException {
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
        String orgname=sh.getRow(1).getCell(2).getStringCellValue()+num;
        System.out.println(orgname+"i am orgname");

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
//         driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
//         driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
//         Thread.sleep(2500);
//         driver.findElement(By.id("submitButton")).click();
//         Thread.sleep(2500);
       //using Pom i am login ....
         Login login= new Login(driver);
         login.LoginToapp(Username, Password);
//// 2.navigate to the organization.....
/// using pom i am navigating to organizartion...
          Home op=new Home(driver);
          op.getOrgLink().click();
//         driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=index\"]")).click();
         Thread.sleep(2500);
////3.click on "+" image
/// by using pom
         OrganizationsPage orgp=new OrganizationsPage(driver);
         orgp.getCreateNewOrgBtn().click();
         Thread.sleep(2000);

//         driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//// 4.create organization with mandatory fields....
////         driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(args);
////         Thread.sleep(2500);
/// by using pom
          CreatingNewOrganization cnop=new CreatingNewOrganization(driver);
          cnop.createOrg(orgname);
        		  

// enter mandatory fields...and create Organization
//         driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);
//         Thread.sleep(2500);

//         driver.findElement(By.xpath("//input[@value=\"  Save  \" and @accesskey=\"S\"]")).click();
         
//verify the header msj expected result
//          by pom
          OrganizationInfoPage oip=new OrganizationInfoPage(driver);
          String actOrgName=oip.getHeaderMsg().getText();
         if( actOrgName.contains(orgname))
         {
     	  System.out.println("pass");
     	  }
         else
         { 
        	 System.out.println("test is got failed");
         }

//          String text=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
//          System.out.println(text);
//          if(text.contains(orgname))
//          {
//        	  System.out.println("pass");
//          }
//          else
//          {
//        	  System.out.println("test is got failed");
//          }
 
//verify header orgname info result
          Thread.sleep(2500);

        String text1=driver.findElement(By.id("dtlview_Organization Name")).getText();
        System.out.println(text1);
        if(text1.equals(orgname))
        {
        	System.out.println(text1+"  "+"our testcases pass");
        }
        else
        	System.out.println("our test cases got failed");
//logout
      driver.quit();  
          
	}
	
	
	
}
