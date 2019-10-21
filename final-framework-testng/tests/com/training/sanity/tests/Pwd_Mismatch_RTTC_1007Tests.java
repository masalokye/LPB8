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
//import com.training.pom.AddProductRTTC09TC02;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//To verify whether application displays error message upon mis matching password & confirm password of Change Your Password page
public class Pwd_Mismatch_RTTC_1007Tests {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM adminLoginPOM;
	//private AddProductRTTC09TC02 addProductRTTC09TC02;
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
		//addProductRTTC09TC02 = new AddProductRTTC09TC02(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}
/*
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	*/
	@Test 
	public void changePasswordMismatchTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		adminLoginPOM.clickMyAccount();
		Thread.sleep(3000);
		adminLoginPOM.clickLogin();
		adminLoginPOM.sendUserName("manju@gmail.com");
		adminLoginPOM.sendPassword("manju@123");
		adminLoginPOM.clickLoginBtn(); 
		adminLoginPOM.changePasswordLink();
		adminLoginPOM.sendNewPassword("manju@1234");
		//adminLoginPOM.sendConfirmNewPassword("manju@12345");
		adminLoginPOM.chgPwdContinue();
		String manual = "Password confirmation does not match password!";
		//Thread.sleep(3000);
		//System.out.println(adminLoginPOM.passwordMismatch());
		String auto = adminLoginPOM.passwordMismatch();
		Assert.assertTrue(auto.contains(manual));
		screenShot.captureScreenShot("First");

	}

	
}
