package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
			WebElement DOB = driver.findElement(By.xpath("//input[@name='dob' and @id='dob']"));
			DOB.click();
			//Explicit Wait
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ui-datepicker-month']")));
			
			WebElement Month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			Select ddmonth = new Select(Month);
			ddmonth.selectByVisibleText("Apr");
			
			WebElement Year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select ddyear = new Select(Year);
			ddyear.selectByVisibleText("1990");
			
			WebElement date = driver.findElement(By.xpath("//a[@data-date='6']"));
			date.click();
			
		}
		
		
		

	

}
