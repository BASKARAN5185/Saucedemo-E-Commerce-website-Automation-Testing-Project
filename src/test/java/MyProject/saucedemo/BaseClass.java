package MyProject.saucedemo;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static RemoteWebDriver driver;

	@BeforeTest
	public void openTheBrowser() {
		// Create ChromeOptions object to configure browser settings
		ChromeOptions options = new ChromeOptions();

		// Add various Chrome options
		// options.addArguments("--headless"); // Run in headless mode
		options.addArguments("--disable-extensions"); // Disable extensions
		options.addArguments("--incognito"); // Run in incognito mode
		options.addArguments("--start-maximized"); // Start maximized
		// options.addArguments("--disable-gpu"); // Disable GPU hardware acceleration
		options.addArguments("--window-size=1920x1080"); // Set window size
		options.addArguments("--disable-software-rasterizer"); // Disable software rasterizer
		options.addArguments("--disable-infobars"); // Disable "Chrome is being controlled" info bar
		options.addArguments(
				"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"); // Set

		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterTest
	public void teardowm() {
		driver.close();

	}

	public String getCurrentUrlpage() {
		String LoginUrl = driver.getCurrentUrl();
		return LoginUrl;

	}

	public void NavigateBack() {

		driver.navigate().back();

	}

	public void PageRefresh() {

		driver.navigate().refresh();

	}

	public void PageScroll(String Scorll) {

		if ("Top".equalsIgnoreCase(Scorll)) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0);");

		} else if ("botton".equalsIgnoreCase(Scorll)) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		} else {

			System.out.println("The page Scolling is not working ");
		}

	}

}