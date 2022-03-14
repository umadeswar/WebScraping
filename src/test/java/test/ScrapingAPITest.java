package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import initialise.InitialiseDriver;
import pageobjects.WebScrapingObjects;
import utils.ExcelUtils;
import utils.Helper;
import config.ScrapingConfig;
//import extentreports.ExtentReportsClass;
public class ScrapingAPITest {//extends ExtentReportsClass  {
//	InitialiseDriver inialise = new InitialiseDriver();
//	WebDriver driver = InitialiseDriver.driver;
//	WebScrapingObjects pageObj = new WebScrapingObjects(driver);
//
//	Helper helper = new Helper(driver);
	
	@Test
	public void scrapeData() throws InterruptedException, IOException {

		InitialiseDriver.initialiseDriver();
		 WebDriver  driver = InitialiseDriver.driver;
		 WebScrapingObjects pageObj = new WebScrapingObjects(driver);

			Helper helper = new Helper(driver);
		
		pageObj.setInputWhat(ScrapingConfig.API_SEARCH_KEYWORD);
		helper.waitInSec(2000);
		pageObj.setInputWhere("Remote");
		helper.waitInSec(2000);
		pageObj.clickSearch();
		helper.waitInSec(2000);
		//pageObj.clickDatePosted();
		//helper.waitInSec(1000);
		//pageObj.clickTime();
		//helper.waitInSec(1000);
		try {
			pageObj.closeAlert();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		pageObj.scrapeAllData("files/WebScrapingAPINew.xlsx",ScrapingConfig.API_SEARCH_KEYWORD);
		
		
	}
}
