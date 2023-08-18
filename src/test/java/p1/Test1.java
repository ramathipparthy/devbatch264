package p1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 
{
RemoteWebDriver driver;
@Test(priority=1)
public void setUp()
{
	//open browser
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	//maximize
	driver.manage().window().maximize();
	
}
@Test(priority=2)
public void openUrl() 
{
	//launch site
	driver.get("http://www.google.com");
	if(driver.getCurrentUrl().contains("http"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);//stops execution
	}
	
}
@Test(priority=3)
public void getTitle() 
{
Reporter.log("site is opened");

	SoftAssert sa=new SoftAssert();
	if(driver.getTitle().equals("Google"))
	{
		sa.assertTrue(true);
	}
	else
	{
		sa.assertTrue(false);
	}
	//driver.close();
	sa.assertAll();
}
}
