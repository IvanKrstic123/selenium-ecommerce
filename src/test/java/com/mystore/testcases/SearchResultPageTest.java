package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void productAvailabilityTest() {
		indexPage = new IndexPage();
		SearchResultPage searchResult = indexPage.searchProduct("LG");
		boolean result = searchResult.isProductAvailable();  
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void productAvailabilityWithCategoryTest() {
		indexPage = new IndexPage();
		SearchResultPage searchResult = indexPage.searchProduct("televizori");
		boolean result = searchResult.isProductWithGivenCategoryAvailable();
		
		Assert.assertTrue(result);
	}
	
	

}
