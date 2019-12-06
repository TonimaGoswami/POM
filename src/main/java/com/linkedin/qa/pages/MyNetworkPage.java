package com.linkedin.qa.pages;

import com.linkedin.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyNetworkPage extends TestBase{

	@FindBy(id= "ember1389")
	WebElement connectionLabel;
	
	@FindBy(xpath="//span[contains(text(),'Manage')]")
	WebElement manageLink;
	
}
