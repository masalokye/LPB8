package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Product_Complex68_69POM {
	
	
		private WebDriver driver; 
		
		public Product_Complex68_69POM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		

		//RTTC_068 08 Catalog> Products> Add ...Valid
		@FindBy(xpath="//li[@id='menu-catalog']//descendant::ul//li[2]//a")
		private WebElement clkProduct;
		
		@FindBy(xpath="//div[@class='pull-right']//a[@data-original-title='Add New']")
		private WebElement plusAddClk;
		
		@FindBy(xpath="//div[@class='col-sm-10']//input[@id='input-name1']")
		private WebElement sendProdName;
		
		
		@FindBy(xpath="//div[@class='col-sm-10']//input[@id='input-meta-title1']")
		private WebElement sendMetaTagDesc;
		
		
		@FindBy(xpath="//ul[@class='nav nav-tabs']//li[2]//a")
		private WebElement dataClk;
		
		//div[@class='col-sm-10']//input[@id='input-model']
		@FindBy(xpath="//div[@class='col-sm-10']//input[@id='input-model']")
		private WebElement sendModel;
		
		@FindBy(xpath="//div[@class='col-sm-10']//input[@id='input-price']")
		private WebElement sendPrice;
		
		
		@FindBy(xpath="//div[@class='col-sm-10']//input[@id='input-quantity']")
		private WebElement sendQuantity;
		
		@FindBy(xpath="//ul[@class='nav nav-tabs']//li[3]//a")
		private WebElement linksClk;
		
		//div[@class='col-sm-10']//input[@id='input-model']
		@FindBy(xpath="//div[@class='col-sm-10']//input[@id='input-category']")
		private WebElement sendCategory;
		
		//button[@data-original-title='Save']
		@FindBy(xpath="//button[@data-original-title='Save']")
		private WebElement saveClkProd;
		
		@FindBy(xpath="//div[@class='alert alert-success']")
		private WebElement savedSuccessMsg;
		
		//RTTC_069 09 Ivalid not saved warning msg
		@FindBy(xpath="//div[@class='alert alert-danger']")
		private WebElement savedSuccessMsg2;
		
		//RTTC_068 08 Catalog> Products> Add ...Valid
		public void clickProduct() {
			this.clkProduct.click();
		}
		
		public void PlusAddClickclickProduct() {
			this.plusAddClk.click();
		}
		
		public void SendProductName(String sendProdName) {
			this.sendProdName.clear();
			this.sendProdName.sendKeys(sendProdName);
		}
		
		public void SendMetaTagDesc(String sendMetaTagDesc) {
			this.sendMetaTagDesc.clear();
			this.sendMetaTagDesc.sendKeys(sendMetaTagDesc);
		}
		
		public void DataTabClick() {
			this.dataClk.click();
		}
		
		public void SendModel(String sendModel) {
			this.sendModel.clear();
			this.sendModel.sendKeys(sendModel);
		}
		
		public void SendPrice(String sendPrice) {
			this.sendPrice.clear();
			this.sendPrice.sendKeys(sendPrice);
		}
		
		public void SendQuantity(String sendQuantity) {
			this.sendQuantity.clear();
			this.sendQuantity.sendKeys(sendQuantity);
		}
		
		public void LinksTabClick() {
			this.linksClk.click();
		}
		
		public void SendCategory(String sendCategory) {
			this.sendCategory.clear();
			this.sendCategory.sendKeys(sendCategory);
		}
		
		public void SaveClkProd() {
			this.saveClkProd.click();
		}
		
		public String AfterSaveProd()  {
			//String SuccessSaveA = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			String SuccessSaveA = this.savedSuccessMsg.getText();
			return SuccessSaveA;
			}
		
		
		
		
		//RTTC_069 09 Ivalid not saved warning msg
		
		public String AfterSaveProdWarn()  {
			//String SuccessSaveAW = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
			String SuccessSaveAW = this.savedSuccessMsg2.getText();
			return SuccessSaveAW;
			}
		
		//RTTC_067 07 Catalog> Products> Filter
		
		
				/*input-name
				input-price
				input-status - select
				input-model
				input-quantity
				input-image - select
				button-filter*/
				
				@FindBy(id="input-name")
				private WebElement prodName;
				
				@FindBy(id="input-price")
				private WebElement price;
				
				@FindBy(id="input-status")
				private WebElement status;
				
				@FindBy(id="input-model")
				private WebElement model;
				
				@FindBy(id="input-quantity")
				private WebElement quantity;
				
				@FindBy(id="input-image")
				private WebElement image;
				
				@FindBy(id="button-filter")
				private WebElement filter;
				
				@FindBy(xpath="//table[@class='table table-bordered table-hover']//thead//tr[1]//td[3]//ancestor::table//tbody//tr//td[3]")
				private WebElement result;
				
				//RTTC_067 07 Catalog> Products> Filter
				
				
				
				public void ProductName(String prodName) {
					this.prodName.clear();
					this.prodName.sendKeys(prodName);
				}
				
				public void Price(String price) {
					this.price.clear();
					this.price.sendKeys(price);
				}
				
				public void Status(String status1) {
					Select sel = new Select(status);
					sel.selectByVisibleText(status1);
				}
			
				public void Model(String model) {
					this.model.clear();
					this.model.sendKeys(model);
				}
				
				public void Quantity(String quantity) {
					this.quantity.clear();
					this.quantity.sendKeys(quantity);
				}
				
				public void Image(String image1) {
					Select sel = new Select(image);
					sel.selectByVisibleText(image1);
				}
				
				public void Filter1() {
					this.filter.click();
				}
				
				public String Result() {
					String ResultA=this.result.getText();
					return ResultA;
				}
				
				
		

}
