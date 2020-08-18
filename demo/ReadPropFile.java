package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropFile {
	static WebDriver driver;
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\seleniumPractise\\demo\\config.properties");
		prop.load(ip);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("URL");
		String input = prop.getProperty("inputbox");
		String search = prop.getProperty("searchIcon");
		String txt = prop.getProperty("searchItem");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//driver = new ChromeDriver();
			driver = new HtmlUnitDriver();
		}
		else if(browser.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("IE")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.findElement(By.xpath(input)).sendKeys(txt);
		driver.findElement(By.xpath(search)).click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Before :"+driver.getTitle());
		for(String actual: handles) {
			driver.switchTo().window(actual);
		}
		System.out.println("After :"+driver.getTitle());
		}

}
