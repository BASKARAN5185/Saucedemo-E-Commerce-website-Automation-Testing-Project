package pageObjectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import MyProject.saucedemo.BaseClass;

public class YourCartPage extends BaseClass {

	// Initial Remote Driver
	public YourCartPage(RemoteWebDriver driver) {
		BaseClass.driver = driver;
	}

	// YourCart Page Locators
	By CartTitle = By.className("title");
	By ContinueShopping = By.id("continue-shopping");
	By Checkout = By.id("checkout");

	// Locator Action Method

	// Title Name Get method
	public String cartPageTitle() {
		WebElement Title = driver.findElement(CartTitle);
		return Title.getText();
	}

	// CLicking the continue shopping button
	public boolean clickingTheContinueShoping() {
		WebElement continueshop = driver.findElement(ContinueShopping);
		continueshop.click();
		return true;
	}

	// CLicking the checkout button
	public boolean clickingTheChockOut() {
		WebElement checkout = driver.findElement(Checkout);
		checkout.click();
		return true;
	}

}