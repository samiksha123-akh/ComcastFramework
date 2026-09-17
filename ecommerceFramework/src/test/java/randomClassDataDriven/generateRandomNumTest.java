package randomClassDataDriven;

import java.util.Random;

public class generateRandomNumTest {
  public static void main(String[] args) {
	Random randnum=new Random();
	
	  int num= randnum.nextInt();
	  System.out.println(num);
	  
	  int num1= randnum.nextInt(100);
	  System.out.println(num1);

}
}
