package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaits {
	public void setupAndWaits() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		//Page load time out setting
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		//Implicit Wait for all the Web elements
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void main(String[] args) {
		ImplicitWaits obj = new ImplicitWaits();
		obj.setupAndWaits();
	}
}
