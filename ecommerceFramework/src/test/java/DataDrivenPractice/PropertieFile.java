package DataDrivenPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertieFile {
	public static void main(String[] args) throws FileNotFoundException {
		WebDriver driver =new ChromeDriver();
		driver.get("http://49.249.29.4:8888");
	    FileInputStream fis=new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\commondata.properties\")");
		Property prop=new Property();
		prop.load(fis);
	}	
}
