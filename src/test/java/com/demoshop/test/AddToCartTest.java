package com.demoshop.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

	@Test
	public void CheckWhetherUserIsAbleToAddaSearchedProductToCart() throws InterruptedException {
		
		productspage.searchProduct(prop.getProperty("AddToCartProduct1"));
		productspage.addProductToCart();
		
		productspage.viewcart();
	
		
		List<String> productNamesList2 =productspage.getCartProductList();
		System.out.println(productspage.getCartProductList());
		boolean istextMatched= true;
		for(String productName : productNamesList2) {
			if(!productName.contains(prop.getProperty("AddToCartProduct1"))) {
				istextMatched=false;
				break;
			}
		}
		
		Assert.assertTrue(istextMatched, "Product is not added to cart");
	}

	}
	// String actualcount=productspage.cartCount();
	// Assert.assertEquals(actualcount, 1,"Product is not added to cart");



	
	
	
	
	
	
	
	
