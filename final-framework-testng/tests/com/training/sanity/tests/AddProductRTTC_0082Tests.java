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
import com.training.pom.AddProductRTTC09TC02;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddProductRTTC_0082Tests {
	private WebDriver driver;
	private String baseUrl;
	private AddProductRTTC09TC02 addProductRTTC09TC02;
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
		addProductRTTC09TC02 = new AddProductRTTC09TC02(driver);
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
		addProductRTTC09TC02.searchBtn();
		addProductRTTC09TC02.sendSearchItem("Iaculis");
		addProductRTTC09TC02.searchBtn();
		addProductRTTC09TC02.selectItem();
		String prodNamebc = addProductRTTC09TC02.beforeCart();
		System.out.println(prodNamebc);
		addProductRTTC09TC02.addTocart();
		addProductRTTC09TC02.popUpclk();
		String prodNameac = addProductRTTC09TC02.AfterCart();
		System.out.println(prodNameac);
		Assert.assertEquals(prodNamebc, prodNameac);
	}
}
