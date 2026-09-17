package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheeetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("/ecommerceFramework/testdata/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheeetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	//getrowCount means kisi particular sheet me kitni row y y btata h 
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1= new FileInputStream("/ecommerceFramework/testdata/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();

		return rowCount;
	}
	public void setDataInExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("/ecommerceFramework/testdata/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		FileOutputStream fos= new FileOutputStream("\"/ecommerceFramework/testdata/testdata.xlsx\"");
		wb.write(fos);
		wb.close();

	}

}// this hs also all complete code........
