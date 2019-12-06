package com.linkedin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;

import com.linkedin.qa.pages.HomePage;
import com.linkedin.qa.pages.LoginPage;
import com.linkedin.qa.pages.MessagePage;


public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	MessagePage messagePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"LinkedIn");
		
	}

	@Test(priority=2)
	public void verifyCorrectUserImgTest() {
		Assert.assertTrue(homepage.verifyCorrectUserImg());
	}
	
	@Test(priority =3)
	public void clickOnMessagingLinkTest() {
		messagePage = homepage.clickOnMessagingLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
