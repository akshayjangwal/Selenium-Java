import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link : links)
		{
			 /* 
		     Step 1 : Get to all URLs tied up to the links using Selenium
		     Step 2 : Take help of Java methods which will call the URLs & get status code
		     Step 3 : If status code > 400, it means URL is not working --> Link tied to URL is broken
		 
		     a[href*="soapui"]   ---> CSS selector regular expression
		     a[contains(@href,'soapui')]  ---> XPath regular expression 
		  */
			
	    String url = link.getAttribute("href");
		
		  /* There is one URL class in java hich exposes openConnection() method 
		     Let's create an object of URL class to access its openConnection() method */
		
	    HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		   
		   /* We need to call openConnection() method --> This method is present in URL class, so we created the object i.e. new URL()
		   and calling that method via object.method() --> Return type for openConnection() method is HttpURLConnection --> We are casting
		   the return type we got */
		   
		 conn.setRequestMethod("HEAD");
		 conn.connect();
		 int respCode = conn.getResponseCode();
		 System.out.println(respCode);
		 a.assertTrue(respCode<400, "The link with text "+link.getText()+" is broken with code "+respCode);
		 
		/*if (respCode>400)
		{
			
			System.out.println("The link with text "+link.getText()+" is broken with code "+respCode);
			Assert.assertTrue(false);   //---> Hard Assertion
			
		  //Here our script terminated as soon as it encountered a broken link, but what if there are more broken links? Here comes the concept of "Soft Assertions"
		
		} */
		
		}
		a.assertAll(); //---> reports all the catched errors in our for loop
	 
	}

}
