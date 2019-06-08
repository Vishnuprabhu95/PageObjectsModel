package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.ResultsPage;

public class ResultsPageTest extends TestBase {
	HomePage homePage;
	ResultsPage resultsPage;
	
	public ResultsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		
		resultsPage = homePage.searchATerm("shoes");
	}
	
	@Test
	public void checkTheSearchTerm() {
		
		String searchTerm = resultsPage.validatesearch();
		Assert.assertEquals(searchTerm,"\"shoes\"");
	}
	
	
	@Test
	public void firstSearchResult() {
	
		String firstResult = resultsPage.getFirstResult();
		System.out.println(firstResult);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
