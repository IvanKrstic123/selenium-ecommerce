package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Regression")
	public void checkTotalPrice() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("lg");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.proceedToCheckout();
		
		Assert.assertEquals(orderPage.getCurrentURL(),  "https://www.neptun.rs/index.php?route=checkout/checkout");
	}
}
