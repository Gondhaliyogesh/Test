package com.Test.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleAP 
{


	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Desktop\\Yogesh Gondhali\\Software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://safarjoy.com/admin/auth");
		
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("safarjoy");
		driver.findElement(By.name("password")).sendKeys("safarjoy@1234");
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(3000);

		List<WebElement>link= driver.findElements(By.tagName("a"));
		System.out.println(link.size());

		for(int i=0;i<link.size();i++)
		{
			System.out.println((link.get(i).getText()));

			if(link.get(i).getText().contains("Customer Management"))
			{
				link.get(i).click();
				break;
			}
		}
	}}
