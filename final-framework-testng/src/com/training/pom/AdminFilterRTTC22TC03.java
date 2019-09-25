package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AdminFilterRTTC22TC03 {
	private WebDriver driver; 

	public AdminFilterRTTC22TC03(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-username")
	private WebElement userNam; 
	
	@FindBy(id="input-password")
	private WebElement passwor;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBt; 
	
	@FindBy(xpath="//i[@class='fa fa-bar-chart-o fw']")
	private WebElement hoverReports;
	
	@FindBy(xpath="/html/body/div[1]/nav/ul/li[10]/ul/li[1]/a")
	private WebElement clkSales;
	
	@FindBy(xpath="/html/body/div[1]/nav/ul/li[10]/ul/li[1]/ul/li[1]/a")
	private WebElement clkOrders;
	
	@FindBy(id="input-group")
	private WebElement week;
	
	@FindBy(id="button-filter")
	private WebElement clkFilter;
	
	
	
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
}