package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Product_Complex68_69POM;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Medium38_39POM;
import com.training.pom.Simple009_022POM;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//import com.training.dataproviders.*;

public class Filter_Product_RTTC_7067_Tests {
	private WebDriver driver;
	private String Url;
	private AdminLoginPOM adminLoginPOM;
	private Simple009_022POM simple009_022POM;
	private Medium38_39POM medium38_39POM;
	private Product_Complex68_69POM product_Complex68_69POM;
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
		product_Complex68_69POM = new Product_Complex68_69POM(driver);
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
	}*/

	@Test(dataProvider = "excel-inputs67", dataProviderClass = LoginDataProviders.class)
	public void adminFilter69(String productName, String price, String status, String model, String quantity, String image) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		simple009_022POM.sendUserNam("admin");
		simple009_022POM.sendPasswor("admin@123");
		simple009_022POM.clickLoginBt();
		medium38_39POM.CatalogHover();
		product_Complex68_69POM.clickProduct();
		product_Complex68_69POM.ProductName(productName);
		product_Complex68_69POM.Price(price);
		product_Complex68_69POM.Status(status);
		product_Complex68_69POM.Model(model);
		product_Complex68_69POM.Quantity(quantity);
		product_Complex68_69POM.Image(image);
		product_Complex68_69POM.Filter1();
		System.out.println(productName + price+ status+ model+quantity +image);
		String result1 = product_Complex68_69POM.Result();
		//System.out.println(result1);
		String resultM1 = "Integer Vitae Iaculis Massa";
		String resultM2 = "Integer vitae iaculis massa";
		String resultM34 = "aaa MRF BAT";
		//Assert.assertTrue(result1.contains(resultM1));
		System.out.println(productName + price+ status+ model+quantity +image);
				
		if (productName.equals("Integer vitae iaculis massa")) { Assert.assertTrue(result1.contains(resultM1)); System.out.println("Test Pass1"); }
		if (model.equals("SKU-003")) {Assert.assertTrue(result1.contains(resultM2)); System.out.println("Test Pass2"); }
		if (quantity.equals("47.0")) {Assert.assertTrue(result1.contains(resultM34)); System.out.println("Test Pass3"); }
		if (quantity.equals("50.0")) {Assert.assertTrue(result1.contains(resultM34)); System.out.println("Test Pass4"); }
		


	}

	
	}




