package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");

		List<WebElement> linksList = driver.findElements(By.tagName("a"));

		// print total links count
		int linksCount = linksList.size();
		System.out.println("Total Links: " + linksCount);

		// for loop
		for (int i = 0; i < linksCount; i++) {
			String text = linksList.get(i).getText();
			if (text.length() > 0)
				System.out.println(i + ": " + text);
		}

		// For Each
		int count = -1;
		for (WebElement we : linksList) {
			String text = we.getText();
			count++;
			if (text.length() > 0)
				System.out.println(count + ": " + text);
		}

//		By Totallinks = By.tagName("a");
//		List<WebElement> lst = getElements(Totallinks);
//		System.out.println("Total Links: " + lst.size());
//		for (WebElement we : lst) {
//			System.out.println(we.getText());
//		}
		driver.close();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
