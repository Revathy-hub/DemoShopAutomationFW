package com.demoshop.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class Productspage extends PageActions {
private WebDriver driver;
	
	public Productspage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='small-searchterms']")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[@class='button-1 search-box-button']")
		private WebElement searchBtn;
	
	
	@FindBy(xpath="//*[@class='cart-qty']")
	private WebElement cartQty;
	
	
	@FindBy(xpath="//*[@class=\"button-2 product-box-add-to-cart-button\"]")
	private WebElement addToCartBtn;
	
			
	@FindBy(css=".product-title a")
	private List<WebElement> productList;
	
	@FindBy(linkText=("Shopping cart"))
	private WebElement shoppingCartBtn;
	
	public void navigateToCart() {
		clickElement(shoppingCartBtn);
	}
	
	public List<String> getSearchedProductList() {
		return getElementTextList(productList);
	}
	

	public void searchProduct(String productName) {
		setTextBox(searchBox, productName);
		clickElement(searchBtn);
		
	}
	
	public void addProductToCart() {
		clickElement(addToCartBtn);
	}
	
	public void viewcart() {
		clickElement(shoppingCartBtn);
	}
	
	@FindBy(xpath="//*[@class='product-name']")	
	private List<WebElement> cartIetemList;
	
	
	public List<String> getCartProductList() {
		return getElementTextList(cartIetemList);
	}

	public String cartCount() {
		waitUntilVisible(cartQty);
		String count=getElementText( cartQty); 
	return count;
	}

}



