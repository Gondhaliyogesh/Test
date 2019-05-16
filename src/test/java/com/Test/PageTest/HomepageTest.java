package com.Test.PageTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomepageTest 
{
	WebDriver driver;

	com.Test.Pages.Homepage homepage;


	@BeforeSuite
	public void Start() throws MalformedURLException
	{
		/*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();



		//recorder=new ATUTestRecorder("F:\\Auto\\Test\\ScriptVideos","Paradigm_Test_Exicution-"+dateFormat.format(date),false);
		//recorder.start();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Desktop\\Yogesh Gondhali\\Software\\geckodriver.exe");
		driver=new FirefoxDriver();*/

		String username = System.getenv("BROWSERSTACK_USERNAME");
		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
		String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "74.0");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.selenium_version", "3.5.2");
		caps.setCapability("browserstack.local", browserstackLocal);
		caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
		//driver = new RemoteWebDriver(new URL("https://" + "yogeshgondhali2" + ":" + "2pyvYZdE8dm8U5CdgwMp" + "@hub.browserstack.com/wd/hub"), caps);
		driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), caps);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://pcsv2dev.azurewebsites.net");
	}

	@Test(priority=2)
	public void Verify_Login() throws Exception 
	{
		homepage=new com.Test.Pages.Homepage(driver);
		homepage.Verify_Login();

		Assert.assertEquals(driver.getCurrentUrl(),"http://pcsv2dev.azurewebsites.net/#/clients/all");

	}

	@Test(priority=1)
	public void Verify_Url() 
	{
		homepage=new com.Test.Pages.Homepage(driver);
		System.out.println(homepage.Verify_Url());

		Assert.assertEquals(homepage.Verify_Url(),"http://pcsv2dev.azurewebsites.net/#/");
	}

	@Test(priority=3)
	public void Verify_Title() 
	{
		homepage=new com.Test.Pages.Homepage(driver);
		System.out.println(homepage.Verify_Title());

		Assert.assertEquals(homepage.Verify_Title(),"Paradigm");
	}

	@Test(priority=4)
	public void Verify_Logout() throws Exception 
	{
		homepage=new com.Test.Pages.Homepage(driver);
		homepage.Verify_Login();

		homepage.Verify_Logout();

		Assert.assertEquals(driver.getCurrentUrl(),"http://pcsv2dev.azurewebsites.net/#/");
	}

	@AfterClass
	public void Close() throws Exception 
	{
		Thread.sleep(3000);
		driver.close();

	}

}
