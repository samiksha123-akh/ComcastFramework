package testcasesAll6;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\prave\\OneDrive\\Desktop\\commonData.properties");
		Properties proObject=new Properties();
		proObject.load(fis);
		
		String browser=proObject.getProperty("Browser");
		String url=proObject.getProperty("URL");
		String username=proObject.getProperty("username");
		String password=proObject.getProperty("password");
		
		//generate random number
		Random random=new Random();
		int randomInt=random.nextInt();
		
		//Read data from excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\prave\\OneDrive\\Desktop\\ExcelFiles\\Readdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Readdata");
		Row row=sh.getRow(10);
		String orgName=row.getCell(2).toString()+randomInt;
		wb.close();
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		  //STEP 1: Login to App
           Login login= new Login(driver);
           login.LoginToapp(username, password);
		
		  //STEP 2: Navigate to Organizations Module
           Home op=new Home(driver);
           op.getOrgLink().click();
		  //STEP 3: click on "create organization" button
           OrganizationsPage orgp=new OrganizationsPage(driver);
           orgp.getCreateNewOrgBtn().click();
		  
		  // STEp 4: enter all the details & Create new Organization
           CreatingNewOrganization cnop=new CreatingNewOrganization(driver);
           cnop.createOrg(orgName);
		 
		  // STEP 5: Verify the heading
           OrganizationInfoPage oip=new OrganizationInfoPage(driver);
           String actOrgName=oip.getHeaderMsg().getText();
          if( actOrgName.contains(orgName))
          {
      	  System.out.println("pass");
      	  }
          else
          { 
         	 System.out.println("test is got failed");
          }
		   //go back to organization page
		   Home.getOrgLink().click();
		    
		   
		   //Search for organization
		   orgPage.getSearchText().sendKeys(orgName);
		   WebElement org=orgPage.getSearchField();
		   Select select =new Select(org);
		   select.selectByVisibleText("Organization Name");
		   orgPage.getSearch().click();
		   
		   
		   driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		   
		   //Handling Alert
		   Alert alert=driver.switchTo().alert();
		   alert.accept();
		   
		  //STEP 6: Logout
//		  homePage.logout();
	}

	
		
	}


