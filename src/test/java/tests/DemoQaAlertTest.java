package tests;

import org.testng.annotations.Test;

import pages.DemoQaPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DemoQaAlertTest {
	/*case 1
	go to https://demoqa.com/alerts
	Click on the ClickMe button for the first Alert, getText then verify the text is
	“You clicked a button” and Accept the alert.
	Test case 2
	go to https://demoqa.com/alerts
	Click on the ClickMe button for the second Alert, getText then verify the text is
	“This alert appeared after 5 seconds” and Accept the alert.
	Test case 3
	go to https://demoqa.com/alerts
	Click on the ClickMe button for the third Alert, getText then verify the text is
	“Do you confirm action?” and Dismiss the alert.
	Test case 4
	go to https://demoqa.com/alerts Click on the ClickMe button for the last Alert, getText then verify the
	text is “Please enter your name” then enter your name and accept..*/
	
	DemoQaPage demoQaPage = new DemoQaPage();
	BrowserUtils utils = new BrowserUtils();
	
  @Test
  public void firstAlertTest(){
	  String expectedAlertText = "You clicked a button";
	  demoQaPage.firstClickMeBtn.click();
	  utils.switchToAlert();
	  
	  String actualAlertText = utils.alertGetText();
	  Assert.assertEquals(actualAlertText, expectedAlertText);
	  utils.alertAccept();
  }
  
  @Test
  public void secondAlertTest(){
	  String expectedAlertText = "This alert appeared after 5 seconds";
	  demoQaPage.secondClickMeBtn.click();
	  utils.waitUntilAletIsPresent();
	  utils.switchToAlert();
	  
	  String actualAlertText = utils.alertGetText();
	  Assert.assertEquals(actualAlertText, expectedAlertText);
	  utils.alertAccept();
  }
  
  @Test
  public void thirdAlertTest(){
	  String expectedAlertText = "Do you confirm action?";
	  demoQaPage.thirdClickMeBtn.click();
	  utils.switchToAlert();
	  String actualAlertText = utils.alertGetText();
	  Assert.assertEquals(actualAlertText, expectedAlertText);
	  utils.alertDismiss();
  }
  
  @Test
  public void fourthAlertTest() throws InterruptedException {
	  String expectedAlertText = "Please enter your name";
	  demoQaPage.fourthClickMeBtn.click();
	  utils.switchToAlert();
	  
	  Thread.sleep(3000);
	  String actualAlertText = utils.alertGetText();
	  Assert.assertEquals(actualAlertText, expectedAlertText);
	 
	  utils.sendKeysOnAlert("Jane");
	  Thread.sleep(10000);
	  utils.alertAccept();
	  Thread.sleep(4000);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver().get(PropertiesReader.getProperty("demoqaURL"));
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.getDriver().quit();
  }

}
