package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img")
	WebElement productResult;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/select")
	WebElement categoryDropdown;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/select/option[23]")
	WebElement lgCategory;
	
	@FindBy(xpath = "//*[@id=\"button-search\"]")
	WebElement advancedSearchBtn;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div/div/div[1]/a")
	WebElement productWithSpecifiedCategoryResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(driver, productResult);
		return new AddToCartPage();
	}
	
	public boolean isProductWithGivenCategoryAvailable() {
		Action.click(driver, categoryDropdown);
		Select select = new Select(categoryDropdown);
		select.selectByValue("1571");
		Action.click(driver, advancedSearchBtn);
		
		return Action.isDisplayed(driver, productWithSpecifiedCategoryResult);
	}

}
