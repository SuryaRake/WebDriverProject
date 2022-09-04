package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsTabExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://demoqa.com/browser-windows"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Before adding new tabs the window id is "+ parentWindow);
		
		WebElement butn1 = driver.findElement(By.xpath("//button[@id='tabButton']"));
		butn1.click();
		Set<String> Allwin = driver.getWindowHandles();
		System.out.println("AFter adding new tab, the window ids are "+ Allwin);
		
		for(String win : Allwin) {
			if(!win.equals(parentWindow)) {
				driver.switchTo().window(win);
			}
		}
		
		WebElement childHeader = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(childHeader.getText());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		WebElement butn2 = driver.findElement(By.xpath("//button[@id='windowButton']"));
		butn2.click();
		
		Set<String> newWinset = driver.getWindowHandles();
		System.out.println("AFter adding new tab, the window ids are "+ newWinset);
		
		for(String win : newWinset) {
			if(!win.equals(parentWindow)) {
				driver.switchTo().window(win);
			}
		}
		
		driver.manage().window().maximize();
		WebElement tab3 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(tab3.getText());
		driver.quit();
		
		
		

	}

}
