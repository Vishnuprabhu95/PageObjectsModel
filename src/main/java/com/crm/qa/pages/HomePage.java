package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - Object Repository
	
	@FindBy(xpath = "//div[@class='welcome-msg']")
	@CacheLookup
	WebElement WelcomeMsg;
	
	@FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")
	WebElement Logo;
	 
	@FindBy(id = "twotabsearchtextbox")
	WebElement SearchBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement SearchButton;
	
	@FindBy(id = "//span[@class='nav-line-2']")
	WebElement OrderDD;
	
	@FindBy(id = "//span[@class='nav-text']")
	WebElement Signout;
	
	//Initializing Page Objects
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateHomePage() {
		return driver.getTitle();	
	}
	
	public Boolean validateLogo() {
		return Logo.isDisplayed(); 
	}
	
	public ResultsPage searchATerm(String term) {
		SearchBox.sendKeys(term);
		SearchButton.click();
		return new ResultsPage();
	}
}
