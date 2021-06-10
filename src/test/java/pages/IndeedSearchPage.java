package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class IndeedSearchPage {
	public IndeedSearchPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="text-input-what")
	public WebElement whatField;
	
	@FindBy(id="text-input-where")
	public WebElement whereField;
	
	@FindBy(xpath="//button[contains(text(),'Find jobs')]")
	public WebElement findJobsBtn;

	@FindBy(id="jobsInLocation")
	public WebElement jobLocation;
	
	@FindBy(xpath="//h2[@class='title']//a[@target='_blank']")
	public List<WebElement> jobTitleResultsList;
	
	
}
