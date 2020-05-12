package com.erp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.newproject.BaseClass;

	public class ActiveProjectAndCustomersPage
	{
		@FindBy(xpath="//input[@value='Add New Customer']")
		private WebElement addNewCustomerButton;
		@FindBy(xpath="//input[@value='Add New Project']")
		private WebElement addNewProjectButton;
		@FindBy(className="Successmsg")
		private WebElement SucessMessage;
		
		public  ActiveProjectAndCustomersPage()
		{
			PageFactory.initElements(BaseClass.driver,this);
		}
		public void clickonAddNewCustomerButton() 
		{
			addNewCustomerButton.click();
		}
		public String RetriveSucessMessage()
		{
			String s=SucessMessage.getText();
			return s;
		}
		public void clickonAddNewProjectButton() 
		{
			addNewProjectButton.click();
		}

	}
	
	
