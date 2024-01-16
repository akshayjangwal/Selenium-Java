import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
/**** 1. Select the checkbox and grab the label i.e. text of selected checkbox  (Checkbox Example) ****/
		
		String text = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		driver.findElement(By.id("checkBoxOption2")).click();
		
		
		
/**** 2. Select same label from dropdown i.e. from step 2 (Dropdown Example) ****/
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select option = new Select(dropdown);
		 option.selectByVisibleText(text);
		
		
/**** 3. Enter label text from step 2 in EditBox (Switch to Alert Example) ****/
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
			
		
/**** 4. Click Alert and verify that label text is coming in pop up you get ****/
		
		String alertMessage = driver.switchTo().alert().getText();
		if(alertMessage.contains(text))
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("No Success");
		}
		
				

	}

}
