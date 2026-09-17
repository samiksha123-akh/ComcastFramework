package com.comcast.crm.generic.webdriverutility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class JavaUtility {
public int getRandomNumber()
  {
	Random random=new Random();
	int randomNumber=random.nextInt(5000);
	return randomNumber;
  }
public String getSystemDateYYYYDDMM()
{
	// this is old java classes which ois used before java8
	Date dateobj=new Date(0);
	SimpleDateFormat sdt=new SimpleDateFormat("YYYY-MM-DD");
	String date = sdt.format(dateobj);
	return date;
}
public String getRequiredDateYYYYDDMM(int days) {
	SimpleDateFormat sim= new SimpleDateFormat("YYYY-MM-DD");
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqdate=sim.format(cal.getTime());
	return reqdate;
}
}
// this is a java class which is introduce after java 8......
//public String getCurrentDate() {
//    LocalDate date=LocalDate.now();
//	 return date.toString();
//  }

//public String getPreviousDate() {
//    LocalDate date=LocalDate.now();
//    LocalDate previousDate=date.plusDays(30);
//	 return  previousDate.toString();


//use this method by creating object of thid class in testscript class and call this method and use them