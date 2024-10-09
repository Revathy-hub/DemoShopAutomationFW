package com.demoshop.utils;

import com.github.javafaker.Faker;

public class DataUtils {
public static String firstName, lastName, uniqueEmail, password;
	
	public static void initUserData() {
		Faker faker= new Faker();
		firstName= faker.name().firstName();
		lastName= faker.name().lastName();
	    uniqueEmail = faker.internet().emailAddress();
		password= faker.internet().password();
	}
}

