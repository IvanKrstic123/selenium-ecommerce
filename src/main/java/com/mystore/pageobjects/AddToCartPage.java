package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(name = "quantity")
	WebElement quantity;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id=\"product-product\"]/div[1]")
	WebElement addToCartMessage;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/button") 
	WebElement shoppingCart;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")
	WebElement proceedToCartSummary;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]")
	WebElement proceedToCheckOutBtn;

	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity1) {
		Action.type(quantity, quantity1);
	}
	
	public void clickOnAddToCart() throws InterruptedException {
		Action.click(driver, addToCartButton);
	}
	
	public boolean validateAddToCart() {
		return Action.isDisplayed(driver, addToCartMessage);
	}
	
	public CartSummaryPage proceedToCartSummary() {
		Action.JSClick(driver, shoppingCart);
		Action.JSClick(driver, proceedToCartSummary);
		return new CartSummaryPage();
	}  
	
	public OrderPage proceedToCheckout() {
		Action.JSClick(driver, shoppingCart);
		Action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
	
	public String getString() {
		return shoppingCart.getText();
	}
}
