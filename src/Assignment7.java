import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//driver.findElement(By.id("details-button")).click();
		//driver.findElement(By.id("proceed-link")).click();
		//Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		
		js.executeScript("window.scrollBy(0,650)");
		
/*** print total number of rows in the table ***/
		System.out.println(driver.findElements(By.cssSelector(".table-display tr")).size());
		
/*** print total number of columns in the table ***/
		System.out.println(driver.findElements(By.cssSelector(".table-display tr:nth-child(1) th")).size());

/*** print third row of the table ***/
	System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3) ")).getText());
		
			 
		// Trainer Rahul Shetty has followed a different approach ---- refer video for the same //
		
		
		
		
		
		

	}

}
