package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class DemoQaPage {
	
	public DemoQaPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="alertButton")
	public WebElement firstClickMeBtn;
	
	@FindBy(id="timerAlertButton")
	public WebElement secondClickMeBtn;
	
	@FindBy(id="confirmButton")
	public WebElement thirdClickMeBtn;
	
	@FindBy(id="promtButton")
	public WebElement fourthClickMeBtn;

}
