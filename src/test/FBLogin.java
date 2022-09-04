package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//create object for chromedriver
		
		WebDriver driver = new ChromeDriver(); //WebDRiver is interface. chromedriver is the class implementing webdriver.
		driver.get("https://www.facebook.com/"); // using the object and get function calling the url
		
		//maximize the window
		driver.manage().window().maximize();
		
		//timeout
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement usrnam = driver.findElement(By.cssSelector("input#email")); // using cssSelector
		usrnam.sendKeys("acvfhgjk@nmj.com");

		username.sendKeys("abcd@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@name='pass']"));
		password.sendKeys("asdc@123");
		//WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
	
	//	login.click();
	//	WebElement msg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		
	
		/*String errorMsg = msg.getText();
		String EXptdmsg = "The password that you've entered is incorrect.";
		if (errorMsg.equals(EXptdmsg)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}*/
		
		WebElement SignIn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignIn.click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		FirstName.sendKeys("Surya");
		
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		LastName.sendKeys("Rakesh");
		
		WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		Mobile.sendKeys("8943415562");
		
		WebElement Newpaswd = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		Newpaswd.sendKeys("Abcd@123");
		
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("30");
		
		
		WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
		Select ddMonth = new Select(Month);
		ddMonth.selectByVisibleText("Oct");
		
		WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
		Select ddYear = new Select(Year);
		ddYear.selectByVisibleText("1990");
		
		List<WebElement> Monthlist = ddMonth.getOptions();
		
		for (WebElement elm : Monthlist) {
			System.out.println(elm.getText());
			
		}
		
		System.out.println("The selected month is " + ddMonth.getFirstSelectedOption().getText());
		System.out.println("The selected year is " + ddYear.getFirstSelectedOption().getText());
		System.out.println("The selected date is " + ddDay.getFirstSelectedOption().getText());
		
		//using xpath instead of function
		
		String selectedmonth = driver.findElement(By.xpath("//select[@id='month']/option[@selected='1']")).getText();
		System.out.println("The selected month using xpath is " + selectedmonth);
		
		List<WebElement> Datelist = ddDay.getOptions();
		
		for (WebElement dateelem : Datelist) {
			System.out.println(dateelem.getText());
		}
		
		

		List<WebElement> Allmonths = driver.findElements(By.xpath("//select[@id='month']/option"));
		
		for(WebElement mnth : Allmonths) {
			System.out.println(mnth.getText());
		}
		
		
		//dropdown
		
		//radio button customized
		String Gender = "Custom";
		
		/*WebElement male = driver.findElement(By.xpath("//input[@type='radio' and @value = '2']"));
		WebElement female = driver.findElement(By.xpath("//input[@type='radio' and @value = '1']"));
		WebElement custom = driver.findElement(By.xpath("//input[@type='radio' and @value = '-1']"));
		
		if(Gender.equals("female")) {
			female.click();
		}
		else if(Gender.equals("custom")) {
			custom.click();
		}
		else if(Gender.equals("male")){
			male.click();
		}
		else {
			System.out.println("Wrong input");
		}*/
		
		//Dynamic xpath - Draw back of above code is has to provide separate xpath for each element
		//Creating dynamic xpath since the xpath is having only change in value and always sibling of label
		/*WebElement genderRadioButn = driver.findElement(By.xpath("//label[(text()='"+Gender+"')]//following-sibling::input"));
		genderRadioButn.click();
		*/
		
		//Using replace function
		
		String GenderXpath = "//label[text()='placeholder']/following-sibling::input";
		GenderXpath.replace("placeholder", Gender);
		
		WebElement genderRadioBtn = driver.findElement(By.xpath(GenderXpath));
		genderRadioBtn.click();
		
		//above code won't work some problems for Nikunj also
		// css selector
		//when the application are building xpath won't ready. that time we can use css selector, when xpath is not available, we can use css selector.
		//if the entire html page is not ready we should use css selector
		
		//driver.close();
		

	}

}


