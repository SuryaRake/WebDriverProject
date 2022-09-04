package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SCrollingExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://www.w3schools.com/html/html_tables.asp"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebElement target = driver.findElement(By.xpath("//h2[text()='HTML Table Tags']"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		//obj.executeScript("arguments[0].scrollIntoView();", target);
		
		//scroll complete down
		
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Thread.sleep(5000);
		//complete scroll up
		
		obj.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
		
		//scroll up and down using arrow keys
		Thread.sleep(5000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		
		act.sendKeys(Keys.PAGE_UP).build().perform();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		
		Thread.sleep(5000);
		//scroll down using contl+end
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		//scroll up using Ctrl+home
		act.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).build().perform();

	}

}
