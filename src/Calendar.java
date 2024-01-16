import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// We want to select April 14
		/***
		 * Search for a common attribute -> Put it into list and iterate Here classname
		 * 'day' is common to all the dates
		 ***/

		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("15")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}

	}

}
