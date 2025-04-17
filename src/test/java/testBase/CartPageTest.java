package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyProject.saucedemo.BaseClass;
import pageObjectClass.LoginPage;
import pageObjectClass.YourCartPage;

public class CartPageTest extends BaseClass {

	YourCartPage Cart = new YourCartPage(driver);
	LoginPage lo = new LoginPage(driver);

	// verify the title of the Page 
	@Test(priority=1)
	void verifyTheTitleOfThePage() {
       Assert.assertEquals(Cart.cartPageTitle(),"Your Cart");
		
	}
	
	//click the continue button click
	@Test(enabled = false)
	void clickTheContinueButton() {
		Assert.assertTrue(Cart.clickingTheContinueShoping());
		
	}
	
	//click the continue button click
		@Test(enabled = true,dependsOnMethods = "verifyTheTitleOfThePage")
		void clickTheCheckOutButton() {
			Assert.assertTrue(Cart.clickingTheChockOut());
			
		}
	
	
	

}
