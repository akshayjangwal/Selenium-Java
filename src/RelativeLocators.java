import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; 

//----> to be written here manually since its a static package, so eclipse does not give auto suggestion for this.

public class RelativeLocators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        //driver.findElement(By.xpath("//form/div[1]/label"));
        
        // Let's use Relative locators instead : 
        
       WebElement name =  driver.findElement(By.xpath("//input[@name='name']"));
      System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());
       
      WebElement IceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
       driver.findElement(with(By.tagName("input")).toLeftOf(IceCreamLabel)).click();
	
	
	
	
	
	
	
	
	
	
	}

}
