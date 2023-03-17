package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLanguageLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

//		List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//
//		System.out.println(langLinks.size());
//
//		for (WebElement e : langLinks) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("मराठी")) {
//				e.click();
//				break;
//			}
//		}
		
		By googleFooterLink = By.xpath("//div[@jscontroller='NzU6V']/div/a");
		List<String> googleFooterLinks = getTotalLinks(googleFooterLink);
		for(String s: googleFooterLinks)
		{
			System.out.println(s);
		}
	}
	
	public static List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public static void clickOnSpecificLink(By locator, String link)
	{
		List<WebElement> totalLinks = getElements(locator);
		
		for(WebElement e: totalLinks)
		{
			String linkText = e.getText();
			if(linkText.equals(link))
			{
				e.click();
				break;
			}
		}
	}
	
	public static List<String> getTotalLinks(By locator)
	{
		List<WebElement> totalLinks = getElements(locator);
		List<String> totalLinksTexts = new ArrayList<>();
		for (WebElement e: totalLinks)
		{
			totalLinksTexts.add(e.getText());
		}
		return totalLinksTexts;
	}

	// 1. m1 - click on a specific lang link
	// 2. m2 - return the list of lang links
	// 3. m3 - capture the list of google footer links

}
