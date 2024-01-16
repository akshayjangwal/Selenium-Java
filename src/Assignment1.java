import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	// ***** Q1 - Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked ******
	    driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).isSelected());
		
		driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).isSelected());
		
	// ***** Q2 - get the Count of number of check boxes present in the page *****	
		
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}

}
