import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium3 {

	public static void main(String[] args) throws InterruptedException {
		 
		String name = "Akshay";
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
	
		//Identify button based upon its text
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	
	}
	
     /*public void getPassword(WebDriver driver) throws InterruptedException
    {
    	 driver.get("https://rahulshettyacademy.com/locatorspractice/");
    	 driver.findElement(By.linkText("Forgot your password?")).click();
 		Thread.sleep(1000);
 		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
 		String PasswordText = driver.findElement(By.className("infoMsg")).getText();
 		String [] PasswordArray = PasswordText.split("'");
 		
 		//PasswordText[0] = Please use temporary password
 		//PasswordText[1] = rahulshettyacademy' to Login.
 		
 		System.out.println("PasswordArray[1].split(\"'\");");
 		
 		
 		
 				
    }*/

}
