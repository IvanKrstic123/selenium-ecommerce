package com.mystore.testcases;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void wishListTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
		boolean resut = homePage.validateMyWishList();
		
		Assert.assertTrue(resut);
	}
	
	@Test
	public void orderHistoryTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
		boolean resut = homePage.validateOrderHistory();
		
		Assert.assertTrue(resut);
	}

}
