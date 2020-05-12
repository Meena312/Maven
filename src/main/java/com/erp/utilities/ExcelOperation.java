package com.erp.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperation 
{
	public static String readData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//testdata/userdata.xlsx");
		Workbook w1 = WorkbookFactory.create(fis);
		String s=w1.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return s;
	}
		public static void writeData(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//testdata/userdata.xlsx");
			Workbook w1 = WorkbookFactory.create(fis);
			w1.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
			FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//testdata/userdata.xlsx");
			w1.write(fos);
			
	}
}
