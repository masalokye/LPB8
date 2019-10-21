package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medium38_39POM {
	
	private WebDriver driver; 
	
	public Medium38_39POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//RTTC_038 - 05 To verify whether application allows admin to add category in categories page

			@FindBy(xpath="//i[@class='fa fa-tags fw']")
			private WebElement catalogHover;

			@FindBy(xpath="/html/body/div[1]/nav/ul/li[3]/ul/li[1]/a") //change later
			private WebElement catagories;

			@FindBy(xpath="//i[@class='fa fa-plus']")
			private WebElement clickAdd;

			@FindBy(id="input-name1")
			private WebElement gtTxtBox;

			@FindBy(xpath="//div[@class='note-editable panel-body']")
			private WebElement gtDecpTxtBox;

			@FindBy(id="input-meta-title1")
			private WebElement mtTitleBox;

			@FindBy(id="input-meta-description1")
			private WebElement mtDescTxtBox;

			@FindBy(xpath="//button[@class='btn btn-primary']")
			private WebElement saveClick;

			@FindBy(xpath="//table//thead//tr//td[@class='text-left']//ancestor::table//tbody//tr//td[text()='ORNAMENTS9999']")
			private WebElement verifyAdd;
			
			//RTTC_039 06 Edit category 
			@FindBy(xpath="//table//thead//tr//td[@class='text-left']//ancestor::table//tbody//tr//td[text()='ORNAMENTS']//following-sibling::td[2]//a")
			private WebElement editclick;
			
			//RTTC_038 - 05 - To verify whether application allows admin to add category in categories page


			public void CatalogHover() {
				Actions act = new Actions(driver);
				act.moveToElement(this.catalogHover).perform();
			}
			
			

			public void Catagories() {
				this.catagories.click();
			}

			public void ClickAdd() {
				this.clickAdd.click(); 
			}

			public void GtTxtBox(String gtTxtBox) {
				this.gtTxtBox.clear();
				this.gtTxtBox.sendKeys(gtTxtBox);
			}


			public void GtDecpTxtBox(String gtDecpTxtBox) {
				this.gtDecpTxtBox.clear();
				this.gtDecpTxtBox.sendKeys(gtDecpTxtBox);
			}

			public void MtTitleBox(String mtTitleBox) {
				this.mtTitleBox.clear();
				this.mtTitleBox.sendKeys(mtTitleBox);
			}

			public void mtDescTxtBox(String mtDescTxtBox) {
				this.mtDescTxtBox.clear();
				this.mtDescTxtBox.sendKeys(mtDescTxtBox);
			}

			public void saveClick() {
				this.saveClick.click();
			}
			
			public String VerifyAdd() {
				return this.verifyAdd.getText();
			}
			
			//RTTC_039 06 Edit category 
			
			public void EditClick() {
				this.editclick.click(); 
			}
			
			public String MtTitleBoxText() {
				return this.mtTitleBox.getAttribute("value");
			}

			public String MtDescTxtBoxText() {
				return this.mtDescTxtBox.getAttribute("value");
			}
			
			
			

}
