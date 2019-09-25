package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_037_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class RTTC_037_Tests {
	
	private WebDriver driver;
	private String Url;
	private RTTC_037_POM rttc_037_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		rttc_037_POM = new RTTC_037_POM(driver);
		Url = properties.getProperty("Url");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(Url);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	
  @Test(dataProvider = "dp")
  public void invalidCredentials(String userName037, String password037) {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rttc_037_POM.sendUserName037(userName037);
		rttc_037_POM.sendPassword037(password037);
		rttc_037_POM.clickLoginBt037();
		String manual = "No match for Username and/or Password";
		String auto = rttc_037_POM.passwordMismatch037();
		Assert.assertTrue(auto.contains(manual));
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "123456" },
      new Object[] { "admin", "admin" },
      new Object[] { "manzoor", "admin@123" },
      new Object[] { "admin@123", "admin@123" },
    };
  }
}
