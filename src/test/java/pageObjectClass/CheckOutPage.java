package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import MyProject.saucedemo.BaseClass;

public class CheckOutPage extends BaseClass {

	// initial RemoteWebDriver
	public CheckOutPage(RemoteWebDriver driver) {

		BaseClass.driver = driver;

	}

	// CheckOutPage Locators
	By CheckOutPageTitle = By.className("title");
	By firstname = By.id("first-name");
	By lastname = By.id("last-name");
	By postalcode = By.id("postal-code");
	By cancel = By.id("cancel");
	By Continue = By.id("continue");
	
	  // Action Methods

    // Get the title of the Checkout page
    public String getCheckOutPageTitle() {
        WebElement title = driver.findElement(CheckOutPageTitle);
        return title.getText();
    }

    // Enter first name
    public String enterFirstName(String firstName) {
        WebElement firstNameField = driver.findElement(firstname);
        firstNameField.sendKeys(firstName);
		return firstName;
    }

    // Enter last name
    public String enterLastName(String lastName) {
        WebElement lastNameField = driver.findElement(lastname);
        lastNameField.sendKeys(lastName);
		return lastName;
    }

    // Enter postal code
    public String enterPostalCode(String postalCode) {
        WebElement postalCodeField = driver.findElement(postalcode);
        postalCodeField.sendKeys(postalCode);
		return postalCode;
    }

    // Click cancel button
    public boolean clickCancel() {
        WebElement cancelButton = driver.findElement(cancel);
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cancelButton);
		return true;
    }

    // Click continue button
    public boolean clickContinue() {
        WebElement continueButton = driver.findElement(Continue);
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", continueButton);
		return true;
    }


}