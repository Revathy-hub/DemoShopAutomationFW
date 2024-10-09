package com.demoshop.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static Properties getProperties() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\DemoWebShopFrameWork\\src\\main\\resources\\config\\config.properties");
		prop.load(fis);
		return prop;
	}
}