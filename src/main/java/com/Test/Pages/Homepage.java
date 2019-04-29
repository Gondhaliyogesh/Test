package com.Test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;
	
	@FindBy(id="email")
	private WebElement Email;

	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(xpath="//*[@id='main-wrapper']/app-body/div/ng-component/div/div/div/div[2]/div/form/div[5]/button")
	private WebElement Login_Btn;
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Verify_Login()
	{
		Email.sendKeys("superadmin@paradigmclaims.com");
		Password.sendKeys("paradigm@123");
		Login_Btn.click();
	}
	
	public String Verify_Title()
	{
		return driver.getTitle();
	}
	
	public String Verify_Url()
	{
		return driver.getCurrentUrl();
		
	}
	
}
