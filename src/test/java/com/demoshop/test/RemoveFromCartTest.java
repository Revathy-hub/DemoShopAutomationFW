package com.demoshop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObjects.CartElementsPage;

public class RemoveFromCartTest extends BaseTest{
	@Test
	public void verfyWhetherUserIsAbleToRemoveAProductFromCart() {
		
		productspage.searchProduct(prop.getProperty("AddToCartProduct1"));
		productspage.addProductToCart();
		
		productspage.viewcart();
		cartEle.removeProduct();
	
		String actualtext=cartEle.getSummaryMsg();
String expectedtext=prop.getProperty("SummaryMsg");

Assert.assertEquals(actualtext, expectedtext, "Product is not Removed");
}
}