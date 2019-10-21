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
//import com.training.pom.AddProductRTTC09TC02;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Simple009_022POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//To Verify whether application displays appropriate search products based on the user preference
public class Add_Product_RTTC_2009Tests {
	private WebDriver driver;
	private String baseUrl;
	//private AddProductRTTC09TC02 addProductRTTC09TC02;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		
	}
	
	@Test 
	public void addProduct() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		simple009_022POM.searchBtn();
		simple009_022POM.sendSearchItem("Iaculis");
		simple009_022POM.searchBtn();
		simple009_022POM.selectItem();
		String prodNamebc = simple009_022POM.beforeCart();
		System.out.println(prodNamebc);
		simple009_022POM.addTocart();
		simple009_022POM.popUpclk();
		String prodNameac = simple009_022POM.AfterCart();
		System.out.println(prodNameac);
		Assert.assertEquals(prodNamebc, prodNameac);
	}
}
