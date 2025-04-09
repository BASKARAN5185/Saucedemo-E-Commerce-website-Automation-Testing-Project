package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.saucedemo.BaseClass;
import pageObjectClass.CheckOutCompletePage;

public class CheckOutCompletePageTest extends BaseClass {

	CheckOutCompletePage OrderPurschase = new CheckOutCompletePage(driver);

	@Test
	public void verifyTheTiTleOfThePage() {
		Assert.assertEquals(OrderPurschase.getTitle(), "Checkout: Complete!");

	}

	@Test
	public void VerifyTheThanksMessage() {
		Assert.assertEquals(OrderPurschase.getThanksMessage(), "Thank you for your order!");

	}

	@Test
	public void VerifyTheCompleteTextMessage() {
		Assert.assertEquals(OrderPurschase.getCompleteText(),
				"Free Pony Express Delivery!Your order has been dispatched, and will arrive just as fast as the pony can get there!");
	}

	@Test
	public void VerifyTheTickIconVisibele() {
		Assert.assertTrue(OrderPurschase.isTickIconDisplayed());

	}

	@Test
	public void VerifyTheFinishButtonClickable() {
		Assert.assertTrue(OrderPurschase.clickBackHome());

	}

}
