package com.demoshop.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.utils.DataUtils;
import com.github.javafaker.Faker;

public class E2ECheckoutTest extends BaseTest{

		
		@Test(groups="Smoke")
		public void verifyNewUserRegistersAndCheckoutProduct() throws InterruptedException {
			//Registering user
			DataUtils.initUserData();
		    loginPage.navigateToRegisterationSection();
			registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
		    String expectedEmail = loginPage.getLoggedEmail();
			Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
			//Searching a product
			productspage.searchProduct(prop.getProperty("AddToCartProduct1"));
			List<String> productNamesList = productspage.getSearchedProductList();
			
			boolean istextMatched= true;
			for(String productName : productNamesList) {
				if(!productName.contains(prop.getProperty("AddToCartProduct1"))) {
					istextMatched=false;
					break;
				}
			}
			
			Assert.assertTrue(istextMatched, "Product is not matching");
		
		
		//Adding product to cart
         productspage.addProductToCart();
         Thread.sleep(2000);
		
		productspage.viewcart();
	
		List<String> productNamesList2 =productspage.getCartProductList();
		System.out.println(productspage.getCartProductList());
		boolean istextMatched2= true;
		for(String productName : productNamesList2) {
			if(!productName.contains(prop.getProperty("AddToCartProduct1"))) {
				istextMatched2=false;
				break;
			}
		}
		
		Assert.assertTrue(istextMatched2, "Product is not added to cart");
	
		cartEle.checkout();
		
		Faker faker= new Faker();
		String country= faker.address().country();
		String city=faker.address().city();
		String address1=faker.address().streetAddress();
		String postalcode=faker.address().zipCode();
		String Phonenumber=faker.phoneNumber().phoneNumber();
		
		checkoutpage.setBillingData(country, city, address1, postalcode, Phonenumber);
		checkoutpage.continueShip();
		String expectedtext=prop.getProperty("msg");
		String actualtext=checkoutpage.getconfirm();
		Assert.assertEquals(actualtext, expectedtext, "Checkout Failed");
		

}
		
}