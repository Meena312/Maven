package com.erp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.erp.newproject.BaseClass;

public class OpenTaskPage extends BaseClass
	{
	@FindBy(linkText="Projects & Customers")
	private WebElement ProjectsAndCustomersLink;
	public OpenTaskPage() 
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	public void clickOnProjectsAndCustomersLink() 
	{
		ProjectsAndCustomersLink.click();
	}


}
