package testBase;

import org.testng.annotations.Test;

import MyProject.saucedemo.BaseClass;
import pageObjectClass.LoginPage;
import utility.TestDataProvider;

public class LoginPageTest extends BaseClass {

	LoginPage Login = new LoginPage(driver);

	// Login Test
	@Test(enabled = true, priority = 2, groups = "smoke")
	void Login() {
		Login.enterTheUserName("standard_user");
		Login.enterThePassword("secret_sauce");
		Login.LoginClick();

	}

	// Data Driven with Valid users login Test
	@Test(enabled = false, groups = "regression", dataProvider = "userData", dataProviderClass = TestDataProvider.class)
	void LoginVaildCrential(String User, String Pass) {
		Login.enterTheUserName(User);
		Login.enterThePassword(Pass);
		Login.LoginClick();

	}

	// Data Driven with inValid users login Test
	@Test(enabled = true, priority = 1, groups = "regression", dataProvider = "userInvalidData", dataProviderClass = TestDataProvider.class)
	void LogininVaildCrential(String User, String Pass) {
		Login.enterTheUserName(User);
		Login.enterThePassword(Pass);
		Login.LoginClick();

	}

}