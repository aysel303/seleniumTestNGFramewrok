package tests;

import org.testng.annotations.Test;

import pages.SeleniumEasyAlertPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class SeleniumEasyTests {
	SeleniumEasyAlertPage alertPage = new SeleniumEasyAlertPage();
	BrowserUtils utils = new BrowserUtils();
	
  @Test
  public void firstAlerTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumeasyalertURL"));
	  alertPage.firstAlertBtn.click();
	  
	  //calling the switchToAlert function
	  utils.switchToAlert();
	  utils.waitUntilAletIsPresent();
	  
	  String expectedMsg = "I am an alert box!";
	  
	  String actualMsg = utils.alertGetText();
	  Assert.assertEquals(actualMsg, expectedMsg);
	  Thread.sleep(4000);
	  utils.alertAccept();
  }
  @Test
  public void secondAlertTest() {
	  String expectedMsg = "Press a button!";
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumeasyalertURL"));
	  alertPage.secondAlertBtn.click();
	  utils.switchToAlert();
	  utils.waitUntilAletIsPresent();
	  String actualMsg = utils.alertGetText();
	  Assert.assertEquals(actualMsg, expectedMsg);
	  utils.alertDismiss();
	  
  }
  
  @Test
  public void thirdAlertTest() throws InterruptedException {
	  String expectedMsg = "Please enter your name";
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumeasyalertURL"));
	  alertPage.thirdAlertBtn.click();
	  utils.switchToAlert();
	  String actualMsg = utils.alertGetText();
	  Assert.assertEquals(actualMsg, expectedMsg);
	  
	  utils.sendKeysOnAlert("John");
	  Thread.sleep(3000);
	  utils.alertDismiss();
	  Thread.sleep(5000);
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
	  Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  
  @AfterTest
  public void afterTest() {
	  Driver.quitDriver();;
  }

}
