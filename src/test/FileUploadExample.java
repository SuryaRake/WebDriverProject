package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://demo.guru99.com/test/upload/"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement fileUpload = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		fileUpload.sendKeys("C:\\Users\\Rakesh\\OneDrive\\Desktop\\surya\\test file.docx");
		
		WebElement chkbox = driver.findElement(By.xpath("//input[@id='terms']"));
		chkbox.click();
		
		WebElement submit = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submit.click();
		
		WebElement result = driver.findElement(By.xpath("//h3[@id='res']/center/br"));
		
		System.out.println(result.getText());
		

	}

}
