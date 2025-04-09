package pageObjectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import MyProject.saucedemo.BaseClass;

public class LandingPage extends BaseClass {

	// intialize the remotewebdriver
	public LandingPage(RemoteWebDriver driver) {

		BaseClass.driver = driver;
	}

	// Landing Page Menu locators
	By BurgerMenu = By.id("react-burger-menu-btn");
	By MenuClose = By.xpath("//div[@class='bm-cross-button']//button[1]");
	By AllItem = By.id("inventory_sidebar_link");
	By About = By.id("about_sidebar_link");
	By ResetTheAppstore = By.id("reset_sidebar_link");
	By Logout = By.id("logout_sidebar_link");

	// Landing Page Header Locators
	By PageTitle = By.className("app_logo");
	By CartIcon = By.className("shopping_cart_link");
	By product = By.cssSelector("span.title[data-test='title']");
	By FilterDD = By.id("select");
	By selectContainer = By.className("select_container");
	By activeOption = By.className("active_option");
	By productSortContainer = By.className("product_sort_container");
	By Cartbage = By.className("shopping_cart_badge");
	By ProducAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
	By ProductRemoveToCart = By.id("remove-sauce-labs-backpack");

	// Action Method
	// MenuIcon Clicked
	public boolean clickTheMenuIcon() {

		WebElement MenuIcon = driver.findElement(BurgerMenu);
		MenuIcon.click();
		return true;
	}

	// Clicked icon clicked and visibled
	public boolean addToCartIconIsVisiable() {

		WebElement cart = driver.findElement(CartIcon);
		cart.click();
		return cart.isDisplayed();
	}

	// Menu Logout Clicked
	public boolean clickTheMenulogout() {

		WebElement logout = driver.findElement(Logout);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", logout);
		return true;
		
	}

	// Menu Closed
	public boolean clickTheMenuClose() {

		
		WebElement closeButton = driver.findElement(MenuClose);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", closeButton);
		return true;

	}

	// Menu AllItems
	public boolean clickTheMenuAllItems() {

		WebElement Allitems = driver.findElement(AllItem);
		Allitems.click();
		return true;
	}

	// Menu Reset
	public boolean clickTheMenuResetAppstore() {

		WebElement Reset = driver.findElement(ResetTheAppstore);
		Reset.click();
		return true;
	}

	// Menu About
	public boolean clickTheMenuAbout() {

		WebElement MenuAbout = driver.findElement(About);
		MenuAbout.click();
		return true;
	}

	// Landing page AppLogo
	public boolean AppLogo() {
		WebElement Title = driver.findElement(PageTitle);
		return Title.isDisplayed();
	}

	// Landing page Badge
	public boolean CartBadge() {
		WebElement Badge = driver.findElement(Cartbage);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", Badge);
		return Badge.isDisplayed();
	}

	// Landing page Title
	public boolean ProductTitle() {
		WebElement Title = driver.findElement(product);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", Title);
		return Title.isDisplayed();
	}

	// Test: Sort by Name (A-Z)
	public void testSortByNameAZ() {

		// Locate the sorting drop down and select "Name (A to Z)"
		WebElement sortDropdown = driver.findElement(By.cssSelector(".product_sort_container"));
		Select dropdown = new Select(sortDropdown);
		dropdown.selectByVisibleText("Name (A to Z)");

		// Locate product names and store them in a list
		List<WebElement> productNames = driver.findElements(By.cssSelector(".inventory_item_name"));
		String[] names = new String[productNames.size()];
		for (int i = 0; i < productNames.size(); i++) {
			names[i] = productNames.get(i).getText();
		}

		// Validate that the product names are sorted in A-Z order
		boolean isSorted = true;
		for (int i = 1; i < names.length; i++) {
			if (names[i].compareTo(names[i - 1]) < 0) {
				isSorted = false;
				break;
			}
		}

		// Assert the sorting is correct
		Assert.assertTrue(isSorted, "Products are not sorted by name (A-Z).");
	}

	public boolean addToCart(String ProductName) {
		WebElement AddToCart = driver.findElement(By.cssSelector("button[id*='add-to-cart-" + ProductName + "']"));
		AddToCart.click();
		return true;
	}

	public boolean AddToCartbuttonVisible(String ProductName) {
		WebElement AddToCart = driver.findElement(By.cssSelector("button[id*='add-to-cart-" + ProductName + "']"));
		return AddToCart.isDisplayed();
	}

	public boolean removeCart(String ProductName) {
		WebElement AddToCartRemove = driver.findElement(By.id("remove-" + ProductName));
		AddToCartRemove.click();
		return true;

	}

	public boolean removeToCartbuttonVisible(String ProductName) {
		WebElement AddToCart = driver.findElement(By.id("remove-" + ProductName));
		return AddToCart.isDisplayed();
	}

	// Test: Sort by Name (Z-A)
	public void testSortByNameZA() {

		// Locate the sorting dropdown and select "Name (Z to A)"
		WebElement sortDropdown = driver.findElement(By.cssSelector(".product_sort_container"));
		Select dropdown = new Select(sortDropdown);
		dropdown.selectByVisibleText("Name (Z to A)");

		// Locate product names and store them in a list
		List<WebElement> productNames = driver.findElements(By.cssSelector(".inventory_item_name"));
		String[] names = new String[productNames.size()];
		for (int i = 0; i < productNames.size(); i++) {
			names[i] = productNames.get(i).getText();
		}

		// Validate that the product names are sorted in Z-A order
		boolean isSorted = true;
		for (int i = 1; i < names.length; i++) {
			if (names[i].compareTo(names[i - 1]) > 0) {
				isSorted = false;
				break;
			}
		}

		// Assert the sorting is correct
		Assert.assertTrue(isSorted, "Products are not sorted by name (Z-A).");
	}

	// Test: Sort by Price (Low to High)
	public void testSortByPriceLowToHigh() {

		// Locate the sorting dropdown and select "Price (low to high)"
		WebElement sortDropdown = driver.findElement(By.cssSelector(".product_sort_container"));
		Select dropdown = new Select(sortDropdown);
		dropdown.selectByVisibleText("Price (low to high)");

		// Locate product prices and store them in an array
		List<WebElement> productPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
		double[] prices = new double[productPrices.size()];
		for (int i = 0; i < productPrices.size(); i++) {
			prices[i] = Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
		}

		// Validate that the products are sorted by price in ascending order
		boolean isSorted = true;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				isSorted = false;
				break;
			}
		}

		// Assert the sorting is correct
		Assert.assertTrue(isSorted, "Products are not sorted by price (low to high).");
	}

	// Test: Sort by Price (High to Low)
	public void testSortByPriceHighToLow() {

		// Locate the sorting dropdown and select "Price (high to low)"
		WebElement sortDropdown = driver.findElement(By.cssSelector(".product_sort_container"));
		Select dropdown = new Select(sortDropdown);
		dropdown.selectByVisibleText("Price (high to low)");

		// Locate product prices and store them in an array
		List<WebElement> productPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
		double[] prices = new double[productPrices.size()];
		for (int i = 0; i < productPrices.size(); i++) {
			prices[i] = Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
		}

		// Validate that the products are sorted by price in descending order
		boolean isSorted = true;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				isSorted = false;
				break;
			}
		}

		// Assert the sorting is correct
		Assert.assertTrue(isSorted, "Products are not sorted by price (high to low).");
	}

}