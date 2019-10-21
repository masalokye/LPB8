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
import com.training.pom.AdminLoginPOM;
import com.training.pom.Medium38_39POM;
import com.training.pom.Simple009_022POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Edit_Category_RTTC_6039_Tests {

	private WebDriver driver;
	private String Url;
	private AdminLoginPOM adminLoginPOM;
	private Simple009_022POM simple009_022POM;
	private Medium38_39POM medium38_39POM;
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
		medium38_39POM = new Medium38_39POM(driver);
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
		medium38_39POM.CatalogHover();
		medium38_39POM.Catagories();
		medium38_39POM.EditClick();
		medium38_39POM.MtTitleBox("ORNAMENTSAAA3");
		medium38_39POM.mtDescTxtBox("ornaments for ladiesaaa3");
		medium38_39POM.saveClick();
		medium38_39POM.EditClick();
		String mtTitBox = medium38_39POM.MtTitleBoxText();
		String mtDescBox = medium38_39POM.MtDescTxtBoxText();
		String manual1 = "ORNAMENTSAAA3";
		String manual2 = "ornaments for ladiesaaa3";
		//System.out.println(manual1+mtTitBox+manual2+mtDescBox);
		Assert.assertEquals(mtTitBox, manual1);
		Assert.assertEquals(mtDescBox, manual2);
		medium38_39POM.saveClick();
		
		
	}


}
