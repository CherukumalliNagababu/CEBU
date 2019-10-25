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

import org.apache.poi.util.PngUtils;
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












public class CebuFlow2 {
	static WebDriver driver;
	private Database PnrDetails;
	boolean status;

	
	@Test
	public void test() throws Exception {
		
		
		
		
		
		if (BrowserContants.ENV.equals("PRD")) {
			RestAssured.baseURI = BrowserContants.PRD_API_URL;
			System.out.println(BrowserContants.PRD_API_URL);
			System.out.println("naga");
		} else if (BrowserContants.ENV.equals("STG")) {
			RestAssured.baseURI = BrowserContants.STG_API_URL;
			System.out.println(BrowserContants.STG_API_URL);
		}
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "text/json");
		Response response = request.get("/GetBookingFromQueue?airline=f3");
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
				
				PnrDetails=data;
				String depMonthFullNameandYear = null;
				String depOnlyDate = null;
				String retMonthFullNameandYear = null;
				String retOnlyDate = null;
				if (data.TripType.equals("OneWay")) {
					Date depDate = new SimpleDateFormat("dd MMM yyyy").parse(data.DepartureDate);
					SimpleDateFormat depMonthYear = new SimpleDateFormat("MMMM yyyy");
					SimpleDateFormat depOnlydate = new SimpleDateFormat("dd");
					depMonthFullNameandYear = depMonthYear.format(depDate);
					depOnlyDate = depOnlydate.format(depDate);
				} else if (data.TripType.equals("RoundTrip")) {
					Date retDate = new SimpleDateFormat("dd MMM yyyy").parse(data.ReturnDate);
					SimpleDateFormat retMonthYear = new SimpleDateFormat("MMMM yyyy");
					SimpleDateFormat retOnlydate = new SimpleDateFormat("dd");
					retMonthFullNameandYear = retMonthYear.format(retDate);
					retOnlyDate = retOnlydate.format(retDate);
				}
				
				System.out.println("depMonthFullNameandYear:"+depMonthFullNameandYear);
				System.out.println("depOnlyDate:"+depOnlyDate);
				System.out.println("retMonthFullNameandYear:"+retMonthFullNameandYear);
				System.out.println("retOnlyDate:"+retOnlyDate);
				
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver", "D:\\jarfiles\\chromedriver.exe");
			driver = new ChromeDriver(options);
	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies();
			driver.get("https://partners.cebupacificair.com");
			
			new BaseClass(driver);
			
			
			CebuAllModules.Agent_Login(PnrDetails);
			CebuAllModules.tripType_2(PnrDetails);
			CebuAllModules.enterFromAndTo_2(PnrDetails);
			CebuAllModules.enterDateAndNumberOfPassenger_2(PnrDetails,depMonthFullNameandYear,depOnlyDate,retMonthFullNameandYear,retOnlyDate);
			CebuAllModules.FlightNumberDetails_2(PnrDetails);
			CebuAllModules.enterPassengerDetails_2(PnrDetails);
			CebuAllModules.extrasAddOns_2();
			//CebuAllModules.Payment();
			
			
			
		
			
		
			}
		
		catch(Exception e)
		{

			// pnrId, Domain, status, remarks

		    CebuModules.passengersDetails.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId,CebuAllModules.status);
			System.out.println("PNR ID:"+PnrDetails.PnrId +" DOMAIN NAME "+PnrDetails.Domain+"  FAIL  "+""+e.getMessage());
			System.out.println(e);
			Thread.sleep(5000);
			//driver.quit();
				
			continue;
		}
	}
			
	
	}	
		
}

	
	

