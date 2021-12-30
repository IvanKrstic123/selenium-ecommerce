package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")
	WebElement unitPrice;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")
	WebElement totalPrice;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement proceedToCheckOut;
	
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String nonFormatedPrice = unitPrice.getText();
		String formatedPrice = nonFormatedPrice.replace(".", "").replace(",", ".").replace("Din", "");
		double result = Double.parseDouble(formatedPrice);
		
		return result;
	}
	
	public double getTotalPrice() {
		String nonFormatedPrice = totalPrice.getText();
		String formatedPrice = nonFormatedPrice.replace(".", "").replace(",", ".").replace("Din", "");
		double result = Double.parseDouble(formatedPrice);
		
		return result;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.click(driver, proceedToCheckOut);
		return new LoginPage();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
}
