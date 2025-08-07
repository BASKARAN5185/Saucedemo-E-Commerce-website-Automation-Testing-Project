package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.saucedemo.BaseClass;
import pageObjectClass.LandingPage;
import pageObjectClass.LoginPage;

public class LandingPageTest extends BaseClass {

	LandingPage HomePage = new LandingPage(driver);
	LoginPage Login = new LoginPage(driver);

	@Test(alwaysRun = true, priority = 1, groups = { "Regression", "LandingTest", "smoke" })
	void Login() {
		Login.enterTheUserName("standard_user");
		Login.enterThePassword("secret_sauce");
		Login.LoginClick();
	}

	@Test(priority = 2, groups = { "Regression", "LandingTest" })
	public void verifyHomePageLogo() {
		// Verifying that the App logo is visible on the homepage
		Assert.assertEquals(HomePage.AppLogo(), "Swag Labs");
	}

	@Test(priority = 3, groups = { "Regression", "LandingTest" })
	public void verifyMenuIconClick() {
		// Verifying that clicking the menu icon works
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
	}

	@Test(priority = 4, groups = { "Regression", "LandingTest" })
	public void verifyMenuClose() {
		// Verifying that closing the menu works
		Assert.assertTrue(HomePage.clickTheMenuClose(), "Menu close failed");
	}

	@Test(priority = 5, groups = { "Regression", "LandingTest" })
	public void verifyMenuAllItemsClick() {
		// Verifying that the "All Items" menu option works
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
		Assert.assertTrue(HomePage.clickTheMenuAllItems(), "Clicking All Items failed");
	}

	@Test(enabled = true, groups = { "Regression", "LandingTest" })
	public void verifyLogout() {
		// Verifying logout functionality
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
		Assert.assertTrue(HomePage.clickTheMenulogout(), "Logout failed");
		Assert.assertEquals("https://www.saucedemo.com/", getCurrentUrlpage());
		Login.Login("standard_user", "secret_sauce");
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", getCurrentUrlpage());
	}

	@Test(enabled = true, groups = { "Regression", "LandingTest" })
	public void verifyMenuAbout() {
		// Verifying the 'About' menu option
		Assert.assertTrue(HomePage.clickTheMenuIcon(), "Menu icon click failed");
		Assert.assertTrue(HomePage.clickTheMenuAbout(), "About menu click failed");
		Assert.assertEquals("https://saucelabs.com/", getCurrentUrlpage());
		NavigateBack();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", getCurrentUrlpage());
	}

	@Test(priority = 6, groups = { "Regression", "LandingTest" })
	public void verifyAppStoreReset() {
		// Verifying reset functionality in the app
		Assert.assertTrue(HomePage.clickTheMenuResetAppstore(), "App store reset failed");
		Assert.assertTrue(HomePage.clickTheMenuClose(), "Menu close failed");
	}

	@Test(priority = -1, groups = { "Regression", "LandingTest" })
	public void verifyProductTitleVisibility() {
		// Verifying that the product title is visible
		Assert.assertTrue(HomePage.ProductTitle(), "Product title not visible");
	}

	@Test(priority = 8, groups = { "Regression", "LandingTest" })
	public void verifyProductSortingAZ() {
		// Verifying sorting of products by name (A-Z)
		HomePage.testSortByNameAZ();
	}

	@Test(priority = 9, groups = { "Regression", "LandingTest" })
	public void verifyProductSortingZA() {
		// Verifying sorting of products by name (Z-A)
		HomePage.testSortByNameZA();
	}

	@Test(priority = 10, groups = { "Regression", "LandingTest" })
	public void verifyProductSortingHighToLow() {
		// Verifying sorting of products by price (High to Low)
		HomePage.testSortByPriceHighToLow();
	}

	@Test(priority = 11, groups = { "Regression", "LandingTest" })
	public void verifyProductSortingLowToHigh() {
		// Verifying sorting of products by price (Low to High)
		HomePage.testSortByPriceLowToHigh();
	}

	@Test(dependsOnMethods = "addToCartBadgevisible", groups = { "Regression", "LandingTest" })
	public void verifyCartIconVisibility() {
		// Verifying that the add to cart icon is visible
		Assert.assertTrue(HomePage.addToCartIconIsVisiable());
		Assert.assertEquals("https://www.saucedemo.com/cart.html", getCurrentUrlpage());
		NavigateBack();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", getCurrentUrlpage());
	}

	@Test(priority = 13, groups = { "Regression", "LandingTest" })
	public void clickTheAddToCart() {
		Assert.assertTrue(HomePage.addToCart("sauce-labs-backpack"));
		Assert.assertFalse(HomePage.removeToCartbuttonVisible("sauce-labs-backpack"));
	}

	@Test(priority = 14, groups = { "Regression", "LandingTest" })
	public void clickTheRemoveAddToCart() {
		Assert.assertTrue(HomePage.addToCart("test.allthethings()-t-shirt-(red)"));
		Assert.assertTrue(HomePage.removeToCartbuttonVisible("test.allthethings()-t-shirt-(red)"));
		Assert.assertTrue(HomePage.removeCart("test.allthethings()-t-shirt-(red)"));
	}

	@Test(priority = 15, groups = { "Regression", "LandingTest" })
	public void addToCartBadgevisible() {
		PageScroll("Top");
		Assert.assertTrue(HomePage.CartBadge());
	}

}
