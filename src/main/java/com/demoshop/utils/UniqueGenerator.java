package com.demoshop.utils;

import com.github.javafaker.Faker;

	public class UniqueGenerator {

		public static String getUniqueEmail() {
			Faker faker= new Faker();
			return  faker.internet().emailAddress();
		}
	}