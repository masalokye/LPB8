package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_38_POM {
private WebDriver driver; 
	
	public RTTC_38_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName038; 
	
	@FindBy(id="input-password")
	private WebElement password038;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn038;
	
	public void sendUserName038(String userName038) {
		this.userName038.clear();
		this.userName038.sendKeys(userName038);
	}
	
	public void sendPassword038(String password038) {
		this.password038.clear(); 
		this.password038.sendKeys(password038); 
	}
	
	public void clickLoginBt038() {
		this.loginBtn038.click(); 
	}
	

}
