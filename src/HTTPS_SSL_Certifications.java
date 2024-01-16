import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPS_SSL_Certifications {

	public static void main(String[] args) {
		
//--> ChromeOptions class helps set up a particular behaviour for our chrome browser	
		ChromeOptions options= new ChromeOptions();  
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
		
		System.out.println(driver.getTitle());
			

	}

}
