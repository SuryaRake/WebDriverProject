package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://demoqa.com/alerts"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement buttn1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
		buttn1.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		

		WebElement buttn4 = driver.findElement(By.xpath("//button[@id='promtButton']"));
		buttn4.click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Surya");
		alert.accept();
		//System.out.println(alert.getText());
		WebElement result = driver.findElement(By.xpath("//span[@id='promptResult']"));
		System.out.println(result.getText());
		Thread.sleep(5000);
		
		
		WebElement buttn3 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		buttn3.click();
		alert = driver.switchTo().alert();
		alert.dismiss();
		WebElement result1 = driver.findElement(By.xpath("//span[@id='confirmResult']"));
		System.out.println(result1.getText());
		
		

	}

}
