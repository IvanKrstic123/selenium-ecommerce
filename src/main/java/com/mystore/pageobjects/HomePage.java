package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//div[@class='list-group']/a[@href='https://www.neptun.rs/wishlist']")
	WebElement myWishList;
	
	@FindBy(xpath = "//div[@class='list-group']/a[@href='https://www.neptun.rs/index.php?route=account/order']")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishList() {
		return Action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	
}
