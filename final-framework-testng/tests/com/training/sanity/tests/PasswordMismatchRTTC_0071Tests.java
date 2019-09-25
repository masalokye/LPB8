package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProductRTTC09TC02;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PasswordMismatchRTTC_0071Tests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
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
	public void changePasswordMismatchTest() throws InterruptedException {

		loginPOM.clickMyAccount();
		Thread.sleep(3000);
		loginPOM.clickLogin();
		loginPOM.sendUserName("manju@gmail.com");
		loginPOM.sendPassword("manju@123");
		loginPOM.clickLoginBtn(); 
		loginPOM.changePasswordLink();
		loginPOM.sendNewPassword("manju@1234");
		//loginPOM.sendConfirmNewPassword("manju@12345");
		loginPOM.chgPwdContinue();
		String manual = "Password confirmation does not match password!";
		Thread.sleep(3000);
		//System.out.println(loginPOM.passwordMismatch());
		String auto = loginPOM.passwordMismatch();
		Assert.assertTrue(auto.contains(manual));
		screenShot.captureScreenShot("First");

	}

	
}
