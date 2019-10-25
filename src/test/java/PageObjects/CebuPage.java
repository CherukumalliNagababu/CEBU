package PageObjects;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.Page;







public class CebuPage extends BaseClass {

	private static WebElement element;
	
	
	public CebuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement pop_Up() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("popup"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement ScrollDown() throws Exception {
		element = null;
		try {
			PageUtils.scrollDown(driver);
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Agent_UserName() throws Exception {
		element = null;
		try {
			PageUtils.isElementLocated(driver, By.id("agent-username"));
			element = driver.findElement(By.id("agent-username"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement Agent_PWD() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("agent-password"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement Agent_Login_Btn() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("btn-agent-login"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement oneyWay2() throws Exception {
		element = null;
		try {
			PageUtils.isElementLocated(driver, By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Round-Trip'])[1]/following::label[1]"));
			Thread.sleep(2000);
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Round-Trip'])[1]/following::label[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement roundTrip2() throws Exception {
		element = null;
		try {
			PageUtils.isElementLocated(driver, By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='One-Way'])[1]/preceding::label[1]"));
			Thread.sleep(2000);
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='One-Way'])[1]/preceding::label[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement oneyWay() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='flightType']//div[2]//label[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement roundTrip() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='flightType']//div[1]//label[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement multiCity() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='multicity']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement Clk_From2() throws Exception {
		element = null;
		try {
			PageUtils.isElementLocated(driver, By.id("station-input-departure-1"));
			element = driver.findElement(By.id("station-input-departure-1"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Clk_To2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("station-input-arrival-1"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Clk_From() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("FromStation"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Clk_To() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("ToStation"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_MonthChange() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@class='daypicker-navbutton daypicker-navbutton--next']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}

	public static WebElement header_Month_D_2(String HeaderMonth) throws Exception {
		element = null;
		try {
			for(int i=0;i<=5;i++){
			element = driver.findElement(By.xpath("//div[@class='daypicker-caption']"));
			System.out.println(element.getText());
			if(element.getText().equals(HeaderMonth))
			{
				System.out.println(element.getText());
				break;
			}
			else{
				driver.findElement(By.xpath("//span[@class='daypicker-navbutton daypicker-navbutton--next']")).click();
			}
			}
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_Calender_R_Clk() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("date-input-arrival"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> select_Date_D_2(String Date) throws Exception {
		List<WebElement> element = null;
		Date mDate = new Date();
		 DateFormat date = new SimpleDateFormat("dd");
		 String currentDate=date.format(mDate);
			//element = driver.findElement(By.xpath("//div[@class='calendar left single']//td[not(contains(@class,'off available'))]"));
			try{
				if(currentDate.equals(Date))
				{
					driver.findElement(By.xpath("//div[@class='daypicker-day daypicker-day--today']")).click();
					
				}
				else{
					
				 element = driver.findElements(By.xpath("//div[@class='daypicker-day']"));
				 for (WebElement e1 : element) {
						String ele = e1.getText();
						

						if (ele.equals(Date)) {
							System.out.println("OneWay:Select Date:"+e1.getText());
							e1.click();	
							break;
						}
						// Thread.sleep(1000);
					}
				
				}
		
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement header_Month_D(String HeaderMonth) throws Exception {
		element = null;
		try {
			for(int i=0;i<=5;i++){
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Departing On:'])[1]/following::span[5]"));
			if(element.getText().equals(HeaderMonth))
			{
				System.out.println(element.getText());
				break;
			}
			else{
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Departing On:'])[1]/following::span[6]")).click();
			}
			}
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> select_Date_D(String Date) throws Exception {
		List<WebElement> element = null;
		Date mDate = new Date();
		 DateFormat date = new SimpleDateFormat("dd");
		 String currentDate=date.format(mDate);
			//element = driver.findElement(By.xpath("//div[@class='calendar left single']//td[not(contains(@class,'off available'))]"));
			try{
				if(currentDate.equals(Date))
				{
					driver.findElement(By.xpath("//table[@class='calendar']//tbody/tr/td[@class='day selected departure-date']")).click();
					
				}
				else{
					
				 element = driver.findElements(By.xpath("//table[@class='calendar']//tbody/tr/td[@class='day']"));
				 for (WebElement e1 : element) {
						String ele = e1.getText();
						

						if (ele.equals(Date)) {
							System.out.println("OneWay:Select Date:"+e1.getText());
							e1.click();	
							break;
						}
						// Thread.sleep(1000);
					}
				
				}
		
		} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement adult_increase2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(12+ years)'])[1]/following::button[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement child_increase2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(2 - 11 years)'])[1]/following::button[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement infant_increase2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(Under 2)'])[1]/following::button[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_FindFlight2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.cssSelector("button.btn-flat.blue.btn-find-flights"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_Continue_selectInfant() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("btn-continue"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement adult_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(2-11 years)'])[2]/preceding::i[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement child_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(Under 2 years)'])[2]/preceding::i[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement infant_increase() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Promo Code'])[1]/preceding::i[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_FindFlight() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//strong[contains(text(),'FIND FLIGHTS')]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement flight_Numbers2_D(String FlightNUM1,String FlightNUM2) throws Exception {
		element = null;
		Thread.sleep(10000);
		
		try {
			PageUtils.isElementLocated(driver, By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr"));
			List<WebElement> element = driver.findElements(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr"));
			//List<WebElement> element1 = driver.findElements(By.xpath("//div[@id='collapseOne0']//tbody//tr[1]//td[5]//button[1]"));
			String ApiBag="FLY ONLY";
			//System.out.println("element.size:"+element.size());
			for(WebElement e:element)
			{
				//System.out.println(e.getText());
			}
			
			for(int i=1;i<=element.size();i++)
			{
				
				        if (driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText().equals(FlightNUM1))
						{
				        	String FlightNumber1=driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText();
				        	System.out.println("FlightNumber:"+FlightNumber1);
				        	
				        	if(!FlightNUM2.isEmpty()){
				        	if (driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[2]/a")).getText().equals(FlightNUM2))
							{
				        		if("FLY ONLY".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
					        		
					        	}
					        	else if("FLY + BAGGAGE".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
					        		
					        	}
					        	
					        
							    break;
				        		
				        	}
				        	}
				        	
						
				        

				        	if("FLY ONLY".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
				        		
				        	}
				        	else if("FLY + BAGGAGE".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
				        		
				        	}
				        	
				        
				        	
						  
						   // break;	       
			}
			
			
			
			
			
			
			
		} 
		}catch (Exception e) {
			System.out.println("FLIGHT NUMBER DOES NOT FOUND");
			throw (e);
			
		}
		return element;
	}
	
	public static List<WebElement> flight_Numbers2_DEP(String FlightNUM1,String FlightNUM2) throws Exception {
		element = null;
		Thread.sleep(10000);
		
		
			PageUtils.isElementLocated(driver, By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr"));
			List<WebElement> element = driver.findElements(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr"));
			//List<WebElement> element1 = driver.findElements(By.xpath("//div[@id='collapseOne0']//tbody//tr[1]//td[5]//button[1]"));
			String ApiBag="FLY ONLY";
			
			if(!FlightNUM2.isEmpty()){
			for(int i=1;i<=element.size();i++)
			{
				
				        if (driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText().equals(FlightNUM1))
						{
				        	String FlightNumber1=driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText();
				        	System.out.println("FlightNumber:"+FlightNumber1);
				        	
				        	if(!FlightNUM2.isEmpty()){
				        	if (driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[2]/a")).getText().equals(FlightNUM2))
							{
				        		if("FLY ONLY".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
					        		
					        	}
					        	else if("FLY + BAGGAGE".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
					        		
					        	}
					        
							    break;
				        		
				        	}
				        	}
				  
				        	
				        	
				            
			}
			
			
			
			
			
			
			
		} 
		}
			if(FlightNUM2.isEmpty()){
				for(int i=1;i<=element.size();i++)
				{
					
					        if (driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText().equals(FlightNUM1))
							{
					        	String FlightNumber1=driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText();
					        	System.out.println("FlightNumber:"+FlightNumber1);
					       
					        	if("FLY ONLY".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
					        		
					        	}
					        	else if("FLY + BAGGAGE".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
					        		
					        	}
					        	
					         break;   
				}
				
				
				
				
				
				
				
				}
			}
			
			
		
		return element;
	}
	public static WebElement flight_Numbers2_RET(String FlightNUM1,String FlightNUM2) throws Exception {
		element = null;
		Thread.sleep(10000);
		try {
			PageUtils.isElementLocated(driver, By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr"));
			List<WebElement> element = driver.findElements(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr"));
			//List<WebElement> element1 = driver.findElements(By.xpath("//div[@id='collapseOne0']//tbody//tr[1]//td[5]//button[1]"));
			String ApiBag="FLY ONLY";
			
			if(!FlightNUM2.isEmpty()){
			for(int i=1;i<=element.size();i++)
			{
				
				        if (driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText().equals(FlightNUM1))
						{
				        	String FlightNumber1=driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText();
				        	System.out.println("FlightNumber:"+FlightNumber1);
				        	
				        	if(!FlightNUM2.isEmpty()){
				        	if (driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[2]/a")).getText().equals(FlightNUM2))
							{
				        		if("FLY ONLY".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
					        		
					        	}
					        	else if("FLY + BAGGAGE".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
					        		
					        	}
					        
							    break;
				        		
				        	}
				        	}
				
			}
			}
	
		} 
			
			if(FlightNUM2.isEmpty()){
				for(int i=1;i<=element.size();i++)
				{
					
					        if (driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText().equals(FlightNUM1))
							{
					        	String FlightNumber1=driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText();
					        	System.out.println("FlightNumber:"+FlightNumber1);
					       
					        	if("FLY ONLY".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
					        		
					        	}
					        	else if("FLY + BAGGAGE".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
					        		
					        	}
					        	
					         break;   
				}
				
				
				
				
				
				
				
				}
			}
			
			
		}catch (Exception e) {
			System.out.println("FLIGHT NUMBER DOES NOT FOUND");
			throw (e);
			
		}
		return element;
	}
	public static WebElement flight_Numbers2_R(String FlightNUM1,String FlightNUM2) throws Exception {
		element = null;
		Thread.sleep(5000);
		try {
			PageUtils.isElementLocated(driver, By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr"));
			List<WebElement> element = driver.findElements(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr"));
			//List<WebElement> element1 = driver.findElements(By.xpath("//div[@id='collapseOne0']//tbody//tr[1]//td[5]//button[1]"));
			String ApiBag="FLY ONLY";
			//System.out.println("element.size:"+element.size());
			for(WebElement e:element)
			{
				//System.out.println(e.getText());
			}
			
			for(int i=1;i<=element.size();i++)
			{
				//System.out.println(11);
				
				if (driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText().equals(FlightNUM1))
						{
				        	String FlightNumber=driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[1]/a")).getText();
				        	System.out.println("FlightNumber:"+FlightNumber);
				        	
				        	if(!FlightNUM2.isEmpty()){
				        	if (driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[1]/div[2]/a")).getText().equals(FlightNUM2))
							{
				        		if("FLY ONLY".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
					        		
					        	}
					        	else if("FLY + BAGGAGE".equals(ApiBag))
					        	{
					        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
					        		
					        	}
					        	
					        
							    break;
				        		
				        	}
				        	}
				        	
						
				        

				        	if("FLY ONLY".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[1]//input")).click();
				        		
				        	}
				        	else if("FLY + BAGGAGE".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//div[2]/div[4]//table[@class='table']//tbody/tr["+i+"]/td[5]/div[2]//input")).click();
				        		
				        	}
				        	
				        
				        	
						  
						    //break;	       
						}
				        

				       
			
			
			
			
			
			
						
			}
			
		} catch (Exception e) {
			System.out.println("FLIGHT NUMBER DOES NOT FOUND");
			throw (e);
			
		}
		return element;
	}
	
	
	public static WebElement flight_Numbers(String FlightNUM) throws Exception {
		element = null;
		try {
			List<WebElement> element = driver.findElements(By.xpath("//table[@id='depart-table']//tbody/tr/th/div[1]"));
			List<WebElement> element1 = driver.findElements(By.xpath("//div[@id='collapseOne0']//tbody//tr[1]//td[5]//button[1]"));
			String ApiBag="FLY ONLY";
			//System.out.println("element.size:"+element.size());
			for(WebElement e:element)
			{
				System.out.println(e.getText());
			}
			
			for(int i=1;i<=element.size();i++)
			{
				//System.out.println(11);
				        if (driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/th/div[1]")).getText().equals(FlightNUM))
						{
				        	String FlightNumber=driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/th/div[1]")).getText();
				        	System.out.println("FlightNumber:"+FlightNumber);
				        	if("FLY ONLY".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/td[5]")).click();
				        		
				        	}
				        	else if("FLY + BAGGAGE".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/td[6]")).click();
				        		
				        	}
				        	else if("FLY + BAGGAGE + MEAL".equals(ApiBag))
				        	{
				        		driver.findElement(By.xpath("//table[@id='depart-table']//tbody/tr["+i+"]/td[7]")).click();
				        		
				        	}
				        
				        	
						  
						    break;
						}
				        

				       
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("FLIGHT NUMBER DOES NOT FOUND");
			throw (e);
			
		}
		return element;
	}
	public static WebElement WebSite_Amount2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Admin, Taxes and Fees'])[2]/preceding::p[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement WebSite_Amount() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//p[@class='amount']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Continue_Srp2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.linkText("CONTINUE"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Continue_Srp() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("submit_search_button"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_Alert_close2() throws Exception {
		element = null;
		try {
			PageUtils.isElementLocated(driver, By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Important Reminder'])[1]/following::a[1]"));
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Important Reminder'])[1]/following::a[1]"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement btn_Alert_close() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[@id='int-flight-reminder-modal-close']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Clk_continueGuestToggleBar() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("continueGuestToggleBar"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-2"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-3"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-4"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-5"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-6"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-7"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_8() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-8"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement Tab_9() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("guest-tab-link-9"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	
	public static WebElement Clk_Forward() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@class='arrow forward']//a"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	public static WebElement tabs() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//a[@id='guest-tab-link-4']"));
			} catch (Exception e) {
			throw (e);
		}
		return element;
	}
	
	
	//***********************************
	public static WebElement drp_title_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='passengers_0__Name_Title-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static List<WebElement> select_Value(String Value) throws Exception {
		List<WebElement> element = null;
		try {
			element = driver.findElements(By.xpath("//div[@class='ui-selectmenu-menu ui-front ui-selectmenu-open']/ul/li"));
			
				for (WebElement e1 : element) {
					String ele = e1.getText();
					

					if (ele.equals(Value)) {
						System.out.println("Select Value:"+e1.getText());
						e1.click();	
						break;
					}
			}
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement firstname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_0__Name_First"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_0__Name_Last"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement drp_date_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_month_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_year_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement btn_Nationality_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='nationality_0-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	
	//***********************************
	public static WebElement drp_title_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='passengers_1__Name_Title-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	
	public static WebElement firstname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_1__Name_First"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement lastname_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("cebPassengers_1__Name_Last"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement drp_date_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_month_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_year_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement btn_Nationality_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//span[@id='nationality_1-button']/span[2]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	
	
	//***********************************
		public static WebElement drp_title_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='passengers_2__Name_Title-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		
		public static WebElement firstname_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("cebPassengers_2__Name_First"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement lastname_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("cebPassengers_2__Name_Last"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement drp_date_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement drp_month_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement drp_year_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement btn_Nationality_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("//span[@id='nationality_2-button']/span[2]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		
		//***********************************
				public static WebElement drp_title_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_3__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_3__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_3__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				//***********************************
				public static WebElement drp_title_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_4__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_4__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_4__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
		
				//***********************************
				public static WebElement drp_title_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_5__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_5__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_5__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				//***********************************
				public static WebElement drp_title_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_6__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_6__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_6__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				
				//***********************************
				public static WebElement drp_title_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_7__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_7__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_7__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				//***********************************
				public static WebElement drp_title_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='passengers_8__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement firstname_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_8__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement lastname_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_8__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_day_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_month_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_birth_year_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='nationality_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				//*************************** Infants
		
				public static WebElement I_drp_title_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_0__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_0__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_0__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				//*************************** 
				
				public static WebElement I_drp_title_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_1__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_1__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_1__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
//*************************** 
				
				public static WebElement I_drp_title_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_2__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_2__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_2__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
//*************************** 
				
				public static WebElement I_drp_title_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_3__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_3__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_3__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
//*************************** 
				
				public static WebElement I_drp_title_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_4__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_4__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_4__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
//*************************** 
				
				public static WebElement I_drp_title_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_5__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_5__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_5__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
//*************************** 
				
				public static WebElement I_drp_title_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_6__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_6__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_6__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
//*************************** 
				
				public static WebElement I_drp_title_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infants_7__Name_Title-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
				public static WebElement I_firstname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_7__Name_First"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_lastname_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebPassengers_Infants_7__Name_Last"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_day_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_month_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_date_of_birth_year_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='infant_nationality_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement btn_Continue_Passenger() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("submit_search_button"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement PopUp_No_Meal() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//button[@id='noMealConfirmationNo']"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_Proceed_Yes() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("buttonProceedConfirmationYes"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_submitPhTravelTax() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("submitPhTravelTax"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement chk_Agree() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pre-paid Baggage'])[1]/preceding::ins[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_Confirm_Continue() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("bookingRecapOK"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				
				//Contact Information
				
				
				
				public static WebElement contact_number_CountryCode() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebContactPayment_HomePhoneCountryCode-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement contact_number() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_Contact_HomePhone"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement Alt_Contact_number_CountryCode() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebContactPayment_OtherPhoneCountryCode-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement Alt_Contact_number() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_Contact_OtherPhone"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement contact_Email() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_Contact_EmailAddress"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement contact_Confirm_Email() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cebContactPayment_ConfirmEmail"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_creditCard() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//label[@class='credit-card-tab']"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement txt_cardNumber() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Card Number*'])[1]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement txt_validationNumber() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Validation Number'])[1]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_Exp_Month() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebExternalPayment_expMonth0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement drp_Exp_Year() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='cebExternalPayment_expYear0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement txt_CardHolder_First_Name() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cardholder Name:'])[1]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement txt_CardHolder_Last_Name() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cardholder Name:'])[1]/following::input[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				
				public static WebElement txt_Street_Address() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Street Address*'])[1]/preceding::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement txt_city_name() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='City*'])[1]/preceding::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement billing_Country_Code() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='City*'])[1]/following::span[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement billing_state() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Country*'])[2]/following::span[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement billing_ZipCode() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Zip Code'])[1]/preceding::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement chk_Privacy() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Privacy Policy'])[1]/preceding::ins[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				public static WebElement btn_Submit_Card() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("submit_search_button"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				// Passport Details 1
				
				
				
				public static WebElement txt_Passport_Num_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_0"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_0-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement chk_Pasport_In_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Privacy Policy'])[1]/preceding::div[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 2
				
				
				
				public static WebElement txt_Passport_Num_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_1"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_1-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
// Passport Details 3
				
				
				
				public static WebElement txt_Passport_Num_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_2"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_3() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_2-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 4
				
				
				
				public static WebElement txt_Passport_Num_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_3-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
// Passport Details 5
				
				
				
				public static WebElement txt_Passport_Num_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_4"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_5() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_4-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 6
				
				
				
				public static WebElement txt_Passport_Num_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_5"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_6() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_5-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
// Passport Details 7
				
				
				
				public static WebElement txt_Passport_Num_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_6"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_7() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_6-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
// Passport Details 8
				
				
				
				public static WebElement txt_Passport_Num_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_7"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_8() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_7-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
// Passport Details 9
				
				
				
				public static WebElement txt_Passport_Num_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passportNumber_8"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}		
				
				public static WebElement select_country_Of_Issue_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='issuingCountry_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_month_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_day_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_day_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Year_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//span[@id='date_of_expiration_year_8-button']/span[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
		//Cebu Flow Two2
				
				//***********************Passenger 1************************************
	public static WebElement drp_title2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-title-pax-0"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement firstname2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-fname-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement middleName2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-mname-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement lastname2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-lname-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement drp_date2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[1]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_month2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[1]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_year2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[1]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement btn_Nationality2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-nationality-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement chk_Nationality_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("chkbox-pax-is-liex-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement drp_countryOfRe_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-country-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement chk_countryOfRe_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[1]/following::input[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement txt_Passport_Num2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement Passport_issuing_Country_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-pax-0"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement drp_pass_Exp_day2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[3]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_pass_Exp_Month2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[3]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_pass_Exp_Year2_1() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[3]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	

	
	//***********************Passenger 2************************************
	public static WebElement drp_title2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-title-pax-1"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	public static WebElement firstname2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-fname-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement middleName2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-mname-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement lastname2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-lname-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	public static WebElement drp_date2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[5]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_month2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[5]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_year2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[5]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement btn_Nationality2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-nationality-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement chk_Nationality_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("chkbox-pax-is-liex-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement drp_countryOfRe_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-country-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement chk_countryOfRe_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[2]/following::input[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement txt_Passport_Num2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement Passport_issuing_Country_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-pax-1"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}	
	public static WebElement drp_pass_Exp_day2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[7]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	public static WebElement drp_pass_Exp_Month2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[7]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	public static WebElement drp_pass_Exp_Year2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[7]/following::select[1]"));
			
		} catch (Exception e) {
			
			throw (e);
		}
		return element;
	}
	
	
	
	//***********************Passenger 3************************************
		public static WebElement drp_title2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-title-pax-2"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}
		
		public static WebElement firstname2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-fname-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement middleName2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-mname-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement lastname2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-lname-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		public static WebElement drp_date2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[9]/following::select[1]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement drp_month2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[9]/following::select[1]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement drp_year2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[9]/following::select[1]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement btn_Nationality2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-nationality-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		public static WebElement chk_Nationality_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("chkbox-pax-is-liex-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		public static WebElement drp_countryOfRe_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-country-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		public static WebElement chk_countryOfRe_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[3]/following::input[1]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		public static WebElement txt_Passport_Num2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("passport-no-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		public static WebElement Passport_issuing_Country_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("passport-issuing-country-pax-2"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}	
		public static WebElement drp_pass_Exp_day2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[11]/following::select[1]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		public static WebElement drp_pass_Exp_Month2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[11]/following::select[1]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
		
		public static WebElement drp_pass_Exp_Year2_3() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[11]/following::select[1]"));
				
			} catch (Exception e) {
				
				throw (e);
			}
			return element;
		}
		
	
		
		//***********************Passenger 4************************************
				public static WebElement drp_title2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-title-pax-3"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				
				public static WebElement firstname2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-fname-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement middleName2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-mname-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement lastname2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-lname-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement drp_date2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[13]/following::select[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_month2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[13]/following::select[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_year2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[13]/following::select[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement btn_Nationality2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-nationality-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement chk_Nationality_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("chkbox-pax-is-liex-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement drp_countryOfRe_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-country-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement chk_countryOfRe_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[4]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement txt_Passport_Num2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passport-no-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement Passport_issuing_Country_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passport-issuing-country-pax-3"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement drp_pass_Exp_day2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[15]/following::select[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement drp_pass_Exp_Month2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[15]/following::select[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement drp_pass_Exp_Year2_4() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[15]/following::select[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				
	// ***********************Passenger 5************************************
	public static WebElement drp_title2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-title-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-fname-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement middleName2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-mname-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-lname-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[17]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[17]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[17]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-nationality-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_Nationality_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("chkbox-pax-is-liex-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_countryOfRe_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-country-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_countryOfRe_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[5]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_Passport_Num2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Passport_issuing_Country_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-pax-4"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_day2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[19]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_Month2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[19]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_Year2_5() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[19]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}


	
	
	// ***********************Passenger 6************************************
	public static WebElement drp_title2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-title-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-fname-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement middleName2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-mname-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-lname-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[21]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[21]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[21]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-nationality-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_Nationality_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("chkbox-pax-is-liex-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_countryOfRe_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-country-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_countryOfRe_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[6]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_Passport_Num2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Passport_issuing_Country_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-pax-5"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_day2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[23]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_Month2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[23]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_Year2_6() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[23]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	// ***********************Passenger 7************************************
	public static WebElement drp_title2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-title-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement firstname2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-fname-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement middleName2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-mname-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement lastname2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-lname-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_date2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[25]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_month2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[25]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_year2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[25]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement btn_Nationality2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-nationality-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_Nationality_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("chkbox-pax-is-liex-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_countryOfRe_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("pax-country-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement chk_countryOfRe_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[7]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement txt_Passport_Num2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement Passport_issuing_Country_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-pax-6"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_day2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[27]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_Month2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[27]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement drp_pass_Exp_Year2_7() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[27]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	
	// ***********************Passenger 8************************************
		public static WebElement drp_title2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-title-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement firstname2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-fname-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement middleName2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-mname-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement lastname2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-lname-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement drp_date2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[29]/following::select[1]"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement drp_month2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By
						.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[29]/following::select[1]"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement drp_year2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[29]/following::select[1]"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement btn_Nationality2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-nationality-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement chk_Nationality_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("chkbox-pax-is-liex-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement drp_countryOfRe_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("pax-country-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement chk_countryOfRe_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath(
						"(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[8]/following::input[1]"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement txt_Passport_Num2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("passport-no-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement Passport_issuing_Country_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.id("passport-issuing-country-pax-7"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement drp_pass_Exp_day2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[31]/following::select[1]"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement drp_pass_Exp_Month2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(By
						.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[31]/following::select[1]"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		public static WebElement drp_pass_Exp_Year2_8() throws Exception {
			element = null;
			try {
				element = driver.findElement(
						By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[31]/following::select[1]"));

			} catch (Exception e) {

				throw (e);
			}
			return element;
		}

		
		// ***********************Passenger 9************************************
				public static WebElement drp_title2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-title-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement firstname2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-fname-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement middleName2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-mname-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement lastname2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-lname-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement drp_date2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(
								By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[33]/following::select[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement drp_month2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By
								.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[33]/following::select[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement drp_year2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(
								By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[33]/following::select[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement btn_Nationality2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-nationality-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement chk_Nationality_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("chkbox-pax-is-liex-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement drp_countryOfRe_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("pax-country-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement chk_countryOfRe_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath(
								"(.//*[normalize-space(text()) and normalize-space(.)='Country of Residence*'])[9]/following::input[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement txt_Passport_Num2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passport-no-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement Passport_issuing_Country_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passport-issuing-country-pax-8"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement drp_pass_Exp_day2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(
								By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Day'])[35]/following::select[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement drp_pass_Exp_Month2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(By
								.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Month'])[35]/following::select[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}

				public static WebElement drp_pass_Exp_Year2_9() throws Exception {
					element = null;
					try {
						element = driver.findElement(
								By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Year'])[35]/following::select[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				
				
				//Infants With Lap--
				
				
				//***********************Infant Passenger 1************************************
				public static WebElement I_TravellingWith2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-0']/div/div/div/div/select"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_title2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[1]/following::select[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				
				public static WebElement I_firstname2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[1]/following::input[1]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_middleName2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[1]/following::input[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_lastname2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-0']/div[3]/div/div[5]/input"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				public static WebElement I_drp_date2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-0']/div[4]/div/div[2]/div/select[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_month2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-0']/div[4]/div/div[2]/div/select"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_year2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-0']/div[4]/div/div[2]/div/select[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_btn_Nationality2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-0']/div[5]/div/div/div/select"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				
				
				public static WebElement I_txt_Passport_Num2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passport-no-infantpax-0"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement I_Passport_issuing_Country_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("passport-issuing-country-infantpax-0"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement I_drp_pass_Exp_day2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-0']/div[3]/div/div[2]/select[2]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				public static WebElement I_drp_pass_Exp_Month2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-0']/div[3]/div/div[2]/select"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
				
				public static WebElement I_drp_pass_Exp_Year2_1() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-0']/div[3]/div/div[2]/select[3]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}
				
	// ***********************Infant Passenger 2************************************
				
	public static WebElement I_TravellingWith2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-1']/div/div/div/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement I_drp_title2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[2]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_firstname2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[2]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_middleName2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[2]/following::input[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_lastname2_2() throws Exception {
		element = null;
		try {
			element = driver
					.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-1']/div[3]/div/div[5]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_date2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[@id='passenger-index-infantpax-info-1']/div[4]/div/div[2]/div/select[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_month2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[@id='passenger-index-infantpax-info-1']/div[4]/div/div[2]/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_year2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[@id='passenger-index-infantpax-info-1']/div[4]/div/div[2]/div/select[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_btn_Nationality2_2() throws Exception {
		element = null;
		try {
			element = driver
					.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-1']/div[5]/div/div/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_txt_Passport_Num2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-infantpax-1"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_Passport_issuing_Country_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-infantpax-1"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_day2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-1']/div[3]/div/div[2]/select[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_Month2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-1']/div[3]/div/div[2]/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_Year2_2() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-1']/div[3]/div/div[2]/select[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
			
	
	
	// ***********************Infant Passenger 3************************************
	
	public static WebElement I_TravellingWith2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-2']/div/div/div/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement I_drp_title2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[3]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_firstname2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[3]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_middleName2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[3]/following::input[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_lastname2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-2']/div[3]/div/div[5]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_date2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-2']/div[4]/div/div[2]/div/select[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_month2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-2']/div[4]/div/div[2]/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_year2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-2']/div[4]/div/div[2]/div/select[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_btn_Nationality2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-2']/div[5]/div/div/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_txt_Passport_Num2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-infantpax-2"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_Passport_issuing_Country_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-infantpax-2"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_day2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(
					By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-2']/div[3]/div/div[2]/select[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_Month2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-2']/div[3]/div/div[2]/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_Year2_3() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-2']/div[3]/div/div[2]/select[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	
	
	

	// ***********************Infant Passenger 4************************************
	public static WebElement I_TravellingWith2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-3']/div/div/div/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	public static WebElement I_drp_title2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[4]/following::select[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_firstname2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[4]/following::input[1]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_middleName2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Title'])[4]/following::input[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_lastname2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-3']/div[3]/div/div[5]/input"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_date2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-3']/div[4]/div/div[2]/div/select[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_month2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-3']/div[4]/div/div[2]/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_year2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-3']/div[4]/div/div[2]/div/select[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_btn_Nationality2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-info-3']/div[5]/div/div/div/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_txt_Passport_Num2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-no-infantpax-3"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_Passport_issuing_Country_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.id("passport-issuing-country-infantpax-3"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_day2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-3']/div[3]/div/div[2]/select[2]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_Month2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-3']/div[3]/div/div[2]/select"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}

	public static WebElement I_drp_pass_Exp_Year2_4() throws Exception {
		element = null;
		try {
			element = driver.findElement(By.xpath("//div[@id='passenger-index-infantpax-passport-info-pax-3']/div[3]/div/div[2]/select[3]"));

		} catch (Exception e) {

			throw (e);
		}
		return element;
	}
	//Passenger Below Check Box
				
				
				
				public static WebElement chk_below_Passenger() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("cbPrivacy"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				public static WebElement btn_Continue_Passenger2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.id("btnContinue"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				
				public static WebElement pop_Up_Yes() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//a[contains(text(),'Yes')]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				
				public static WebElement btn_Continue_AddOns() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.linkText("CONTINUE"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				public static WebElement btn_NoThanks_PhTravelTax() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//a[contains(text(),'No, thanks')]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}
				
				public static WebElement chk_CANCELLATION() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Terms and Conditions of Pre-paid Baggage,'])[1]/preceding::input[1]"));

					} catch (Exception e) {

						throw (e);
					}
					return element;
				}	
				public static WebElement btn_Confirm_Continue2() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//a[contains(text(),'CONFIRM AND CONTINUE')]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				public static WebElement Pay_button() throws Exception {
					element = null;
					try {
						element = driver.findElement(By.xpath("//a[contains(text(),'CONTINUE')]"));
						
					} catch (Exception e) {
						
						throw (e);
					}
					return element;
				}	
				
				
				
				
}