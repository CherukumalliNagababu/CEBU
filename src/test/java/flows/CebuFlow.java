package flows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import CebuModules.CebuAllModules;
import PageObjects.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;










public class CebuFlow {
	static WebDriver driver;
	private int iTestCaseRow;
	boolean status;

	
	@Test
	public void test() throws Exception {
		
		
		
		
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver", "D:\\jarfiles\\chromedriver.exe");
			driver = new ChromeDriver(options);
	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Log.info("Implicit wait applied on the driver for 10 seconds");
			driver.manage().deleteAllCookies();
			//driver.get("https://www.cebupacificair.com/en-us");
			driver.get("https://book.cebupacificair.com/Flight/Select?o1=HKG&d1=MEL&o2=&d2=&dd1=2019-10-23&ADT=2&CHD=0&INF=0&inl=0&pos=cebu.us&culture=&p=");
			
			new BaseClass(driver);
			
			//CebuAllModules.tripType();
			//CebuAllModules.enterFromAndTo();
			//CebuAllModules.enterDateAndNumberOfPassenger();
			CebuAllModules.FlightNumberDetails();
			CebuAllModules.handelAlertandGuestUser();
			CebuAllModules.enterPassengerDetails();
			CebuAllModules.extrasAddOns();
			CebuAllModules.contact_Information();
			CebuAllModules.enterCardDetails();
			
			//driver.quit();
			
		
			}
		
			
	
	}	
		

	
	

