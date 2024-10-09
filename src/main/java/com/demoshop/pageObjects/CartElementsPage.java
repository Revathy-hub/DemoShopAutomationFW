package com.demoshop.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoshop.utils.PageActions;

public class CartElementsPage extends PageActions {
	
	private WebDriver driver;
	
public CartElementsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[@class='remove-from-cart']")
	private WebElement removeBtn;

	@FindBy(xpath="//*[@class='button-2 update-cart-button']")
	private WebElement updateCartBtn;

	@FindBy(xpath="//*[@class='order-summary-content']")
	private WebElement orderSummaryMsg;

	@FindBy(xpath="//*[@class='country-input valid']")
	private WebElement countrySelector;

    @FindBy(xpath="//*[@id='StateProvinceId']")
	private WebElement StateProvinceId;

    
    @FindBy(xpath="//*[@class='zip-input']")
	private WebElement postalinput;


    @FindBy(xpath="//*[@class='button-2 estimate-shipping-button']")
    private WebElement shippingEstimatebtn;
   
    @FindBy(xpath="//*[@id='termsofservice']")
	private WebElement agreeBtn;

    @FindBy(xpath="//*[@id='checkout']")
  	private WebElement checkOutBtn;
  
	public void removeProduct() {
		clickElement(removeBtn);
		clickElement(updateCartBtn);
	}
	public String getSummaryMsg() {
		String msg=getElementText(orderSummaryMsg ); 
		return msg;
	}
	
	
	
	public void countrySelector() {
		
		WebElement dropdown=countrySelector;
		Select staticDropdown= new Select(dropdown);
		staticDropdown.selectByVisibleText("India");
		
		}
	
	
	
}




