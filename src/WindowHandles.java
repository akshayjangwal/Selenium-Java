import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		
		/* QUES... GO TO https://rahulshettyacademy.com/loginpagePractise/, CLICK ON LINK APPEARING ON TOP RIGHT, GRAB EMAIL ID FROM THIS NEW LINK, GO BACK TO THE PREVIOUS LINK https://rahulshettyacademy.com/loginpagePractise/ AND FILL USERNAME FIELD WITH THE EMAIL ID YOU COPIED  */

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
	
		
		/*** *** Now 2 tabs or we can say windows are opened, but our driver object will not have knowledge of the second opened tab and we need to give this knowledge to it.
	      So we need to give that knowledge to selenium, so it can shift its focus from parent to child browser. How to achieve it? *** ***/
	
		/*Step 1 : Know how many windows are opened by selenium  --> Step 2 : Get Window IDs of windows opened by our automation code */
	    /* return type of getWindowHandles() is Set<String> */
		/*Now 2 window IDs are there in the windows object, i.e. parent ID and child ID */
		
		Set<String> windows = driver.getWindowHandles();   //[parent ID, child ID] ---> captures total windows that get opened by our automation code
		
		/* we need to grab the child ID now that is provided by getWindowHandles OR we need to iterate through windows opened through our automation code */
		Iterator<String> it = windows.iterator();
		String parentID = it.next();   // control goes to 0 th index 
		String childID = it.next();    // control goes to 1st index 
		
		
		/* Switch to child window to grab mail id text */
		driver.switchTo().window(childID);
		
	   System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
		
	   /* Please email us at mentor@rahulshettyacademy.com with below template to receive response */
	 
	   String emailID = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
	   System.out.println(emailID);
	   
	   /* Now we need to switch back to parent window and insert our email id in username */ 
	   
	   driver.switchTo().window(parentID);
	   driver.findElement(By.id("username")).sendKeys(emailID);
	
	
	}

}
