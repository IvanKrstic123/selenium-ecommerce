package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{

	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr[2]/td[4]")
	WebElement unitPrice;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[2]/td[2]")
	WebElement totalPrice;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
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
	
	
	
}
