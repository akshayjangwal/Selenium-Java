import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAlerts {

	public static void main(String[] args) {

		String name = "Akshay";
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();

		// ***** Read Text from pop up or window alert *****
		System.out.println(driver.switchTo().alert().getText());

		// ***** Our Alert pop up has only "OK" option, no cross, no Decline,
		// nothing....*****
		driver.switchTo().alert().accept();

		/*
		  ***** Handle Alert pop up that has "OK" and "Cancel" option ***** accept()
		  method is for positive like Yes, OK etc. dismiss () method is for negative
		  like No, Cancel etc.
		 */

		driver.findElement(By.id("confirmbtn")).sendKeys(name);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

}
