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

import CebuModules.BrowserContants;
import CebuModules.CebuAllModules;
import PageObjects.BaseClass;
import PageObjects.Database;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;











public class CebuSRP {
	static WebDriver driver;
	boolean status;
	private Database PnrDetails;
	
	@Test
	public void test() throws Exception {
		

		if (BrowserContants.ENV.equals("PRD")) {
			RestAssured.baseURI = BrowserContants.PRD_API_URL;
			System.out.println(BrowserContants.PRD_API_URL);
			
		} else if (BrowserContants.ENV.equals("STG")) {
			RestAssured.baseURI = BrowserContants.STG_API_URL;
			System.out.println(BrowserContants.STG_API_URL);
		}
		
		
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "text/json");
		Response response = request.get("/Get5JRoutes");
		System.out.println("Response body: " + response.body().asString());
		String s=response.body().asString();
		System.out.println(s);
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		
		Gson g = new Gson();
		Database[] mcArray = g.fromJson(s, Database[].class);
		List<Database> p = Arrays.asList(mcArray);
		for(Database data:p){
			try{
				
				
				Date depDate=new SimpleDateFormat("dd MMM yyyy").parse(data.DepartureDate);  
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
				String strDate= formatter.format(depDate);
				String YearMDate= formatter2.format(depDate);
				
				System.out.println("strDate :"+strDate);
				System.out.println("YearMonthDAte :"+YearMDate);
				
				//String cebuApiUrl="https://book.cebupacificair.com/Flight/Select?o1="+data.From+"&d1="+data.To+"&o2=&d2=&dd1="+strDate +"&ADT=1&CHD=0&INF=0&inl=0&pos=cebu.us&culture=&p=";
				String cebuApiUrl="https://book.cebupacificair.com/Flight/InternalSelect?o1=MNL&d1=MEL&o2=&d2=&dd1=2019-10-25&p=&ADT=1&CHD=0&INF=0&inl=0&s=true&mon=true";
				
				System.out.println("API URL"+cebuApiUrl);
				
				PnrDetails=data;
				
            
		
		
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver", "D:\\jarfiles\\chromedriver.exe");
			driver = new ChromeDriver(options);
	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Log.info("Implicit wait applied on the driver for 10 seconds");
			driver.manage().deleteAllCookies();
			//driver.get(cebuApiUrl);
			driver.get("https://partners.cebupacificair.com");
			new BaseClass(driver);
			
			CebuAllModules.Agent_Login();
			CebuAllModules.tripType_SRP();
			CebuAllModules.enterFromAndTo_SRP(data.From,data.To);
			CebuAllModules.enterDateAndNumberOfPassenger_SRP();
			CebuAllModules.Flight_Srp_Details(driver,PnrDetails,YearMDate,depDate);
		
			
			driver.quit();
			
		
			}
		
			catch(Exception e)
			{
				
			}
		}
	}
	
	}	
		

	
	

