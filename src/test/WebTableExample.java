package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://www.w3schools.com/html/html_tables.asp"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> Rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("Total no of rows is "+Rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		System.out.println("The total columns is "+ columns.size());
		//print data in row no 3 and column no 1
		
		WebElement data1 = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
		System.out.println("The data in row 3 and column 1 is " + data1.getText());
		
		//print all rows and columns in the screen - for each loop
		
		/*for (WebElement row:Rows) {
			List<WebElement> Allvalue = row.findElements(By.tagName("td"));	
			for (WebElement cell:Allvalue) {
				System.out.print(cell.getText()+ " ");
			}
			
			System.out.println();
		}*/
		
		////print all rows and columns in the screen - for loop
		
		for (int i=1;i<Rows.size();i++) {
			for(int j=1;j<=columns.size();j++) {
				WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i +"]/*[" + j +"]"));
				System.out.print(cell.getText());
			}
			System.out.println();
		}
		
		//printing country for given company
		
		String company = "Island Trading";
		
		String xpath = "//td[text()='" + company + "']/following-sibling::td[2]";
		WebElement Country = driver.findElement(By.xpath(xpath));
		System.out.println("The country associated with the given company is " +Country.getText());
		
	}

}
