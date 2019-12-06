package com.linkedin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.qa.base.TestBase;
import com.linkedin.qa.pages.ComposePage;
import com.linkedin.qa.pages.GroupConversationPage;
import com.linkedin.qa.pages.HomePage;
import com.linkedin.qa.pages.LoginPage;
import com.linkedin.qa.pages.MessagePage;

public class MessagePageTest extends TestBase {
		MessagePage messagePage;
		ComposePage composePage;
		LoginPage loginpage;
		HomePage homepage;
		GroupConversationPage groupConversationPage;
	
	public MessagePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		messagePage = new MessagePage();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		messagePage = homepage.clickOnMessagingLink();
	}
	
	@Test(priority=1)
	public void verifyMessageTest(){
		Assert.assertTrue(messagePage.verifyMessage());
	
	}
	
	@Test(priority=2)
	public void clickOnComposeButtonTest() {
		composePage = messagePage.clickOnComposeButton();
		
	}
	@Test(priority=3)
	public void selectMessageByNameTest() {
		messagePage.selectMessageByName();
		
	}
	
	@Test(priority=4)
	public void CheckGroupConversationIconTest() {
		messagePage.verifyGroupConversationIcon();
	}
	
	@Test(priority=5)
	public void SearchBoxVerificationTest() {
		messagePage.verifySearchBox();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
}


	
	
	
	
	
}
