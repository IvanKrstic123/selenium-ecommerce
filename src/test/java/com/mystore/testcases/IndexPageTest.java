package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class IndexPageTest extends BaseClass{
	
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
	public void verifyLogo() {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() {
		String actualTitleString = indexPage.getStoreTitle();
		assertEquals(actualTitleString, "NEPTUN SHOP - Internet prodavnica tehnike");
	}
}
