package com.mystore.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Index;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	HomePage homePage;
	
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup() {
		launchApp();
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Sanity")
	public void displayAccountCreationFormTest() { 
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.clickOnCreateNewAccount();
		
		boolean result = accountCreationPage.validateAccountCreationForm();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Sanity")
	public void createUserAccountTest() throws InterruptedException {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.clickOnCreateNewAccount();
		HomePage homePage = accountCreationPage.createAccount();
		
		String actualUrl = homePage.getCurrentURL();
		String expectedString = "https://www.neptun.rs/index.php?route=account/success";
		
		assertEquals(actualUrl, expectedString);
	}
	
	@Test(groups = "Sanity")
	public void compareRegistrationAndProfileDetails() throws InterruptedException {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.clickOnCreateNewAccount();
		boolean result = accountCreationPage.createAccountAndCheckProfileDetails();
		
		assertTrue(result);
	}
	
}
