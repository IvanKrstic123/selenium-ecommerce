package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.CartSummaryPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class CartSummaryPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	CartSummaryPage cartSummaryPage;;
	
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void checkTotalPrice() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("lg");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		cartSummaryPage = addToCartPage.proceedToCartSummary();

		Double expectedTotalPrice = cartSummaryPage.getUnitPrice() * cartSummaryPage.getQuantity();
		Double actualTotalPrice = cartSummaryPage.getTotalPrice();
		
		Assert.assertEquals(actualTotalPrice,  expectedTotalPrice);
	}
	
	@Test
	public void clickOnCheckOut() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("lg");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		cartSummaryPage = addToCartPage.proceedToCartSummary();
		
		Double expectedTotalPrice = cartSummaryPage.getUnitPrice() * cartSummaryPage.getQuantity();
		Double actualTotalPrice = cartSummaryPage.getTotalPrice();
		
		OrderPage orderPage = cartSummaryPage.proceedToCheckOut();
		
		Assert.assertEquals(actualTotalPrice,  expectedTotalPrice);
		assertEquals(orderPage.getCurrentURL(), "https://www.neptun.rs/index.php?route=checkout/checkout");
	}
}
