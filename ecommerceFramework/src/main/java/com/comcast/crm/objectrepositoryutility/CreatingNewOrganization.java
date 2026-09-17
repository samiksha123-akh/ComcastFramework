package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganization {
		WebDriver driver;
		public  CreatingNewOrganization(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	  @FindBy(name="accountname")
	  private WebElement orgNameEdit;
	  
	  @FindBy(xpath="//input[@title='Save [Alt+S]']")
	  private WebElement savebtn;
	  
	  @FindBy(name="industry")
	  private WebElement industryDB;
	  
	  public WebElement getOrgNameEdit() {
		  return orgNameEdit;
	  }

	  public WebElement getIndustryDB() {
		return industryDB;
	}

	  public WebElement getSavebtn() {
		  return savebtn;
	  }
	  public void createOrg(String orgName)
	  {
		  orgNameEdit.sendKeys(orgName);
		  savebtn.click();
	  }
	  public void createOrg(String orgName,String industry)
	  {
		 orgNameEdit.sendKeys(orgName);
		 Select sel=new Select(industryDB);
		 sel.selectByVisibleText(industry);
		 savebtn.click();
	  }



}


