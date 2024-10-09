package com.demoshop.utils;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {
	private WebDriver driver;
	public PageActions(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void setTextBox(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}


public List<String> getElementTextList(List<WebElement> listofElements) {
		
		List<String> textList = new ArrayList<>();
		for(WebElement element : listofElements) {
			textList.add(getElementText(element));
		}
	 return textList;
	}
	

public void handleStaticDrowpdown(WebElement dropdown, String visibleText) {
	  Select select = new Select(dropdown);
	  select.selectByVisibleText(visibleText);
	}
	
	
public void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}

