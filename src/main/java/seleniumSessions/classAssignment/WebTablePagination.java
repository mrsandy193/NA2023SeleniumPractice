package seleniumSessions.classAssignment;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);

		WebElement el = driver.findElement(By.xpath("//h2[contains(@id,'tablepress')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", el);

		String country = "Denmark";
		int countryListSize;
		List<WebElement> countryList;
		WebElement nextButton = null;
		int count = 0;

		while (true) {
			countryListSize = driver.findElements(By.xpath("//td[text()='" + country + "']")).size();
			nextButton = driver.findElement(By.linkText("Next"));
			if (countryListSize > 0) {
				countryList = driver.findElements(
						By.xpath("//td[text()='" + country + "']/preceding-sibling::td/input[@type='checkbox']"));
				for (WebElement e : countryList) {
					e.click();
					Thread.sleep(500);
					count++;
				}
			}
			if (nextButton.getAttribute("class").contains("disabled")) {
				if (count > 0)
					System.out.println(
							"Pagination is completed. Country: " + country + " is selected " + count + " times.");
				else
					System.out.println("Pagination is completed. Country: " + country + " is not available.");
				break;
			} else {
				Thread.sleep(2000);
				nextButton.click();
			}
		}

		driver.close();
	}
}
