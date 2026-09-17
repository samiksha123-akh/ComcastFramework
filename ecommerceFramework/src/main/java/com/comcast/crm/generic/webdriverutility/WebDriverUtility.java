package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
public void waitForPageToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void waitForElementPresent(WebDriver driver,WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void switchNewBrowsertab(WebDriver driver)
{
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	  while(it.hasNext())
	  {
		  String windowID=it.next();
		  driver.switchTo().window(windowID);
		  String  actUrl=driver.getCurrentUrl();
		  if(actUrl.contains("module=Accounts"))
		  {
			  break;
		  }
	  }
	  
	  // we hv so any methods releated to browser in this webdriver utility class whenever we hv to
	  // work on such type of things we can create object o this class  and call these alkl methods 
//	  like  switch to frame()    Switch to alert()
//	  dropdown methods also we hv to write here only
//	  Action class methods also we hv to write here
}





   }
