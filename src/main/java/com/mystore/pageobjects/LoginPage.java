package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement singInBtn;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/a")
	WebElement continueToRegistration;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String userEmail, String userPsw) {
		Action.type(email, userEmail);
		Action.type(password, userPsw);
		Action.click(driver, singInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String userEmail, String userPsw) {
		Action.type(email, userEmail);
		Action.type(password, userPsw);
		Action.click(driver, singInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount() {
		Action.click(driver, continueToRegistration);
		return new AccountCreationPage();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

}
