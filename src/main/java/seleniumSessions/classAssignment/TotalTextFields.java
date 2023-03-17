package seleniumSessions.classAssignment;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seleniumSessions.BrowserUtil;
import seleniumSessions.ElementUtil;

public class TotalTextFields {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		WebDriver driver = bu.initDriver("chrome");
		bu.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		ElementUtil eu = new ElementUtil(driver);

		By textFelds = By.cssSelector(".form-control");
		List<WebElement> lst = eu.getElements(textFelds);
		for (WebElement e : lst) {
			System.out.println(e.getAttribute("name"));
		}

		bu.quitBrowser();

	}

}
