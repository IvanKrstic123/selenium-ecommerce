package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	@FindBy(xpath = "//h1[text()='Registrujte nalog']")
	WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreatePage() {
		return Action.isDisplayed(driver, formTitle);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	
	

}
