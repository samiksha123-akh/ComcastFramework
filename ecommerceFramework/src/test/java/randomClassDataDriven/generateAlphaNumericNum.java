package randomClassDataDriven;

import java.util.Random;

public class generateAlphaNumericNum {
public static void main(String[] args) {
	Random randnum=new Random();
	int num=8;
	String s="abcdefghijklmnopqrstuvwxyz0123456789";
	StringBuilder data= new StringBuilder();
	for (int i = 0; i < num; i++) 
	{
		int index=randnum.nextInt(s.length());
		 data=data.append(s.charAt(index));
	}
	String f=data.toString();
	System.out.println(f);
	
     }
 }
