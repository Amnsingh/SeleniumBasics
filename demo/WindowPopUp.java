package demo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #1')]")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindow = it.next();
		System.out.println(driver.getTitle());
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
	}

}
