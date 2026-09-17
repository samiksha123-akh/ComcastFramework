package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText ="Organizations")
	private WebElement orgLink;

	@FindBy(name="Contacts")
	private WebElement contactlnk;
	
	public  WebElement getOrgLink()
	{
		System.out.println("kijuu");
	}
		
}
//		return orgLink;


///this code is taken by praveena so file location will be different and 
/// amybe variable name can also be different
 */