package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of given browser
	 * 
	 * @param browserName
	 * @return This returns the specific browser driver
	 */
	public WebDriver initDriver(String browserName) {
		if (browserName == null || browserName == "") {
			System.out.println("Please provide correct browser name.");
			return null;
		}
		browserName = browserName.toLowerCase().trim();

		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Please provide correct browser name.");
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		return driver;
	}

	public void launchURL(String url) {
		if (url == null)
			System.out.println("Please provide correct URL.");

		if (url.indexOf("https") == 0)
			driver.get(url);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("page title : " + title);
		return title;
	}

	public String getPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("page current url : " + url);
		return url;
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
