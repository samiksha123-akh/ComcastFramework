package SelftestngPractice;

import java.time.LocalDate;
import java.util.Random;

public class javautility {
	public int getRandomNumber() {
   Random ran=new Random();
   int num=ran.nextInt(100);
   return num;
	}
   public String getCurrentDate() {
     LocalDate date=LocalDate.now();
	 return date.toString();
   }
   public String getPreviousDate() {
	     LocalDate date=LocalDate.now();
         LocalDate previousDate=date.plusDays(30);
		 return  previousDate.toString();
   }
}
