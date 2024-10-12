package com.demoshop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import com.github.javafaker.Faker;

	public class UniqueGenerator {

		public static String getUniqueEmail() {
			Faker faker= new Faker();
			return  faker.internet().emailAddress();
		}
		public static int randomNumber() {
			Random rand = new Random();
			int randonNum = rand.nextInt(1000);
			return randonNum;
		}
		
		public static String getCurrentDateTime() {
			String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());  
			  return date.replaceAll("[^0-9]", "");
		    
		}
	}