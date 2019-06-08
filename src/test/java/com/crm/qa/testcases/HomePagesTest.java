package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.ResultsPage;
import com.crm.qa.util.TestUtil;



public class HomePagesTest extends TestBase {
		HomePage homePage;
		ResultsPage resultPage;
	
		public String SheetName = "TestData";
		public HomePagesTest() {
			super();
		}
		@BeforeMethod
		public void setUp() {
			initialization();
			homePage = new HomePage();
		}
		
		@DataProvider
		public Object[][] getTestData() {
			Object Data[][] = TestUtil.getTestData(SheetName);
			return Data;
		}
		
		@Test (priority=1)
		public void homepageTitleTest() {
			String Title = homePage.validateHomePage();
			Assert.assertEquals(Title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		}
		
		@Test (priority=2)
		public void logoimageTest() {
			Boolean logoTest = homePage.validateLogo();
			Assert.assertTrue(logoTest);
		}
		
		@Test (priority=3, dataProvider="getTestData")
		public void searchTermTest(String search) {
			resultPage = homePage.searchATerm(search);
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
