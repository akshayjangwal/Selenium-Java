import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		// count number of frames on the webpage
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		/*  switching to frame using index. At 0th index, first frame will come
		//driver.switchTo().frame(0);  */ 
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//driver.findElement(By.id("draggable")).click();
		
		// Drag and Drop --> Use actions class --> pre-requisite : Use Frames

		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		// Now we need to perform an action (eg: clicking on the link) outside this frame
		//coming out of frame as we have performed all the actions on our frame component
		driver.switchTo().defaultContent();
		
	}

}
