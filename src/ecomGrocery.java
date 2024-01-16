import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ecomGrocery {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
/***** ADD TO CART - CUCUMBER  *****/
		// Approach 1 (search via button) : //button[text()='ADD TO CART'] ---> xpath not unique, 30 elements matching, so can't use
        // Approach 2 (search via product name) : h4.product-name ---> xpath not unique, 30 elements matching, so can't use
	
		// Approach (on which index cucumber is present) 
		//--> Take all product names -> Iterate through each one of them -> Get the index on which cucumber is present -> Go and click that button ---> tomorrow even if index of cucumber changes, we shall still be able to find it, so we are making our code dynamic
	
	    // If one element to be selected --> WebElement product = driver.findElement(By.cssSelector("h4.product-name"));
	
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
	for(int i=0; i<products.size();i++)
	{
		String productName = products.get(i).getText();
		
		if(productName.contains("Cucumber"))
		{
			// click on ADD TO CART 	
			
			driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			break;
			
		}
	
	
	
	
	
	
	}
	
	
	
	}

}
