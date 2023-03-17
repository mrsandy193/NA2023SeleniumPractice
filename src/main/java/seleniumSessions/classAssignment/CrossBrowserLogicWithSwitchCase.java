package seleniumSessions.classAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserLogicWithSwitchCase {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		String browser = "chrome";
		
		
		switch (browser.toUpperCase()) {
			case "CHROME":
				driver = new ChromeDriver();
				break;
			case "FF":
				driver = new FirefoxDriver();
			case "EDGE":
				driver = new EdgeDriver();
			default:
				break;
		}
		
		driver.get("https://www.amazon.in/");
		
		String title = driver.getTitle();
		System.out.println("Title is: " + title);
		
		if(title.contains("Amazon")) {
			System.out.println("Pass");
		}
		else
			System.out.println("Fail");
		driver.quit();
	}

}
