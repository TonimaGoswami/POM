package com.linkedin.qa.pages;

import com.linkedin.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagePage extends TestBase{

	@FindBy(xpath = "//h1[contains(text(),'Messaging')]")
	WebElement messageLabel;
	
	@FindBy(xpath = "//li-icon[@type='compose-icon']")
	WebElement composeBtn;
	
	@FindBy(xpath="//div[@class='msg-messaging-container__create-group-convo-icon']")
	WebElement groupConversationIcon;
	
	@FindBy(xpath="//input[@class='search-global-typeahead__input']")
	WebElement searchBox;
	
	// Initializing the page objects
	
	public MessagePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions (methods)
	
	public boolean verifyMessage(){
		return messageLabel.isDisplayed();
		
	}
	
	public ComposePage clickOnComposeButton() {
		composeBtn.click();
		return new ComposePage();
	}
	
	public void selectMessageByName() {
		driver.findElement(By.xpath("//div[@class='msg-conversation-card__row pr2']/h3[text()='David Gordon']")).click();
		
	}
	public GroupConversationPage verifyGroupConversationIcon() {
		groupConversationIcon.click();
		return new GroupConversationPage();
	}
	
	public WebElement verifySearchBox() {
		searchBox.sendKeys("Priyanka");
		return driver.findElement(By.xpath("//div[@class='msg-conversation-card__row pr2']/h3[text()='komati priyanka']"));
		
		
	}
}

