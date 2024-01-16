import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(3000);
		
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		//after typing ind, right click there itself and click inspect to land to the exact element
		//List<WebElement> is the return type, options is the object
		
		/*Whenever we see auto suggestive dropdown :
			Provide input >> Figure out generic locator that extracts all the items under that autosuggestive dropdown >> 
			Store them in List >> Iterate over the list >> Find your element and getText()*/

		for(WebElement option:options)                         //-----> Enhanced for loop
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		// ************** Click the checkbox on the page *************
	
	System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());  //-----> should return "false" the first time
	
	// ******************** Using Assertions for comparision i.e. this above line will now become as below line  *************************
	
	//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());  //------> expects false value
	
	driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();                          //----------> Using regular expression as id is having complex name so to keep it readable, we do like this. . .
	System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());   //----------> should return "true"
	
	
	// ********** Counting total number of checkBoxes in a page
	System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	
	
	// ******** Handling something when it is enabling and disabling ("return date" in this case) *********
	
	/* disabled ---> opacity: 0.5; display: block;
	   enables ----> opacity: 1; display: block;
	*/
	
	
	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
	{
		System.out.println("Its enabled");
		Assert.assertTrue(true);
	}
	else
	{
		System.out.println("Its disabled");
		Assert.assertTrue(false);
	}
	
	
	
	
	
	}

}
