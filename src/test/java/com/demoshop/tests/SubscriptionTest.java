package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoshop.utils.UniqueGenerator;
public class SubscriptionTest extends BaseTest {

	@Test(groups="Smoke")
	public void verifyUserIsAbleToSubscribeWithValidEmail() throws InterruptedException {

		String actualSubscriptionMsg = loginPage.verifyNewsLetterEmail(UniqueGenerator.getUniqueEmail(), prop.getProperty("subscriptionMsg"));
		System.out.println(actualSubscriptionMsg );
		Assert.assertEquals(actualSubscriptionMsg , prop.getProperty("subscriptionMsg"));
	}
}