package com.erp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.newproject.BaseClass;

public class AddNewCustomerPage 
	{
		@FindBy(name="name")
		private WebElement CustomerNameTextFiled;
		@FindBy(name="createCustomerSubmit")
		private WebElement createCustomerButton;
		public AddNewCustomerPage() 
		{
			PageFactory.initElements(BaseClass.driver,this);
		}
		public void enterCustomerName(String CustomerName) 
		{
			CustomerNameTextFiled.sendKeys(CustomerName);
		}
		public void clickonCreateCustomerButton()
		{
			createCustomerButton.click();
		}
			
	}
