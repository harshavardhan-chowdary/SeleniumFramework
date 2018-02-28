package com.test.automation.uiAutomations.homepage;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomations.testbase.TestBase;
import com.test.automation.uiAutomations.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCradentiols extends TestBase {
	
	HomePage homepage;
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCradentiols.class.getName());
	@BeforeClass
	public void setUp()
	{
		
		init();
		homepage=new HomePage(driver);
		
	}
	
	@DataProvider(name="logindata")
	public String[][] getTestData()
	{
		String [][] testRecords=getData("LoginData.xlsx", "LoginTestData");
		return testRecords;
		
	}
	
	@Test(dataProvider="logindata")
	public void VerifyLoginWithInvalidCradentiols( String username, String password, String runMode){
	
	if(runMode.equalsIgnoreCase("y"))
	{
	
		log.info("====================STARTING TEST=====================");
		homepage.loginToApplication(username, password);
		
		Assert.assertEquals(homepage.authFailedMessage(), "Authentication failed.");
		getScreenShot("VerifyLoginWithInvalidCradentiols");
		log.info("====================Finished TEST=====================");
	}
	else
	{
		log.info("skipped");
	}}
	
	@AfterClass
	public void endTest()
	{
		driver.close();
	}

}
