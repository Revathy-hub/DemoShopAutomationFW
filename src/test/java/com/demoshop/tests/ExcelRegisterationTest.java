package com.demoshop.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pageObjects.LoginPage;
import com.demoshop.pageObjects.RegisterPage;
import com.demoshop.utils.DataUtils;
import com.github.javafaker.Faker;
public class ExcelRegisterationTest extends BaseTest {

	@Test
	public void verifyUserIsAbleToRegisterUsingCorrectCreds() {
		
		loginPage.navigateToRegisterationSection();
		DataUtils.initUserData();
		registerPage.setUserData(DataUtils.firstName, DataUtils.lastName, DataUtils.uniqueEmail, DataUtils.password);
	    String expectedEmail = loginPage.getLoggedEmail();
		Assert.assertEquals(DataUtils.uniqueEmail, expectedEmail, "Registered email is differents");
		
	}
}


