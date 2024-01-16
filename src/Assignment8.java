import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("united");
		Thread.sleep(3000);
		
	List<WebElement> dropdowns = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
	//int dropdownSize = dropdowns.size();
	
	for(WebElement dropdown : dropdowns )
	{
		if(dropdown.getText().equalsIgnoreCase("United States (USA)"))
		{
			
			dropdown.click();
			break;
			
		}
		
		
	}
		
	}

}
