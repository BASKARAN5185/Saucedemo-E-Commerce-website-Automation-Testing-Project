package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.saucedemo.BaseClass;
import pageObjectClass.LandingPage;
import pageObjectClass.LoginPage;

public class LandingPageTest extends BaseClass {

	LandingPage HomePage = new LandingPage(driver);
	LoginPage Login = new LoginPage(driver);

	@Test(alwaysRun = true, priority = 1, groups = "smoke")
	void Login() {
		Login.enterTheUserName("standard_user");
		Login.enterThePassword("secret_sauce");
		Login.LoginClick();
	}

	@Test(priority = 2)
	public void verifyHomePageLogo() {
		// Verifying that the App logo is visible on the homepage
		Assert.assertEquals(HomePage.AppLogo(), "Swag Labs");
	}

	@Test(priority = 3)
	public void verifyMenuIconClick() {
		// Verifying that clicking the menu icon works
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
	}

	@Test(priority = 4)
	public void verifyMenuClose() {
		// Verifying that closing the menu works
		Assert.assertTrue(HomePage.clickTheMenuClose(), "Menu close failed");
	}

	@Test(priority = 5)
	public void verifyMenuAllItemsClick() {
		// Verifying that the "All Items" menu option works
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
		Assert.assertTrue(HomePage.clickTheMenuAllItems(), "Clicking All Items failed");
	}

	@Test(enabled = true) // Enabled for now
	public void verifyLogout() {
		// Verifying logout functionality
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
		Assert.assertTrue(HomePage.clickTheMenulogout(), "Logout failed");
		Assert.assertEquals("https://www.saucedemo.com/", getCurrentUrlpage());
		Login.Login("standard_user", "secret_sauce");
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", getCurrentUrlpage());
	}

	@Test(enabled = true) // Enabled for now
	public void verifyMenuAbout() {
		// Verifying the 'About' menu option
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
		Assert.assertTrue(HomePage.clickTheMenuAbout(), "About menu click failed");
		Assert.assertEquals("https://saucelabs.com/", getCurrentUrlpage());
		NavigateBack();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", getCurrentUrlpage());

	}

	@Test(priority = 6)
	public void verifyAppStoreReset() {
		// Verifying reset functionality in the app
		Assert.assertTrue(HomePage.clickTheMenuResetAppstore(), "App store reset failed");
		Assert.assertTrue(HomePage.clickTheMenuClose(), "Menu close failed");
	}

	@Test(priority=-1)
	public void verifyProductTitleVisibility() {
		// Verifying that the product title is visible
		Assert.assertTrue(HomePage.ProductTitle(), "Product title not visible");
	}

	@Test(priority = 8)
	public void verifyProductSortingAZ() {
		// Verifying sorting of products by name (A-Z)
		HomePage.testSortByNameAZ();
	}

	@Test(priority = 9)
	public void verifyProductSortingZA() {
		// Verifying sorting of products by name (Z-A)
		HomePage.testSortByNameZA();
	}

	@Test(priority = 10)
	public void verifyProductSortingHighToLow() {
		// Verifying sorting of products by price (High to Low)
		HomePage.testSortByPriceHighToLow();
	}

	@Test(priority = 11)
	public void verifyProductSortingLowToHigh() {
		// Verifying sorting of products by price (Low to High)
		HomePage.testSortByPriceLowToHigh();
	}

	@Test(dependsOnMethods = "addToCartBadgevisible")
	public void verifyCartIconVisibility() {
		// Verifying that the add to cart icon is visible
		Assert.assertTrue(HomePage.addToCartIconIsVisiable());
		Assert.assertEquals("https://www.saucedemo.com/cart.html", getCurrentUrlpage());
		NavigateBack();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", getCurrentUrlpage());
	}

	@Test(priority = 13)
	public void clickTheAddToCart() {
		Assert.assertTrue(HomePage.addToCart("sauce-labs-backpack"));
		Assert.assertFalse(HomePage.removeToCartbuttonVisible("sauce-labs-backpack"));
	}

	@Test(priority = 14)
	public void clickTheRemoveAddToCart() {
		Assert.assertTrue(HomePage.addToCart("test.allthethings()-t-shirt-(red)"));
		Assert.assertTrue(HomePage.removeToCartbuttonVisible("test.allthethings()-t-shirt-(red)"));
		Assert.assertTrue(HomePage.removeCart("test.allthethings()-t-shirt-(red)"));

	}

	@Test(priority = 15)
	public void addToCartBadgevisible() {

		PageScroll("Top");
		Assert.assertTrue(HomePage.CartBadge());

	}

}