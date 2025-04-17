package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import MyProject.saucedemo.BaseClass;

public class CheckOutOverViewPage extends BaseClass {

	// Initial RemoteWebdriver
	public CheckOutOverViewPage(RemoteWebDriver driver) {
		BaseClass.driver = driver;
	}

	// Overview Page Locators
	By title = By.className("title");
	By PaymentInformation = By.xpath("(//div[@class='summary_value_label'])[1]");
	By ShoppingInformation = By.xpath("(//div[@class='summary_value_label'])[2]");
	By ItemTotal = By.xpath("//div[text()='Item total: $']");
	By Tax = By.xpath("//div[text()='Tax: $']");
	By totlal = By.xpath("//div[text()='Item total: $']");
	By cancel = By.id("cancel");
	By finish = By.id("finish");

	// Action Methods

	// Get the title of the Overview page
	public String getTitle() {
		WebElement pageTitle = driver.findElement(title);
		return pageTitle.getText();
	}

	// Get Payment Information
	public String getPaymentInformation() {
		WebElement paymentInfo = driver.findElement(PaymentInformation);
		return paymentInfo.getText();
	}

	// Get Shopping Information
	public String getShoppingInformation() {
		WebElement shoppingInfo = driver.findElement(ShoppingInformation);
		return shoppingInfo.getText();
	}

	// Get the Item Total
	public String getItemTotal() {
		WebElement itemTotal = driver.findElement(ItemTotal);
		return itemTotal.getText();
	}

	// Get Tax amount
	public String getTax() {
		WebElement tax = driver.findElement(Tax);
		return tax.getText();
	}

	// Get the Total amount
	public String getTotal() {
		WebElement totalAmount = driver.findElement(totlal);
		return totalAmount.getText();
	}

	// Click the Cancel button
	public boolean clickCancel() {
		WebElement cancelButton = driver.findElement(cancel);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cancelButton);
		return true;
	}

	// Click the Finish button
	public boolean clickFinish() {
		WebElement finishButton = driver.findElement(finish);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", finishButton);
		return true;
	}

}