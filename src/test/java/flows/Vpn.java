package flows;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import PageObjects.BaseClass;










public class Vpn {
	static WebDriver driver;
	
	boolean status;

	
	@Test
	public void test() throws Exception {
		
		
		
		
		
			
			
			System.setProperty("webdriver.chrome.driver", "D:\\jarfiles\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addExtensions(new File("D:\\VPNCRX\\PureVPN.crx"));
			driver = new ChromeDriver(options);
	        
	
			
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Log.info("Implicit wait applied on the driver for 10 seconds");
			driver.manage().deleteAllCookies();
			driver.get("https://book.cebupacificair.com");
			new BaseClass(driver);
			
			
			Set<String> set1 = driver.getWindowHandles();
			Iterator<String> win1 = set1.iterator();
			String parent = win1.next();
			String child = win1.next();
			driver.switchTo().window(child);
			driver.close();
			driver.switchTo().window(parent);
			Thread.sleep(5000);
		
			
			
			
		
			}
		
			
	
	}	
		

	
	

