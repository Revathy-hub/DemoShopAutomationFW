package com.demoshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoshop.utils.PageActions;

public class RegisterPage extends PageActions {

	private WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="gender-male")
	private WebElement genderMale;
	
	@FindBy(id="FirstName")
	private WebElement firstName;
	
	@FindBy(id="LastName")
	private WebElement lastName;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="register-button")
	private WebElement registerBtn;
	
	@FindBy(css = ".ico-logout")
	private WebElement logoutBtn;
	
	public void setUserData(String fName, String lName, String emailVal, String passVal) {
		clickElement(genderMale);
		setTextBox(firstName,fName );
		setTextBox(lastName,lName );
		setTextBox(email,emailVal);
		setTextBox(password,passVal );
		setTextBox(confirmPassword,passVal );
		clickElement(registerBtn);
	}
	public void logout() {
		clickElement(logoutBtn);
	}



}