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

import io.github.bonigarcia.wdm.managers.VoidDriverManager;

public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
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
		orderPage = addToCartPage.proceedToCheckout();
//TBD
//		Double expectedTotalPrice = orderPage.getUnitPrice() * 2;
//		Double actualTotalPrice = orderPage.getTotalPrice();
//		
//		Assert.assertEquals(actualTotalPrice,  expectedTotalPrice);
	
		
	}

	
}
