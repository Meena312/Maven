package com.erp.projects.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.erp.newproject.BaseClass;
import com.erp.utilities.ExcelOperation;
import com.erp.webpages.ActiveProjectAndCustomersPage;
import com.erp.webpages.AddNewProjectPage;
import com.erp.webpages.OpenTaskPage;

public class CreateProject extends BaseClass
{
	@Test
	public void testCreateProject() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	String CustomerName=ExcelOperation.readData("sheet1",0,0);
	String ProjectName=ExcelOperation.readData("sheet1",0,1);
	OpenTaskPage otp=new OpenTaskPage();
	otp.clickOnProjectsAndCustomersLink();
	log.info("**********Projects and Customers Linked**********");
	ActiveProjectAndCustomersPage apcp=new ActiveProjectAndCustomersPage();
	apcp.clickonAddNewProjectButton();
	log.info("********** New Project Button is Added**********");
	AddNewProjectPage anpp=new AddNewProjectPage();
	anpp.selectCustomerFromDropdown(CustomerName);
	log.info("**********Entered Customer Name**********");
	anpp.enterProjectName(ProjectName);
	log.info("**********Entered Project Name**********");
	anpp.clickonCreateProjectButton();
	log.info("**********Project Button is Created**********");
	String s=apcp.RetriveSucessMessage();
	log.info("**********Retrived Sucess Message sucessfully**********");
	System.out.println(s);
}
}
