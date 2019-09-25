package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_037_POM {
private WebDriver driver; 
	
	public RTTC_037_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName037; 
	
	@FindBy(id="input-password")
	private WebElement password037;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn037;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement passwordConfirmation037;
	
	public void sendUserName037(String userName037) {
		this.userName037.clear();
		this.userName037.sendKeys(userName037);
	}
	
	public void sendPassword037(String password037) {
		this.password037.clear(); 
		this.password037.sendKeys(password037); 
	}
	
	public void clickLoginBt037() {
		this.loginBtn037.click(); 
	}
	
	public String passwordMismatch037() {
		return this.passwordConfirmation037.getText();
	}

}
