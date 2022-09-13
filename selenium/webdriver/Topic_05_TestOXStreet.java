package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_TestOXStreet {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
        //System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	
     	//driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Register() {
		driver.get("https://oxstreet.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.findElement(By.id("email")).sendKeys("nguyenuyen.dt@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@4321");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		sleepInSecond(5);

	}
	@Test
	public void TC_02_Search_Product() {
		WebElement search = driver.findElement(By.xpath("//label[contains(@class,'styles_placeholder') and text()='Search']"));
		search.click();
		sleepInSecond(2);
		WebElement search_input = driver.findElement(By.xpath("//div[contains(@class,'SearchInput_root__yOOHT')]/input[1]"));
		search_input.sendKeys("neptune blue");
		search_input.sendKeys(Keys.ENTER);
		sleepInSecond(5);
        driver.findElement(By.xpath("//a[contains(text(),\"KAWS x sacai x Blazer Low 'Neptune Blue'\")]")).isDisplayed();	
		sleepInSecond(2);

	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	//Gọi hàm khác để dùng
		public void sleepInSecond(long second) {
			try {
				Thread.sleep(second * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}