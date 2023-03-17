package testNGSessions.ClassAssignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegPageTest {

	WebDriver driver;

	public boolean doRegister(String fn, String ln, String email, String phnNo, String pwd) {
		String successMessage = "";
		try {
			driver.findElement(By.id("input-firstname")).sendKeys(fn);
			driver.findElement(By.id("input-lastname")).sendKeys(ln);
			driver.findElement(By.id("input-email")).sendKeys(email);
			driver.findElement(By.id("input-telephone")).sendKeys(phnNo);
			driver.findElement(By.id("input-password")).sendKeys(pwd);
			driver.findElement(By.id("input-confirm")).sendKeys(pwd);

			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();

			By successMsgTxtEl = By.xpath("//h1[contains(text(),'Created')]");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsgTxtEl)).getText();

			if (successMessage.contains("Your Account Has Been Created!"))
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@DataProvider
	public Object[][] getRegTestData() {
		return new Object[][] {

				{ "LK", "OI", "LK43324@gmail.com", "9090909128", "LK1234@123" },
				{ "LK", "OI", "LK11324@gmail.com", "9090909128", "LK1234@123" },
				{ "LK", "OI", "LK30324@gmail.com", "9090909128", "LK1234@123" } };

	}

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(dataProvider = "getRegTestData")
	public void registerTest(String fn, String ln, String email, String phnNo, String pwd) {
		boolean flag = doRegister(fn, ln, email, phnNo, pwd);
		Assert.assertTrue(flag, "The registration failed.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
