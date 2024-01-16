import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='name']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@name='email']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("akshay@ymail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("hello123");
		driver.findElement(By.cssSelector("input#exampleCheck1")).click();
		
		WebElement usegender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(usegender);
		gender.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@type='date']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("23-04-1997");

		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
	}
}
