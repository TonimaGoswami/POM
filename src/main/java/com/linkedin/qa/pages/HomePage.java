package com.linkedin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//img[@id='ember28']")
	WebElement userImg;
	
	@FindBy(xpath="//span[contains(text() ,'My Network')]")
	WebElement myNetworkLink;
	
	@FindBy(xpath="//span[contains(text() ,'Jobs')]")
	WebElement jobsLink;
	
	@FindBy(xpath="//span[contains(text() ,'Messaging')]")
	WebElement messagingLink;
	
	
	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions (methods)
	
	public String verifyHomePageTitle()  {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserImg() {
		return userImg.isDisplayed();
	}
	
	public MessagePage clickOnMessagingLink() {
		messagingLink.click();
		return new MessagePage();
	}
	
	public MyNetworkPage clickOnMyNetworkLink() {
		myNetworkLink.click();
		return new MyNetworkPage();
	}
	public JobsPage clickOnJobsLink() {
		jobsLink.click();
		return new JobsPage();
	}
	
}
