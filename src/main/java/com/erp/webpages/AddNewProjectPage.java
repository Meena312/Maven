package com.erp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.erp.newproject.BaseClass;

public class AddNewProjectPage 
{
	@FindBy(name="customerId")
	private WebElement CustomerDropdown;
	@FindBy(name="name")
	private WebElement ProjectNameTextField;
	@FindBy(name="createProjectSubmit")
	private WebElement createProjectButton;
	public AddNewProjectPage() 
	{
	PageFactory.initElements(BaseClass.driver,this);
	}
	public void selectCustomerFromDropdown(String CustomerName) 
	{
		Select s1=new Select(CustomerDropdown);
		s1.selectByVisibleText(CustomerName);
	}
	public void enterProjectName(String ProjectName) 
	{
		ProjectNameTextField.sendKeys(ProjectName);
	}
	public void clickonCreateProjectButton()
	{
		createProjectButton.click();
	}
		
}
