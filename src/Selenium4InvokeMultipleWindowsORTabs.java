import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4InvokeMultipleWindowsORTabs {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
/* We need to grab text from above URL and paste to a different one. For that we open the URL from where text needs to be grabbed
   in a new tab by using below command */	
		
		driver.switchTo().newWindow(WindowType.TAB);  //--> Opens new Tab
		// driver.switchTo().newWindow(WindowType.WINDOW);  --> Opens new window
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
		driver.get("https://rahulshettyacademy.com/");
		String FirstCourseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
	    System.out.println(FirstCourseName);
	    
	    driver.switchTo().window(parentWindow);
	    WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
	    name.sendKeys(FirstCourseName);
	    
/* Get WebElement Screenshot, not of the entire page */
	    
	    File src = name.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File("snapshot.png"));
	    
/* Get Dimensions (Height & Width) of Element */   
	    
	    
	    System.out.println(name.getRect().getDimension().getHeight());
	    System.out.println(name.getRect().getDimension().getWidth());
	    
	
	}

}
