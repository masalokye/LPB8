package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Simple009_022POM {
private WebDriver driver; 
	
	public Simple009_022POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//RTTC_009 02 Add Product and verify same product added
	
		@FindBy(xpath="//a[@id='search_button']")
		private WebElement clkSearchBtn; 

		@FindBy(xpath="//input[@id='filter_keyword']")
		private WebElement searchItem;
		
		@FindBy(partialLinkText="Iaculis Massa")
		private WebElement selectItem;
		
		@FindBy(xpath="//dl[@class='dl-horizontal']/dd[2]")
		private WebElement beforeCart;
		
		@FindBy(id="button-cart")
		private WebElement addToCart;
		
		@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
		private WebElement popUp;
		
		@FindBy(xpath="//ul[@class='noty_cont noty_layout_topRight']")
		private WebElement afterCart;
		
		//RTTC_022 03 - To Verify whether application allows the admin to filter the order details from sales list from reports module
			@FindBy(id="input-username")
			private WebElement userNam; 

			@FindBy(id="input-password")
			private WebElement passwor;

			@FindBy(xpath="//button[@type='submit']")
			private WebElement loginBt; 

			@FindBy(xpath="//i[@class='fa fa-bar-chart-o fw']")
			private WebElement hoverReports;

			@FindBy(xpath="/html/body/div[1]/nav/ul/li[10]/ul/li[1]/a") //change later
			private WebElement clkSales;

			@FindBy(xpath="/html/body/div[1]/nav/ul/li[10]/ul/li[1]/ul/li[1]/a") //change later
			private WebElement clkOrders;

			@FindBy(id="input-group")
			private WebElement week;

			@FindBy(id="button-filter")
			private WebElement clkFilter;
			
			@FindBy(xpath="//table//thead//tr//td[text()='Date Start']//ancestor::table//tbody//tr//td[text()='1']")
			//table//thead//tr//td[text()='Date Start']//ancestor::table//tbody//tr//td[text()='8']
			private WebElement totalOrder;
			
			//RTC037 04 invalid admin id or pwd
			@FindBy(xpath="//div[@class='alert alert-danger']")
			private WebElement passwordConfirmation037;
			
			//RTTC_009 02 Add Product and verify same product added
			
			public void searchBtn() {
				this.clkSearchBtn.click();
				
			}

			public void sendSearchItem(String searchItem) {
				//this.searchItem.clear();
				this.searchItem.sendKeys(searchItem);
			}
			
			public void selectItem() {
				this.selectItem.click();
			}
			
			public String beforeCart() {
				return this.beforeCart.getText();
			}
			
			public void addTocart() {
				this.addToCart.click();
			}
			
			public void popUpclk() {
				this.popUp.click();
			}
			public String AfterCart() throws InterruptedException {
				
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"))).perform();
			Thread.sleep(1000);
			act.moveToElement(driver.findElement(By.xpath("//a[@href='http://retail.upskills.in/checkout/cart']"))).click().build().perform();
			String productNameAfter = driver.findElement(By.xpath("//a[text()='Integer Vitae Iaculis Massa']")).getText();
			return productNameAfter;
			}
			
			//RTTC_022 03 - To Verify whether application allows the admin to filter the order details from sales list from reports module
				public void sendUserNam(String userName) {
					this.userNam.clear();
					this.userNam.sendKeys(userName);
				}

				public void sendPasswor(String password) {
					this.passwor.clear(); 
					this.passwor.sendKeys(password); 
				}

				public void clickLoginBt() {
					this.loginBt.click(); 
				}

				public void reports() {
					Actions act = new Actions(driver);
					act.moveToElement(hoverReports).perform();
				}

				public void sales() {
					this.clkSales.click();
				}

				public void orders() {
					this.clkOrders.click();
				}

				public void selectWeek() {
					Select sel = new Select(week);
					sel.selectByVisibleText("Days");
				}

				public void Filter() {
					this.clkFilter.click();
				}
				
				public String TotalOrder() {
					return this.totalOrder.getText();
				}
				


}
