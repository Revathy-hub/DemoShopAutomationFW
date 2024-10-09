package com.demoshop.test;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import model.Person;

public class RegisterationDP2 extends BaseTest {
	@Test(dataProvider="getData")
	public void verifyUserIsAbleToMultipleRegisterUsingCorrectCreds(List<Person> personList) {
      
		 personList.forEach(person->{
			 System.out.println(person);
				loginPage.navigateToRegisterationSection();
				registerPage.setUserData(person.fName, person.lName,person.email, person.password);
			    String expectedEmail = loginPage.getLoggedEmail();
				Assert.assertEquals(person.email, expectedEmail, "Registered email is differents");
				
				registerPage.logout();
				loginPage.navigateToRegisterationSection();
		 });
		
	
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Faker faker= new Faker();
		String password= faker.internet().password();
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), password, password));
		personList.add(new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), password, password));
		return new Object[][] {
			{personList}
		};
		
	}
	
}

