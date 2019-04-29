package com.Test.PageTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Test.Pages.Homepage;



public class HomepageTest 
{
	WebDriver driver;
	
	Homepage homepage;

	@BeforeSuite
	public void Start() throws MalformedURLException
	{
		/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\Yogesh Gondhali\\Software\\geckodriver.exe");
		driver=new FirefoxDriver();

		driver.get("http://pcsv2dev.azurewebsites.net");

		driver.manage().window().maximize();*/
		
		 ChromeOptions options = new ChromeOptions();

	        options.setCapability("username", "yogeshshinde");
	       options.setCapability("accessKey", "e251e6cf-8679-4c09-9dea-57f34692a481");

	       // options.setCapability("browserName", "Chrome");
	       // options.setCapability("platform", "Windows 10");
	       // options.setCapability("version", "73.0");
	        options.setCapability("build", "Paradigm_Login_Function");
	        options.setCapability("name", "Login_Page");
	        
	        driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), options);

	        /*System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Yogesh Gondhali\\Software\\chromedriver.exe");
	        driver=new ChromeDriver();*/

	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();

	        driver.get("http://pcsv2dev.azurewebsites.net/#/");

	}
	
	@Test(priority=2)
	public void login() 
	{
		homepage=new Homepage(driver);
		homepage.Verify_Login();
	}
	
	@Test(priority=1)
	public void Url() 
	{
		homepage=new Homepage(driver);
		System.out.println(homepage.Verify_Url());
		
		Assert.assertEquals(homepage.Verify_Url(), "http://pcsv2dev.azurewebsites.net/#/");
	}
	
	@Test(priority=3)
	public void Title() 
	{
		homepage=new Homepage(driver);
		System.out.println(homepage.Verify_Title());
		
		Assert.assertEquals(homepage.Verify_Title(), "Paradigm");
	}

	@AfterClass
	public void Close() 
	{
		driver.close();
		
	}

}
