package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminFilterRTTC22TC03;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminFilterRTTC22TC03Tests {

	private WebDriver driver;
	private String Url;
	private AdminFilterRTTC22TC03 adminFilterRTTC22TC03;
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
		adminFilterRTTC22TC03 = new AdminFilterRTTC22TC03(driver);
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


	
	@Test 
	public void adminFilter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		adminFilterRTTC22TC03.sendUserNam("admin");
		adminFilterRTTC22TC03.sendPasswor("admin@123");
		adminFilterRTTC22TC03.clickLoginBt();
		adminFilterRTTC22TC03.reports();
		//Thread.sleep(3000);
		adminFilterRTTC22TC03.sales();
		//Thread.sleep(3000);
		adminFilterRTTC22TC03.orders();
		adminFilterRTTC22TC03.selectWeek();
		adminFilterRTTC22TC03.Filter();
	}




}
