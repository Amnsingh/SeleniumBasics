package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");
		//Page load time out setting
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		//Implicit Wait for all the Web elements
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@class='landscape-image']")).click();
		String loc1 = driver.getWindowHandle();
		driver.switchTo().window(loc1);
		driver.findElement(By.xpath("//span[@class='a-color-base']")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]")).click();
	}

}
