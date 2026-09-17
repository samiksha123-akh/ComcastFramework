package revisionOfAllDataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelDataDriven {
   //how to read data from Propert File.....
public static void main(String[] args) throws IOException, InterruptedException {
	System.out.println("hii i am the starting of fis");
    FileInputStream fis= new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\config.properties//commondata.properties");
	System.out.println("hii i am the end of fis");

    Properties prop= new Properties();
    prop.load(fis);
    String URL=prop.getProperty("url");
    System.out.println(URL);
    String Username=prop.getProperty("username");
    String Password=prop.getProperty("password");
    //getting random number....
    Random ran=new Random();
    int numR=ran.nextInt();
    // how to read data from excel....
    FileInputStream fis1= new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\excelfiles\\testdata.xlsx");
    Workbook wb=WorkbookFactory.create(fis1);
    Sheet sh=wb.getSheet("Organization");
    Row rw=sh.getRow(7);
    String orgname=rw.getCell(2).getStringCellValue()+numR;
    System.out.println(orgname);
    String num=rw.getCell(3).getStringCellValue();
    System.out.println(num);
    WebDriver driver=new ChromeDriver();
    driver.get(URL);
    System.out.println(URL);
    driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(Username);
    driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(Password);
   Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
    driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
    driver.findElement(By.name("accountname")).sendKeys(orgname);
    driver.findElement(By.id("phone")).sendKeys(num);
    driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();  
   }	
}


	

