package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement myAccount; 
	
	@FindBy(partialLinkText="LOGIN")
	private WebElement clickLogin; 
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(partialLinkText="Change your")
	private WebElement changePasswordLink;
	
	@FindBy(id="input-password")
	private WebElement sendNewPassword;
	
	@FindBy(id="input-confirm")
	private WebElement SendConfirmNewPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement chgPwdContinue;
	
	//@FindBy(partialLinkText="Password confirmation")
	//private WebElement passwordConfirmation;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement passwordConfirmation;
	
	public void clickMyAccount() {
		this.myAccount.click();
	}
	
	public void clickLogin() {
		this.clickLogin.click();
	}
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void changePasswordLink() {
		this.changePasswordLink.click(); 
	}
	
	public void sendNewPassword(String newPassword) {
		this.password.clear(); 
		this.password.sendKeys(newPassword); 
	}
	
	public void sendConfirmNewPassword(String confirmNewPassword) {
		this.password.clear(); 
		this.password.sendKeys(confirmNewPassword); 
	}
	
	public void chgPwdContinue() {
		this.chgPwdContinue.click(); 
	}
	
	public String passwordMismatch() {
		return this.passwordConfirmation.getText();
	}

	
}
