package com.mystore.pageobjects;

import java.util.List;

import javax.swing.plaf.basic.BasicArrowButton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;


public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement toggleToSingIn;
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement signInBtn;
	
	@FindBy(xpath = "//div[contains(@id,'logo')]/a")
	WebElement storeLogo;
	
	@FindBy(xpath = "//div[@id='search']/input")
	WebElement searchProductBox;
	
	@FindBy(xpath = "//*[@id=\"search\"]/span/button")
	WebElement searchButton;
	
	// adding products to cart
	// TV category
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr")
	List<WebElement> productsAddedToCartElements;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
	WebElement categoryTVs;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/div/ul/li[1]/a")
	WebElement categoryTVsAlpha;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]")
	WebElement addToCartTVBtn;

	// Appliances category
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[5]/a")
	WebElement categoryAppliances;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[5]/div/div/ul[1]/li[7]/a")
	WebElement categoryAppliancesMicrowave;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]")
	WebElement categoryAppliancesBeko;
	
	// Laptops category
	
	@FindBy(xpath = "/html/body/div[1]/nav/div[2]/ul/li[7]/a")
	WebElement categoryLaptops;
	
	@FindBy(xpath = "/html/body/div[1]/nav/div[2]/ul/li[7]/div/div/ul/li[1]/a")
	WebElement categoryLaptopsAcer;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]")
	WebElement categoryLaptopsAcer315;
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(driver, toggleToSingIn);
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(driver, storeLogo);
	}
	
	public String getStoreTitle() {
		return driver.getTitle();
	}
	
	public SearchResultPage searchProduct(String text) {
		Action.type(searchProductBox,text);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
	
	public int addToCartMultipleProductFromDiffGroups() throws InterruptedException {
		clickElement(driver, categoryTVs, categoryTVsAlpha, addToCartTVBtn);
		clickElement(driver, categoryAppliances, categoryAppliancesMicrowave, categoryAppliancesBeko);
		clickElement(driver, categoryLaptops, categoryLaptopsAcer, categoryLaptopsAcer315);
		
		Thread.sleep(1000);
		
		return productsAddedToCartElements.size();
	}
	
	private void clickElement(WebDriver driver, WebElement element, WebElement element1, WebElement element2) {
		Action.JSClick(driver, element);
		Action.JSClick(driver, element1);
		Action.JSClick(driver, element2);
	}
	
}
