import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interview {

	public static void main(String[] args) throws InterruptedException {
		
		//Invoking Browser
		//Chrome - ChromeDriver -> Methods
		//webdriver.chrome.driver -> This is the key. In this key, we will give the value of path where exactly the chrome driver is present in our local
		//System.setProperty("key", "value")
		//implicit wait - time waiting / time out
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://voereir.com/");
	
		driver.findElement(By.linkText("Contact")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("akshay"); 
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("akshayjangwal59@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Contact Number']")).sendKeys("8576837489");
		//driver.findElement(By.cssSelector("input[placeholder='location']")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("input[placeholder='Subject']")).sendKeys("Written Test at VoerEir");
		driver.findElement(By.cssSelector("textarea[placeholder='Message']")).sendKeys("Automation code assessment"); 
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-submit']")).click();
		
		/*driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("About us")).click();
		driver.findElement(By.linkText("Offerings")).click();
		driver.findElement(By.linkText("Contact")).click();*/
		
}
}

