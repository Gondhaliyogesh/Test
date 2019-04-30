package com.Test.PageTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Test.Pages.Homepage;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;



public class HomepageTest 
{
	WebDriver driver;

	Homepage homepage;

	ATUTestRecorder recorder;

	@BeforeMethod
	public void Start() throws ATUTestRecorderException 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\Yogesh Gondhali\\Software\\geckodriver.exe");

		recorder=new ATUTestRecorder("F:\\Auto\\Test\\ScriptVideos","Paradigm_Test_Exicution-"+dateFormat.format(date),false);

		
		driver=new FirefoxDriver();
		recorder.start();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://pcsv2dev.azurewebsites.net");
	}

	@Test(priority=2)
	public void Login() throws Exception 
	{
		homepage=new Homepage(driver);
		homepage.Verify_Login();

		Assert.assertEquals(driver.getCurrentUrl(), "http://pcsv2dev.azurewebsites.net/#/clients/all");

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

	@Test(priority=4)
	public void Logout() throws Exception 
	{
		homepage=new Homepage(driver);
		homepage.Verify_Login();

		homepage.Verify_Logout();

		Assert.assertEquals(driver.getCurrentUrl(), "http://pcsv2dev.azurewebsites.net/#/");
	}

	@AfterMethod
	public void Close() throws Exception 
	{
		Thread.sleep(3000);

		driver.close();
		recorder.stop();
	}

}
