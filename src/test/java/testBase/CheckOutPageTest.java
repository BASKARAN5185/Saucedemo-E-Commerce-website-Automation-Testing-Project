package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.saucedemo.BaseClass;
import pageObjectClass.CheckOutPage;

public class CheckOutPageTest extends BaseClass {

	CheckOutPage OrderCheck = new CheckOutPage(driver);

	// verify the title of the Page
	@Test(priority = 1)
	void verifyTheTitleOfThePage() {
		Assert.assertEquals(OrderCheck.getCheckOutPageTitle(), "Checkout: Your Information");

	}

	// Enter the first name
	@Test
	void enterTheFirstName() {

		String fname = OrderCheck.enterFirstName("Zoya");

		Assert.assertEquals("Zoya", fname);

	}

	// Enter the last name
	@Test(dependsOnMethods = "enterTheFirstName")
	void enterTheLastName() {

		String lastname = OrderCheck.enterLastName("K");

		Assert.assertEquals("K", lastname);

	}

	// Enter the ZipCode
	@Test(dependsOnMethods = "enterTheLastName")
	void enterTheZipCode() {
		String zipcode = OrderCheck.enterPostalCode("10001");

		Assert.assertEquals(zipcode, "10001");

	}

	// Click the continue button
	@Test(dependsOnMethods = "enterTheZipCode")
	void clicktheContinue() {

		Assert.assertTrue(OrderCheck.clickContinue());

	}

	// Click the continue button
	@Test(enabled = false)
	void clickTheCancel() {

		Assert.assertTrue(OrderCheck.clickCancel());

	}

}
