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

public class ErrorInvalidDetails_RTTC_9069_Tests {
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

	@Test(dataProvider = "excel-inputs69", dataProviderClass = LoginDataProviders.class)
	public void adminFilter69(String productName, String MetaTagDesc, String model, String price, String quantity, String category) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		simple009_022POM.sendUserNam("admin");
		simple009_022POM.sendPasswor("admin@123");
		simple009_022POM.clickLoginBt();
		medium38_39POM.CatalogHover();
		product_Complex68_69POM.clickProduct();
		product_Complex68_69POM.PlusAddClickclickProduct();
		product_Complex68_69POM.SendProductName(productName);
		product_Complex68_69POM.SendMetaTagDesc(MetaTagDesc);
		product_Complex68_69POM.DataTabClick();
		product_Complex68_69POM.SendModel(model);
		product_Complex68_69POM.SendPrice(price);
		product_Complex68_69POM.SendQuantity(quantity);
		product_Complex68_69POM.LinksTabClick();
		product_Complex68_69POM.SendCategory(category);
		product_Complex68_69POM.SaveClkProd();
		String SuccessSaveM = "Warning: Please check";
		String SuccessSaveA = product_Complex68_69POM.AfterSaveProdWarn();
		//System.out.println(prodNameac);
		//Assert.assertEquals(SuccessSaveA, SuccessSaveM);
		Assert.assertTrue(SuccessSaveA.contains(SuccessSaveM));


	}

}
