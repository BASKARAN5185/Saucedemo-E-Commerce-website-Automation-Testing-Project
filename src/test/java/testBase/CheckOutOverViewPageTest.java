package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.saucedemo.BaseClass;
import pageObjectClass.CheckOutOverViewPage;

public class CheckOutOverViewPageTest extends BaseClass {

	CheckOutOverViewPage OrderOverview = new CheckOutOverViewPage(driver);

	@Test(priority = 1)
	public void verifyTheTiTleOfThePage() {
		Assert.assertEquals(OrderOverview.getTitle(), "Checkout: Overview");

	}

	@Test
	public void VerifyThePaymentImfomation() {
		Assert.assertEquals(OrderOverview.getPaymentInformation(), "SauceCard #31337");

	}

	@Test
	public void VerifyTheShopingInformation() {
		Assert.assertEquals(OrderOverview.getShoppingInformation(), "Free Pony Express Delivery!");

	}

	@Test
	public void VerifyTheItemTotalInformation() {
		Assert.assertEquals(OrderOverview.getItemTotal(), "Item total: $29.99");

	}

	@Test
	public void VerifyTheItemTax() {
		Assert.assertEquals(OrderOverview.getTax(), "Tax: $2.40");

	}

	@Test
	public void VerifyTheTotalPrice() {
		Assert.assertEquals(OrderOverview.getTotal(), "Total: $32.39");

	}

	@Test(dependsOnMethods = "verifyTheTiTleOfThePage")
	public void VerifyTheFinishButtonClickable() {
		Assert.assertTrue(OrderOverview.clickFinish());

	}

	@Test(enabled = false)
	public void VerifyTheCancelButtonClickable() {
		Assert.assertTrue(OrderOverview.clickCancel());

	}

}
