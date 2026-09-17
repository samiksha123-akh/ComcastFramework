package com.comcast.crm.objectrepositoryutility;

import java.security.PrivateKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {    //rule1:..create seperate java class for all pages
	                   //rule 2:..identify all the elements using@findby
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdit;

	@FindBy(name="user_password")
	private WebElement passwordEdit;

	@FindBy(id="submitButton")
	private WebElement loginBtn;    // rule 3:...object initialization

	//rule 4:..Object encapsulation

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
		
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
//rule 5:...provide action methods
	public void LoginToapp(String username,String password)
	{
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
		System.out.println("hii i hv updated in my loginpage which should be for gitHub");
	}
		
}
