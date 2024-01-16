import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		 
		 Iterator<String> it = windows.iterator(); 
		 String parentID = it.next();
		 String childID = it.next();
		 
		
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
	
	
	}

}
