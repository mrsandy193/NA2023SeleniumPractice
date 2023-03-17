package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		//create a webelement + perform action (click, sendkeys, gettext, isDisplayed....)
		
		//create a webelement: need a locator
		
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		
		//1st approach
//		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("naveen@123");
		
		//2nd approach
//		WebElement email = driver.findElement(By.id("input-email"));
//		WebElement pwd = driver.findElement(By.id("input-password"));
//		email.sendKeys("naveen@gmail.com");
//		pwd.sendKeys("naveen@123");
		
		//3rd approach
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		WebElement eid = driver.findElement(email);
//		WebElement pwd = driver.findElement(password);
//		eid.sendKeys("naveen@gmail.com");
//		pwd.sendKeys("naveen@123");
		
		//4th approach
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		getElement(email).sendKeys("naveen@gmail.com");
//		getElement(password).sendKeys("naveen@123");
		
		//5th approach
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		doSendKeys(email, "naveen@gmail.com");
//		doSendKeys(password, "naveen@123");
		
		//6th Approach
		By email = By.id("input-email");
		By password = By.id("input-password");
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.doSendKeys(email, "naveen@gmail.com");
		eUtil.doSendKeys(password, "naveen@123");
		
//		driver.quit();
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}

}
