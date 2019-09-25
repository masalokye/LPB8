

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductRTTC09TC02 {
	private WebDriver driver; 

	public AddProductRTTC09TC02(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

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
}
