package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement proceedToCheckOut;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		Action.click(driver, proceedToCheckOut);
		return new PaymentPage();
	}

}
