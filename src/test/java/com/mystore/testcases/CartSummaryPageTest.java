package com.mystore.testcases;

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
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
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
		
		System.out.println(cartSummaryPage.getQuantity());

		Double expectedTotalPrice = cartSummaryPage.getUnitPrice() * cartSummaryPage.getQuantity();
		Double actualTotalPrice = cartSummaryPage.getTotalPrice();
		
		Assert.assertEquals(actualTotalPrice,  expectedTotalPrice);
	}


}
