package propertyFileDataDriven;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class dataDrivenPropertiesfile {
	
	public static void main(String[] args) throws IOException {
		// step 1:get the java representation object of physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\Akhilesh Kumar Singh\\Desktop\\commondata.properties");
		
		//step 2: using properties class and load all the key
		Properties prop= new Properties();
		prop.load(fis);
		
		// step 3: get the value based on key
		System.out.println(prop.getProperty("Browser"));
		System.out.println(prop.getProperty("URL"));

	   
	 }

}
