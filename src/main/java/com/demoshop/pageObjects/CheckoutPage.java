package com.demoshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demoshop.utils.PageActions;

public class CheckoutPage extends PageActions{
	
	
	private WebDriver driver;
	public CheckoutPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);	
}

@FindBy(css=".inputs select#BillingNewAddress_CountryId")
private WebElement BcountrySelector;

@FindBy(css="#BillingNewAddress_City")
private WebElement BcitySelector;

@FindBy(css="#BillingNewAddress_Address1")
private WebElement BAddress1;

@FindBy(css="#BillingNewAddress_ZipPostalCode")
private WebElement Bpostalcode;

@FindBy(css="#BillingNewAddress_PhoneNumber")
private WebElement Bphonenum;

@FindBy(css="[onclick=\"Billing.save()\"]")
private WebElement BcountinueBtn1;

@FindBy(css="[onclick=\"Shipping.save()\"]")
private WebElement BcountinueBtn2;

@FindBy(css="[onclick=\"ShippingMethod.save()\"]")
private WebElement BcountinueBtn3;

@FindBy(css="[onclick=\"PaymentMethod.save()\"]")
private WebElement BcountinueBtn4;

@FindBy(css="[onclick=\"PaymentInfo.save()\"]")
private WebElement BcountinueBtn5;

@FindBy(css="[onclick=\"ConfirmOrder.save()\"]")
private WebElement ConfirmBtn;

@FindBy(xpath="//*[contains(text(),'Your order has been successfully processed!')]")
private WebElement ConfirmMsg;

public void setBillingData(String country, String city, String address1, String postalcode, String Phonenumber) throws InterruptedException {
	setTextBox(BcountrySelector,country );
	setTextBox(BcitySelector,city );
	setTextBox(BAddress1,address1);
	setTextBox(Bpostalcode,postalcode );
	setTextBox(Bphonenum, Phonenumber );
	clickElement(BcountinueBtn1);
}
	public void continueShip() {
		waitUntilClickable(BcountinueBtn2);
	clickElement(BcountinueBtn2);
	waitUntilClickable(BcountinueBtn3);
	clickElement(BcountinueBtn3);
	waitUntilClickable(BcountinueBtn4);
	clickElement(BcountinueBtn4);
	waitUntilClickable(BcountinueBtn5);
	clickElement(BcountinueBtn5);
	waitUntilClickable(ConfirmBtn);
	clickElement(ConfirmBtn);
	
}


@FindBy(css="#PickUpInStore")
private WebElement pickupBtn;


public void billingCountryselector(String country) {
	WebElement dropdown=BcountrySelector;
	Select staticDropdown= new Select(dropdown);
	staticDropdown.selectByVisibleText(country);
	}

public void cityselector(String city) {
	setTextBox(BcitySelector,city);
}

public String getconfirm() {
	waitUntilVisible(ConfirmMsg);
	String msg=getElementText(ConfirmMsg); 
	return msg;
}



}
