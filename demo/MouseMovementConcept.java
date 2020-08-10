package demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.className("nav-action-inner")).click();
		Set<String> handles=driver.getWindowHandles();
		for(String actual: handles) {
			driver.switchTo().window(actual);
		}
		driver.findElement(By.id("ap_email")).sendKeys("987654321");
		driver.findElement(By.id("continue")).click();
	}

}
