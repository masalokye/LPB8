package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminLoginPOM {
	private WebDriver driver; 
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//RTTC_008 01 New Password Miss match
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
	
	
		
		//RTC037 04 invalid admin id or pwd
		@FindBy(xpath="//div[@class='alert alert-danger']")
		private WebElement passwordConfirmation037;


		//RTC037 04 invalid admin id or pwd
		public String passwordMismatch037() {
			return this.passwordConfirmation037.getText();
		}

		
		
		//RTTC_008 01 New Password Miss match
	
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
