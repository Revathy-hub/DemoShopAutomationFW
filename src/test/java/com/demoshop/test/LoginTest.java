package com.demoshop.test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoshop.pageObjects.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void verifyUserIsAbleToLoginWithValidCreds() {
		
		loginPage.navigateToLoginSection();
		
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
		String expectedEmail = loginPage.getLoggedEmail();
		
		System.out.println(expectedEmail);
		Assert.assertEquals(prop.getProperty("email"), expectedEmail, "Logged Email is not matching");

	}
}
	


