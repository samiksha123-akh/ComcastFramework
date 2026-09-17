package revisionOfAllDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WithoutpomStaleexceptionCheck {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("http://49.249.29.4:8888");
	WebElement ele1=driver.findElement(By.xpath("//input[@name=\"user_name\"]"));
	System.out.println(ele1);
	driver.navigate().refresh();
	WebElement ele2=driver.findElement(By.xpath("//input[@name=\"user_name\"]"));

	ele2.sendKeys("admin");
	System.out.println(ele2);

}
}
