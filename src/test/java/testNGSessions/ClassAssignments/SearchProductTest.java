package testNGSessions.ClassAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchProductTest {
	WebDriver driver;
	
	public boolean doSearchProduct(String searchText, String productName)
	{
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(searchText, Keys.ENTER);
//		driver.findElement(By.cssSelector(".fa.fa-search")).click();
		driver.findElement(By.linkText(productName)).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		return wait.until(ExpectedConditions.titleContains(productName));
		
	}
	
	
	@DataProvider
	public Object [][] getProductData()
	{
		return new Object[][] {
			{"mac", "iMac"},
			{"mac", "MacBook"},
			{"mac", "MacBook Air"},
			{"mac", "MacBook Pro"},
			{"Samsung", "Samsung SyncMaster 941BW"},
			{"Samsung", "Samsung Galaxy Tab 10.1"}
		};
	}
	
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	
	@Test(dataProvider = "getProductData")
	public void searchProductTest(String searchText, String productName)
	{
		boolean flag = doSearchProduct(searchText, productName);
		Assert.assertTrue(flag);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
