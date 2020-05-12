package com.erp.customer_scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.erp.newproject.BaseClass;
import com.erp.utilities.ExcelOperation;
import com.erp.webpages.ActiveProjectAndCustomersPage;
import com.erp.webpages.AddNewCustomerPage;
import com.erp.webpages.OpenTaskPage;

public class CreateCustomer extends BaseClass
{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	String CustomerName=ExcelOperation.readData("sheet1",0,0);
	OpenTaskPage otp=new OpenTaskPage();
	otp.clickOnProjectsAndCustomersLink();
	log.info("**********Projects and Customers Linked**********");
	ActiveProjectAndCustomersPage apcp=new ActiveProjectAndCustomersPage();
	apcp.clickonAddNewCustomerButton();
	log.info("********** New Customer Button is Added**********");
	AddNewCustomerPage ancp=new AddNewCustomerPage();
	ancp.enterCustomerName(CustomerName);
	log.info("**********Entered Customer Name**********");
	ancp.clickonCreateCustomerButton();
	log.info("**********Customer Button is Created**********");
	String s=apcp.RetriveSucessMessage();
	log.info("**********Retrived sucessMessage successfully**********");
	System.out.println(s);
}
}