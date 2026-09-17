package revisionOfAllDataDriven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WithPomStaleException {
@FindBy(name="user_name")
WebElement ele1;
	
//@FindBy(name="user_name")
//WebElement ele2;
//
//@FindBy(name="user_name")
//WebElement ele3; 
@Test
public void sampletesst()
{
WebDriver driver=new ChromeDriver();
driver.get("http://49.249.29.4:8888");
WithPomStaleException s=PageFactory.initElements(driver,WithPomStaleException);
s.ele1.sendKeys("admin");
driver.navigate().refresh();
s.ele1.sendKeys("admin");
 
}	
}
