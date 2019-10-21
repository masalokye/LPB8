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
//import com.training.pom.AdminFilterRTTC22TC03;
//import com.training.pom.RTTC_037_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//To verify whether application allows admin to add category in categories page
public class Add_Category_RTTC_5038_Tests {

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
/*
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	*/
	@Test 
	public void adminFilter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		simple009_022POM.sendUserNam("admin");
		simple009_022POM.sendPasswor("admin@123");
		simple009_022POM.clickLoginBt();
		medium38_39POM.CatalogHover();
		medium38_39POM.Catagories();
		medium38_39POM.ClickAdd();
		medium38_39POM.GtTxtBox("ORNAMENTS9999");
		medium38_39POM.GtDecpTxtBox("ornaments for ladies9999");
		medium38_39POM.MtTitleBox("ORNAMENTS999");
		medium38_39POM.mtDescTxtBox("ornaments for ladies9999");
		medium38_39POM.saveClick();
		String manual = "ORNAMENTS9999"; //Created same
		String auto = medium38_39POM.VerifyAdd(); //fetched same change in xpath text
		//System.out.println(manual+auto);
		Assert.assertEquals(auto, manual);
		
	}


}
