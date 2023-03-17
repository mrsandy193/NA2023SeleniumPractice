package seleniumSessions.classAssignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By footerLinks = By.xpath("//div[@id='account-login']/following-sibling::footer//li/a");

		List<String> linkTexts = getElementsTextList(footerLinks);
		System.out.println(linkTexts);
		if (linkTexts.size() == 15)
			System.out.println("Pass");
		else
			System.out.println("Fail");

		// Get Links with its attribute
		getAttributes(footerLinks, "href");

		driver.quit();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void getAttributes(By locator, String attributeName) {

		List<WebElement> elements = getElements(locator);
		for (WebElement we : elements) {
			System.out.println("Link: " + we.getText() + "  ===>  " + we.getAttribute(attributeName));
		}
	}

	public static List<String> getElementsTextList(By locator) {
		List<String> elementsText = new ArrayList<>();
		List<WebElement> elements = getElements(locator);
		for (WebElement we : elements) {
			elementsText.add(we.getText());
		}
		return elementsText;
	}

}
