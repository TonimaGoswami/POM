package com.linkedin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.pages.HomePage;
import com.linkedin.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
	}
	
	@Test(priority=2)
	public void loginPageLogoTest() {
		Assert.assertTrue(loginpage.validateLinkedInImage());
		
	}
	
	@Test(priority=3)
	public void LoginTest() {
		homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
