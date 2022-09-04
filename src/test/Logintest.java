package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://www.simplilearn.com/"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//identify the location
		
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		
		//click on the identified locator
		loginlink.click();
		
		//Identify username field
		WebElement UserName = driver.findElement(By.name("user_login"));
		
		//enter the user name to the identified space
		UserName.sendKeys("surya.satheesan@qwer.com");
		
		//identify password space
		WebElement paswrd = driver.findElement(By.id("password"));
		
		//enter the password
		paswrd.sendKeys("Test@1234");
		
		//click on remember me check box
		WebElement remebr = driver.findElement(By.className("rememberMe"));
		remebr.click();
		
		
		//click on login button
		WebElement loginbtn = driver.findElement(By.name("btn_login"));
		loginbtn.click();
		
		//validation of error message
		
		WebElement errormsg = driver.findElement(By.id("msg_box"));
		
		
		String ActError = errormsg.getText(); // ACtual error message fetched and saved to ActErr
		String ExpError = "The email or password you have entered is invalid."; //Expected msg also saved
		
		if(ActError.equals(ExpError)) {   			//comparing actual and expected
			System.out.println("Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		
		//have to find out all hyperlinks on this page 
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of links in the page is " + links.size());
		
		//iterate through list and print the attribute having href
		
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getAttribute("href"));
		}
		
		//close the browser
		
		driver.close();
		
		

	}

}
