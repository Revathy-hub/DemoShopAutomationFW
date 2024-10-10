package com.demoshop.tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoshop.pageObjects.Productspage;

public class SearchTest extends BaseTest {
	
	
	
	@Test
			public void verifyUserIsAbletoSearchDesiredProducts() {
				productspage.searchProduct(prop.getProperty("productToSearch"));
				List<String> productNamesList = productspage.getSearchedProductList();
				
				boolean istextMatched= true;
				for(String productName : productNamesList) {
					if(!productName.contains(prop.getProperty("productToSearch"))) {
						istextMatched=false;
						break;
					}
				}
				
				Assert.assertTrue(istextMatched, "Product is not matching");
			}
	
	
	}
