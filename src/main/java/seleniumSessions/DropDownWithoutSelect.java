package seleniumSessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelect {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By options = By.xpath("//select[@id='Form_getForm_Country']/option");

		List<WebElement> optionsList = driver.findElements(options);
		System.out.println(optionsList.size());

		List<String> actualDropdownValuesText = getDropdownValuesUsingFindElements(options);
		System.out.println(actualDropdownValuesText);
		List<String> expectedDropdownValuesText = Arrays.asList("India", "Brazil", "Belgium");

		if (actualDropdownValuesText.containsAll(expectedDropdownValuesText)) {
			System.out.println("Pass");
		}
		
		Thread.sleep(2000);
		selectDropdownValueWithoutSelectMethods(options, "India");

//		for (WebElement e : optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//				if(text.equals("India")) {
//					e.click();
//					break;
//				}
//
//			// arraylist<String>
//			// add it with text
//
//		}
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void selectDropdownValueWithoutSelectMethods(By locator, String dropdownValue) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement we : optionsList) {
			String value = we.getText();
			if (value.equals(dropdownValue))
			{
				we.click();
				break;
			}
			
		}
	}

	public static List<String> getDropdownValuesUsingFindElements(By locator) {
		List<WebElement> optionsList = getElements(locator);
		List<String> optionsListValues = new ArrayList<String>();

		for (WebElement we : optionsList) {
			optionsListValues.add(we.getText());
		}

		return optionsListValues;
	}
}
