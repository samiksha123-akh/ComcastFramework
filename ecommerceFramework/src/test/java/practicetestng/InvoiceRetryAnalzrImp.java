package practicetestng;

import org.testng.annotations.Test;

public class InvoiceRetryAnalzrImp {

	@Test(retryAnalyzer="com.comcast.crm.listenerutility.RetryListenerImp.class")
	public void activeSim()
	{
		System.out.println("execute invoiceretry");
		System.out.println("login");
		System.out.println("step-1");
		System.out.println("step-2");

	}
	//y testcase 5 time execute hoga qki apn retryanalyzer  implement kiy h by using test attribute retryanalyzer 
//	inside test annotation.5 baar isly hoga qki retryanalyzer  jo utility package me bnay h class usme condtn
//	likhe h or us class ko yah implement kiy isly y utna baar execute hoga.jb test method fail hpta h tbhi y retryanalyzer work
//	work krta h nhi to nhi krta h 
	
}
