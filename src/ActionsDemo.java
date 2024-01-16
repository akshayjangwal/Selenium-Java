import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		// *** Let's create an  Actions class just like we created for Select class to handle dropdowns ***
		
		Actions a = new Actions(driver);  // We are passing driver object here so that driver now gets the capabilities of Actions class methods that we can use with our 'a' object.
		
		// **** Hover over the menu and it appears without clicking ***
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		// *** After moving to element, right click on it *** 
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		
		// *** .build() means that now this step is ready to execute.
		// *** .perform() means execute the step
		
		
		// *** Enter text in capital letters *** & *** select entire text with mouse --> we double click with mouse*** 
	
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	    
		// USER ACTIONS for line of code : Move to search box --> Type HELLO --> Select HELLO by double clicking it 
		// *** press shift key and then type anything, we see its getting typed in capital letters, this can be simulated using keyDown(Keys.SHIFT)
	
	}
	

}
