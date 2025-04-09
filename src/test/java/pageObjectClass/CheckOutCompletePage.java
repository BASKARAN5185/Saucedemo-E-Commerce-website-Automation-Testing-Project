package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import MyProject.saucedemo.BaseClass;

public class CheckOutCompletePage extends BaseClass {

	// Initial Remote web driver
	public CheckOutCompletePage(RemoteWebDriver driver) {

		BaseClass.driver = driver;

	}

	// Complete Page Locator
	By title = By.className("title");
	By TickIconBy = By.className("pony_express");
	By Thanksmessage = By.className("complete-header");
	By completetext = By.className("complete-text");
	By BackHome = By.id("back-to-products");

	// Action Methods

	// Get the title of the Complete page
	public String getTitle() {
		WebElement pageTitle = driver.findElement(title);
		return pageTitle.getText();
	}

	// Check if the tick icon is displayed
	public boolean isTickIconDisplayed() {
		WebElement tickIcon = driver.findElement(TickIconBy);
		return tickIcon.isDisplayed();
	}

	// Get the Thanks message
	public String getThanksMessage() {
		WebElement thanksMessage = driver.findElement(Thanksmessage);
		return thanksMessage.getText();
	}

	// Get the completion text message
	public String getCompleteText() {
		WebElement completeText = driver.findElement(completetext);
		return completeText.getText();
	}

	// Click the Back to Products button
	public boolean clickBackHome() {
		WebElement backHomeButton = driver.findElement(BackHome);
		backHomeButton.click();
		return true;
	}

}