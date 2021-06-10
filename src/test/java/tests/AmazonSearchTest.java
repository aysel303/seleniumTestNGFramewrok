package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTest {
	AmazonHomePage amazonHP;
	BrowserUtils utils = new BrowserUtils();
  @Test
  public void amazonSearchTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  amazonHP.searchBox.sendKeys("coffee mug");
	  amazonHP.searchButton.click();
	  Thread.sleep(4000);
  }
  
  @Test
  public void amazonDropDownTest() {
	  	/*
		 * go to amazon.com
		 * get all the options in the departments select dropdown
		 * verify there are total 59 departments. And print them out.
		 */
	 // int expectedNumOfDepartments = 60;
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  Select dropdownbox = new Select(amazonHP.selectDropDown);
	  List<WebElement> selectDepartments = dropdownbox.getOptions();
	  //System.out.println(selectDepartments.size());
	  	int actualNumOfDepartments = selectDepartments.size();
	  //Assert.assertEquals(actualNumOfDepartments, expectedNumOfDepartments);
	  System.out.println(actualNumOfDepartments);
	  for (WebElement department : selectDepartments) {
		System.out.println(department.getText());
	}
	  	
  }
  
  @Test
  public void AmazonHomeAndKitchenTest() {
	  /*
	   * go to amazon.com
		verify that you are on the amazon home page. (verify with title).
		verify dropdown value is by default “All Departments”
		select department Home & Kitchen, and search coffee mug.
		verify you are on coffee mug search results page (use title).
		verify you are in Home & Kitchen department.
	   */
	  String homePageTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	  String expectedFirstOption = "All Departments";
	  String searchPageTitle = "Amazon.com : coffee mug";
	  
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  String actualHomePageTitle = Driver.getDriver().getTitle();
	  Assert.assertEquals(actualHomePageTitle, homePageTitle);
	  
	  Select dropdownbox = new Select(amazonHP.selectDropDown);
	  String actualFirstOption = dropdownbox.getFirstSelectedOption().getText();
	  Assert.assertEquals(actualFirstOption, expectedFirstOption);
	  
	 // amazonHP.selectOption();
	  amazonHP.searchBox.sendKeys("coffee mug");
	  amazonHP.searchButton.click();
	  
	  String actualSearchPagetitle = Driver.getDriver().getTitle();
	  Assert.assertEquals(actualSearchPagetitle, searchPageTitle);
	  
	  Select searchDropDown = new Select(amazonHP.selectDropDown);
	  String actualDeptName = searchDropDown.getFirstSelectedOption().getText();
	  Assert.assertEquals(actualDeptName, "Home & Kitchen");
	  
  }
  
  @Test
  public void softAssertTest() {
	  SoftAssert softassert = new SoftAssert();
	  
	  Assert.assertTrue(true);//if false the test fails the code stops executing
	  System.out.println("hard assert");
	  
	  
	  softassert.assertTrue(false);//if false test fails but the code continues ecxecuting
	  System.out.println("soft assert");
	  softassert.assertAll();
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
