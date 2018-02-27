package com.test.automation.uiAutomations.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.automation.uiAutomations.excelreader.Excel_Reader;

public class TestBase {
	
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browser = "chrome";
	Excel_Reader excel;

	public void init() {
		selectUrl(browser);
		getUrl(url);
	String log4jconfpath="log4j.properties";
	PropertyConfigurator.configure(log4jconfpath);
	
	}

	public void selectUrl(String browser) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/kavurichowdary/Desktop/Harsha1/Selenium Project/chromedriver");
			log.info("creating object"+browser);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/kavurichowdary/Desktop/Harsha1/Selenium Project/geckodriver");
			log.info("creating object"+browser);
			driver = new FirefoxDriver();

		}

	}

	public void getUrl(String url) {
		log.info("navigating to url"+ url);
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public String[][] getData(String excelName, String sheetName)
	
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/test/automation/uiAutomations/data/"+excelName;
		excel=new Excel_Reader(path);
		return excel.getDataFromSheet(sheetName, excelName);
		
	}

}

