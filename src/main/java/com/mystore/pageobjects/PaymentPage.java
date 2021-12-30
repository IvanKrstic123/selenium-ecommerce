package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement proceedToConfirmation;
	
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummary clickOnProceedToConfirmation() {
		Action.click(driver, proceedToConfirmation);
		return new OrderSummary();
	}
}
