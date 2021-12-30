package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;


public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement toggleToSingIn;
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement signInBtn;
	
	@FindBy(xpath = "//div[contains(@id,'logo')]/a")
	WebElement storeLogo;
	
	@FindBy(xpath = "//div[@id='search']/input")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//*[@id=\"search\"]/span/button")
	WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(driver, toggleToSingIn);
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(driver, storeLogo);
	}
	
	public String getStoreTitle() {
		return driver.getTitle();
	}
	
	public SearchResultPage searchProduct(String text) {
		Action.type(searchProductBox,text);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
	
}
