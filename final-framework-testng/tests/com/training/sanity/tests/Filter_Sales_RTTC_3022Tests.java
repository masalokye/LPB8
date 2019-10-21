package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
//import com.training.pom.AdminFilterRTTC22TC03;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Simple009_022POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//To Verify whether application allows the admin to filter the order details from sales list from reports module
public class Filter_Sales_RTTC_3022Tests {

	private WebDriver driver;
	private String Url;
	//private AdminFilterRTTC22TC03 adminFilterRTTC22TC03;
	private AdminLoginPOM adminLoginPOM;
	private Simple009_022POM simple009_022POM;
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
		adminLoginPOM = new AdminLoginPOM(driver);
		simple009_022POM = new Simple009_022POM(driver);
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
		simple009_022POM.sendUserNam("admin");
		simple009_022POM.sendPasswor("admin@123");
		simple009_022POM.clickLoginBt();
		simple009_022POM.reports();
		simple009_022POM.sales();
		simple009_022POM.orders();
		simple009_022POM.selectWeek();
		simple009_022POM.Filter();
		String totalOrder = simple009_022POM.TotalOrder();
		String manual = "1"; //No. Orders  count may change ....update same in xpath..try to change for header 'No. Orders'
		Assert.assertEquals(totalOrder, manual);
	}




}
