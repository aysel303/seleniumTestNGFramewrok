package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	Alert alert;
	WebDriverWait letsWait;
	Select letsSelect;
	
	public void switchToAlert() {
		alert = Driver.getDriver().switchTo().alert();
	}
	
	public String alertGetText() {
		return alert.getText();
	}
	
	public void alertAccept() {
		 alert.accept();
	}
	public void alertDismiss() {
		 alert.dismiss();
	}
	
	public void sendKeysOnAlert(String name) {
		alert.sendKeys(name);
	}
	
	public void waitUntilAletIsPresent() {
		letsWait = new WebDriverWait(Driver.getDriver(), 10);
		letsWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void selectByVisibleText(WebElement element, String optionToSelect) {
		letsSelect = new Select(element);
		letsSelect.selectByVisibleText(optionToSelect);
	}
	
	public void waitUntilElementIsVisible(WebElement element) {
		letsWait = new WebDriverWait(Driver.getDriver(),10);
		letsWait.until(ExpectedConditions.visibilityOf(element));
				
	}
	
	public void clearFieldByAttributeValue(WebElement element, String value) {
		String getText  = element.getAttribute(value);
		for (int i = 0; i < getText.length(); i++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

}
