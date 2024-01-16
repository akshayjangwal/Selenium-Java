import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
	//************* HANDLING STATIC DROPDOWNS *********
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));   //-----> stored webelement dropdown's address in a VARIABLE staticDropDown
		Select dropdown = new Select(staticDropDown);               //------------------------> created an object of SELECT class
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());    //-----> Display the selected option in output
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText()); 
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText()); 
		
		
	// *********** HANDLING PASSENGERS DROPDOWN ************
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		
		int i=1;   //---> initialise
		while(i<5)  // ---> condition
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;    // ----> increment operator
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	 // ************* DYNAMIC XPATH***************
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();         //----> //a[@value='MAA'] -------> (//a[@value='MAA'])[2]
		
//If we do not wish to use indexing, then we can use ****** PARENT CHILD RELATIONSHIP ******
		//-----> //div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']  IS SAME AS "//a[@value='BLR']")
	
	}
	
	
	
  
}
