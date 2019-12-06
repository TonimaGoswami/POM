package com.linkedin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.linkedin.qa.base.TestBase;



public class LoginPage extends TestBase {

	// Page Factory : Object repository
	@FindBy(name ="session_key")
	WebElement username;
	
	@FindBy(name ="session_password")
	WebElement password;
	
	@FindBy(css ="button.sign-in-form__submit-btn")
	WebElement LoginBtn;
	
	@FindBy(linkText="Join now")
	WebElement JoinNowLink ;
	
	@FindBy(css = "a.nav__logo-link")
	WebElement Logo;
	
	// initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions (methods)
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLinkedInImage() {
		return Logo.isDisplayed();
	}
	
	public HomePage Login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		LoginBtn.click();
		
		return new HomePage();
	}
	
}
