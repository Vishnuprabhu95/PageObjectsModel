package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ResultsPage extends TestBase {

		//Factory Objects - Object Repository
		@FindBy(xpath = "//span[contains(text(),'shoe')]")
		WebElement SearchTermCheck;
		
		@FindBy(xpath = "//div[@class='s-expand-height s-include-content-margin s-border-bottom']/div/div[2]/div[2]/div/div/h2/a/span")
		WebElement FirstResult;
		
		
		//Initializing Page Objects
			public ResultsPage() {
				
				PageFactory.initElements(driver, this);
				
			}
		
			
		//Actions
		public String validatesearch() {
			return SearchTermCheck.getText();	
		}
		
		public String getFirstResult() {
			return FirstResult.getText();	
		}
}
