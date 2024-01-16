import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		
/*** Scrolling down the webpage ***/	
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
   //Now our driver is aware that it can go ahead and execute javascripts. That knowledge is placed in the javascript object, i.e. js object here.
	
		js.executeScript("window.scrollBy(0,700)");  // ---> If we want to run any javascript, we can do it by the console
		Thread.sleep(3000);
		
		
/*** Scrolling down a table vertically within a webpage OR scrolling down on a component***/
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");  // Used '.tableFixHead' instead of ".tableFixHead" as there are double quotes already outside in the statement
	
		
/*** Print sum of numbers under Amount column ***/		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		for(int i=0; i<values.size();i++)
		{
			// values.get(i).getText();  ---> This will return text, but we have integer at the specified location rather than text, so we will parse the string as below.
		 
			//System.out.println(Integer.parseInt(values.get(i).getText()));  
			  sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
	
		
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

		Assert.assertEquals(sum, total);
	
	
	
	}

}
