package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSearchDataDrivenTest {
  @Test(dataProvider = "myDataBucket")
  public void test(String input) {
	  AmazonHomePage amazonHP = new AmazonHomePage();
	  BrowserUtils utils = new BrowserUtils();
	  
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  Assert.assertTrue(amazonHP.searchBox.isDisplayed());
	  amazonHP.searchBox.sendKeys(input);
	  amazonHP.searchButton.click();
	  
	  utils.waitUntilElementIsVisible(amazonHP.serchResultBar);
	  
	  String actualResultText = amazonHP.serchResultBar.getText();
	  String subStringOfActualText = actualResultText.substring(1, actualResultText.length()-1);
	  Assert.assertEquals(subStringOfActualText, input);
  }
  
  @DataProvider
  public String[] myDataBucket() {
	  String[] mydata = new String[5];
	  
	  mydata[0] = "coffee mug";
	  mydata[1] = "pretty coffee mug";
	  mydata[2] = "cool coffee mug";
	  mydata[3] = "cute coffee mug";
	  mydata[4] = "ugly coffee mug";
	  
	  return mydata;
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.getDriver().quit();
  }

}
