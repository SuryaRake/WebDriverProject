package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragnDropExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://demo.guru99.com/test/drag_drop.html"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebElement from = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		WebElement to = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
		

	}

}
