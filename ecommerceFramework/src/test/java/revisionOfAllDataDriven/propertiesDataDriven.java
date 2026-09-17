package revisionOfAllDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class propertiesDataDriven {
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Browser=prop.getProperty("browser");
		String Url=prop.getProperty("url");
		
	    WebDriver driver=null;
		if((Browser).equals("Chrome"))
          {
		     driver=new ChromeDriver();
		     System.out.println("hii am chrome driver");
		  }
		else if((Browser).equals("Edge"))
         {
		     driver=new EdgeDriver();
		     System.out.println("hii i am edge driver");
		     
		  }
		
	    driver.get(Url);
//	    driver.findElement("");
		
		
	}

}
