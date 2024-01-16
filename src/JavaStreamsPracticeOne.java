import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamsPracticeOne {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
/*** Web Table sorting using Selenium Java Streams ***/		
		
//STEP 1 : Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
// STEP 2 : Capture all the webelements into the list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		
// STEP 3 : Capture text of all webelements into new (original) list
		List<String> originalList= elementList.stream().map(s->s.getText()).collect(Collectors.toList());
	
// STEP 4 : Sort the original list in step 3 to get sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());	
	
// STEP 5 : Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList)); 
	
	
	
	

	}

}
