import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
/***** 1. Count number of links on the webpage *****/
		
		
		System.out.println(driver.findElements(By.tagName("a")).size());   // We know that every link will have a tagname as 'a' i.e. anchor
		
/***** 2.Count number of links in the footer section *****/
		          /*Concept of limiting webDriver scope */
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));    /* We need to change driver scope to footer section only as driver's scope is on the entire page "https://www.rahulshettyacademy.com/AutomationPractice/" */ 
		
		
	    System.out.println(footerDriver.findElements(By.tagName("a")).size());   // Now this footerDriver plays the role of driver here which is limited to footer section only. 
	
/*****  3. Get number of links in first column of footer section *****/
	  // We will create a webDriver scope limited to first column of footer section
	    
	    
	    WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	    System.out.println(columnDriver.findElements(By.tagName("a")).size());
	    
	    
/***** 4. Click on each link in the page and check if the links are opening *****/
	
	    for(int i=1; i<columnDriver.findElements(By.tagName("a")).size() ; i++)
	    {
	    	//columnDriver.findElements(By.tagName("a")).get(i).click();     //By following just this, it will throw an error as we are now on first clicked link (Rest API) webpage, and that does not have second clickable link (Soap UI) now
	    	 // Approach 1 :  Click first link -> Navigate back to click second link -> Click on second link -> Navigate back to click third link ...... This is time consuming and not very effective approach
	         // Approach 2 : ctrl + click on a link opens a link in new tab. So we can open all the links like this in new tab without navigating back and forth to different webpage like in Approach 1.
	     
	    	String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);    // This combination lets you click on any link so it can open in another tab
	    	columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);  // Whenever there is a keyboard event, pass that as a sendkeys method. 
	        Thread.sleep(5000);
	    }
	    
/***** 5. Get the title of each and every tab *****/
	    
	    Set<String> windowTabs = driver.getWindowHandles();
	    Iterator<String> it = windowTabs.iterator();
	   
	    while(it.hasNext())            // hasNext() tells whether there is any next window present or not.
	    {
	    	driver.switchTo().window(it.next());   //it.next() switches to the next window
	    System.out.println(driver.getTitle());
	    
	    }
	    
	    
	
	
	
	
	}

}
