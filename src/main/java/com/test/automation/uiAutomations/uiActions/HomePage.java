package com.test.automation.uiAutomations.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signin;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signinbtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']/ol/li")
	WebElement athfailmessage;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

	public void loginToApplication( String uname, String pword){
		
		signin.click();
		log.info("Clicked on signin link");
		username.sendKeys(uname);
		log.info("Entered Username");
		password.sendKeys(pword);
		log.info("Entered Password");
		signinbtn.click();
		log.info("Clicked on signin button");
		
	}
	
	public String authFailedMessage(){
		log.info("Fetched error message");
		return athfailmessage.getText();
		
	}
	

}
