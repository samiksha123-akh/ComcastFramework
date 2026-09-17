package commandLineDataDriven;

import org.testng.annotations.Test;

public class readRuntimeMavenParameterTest {
@Test
public void runtimeParameterTest()
    {
	String Browser=System.getProperty("browser");
	String Username=System.getProperty("username");
	String Password=System.getProperty("password");

	System.out.println("browser="+Browser);
	System.out.println("username="+Username);
	System.out.println("password="+Password);


	}


}
