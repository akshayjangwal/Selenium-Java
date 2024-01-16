import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import com.sun.jdi.Method;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		/*** Here driver object knows how to open URL, but now we want to change its behaviour to capturing screenshots
             We can do that by casting driver with a method "TakesScreenshot"***/
	
		//((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)
		
	   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   
	/*** We are casting our driver object to TakeScreenshot so it is ready to capture the screenshots by using method "getScreenshotAs". 
	   Method "getScreenshotAs" will only be visible when we cast our driver object to TakeScreenshot Method
	   OutputType.FILE ---> After taking the screenshot, provide the output as a File which we are storing in 'src' object ***/
	
	   //Now let's copy the screenshot from "src" object to our local machine by using "FileUtils" method
	
	FileUtils.copyFile(src,new File("C:\\Users\\aksha\\screenshot.png"));
	
	}

}
