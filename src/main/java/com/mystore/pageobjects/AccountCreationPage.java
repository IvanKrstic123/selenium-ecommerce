package com.mystore.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

import shared.SharedMethods;

public class AccountCreationPage extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;

	@FindBy(xpath = "//h1[text()='Registrujte nalog']")
	WebElement formTitle;

	@FindBy(xpath = "//*[@id=\"input-firstname\"]")
	WebElement name;

	@FindBy(xpath = "//*[@id=\"input-lastname\"]")
	WebElement surname;

	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"input-telephone\"]")
	WebElement telephone;

	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"input-confirm\"]")
	WebElement repeatPassword;

	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	WebElement accountCreationHeading;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input")
	WebElement submitRegistration;
	
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[2]")
	WebElement accountDetailsBtn;
	
	// PROFILE DETAILS
	
	@FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset/div[1]/div/input")
	WebElement fName;

	@FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset/div[2]/div/input")
	WebElement lName;

	@FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset/div[3]/div/input")
	WebElement eMail;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset/div[4]/div/input")
	WebElement phoneNumb;
	

	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateAccountCreationForm() {
		return Action.isDisplayed(driver, formTitle);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public HomePage createAccount() throws InterruptedException {
		SharedMethods sharedMethods = new SharedMethods();
		
		Action.type(name, sharedMethods.generateNameAndSurname());
		Action.type(surname, sharedMethods.generateNameAndSurname());
		Action.type(email, sharedMethods.generateFakeEmail());
		Action.type(telephone, sharedMethods.generatePhoneNumber());
		Action.type(password, prop.getProperty("password"));
		Action.type(repeatPassword, prop.getProperty("password"));
		
		Thread.sleep(16000);
		Action.click(driver, submitRegistration);
		
		return new HomePage();
	}
	
	public boolean createAccountAndCheckProfileDetails() throws InterruptedException  {
		SharedMethods sharedMethods = new SharedMethods();

		// saving data to compare with 
		String firstname = sharedMethods.generateNameAndSurname();
		String lastname = sharedMethods.generateNameAndSurname();
		String emailAddress = sharedMethods.generateFakeEmail();
		String phoneNumber = sharedMethods.generatePhoneNumber();
		String psw =  prop.getProperty("password");
		
		Action.type(name, firstname);
		Action.type(surname, lastname);
		Action.type(email, emailAddress);
		Action.type(telephone, phoneNumber);
		Action.type(password, psw);
		Action.type(repeatPassword, psw);
		
		Thread.sleep(16000);
		Action.click(driver, submitRegistration);
		
		// Navigate to Profile Page
		Action.click(driver, accountDetailsBtn);	
		
		if (firstname.equals(fName.getAttribute("value")) && lastname.equals(lName.getAttribute("value")) && emailAddress.equals(eMail.getAttribute("value")) && phoneNumber.equals(phoneNumb.getAttribute("value"))) {
			return true;
		}
		else {
			return false;
		}
	}
}
