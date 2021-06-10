package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.IndeedSearchPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class IndeedSearchTest {
  @Test(dataProvider = "dataBucket")
  public void indeedSearchTest(String jobTitle, String location) throws InterruptedException {
	  IndeedSearchPage indeedPage = new IndeedSearchPage();
	  BrowserUtils utils = new BrowserUtils();
	  SoftAssert softAssert = new SoftAssert();
	  
	  Driver.getDriver().get(PropertiesReader.getProperty("indeedURL"));
	  Thread.sleep(1000);
	  
	  indeedPage.whatField.sendKeys(jobTitle);
	  
	  utils.clearFieldByAttributeValue(indeedPage.whereField, "value");
	  
	  indeedPage.whereField.sendKeys(location);
	  indeedPage.findJobsBtn.click();
	  
	  utils.waitUntilElementIsVisible(indeedPage.jobLocation);
	  
	  Assert.assertTrue(indeedPage.jobLocation.getText().contains(location));
	  
	  for (WebElement jobs : indeedPage.jobTitleResultsList) {
		softAssert.assertTrue(jobs.getText().contains(jobTitle));
	}
	  softAssert.assertAll();
  }
  @DataProvider
  public String[][] dataBucket(){
	 return new String[][] {
			 {"SDET", "Washington, DC"},
			 {"UX Designer", "Chicago, IL"},
			 {"Web Developer","Pittsburgh, PA"},
			 {"Project Manager", "Reston, VA"}
	 };
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.quitDriver();
  }

}
