package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void loginTest() {
		indexPage = new IndexPage();
		loginPage =  indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		String actualURL = homePage.getCurrentURL();
		String expectedURL = "https://www.neptun.rs/account";

		assertEquals(actualURL, expectedURL);
	}
	
	@Test
	public void loginTestNotAuthorizedTest() {
		indexPage = new IndexPage();
		loginPage =  indexPage.clickOnSignIn();
		homePage = loginPage.login("some email", "some password");
		
		String actualURL = homePage.getCurrentURL();
		String expectedURL = "https://www.neptun.rs/login";

		assertEquals(actualURL, expectedURL);
	}
	
	@Test
	public void clickOnCreateAccountTest() {
		indexPage = new IndexPage();
		loginPage =  indexPage.clickOnSignIn();
		accountCreationPage = loginPage.clickOnCreateNewAccount();
		
		String actualURL = accountCreationPage.getCurrentURL();
		String expectedURL = "https://www.neptun.rs/register";

		assertEquals(actualURL, expectedURL);
	}
}
