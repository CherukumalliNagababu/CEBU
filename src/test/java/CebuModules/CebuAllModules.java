package CebuModules;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import PageObjects.PageUtils;

import PageObjects.CebuPage;
import PageObjects.Database;




public class CebuAllModules extends passengersDetails{
	static WebDriver driver;
	public static String status;
	
	public static String GetMins(String FlightTime)
	{
		FlightTime = FlightTime.replace(" ","");
		FlightTime = FlightTime.toLowerCase();
		String[] jrnyTmHrs = FlightTime.split("h");
		int hrs = Integer.parseInt(jrnyTmHrs[0]);
		hrs = hrs*60;
		String[] minsstr =  jrnyTmHrs[1].split("m");
		int mins = Integer.parseInt(minsstr[0]);
		mins = mins + hrs;
		return mins +"";
	}
	public static String GetEndDate(Date depDate, String dayChng)
	{
		String result = "";
		if(dayChng != null && dayChng != "" && dayChng != "0" ){
			
		Calendar c = Calendar.getInstance();
		c.setTime(depDate);
		c.add(Calendar.DATE, 1);
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		String strDate= formatter2.format(c.getTime());
		result = strDate;
	}
	else
	{
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		String strDate= formatter2.format(depDate);
		result = strDate;
	}
		return result;
	}
	
	public static void Flight_Srp_Details(WebDriver driver,Database PnrDetails,String YMD,Date searchDate) throws InterruptedException, IOException
	{
		//table[@id='depart-table']//tbody/tr
		Thread.sleep(10000);
		
		String From=PnrDetails.From;
		String To=PnrDetails.To;
		String DepDate=PnrDetails.DepartureDate;
		System.out.println("DepartureDate DepartureDate DepartureDate :"+PnrDetails.DepartureDate);
		String FlightNumberFirst;
		String FlightNumberSecond = null;
		String FirstFlightStartTime;
		String FirstFlightStartTime_WithOutH;
		String FirstFlightEndTime;
		String FirstFlightEndTime_WithOutH;
		String SecondFlightStartTime;
		String SecondFlightStartTime_WithOutH = null;
		String SecondFlightEndTime = null;
		String SecondFlightEndTime_WithOutH= null;
		String FirstFlightEndTime_DayChange=null;
		String SecondFlightEndTime_DayChange=null;
		
		String FirstFlightAirPort_1= null;
		 String FirstFlightAirPort_2= null;
		 
		 String SecondFlightAirPort_1= null;
		 String SecondFlightAirPort_2= null;
		 String FirstFlightEndTime_PlusOne;
		 String SecondFlightEndTime_PlusOne;
		 
		 String FirstFlightTime= null;
		 String SecondFlightTime= null;
		 String FirstFlightEndTime_Next = null;
		 String SecondFlightEndTime_Next = null;
		 
		 String FlyOnlyTotalAmount = null;
		 
		 String CurrencyType = null;
		
		 List<CBFlightDetails> finalList =  new ArrayList<CBFlightDetails>();
		
		
		//List<WebElement> element=driver.findElements(By.xpath("//table[@id='depart-table']//tbody/tr"));
		List<WebElement> element=driver.findElements(By.xpath("//div[1]/div[4]//table[@class='table']//tbody/tr"));
		System.out.println("Element Size:"+element.size());
		
		for(WebElement e:element)
		{
			CBFlightDetails cbFd = new CBFlightDetails();
			cbFd.Flight = new ArrayList<CBFlight>();
			//List<CBFlight> cbFlight = new ArrayList<CBFlight>();
			
			CBFlight currentFirstFlight = new CBFlight();
			CBFlight currentSecondFlight = new CBFlight();
			
			String AllData=e.getText();
			System.out.println("Data Print:"+AllData);
			String NoFlights="Sorry, flights for this day are either sold out or unavailable. Please choose another date, or search again.";
			if(NoFlights.equals(AllData))
			{
				System.out.println("No Flights Found");
			}
			else{
			String str1=AllData.replaceAll("[\r\n]+", ",");
			
			
			if("FLIGHT OPERATED BY: Cebu Pacific Cebgo,Information and updates on baggage fees here.".equals(str1))
			{
				System.out.println("If1:");
			}
			
			else{
				
			 
			
			String FlightstartTime= str1.split(",")[1];
			String SingleFlight= FlightstartTime.split(" ")[1];
			
			if("H".equals(SingleFlight))
			{
				 FlightNumberFirst= str1.split(",")[0];
				  FirstFlightStartTime= str1.split(",")[1];
				 FirstFlightStartTime_WithOutH= FirstFlightStartTime.split(" ")[0];
				  FirstFlightEndTime= str1.split(",")[2];
				 FirstFlightEndTime_WithOutH= FirstFlightEndTime.split(" ")[0];
				 FirstFlightAirPort_1=str1.split(",")[3];
				  FirstFlightAirPort_2=str1.split(",")[4];
				  FirstFlightTime=str1.split(",")[5];
				  
				  //**********************************
				  String Amount=str1.split(",")[6];
				   CurrencyType=Amount.split(" ")[0];
				  System.out.println("CurrencyType"+CurrencyType);
				  //**********************************
				
				  String FlyOnlyAmount=str1.split(" ")[5];
				 
				  String FlyOnlyAmountS=FlyOnlyAmount.replaceAll(",", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("HKD", "");
				  FlyOnlyTotalAmount=FlyOnlyTotalAmount.replaceAll("This", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("Regular", "").replaceAll("Promo", "");
				 
			}
			else{
				FlightNumberFirst= str1.split(",")[0];
				 FlightNumberSecond= str1.split(",")[1];
				
				 FirstFlightStartTime= str1.split(",")[2];
				 FirstFlightStartTime_WithOutH= FirstFlightStartTime.split(" ")[0];
				 FirstFlightEndTime= str1.split(",")[3];
				 FirstFlightEndTime_WithOutH= FirstFlightEndTime.split(" ")[0];
				 
				 SecondFlightStartTime= str1.split(",")[4];
				 SecondFlightStartTime_WithOutH= SecondFlightStartTime.split(" ")[0];
				 SecondFlightEndTime= str1.split(",")[5];
				 SecondFlightEndTime_WithOutH= SecondFlightEndTime.split(" ")[0];
				 FirstFlightEndTime_DayChange=null;
				 SecondFlightEndTime_DayChange= null;
				 
				 FirstFlightAirPort_1=str1.split(",")[6];
				 FirstFlightAirPort_2=str1.split(",")[7];
				 SecondFlightAirPort_1=str1.split(",")[8];
				 SecondFlightAirPort_2=str1.split(",")[9];
				 
				 FirstFlightTime=str1.split(",")[10];
				  SecondFlightTime=str1.split(",")[11];
				  
				
				  //**********************************
				  String Amount=str1.split(",")[12];
				  CurrencyType=Amount.split(" ")[0];
				  System.out.println("CurrencyType"+CurrencyType);
				  //**********************************
				  String FlyOnlyAmount=str1.split(" ")[11];
				
				  String FlyOnlyAmountS=FlyOnlyAmount.replaceAll(",", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("HKD", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("This", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("Regular", "").replaceAll("Promo", "");
				 
				 FirstFlightEndTime_PlusOne = "0";
				 SecondFlightEndTime_PlusOne="0";
				
				 FirstFlightEndTime_Next= str1.split(",")[4];
				 SecondFlightEndTime_Next= str1.split(",")[6];
			}
			if("*Next Day Arrival".equals(FirstFlightEndTime_Next))
			{
				 FirstFlightEndTime_DayChange= "+1";
				 SecondFlightStartTime= str1.split(",")[5];
				 SecondFlightStartTime_WithOutH= SecondFlightStartTime.split(" ")[0];
				 SecondFlightEndTime= str1.split(",")[6];
				 SecondFlightEndTime_WithOutH= SecondFlightEndTime.split(" ")[0];
				 SecondFlightEndTime_DayChange= null;
				 
				  FirstFlightAirPort_1=str1.split(",")[7];
				  FirstFlightAirPort_2=str1.split(",")[8];
				 
				  SecondFlightAirPort_1=str1.split(",")[9];
				  SecondFlightAirPort_2=str1.split(",")[10];
				 
				  FirstFlightTime=str1.split(",")[11];
				  SecondFlightTime=str1.split(",")[12];
				 
				
				  //**********************************
				  String Amount=str1.split(",")[12];
				  CurrencyType=Amount.split(" ")[0];
				  System.out.println("CurrencyType"+CurrencyType);
				  //**********************************
				  String FlyOnlyAmount=str1.split(" ")[12];
				
				  String FlyOnlyAmountS=FlyOnlyAmount.replaceAll(",", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("HKD", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("This", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("Regular", "").replaceAll("Promo", "");
				 
				 
			}
			else if("*Next Day Arrival".equals(SecondFlightEndTime_Next))
			{
				SecondFlightEndTime_DayChange= "+1";
				SecondFlightStartTime= str1.split(",")[4];
				 SecondFlightStartTime_WithOutH= SecondFlightStartTime.split(" ")[0];
				 SecondFlightEndTime= str1.split(",")[5];
				 SecondFlightEndTime_WithOutH= SecondFlightEndTime.split(" ")[0];
				 SecondFlightEndTime_PlusOne= SecondFlightEndTime.split(" ")[2];
				 FirstFlightEndTime_DayChange= null;
				 
				  FirstFlightAirPort_1=str1.split(",")[7];
				  FirstFlightAirPort_2=str1.split(",")[8];
				 
				  SecondFlightAirPort_1=str1.split(",")[9];
				  SecondFlightAirPort_2=str1.split(",")[10];
				 
				  FirstFlightTime=str1.split(",")[11];
				  SecondFlightTime=str1.split(",")[12];
				 
				  //**********************************
				  String Amount=str1.split(",")[13];
				  CurrencyType=Amount.split(" ")[0];
				  System.out.println("CurrencyType"+CurrencyType);
				  //**********************************
				  String FlyOnlyAmount=str1.split(" ")[12];
				
				  String FlyOnlyAmountS=FlyOnlyAmount.replaceAll(",", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("HKD", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("This", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("Regular", "").replaceAll("Promo", "");
				  
				
			}
			
			
			
			System.out.println(str1);
			System.out.println("FlightNumberFirst:"+FlightNumberFirst);
			System.out.println("FlightNumberSecond:"+FlightNumberSecond);
			
			System.out.println("FirstFlightStartTime:"+FirstFlightStartTime_WithOutH);
			System.out.println("FirstFlightEndTime:"+FirstFlightEndTime_WithOutH);
			System.out.println("DayChangeF:"+FirstFlightEndTime_DayChange);
			
			System.out.println("SecondFlightStartTime:"+SecondFlightStartTime_WithOutH);
			System.out.println("SecondFlightEndTime:"+SecondFlightEndTime_WithOutH);
			System.out.println("DayChangeS:"+SecondFlightEndTime_DayChange);
			
			System.out.println("FirstFlightAirPort_1:"+FirstFlightAirPort_1);
			System.out.println("FirstFlightAirPort_2:"+FirstFlightAirPort_2);
			System.out.println("SecondFlightAirPort_1:"+SecondFlightAirPort_1);
			System.out.println("SecondFlightAirPort_2:"+SecondFlightAirPort_2);
			System.out.println("FirstFlightTime:"+FirstFlightTime);
			System.out.println("SecondFlightTime:"+SecondFlightTime);
			System.out.println("FlyOnlyAmount:"+FlyOnlyTotalAmount);
			
			
			
			currentFirstFlight.Fltnum=FlightNumberFirst;
			currentFirstFlight.FareType="FLY ONLY";
			currentFirstFlight.Class="Economy";
			currentFirstFlight.StartAirp =FirstFlightAirPort_1;
			currentFirstFlight.EndAirp=FirstFlightAirPort_2;
			currentFirstFlight.StartDt=YMD;
			currentFirstFlight.ADTBG="";
			currentFirstFlight.CHDBG="";
		    currentFirstFlight.INFBG="";
			currentFirstFlight.DayChg = FirstFlightEndTime_DayChange;
			currentFirstFlight.JrnyTm=GetMins(FirstFlightTime);
			currentFirstFlight.StartTm=FirstFlightStartTime_WithOutH;
			currentFirstFlight.EndTm=FirstFlightEndTime_WithOutH;
			currentFirstFlight.NoOfSeats="99";
			currentFirstFlight.StartTerminal="";
			currentFirstFlight.EndTerminal="";
			currentFirstFlight.AdultBasePrice=FlyOnlyTotalAmount;
			currentFirstFlight.AdultTaxes ="";
			currentFirstFlight.ChildBasePrice=FlyOnlyTotalAmount;
			currentFirstFlight.ChildTaxes="";
			currentFirstFlight.InfantBasePrice ="56";
			currentFirstFlight.InfantTaxes="";
			currentFirstFlight.TotalApiFare="";
			
			//cbFlight.add(currentFirstFlight);
			cbFd.Flight.add(currentFirstFlight);
			if("H".equals(SingleFlight))
			{
				
			}
			else{
			currentSecondFlight.Fltnum=FlightNumberSecond;
			currentSecondFlight.StartAirp =SecondFlightAirPort_1;
			currentSecondFlight.EndAirp=SecondFlightAirPort_2;
			currentSecondFlight.StartDt= GetEndDate(searchDate, FirstFlightEndTime_DayChange);
			currentSecondFlight.DayChg = SecondFlightEndTime_DayChange;
			currentSecondFlight.JrnyTm=GetMins(SecondFlightTime);
			currentSecondFlight.StartTm=SecondFlightStartTime_WithOutH;
			currentSecondFlight.EndTm=SecondFlightEndTime_WithOutH;
			currentSecondFlight.AdultBasePrice=FlyOnlyTotalAmount;
			currentSecondFlight.AdultTaxes ="";
			currentSecondFlight.ChildBasePrice=FlyOnlyTotalAmount;
			currentSecondFlight.ChildTaxes="";
			currentSecondFlight.InfantBasePrice ="56";
			currentSecondFlight.InfantTaxes="";
			currentSecondFlight.TotalApiFare="";
			
			// cbFlight.add(currentSecondFlight);
			cbFd.Flight.add(currentSecondFlight);
			
			}
			
			finalList.add(cbFd);
			
		}
			
			ApiMethods.sendResults(From, To,CurrencyType,DepDate, finalList);
			}
		}
		}
	
	
	public static void Agent_Login(Database PnrDetails ) throws Exception
	{
		try {
		CebuPage.Agent_UserName().sendKeys("APS057DXB");
		System.out.println("Enter UserName");
		CebuPage.Agent_PWD().sendKeys("Rehlat@2020");
		System.out.println("Enter Password");
		CebuPage.Agent_Login_Btn().click();
		} catch (Exception e) {
			status = "Login Error";
			PageUtils.getScreenShot(PnrDetails.PnrId, driver);
			driver.quit();

		}
	}
	public static void tripType_2(Database PnrDetails ) throws Exception
	{
		try {
			if ("OneWay".equals(PnrDetails.TripType)) {
				// Thread.sleep(10000);
				CebuPage.oneyWay2().click();
			} else if ("RoundTrip".equals(PnrDetails.TripType)) {
				System.out.println("Select Round Trip");
			}
		} catch (Exception e) {
			status = "TripType error";
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
			driver.quit();

		}
		//PageUtils.getScreenShot(PnrDetails.PnrId, driver);

	}
	public static void tripType_SRP() throws Exception
	{
		
				CebuPage.oneyWay2().click();
			
	
	}
	
	public static void enterFromAndTo_SRP(String From,String To) throws Exception
	{
		
		CebuPage.Clk_From2().click();
		CebuPage.Clk_From2().sendKeys(From);
		CebuPage.Clk_From2().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		CebuPage.Clk_From2().sendKeys(Keys.ENTER);
		
		PageUtils.isElementVisibil(driver, CebuPage.Clk_To2());
		CebuPage.Clk_To2().click();
		Thread.sleep(1000);
		CebuPage.Clk_To2().sendKeys(To);
		CebuPage.Clk_To2().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		CebuPage.Clk_To2().sendKeys(Keys.TAB);
		

	}
	public static void enterFromAndTo_2(Database PnrDetails ) throws Exception
	{
		
		CebuPage.Clk_From2().click();
		CebuPage.Clk_From2().sendKeys(PnrDetails.From);
		CebuPage.Clk_From2().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		CebuPage.Clk_From2().sendKeys(Keys.ENTER);
		
		PageUtils.isElementVisibil(driver, CebuPage.Clk_To2());
		CebuPage.Clk_To2().click();
		Thread.sleep(1000);
		CebuPage.Clk_To2().sendKeys(PnrDetails.To);
		CebuPage.Clk_To2().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		CebuPage.Clk_To2().sendKeys(Keys.TAB);
		

	}
	public static void enterDateAndNumberOfPassenger_SRP(String MandYear,String date) throws Exception
	{
		
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
		
		CebuPage.header_Month_D_2(MandYear);
		Thread.sleep(1000);
		CebuPage.ScrollDown();
		CebuPage.select_Date_D_2(date);
		
		
		
		
		
		
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		CebuPage.btn_FindFlight2().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
         
		}
	
	public static void enterDateAndNumberOfPassenger_2(Database PnrDetails,String depMandY,String depDate,String retMandY,String retDate ) throws Exception
	{
		
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
		if ("OneWay".equals(PnrDetails.TripType)) {
		CebuPage.header_Month_D_2(depMandY);
		Thread.sleep(1000);
		CebuPage.ScrollDown();
		CebuPage.select_Date_D_2(depDate);
		}
		else if ("RoundTrip".equals(PnrDetails.TripType)) {
			CebuPage.header_Month_D_2(depMandY);
			Thread.sleep(1000);
			CebuPage.ScrollDown();
			CebuPage.select_Date_D_2(depDate);
			Thread.sleep(1000);
			CebuPage.btn_Calender_R_Clk().click();
			Thread.sleep(1000);
			CebuPage.header_Month_D_2(retMandY);
			Thread.sleep(1000);
			CebuPage.ScrollDown();
			CebuPage.select_Date_D_2(retDate);
			
		}
		Thread.sleep(1000);
		
		
		int Adult = Integer.parseInt("3");
		System.out.println("Adult:"+Adult);
		for (int i = 0; i < Adult - 1; i++) {
			CebuPage.adult_increase2().click();
		}
		int Child = Integer.parseInt("3");
		System.out.println("Child:"+Child);
		for (int i = 0; i < Child; i++) {
			CebuPage.child_increase2().click();

		}
		int infant = Integer.parseInt("3");
		System.out.println("infant:"+infant);

		for (int i = 0; i < infant; i++) {
			CebuPage.infant_increase2().click();
		}
		
         PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL_ENGINE);
        
		if (infant <= 0) {
			
			CebuPage.btn_FindFlight2().click();
			PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		} else {
			CebuPage.btn_FindFlight2().click();
			PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
			CebuPage.btn_Continue_selectInfant().click();
			PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		}
         
		}
	
	public static void FlightNumberDetails_2(Database PnrDetails) throws Exception
	{
		
		if ("OneWay".equals(PnrDetails.TripType)) {
		CebuPage.flight_Numbers2_DEP("5J 113","5J 49");
		}
		else if ("RoundTrip".equals(PnrDetails.TripType)) {
			
			CebuPage.flight_Numbers2_DEP("5J 241","5J 554");
			Thread.sleep(3000);
			CebuPage.flight_Numbers2_RET("DG 6507","5J 240");
		}
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		String WebSiteAmount=CebuPage.WebSite_Amount2().getText();
		WebSiteAmount=WebSiteAmount.split(" ")[1];
		String WEB = WebSiteAmount.replaceAll(",", "");
		//System.out.println("WebSite Amount is:"+WEB);
		float WEBAMOUNT = Float.parseFloat(WEB);
		int currency=12000;
		
		if (currency >= WEBAMOUNT) {
           System.out.println("API Amount:" + currency);
           System.out.println("WebSite Amount:" +WEBAMOUNT);
			//System.out.println("API Amount:" + PnrDetails.Amount);
			//System.out.println("WebSite Amount:" + WebSiteAmount);
		}
		else
		{
			
			//passengersDetails.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId," "+WebSiteAmount+" Website amount is greater than "+ PnrDetails.Amount +" API amount");
			//System.out.println(WebSiteAmount+" Website amount is greater than "+ PnrDetails.Amount +" API amount");
			//driver.quit();
		}
		CebuPage.btn_Continue_Srp2().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		Imp_Alert2();
	}
	
	
	public static void Imp_Alert2() throws Exception
	{
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		try{
		CebuPage.btn_Alert_close2().click();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public static void enterPassengerDetails_2(Database PnrDetails) throws Exception

	{
		
		
		
		try{
			passengersDetails.paxAPI(PnrDetails);
			
			String numofAdults =PnrDetails.Adults; 
			String numofChilds = PnrDetails.Childs;
			String numofInfants = PnrDetails.Infants;
			
			Thread.sleep(5000);
		
		if (numofAdults.equals("1")) {
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
			passengersDetails.adult2_1();
			
		
		} else if (numofAdults.equals("2")) {
			System.out.println("Adults 2-----------------");
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
		}
		else if (numofAdults.equals("3")) {
			
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
			passengersDetails.adult2_3();
		}
		else if (numofAdults.equals("4")) {
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
			passengersDetails.adult2_3();
			passengersDetails.adult2_4();
		}
		else if (numofAdults.equals("5")) {
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
			passengersDetails.adult2_3();
			passengersDetails.adult2_4();
			passengersDetails.adult2_5();
		
		}
		else if (numofAdults.equals("6")) {
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
			passengersDetails.adult2_3();
			passengersDetails.adult2_4();
			passengersDetails.adult2_5();
			passengersDetails.adult2_6();
		}
		else if (numofAdults.equals("7")) {
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
			passengersDetails.adult2_3();
			passengersDetails.adult2_4();
			passengersDetails.adult2_5();
			passengersDetails.adult2_6();
			passengersDetails.adult2_7();
		}
		else if (numofAdults.equals("8")) {
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
			passengersDetails.adult2_3();
			passengersDetails.adult2_4();
			passengersDetails.adult2_5();
			passengersDetails.adult2_6();
			passengersDetails.adult2_7();
			passengersDetails.adult2_8();
		}
		else if (numofAdults.equals("9")) {
			passengersDetails.adult2_1();
			passengersDetails.adult2_2();
			passengersDetails.adult2_3();
			passengersDetails.adult2_4();
			passengersDetails.adult2_5();
			passengersDetails.adult2_6();
			passengersDetails.adult2_7();
			passengersDetails.adult2_8();
			passengersDetails.adult2_9();
		}
	
		if(numofChilds.equals("1"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			
		}
		else if(numofChilds.equals("2"))
		{
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			
		}
		else if(numofChilds.equals("3"))
		{
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
		
			
		}
		else if(numofChilds.equals("4"))
		{
			

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child2_8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
		
		}
		else if(numofChilds.equals("5"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child2_8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
		}
		else if(numofChilds.equals("6"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child2_8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_6(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_7(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_8(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			}
				
		}
		else if(numofChilds.equals("7"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child2_8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_6(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_7(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_8(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_7(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_8(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);

			}
		}
		
		
		else if(numofChilds.equals("8"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child2_8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child2_8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2_3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child2_5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child2_6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child2_7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child2_8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child2_8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child2_8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_6(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_7(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child2_8(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_7(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2_8(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child2_8(child_8_Title,child_8_firstname,child_8_lastname,child8_dof_d,child8_dof_m,child8_dof_y,child8_doc_Type,child_8_IC,child8_doc_Number,child8_pass_d,child8_pass_m,child8_pass_y,child_8_nation);
			} 
		}
		
		
		if (numofInfants.equals("1")) {
			
			passengersDetails.Infant2_1();
			
		
		} else if (numofInfants.equals("2")) {
			passengersDetails.Infant2_1();
			passengersDetails.Infant2_2();
		}
		else if (numofInfants.equals("3")) {
			
			passengersDetails.Infant2_1();
			passengersDetails.Infant2_2();
			passengersDetails.Infant2_3();
		}
		else if (numofInfants.equals("4")) {
			passengersDetails.Infant2_1();
			passengersDetails.Infant2_2();
			passengersDetails.Infant2_3();
			passengersDetails.Infant2_4();
		}
		
		
			
		
			}
		catch(Exception e)
		{
			PageUtils.getScreenShot(PnrDetails.PnrId,driver);
			passengersDetails.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId,"Document Details Element Not Found");
			driver.quit();
		}
		
		
		
		Thread.sleep(2000);
	  
		System.out.println("Enter All Passenger Details Successfully");
		////PageUtils.getScreenShot(pnrdetails.PnrId,driver);
		/*flynasPage.txt_Conf_Pwd().sendKeys("test");
		flynasPage.txt_Conf_Pwd().clear();*/
		CebuPage.chk_below_Passenger().click();
		Thread.sleep(2000);
		CebuPage.btn_Continue_Passenger2().click();
		
		
		
	}
	
	public static void extrasAddOns_2() throws Exception
	{
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		PageUtils.isElementVisibil(driver, CebuPage.pop_Up_Yes());
		CebuPage.pop_Up_Yes().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_LONG);
		PageUtils.isElementVisibil(driver, CebuPage.btn_Continue_AddOns());
		CebuPage.btn_Continue_AddOns().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		PageUtils.isElementVisibil(driver, CebuPage.btn_NoThanks_PhTravelTax());
		CebuPage.btn_NoThanks_PhTravelTax().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_LONG);
		PageUtils.isElementVisibil(driver, CebuPage.chk_CANCELLATION());
		CebuPage.chk_CANCELLATION().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		CebuPage.btn_Confirm_Continue2().click();
	}

	public static void Payment() throws Exception {
		CebuPage.Pay_button().click();
	}
	
	public static void tripType() throws Exception
	{
		
		Thread.sleep(1000);
		PageUtils.isElementVisibil(driver, CebuPage.oneyWay());
		CebuPage.oneyWay().click();
		/*PageUtils.isElementVisibil(driver, PiaPage.roundTrip());
		PiaPage.roundTrip().click();*/
	}
	public static void enterFromAndTo() throws Exception
	{
		PageUtils.isElementVisibil(driver, CebuPage.Clk_From());
		CebuPage.Clk_From().click();
		CebuPage.Clk_From().sendKeys("Hong Kong");
		CebuPage.Clk_From().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		CebuPage.Clk_From().sendKeys(Keys.ENTER);
		
		PageUtils.isElementVisibil(driver, CebuPage.Clk_To());
		CebuPage.Clk_To().click();
		Thread.sleep(1000);
		CebuPage.Clk_To().sendKeys("Melbourne");
		CebuPage.Clk_To().sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		CebuPage.Clk_To().sendKeys(Keys.ENTER);
		

	}
	
	public static void enterDateAndNumberOfPassenger() throws Exception
	{
		
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
		CebuPage.header_Month_D("October");
		Thread.sleep(1000);
		CebuPage.ScrollDown();
		CebuPage.select_Date_D("23");
      
		Thread.sleep(1000);
		
		
		int Adult = Integer.parseInt("1");
		System.out.println("Adult:"+Adult);
		for (int i = 0; i < Adult - 1; i++) {
			CebuPage.adult_increase().click();
		}
		int Child = Integer.parseInt("0");
		System.out.println("Child:"+Child);
		for (int i = 0; i < Child; i++) {
			CebuPage.child_increase().click();

		}
		int infant = Integer.parseInt("0");
		System.out.println("infant:"+infant);

		for (int i = 0; i < infant; i++) {
			CebuPage.infant_increase().click();
		}
		
         PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL_ENGINE);
        
        
         CebuPage.btn_FindFlight().click();
        
         
		}
	public static void FlightNumberDetails() throws Exception
	{
		CebuPage.flight_Numbers("5J 115");
		
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		String WebSiteAmount=CebuPage.WebSite_Amount().getText();
		WebSiteAmount=WebSiteAmount.split(" ")[1];
		String WEB = WebSiteAmount.replaceAll(",", "");
		//System.out.println("WebSite Amount is:"+WEB);
		float WEBAMOUNT = Float.parseFloat(WEB);
		int currency=12000;
		
		if (currency >= WEBAMOUNT) {
           System.out.println("API Amount:" + currency);
           System.out.println("WebSite Amount:" +WEBAMOUNT);
			//System.out.println("API Amount:" + PnrDetails.Amount);
			//System.out.println("WebSite Amount:" + WebSiteAmount);
		}
		else
		{
			
			//passengersDetails.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId," "+WebSiteAmount+" Website amount is greater than "+ PnrDetails.Amount +" API amount");
			//System.out.println(WebSiteAmount+" Website amount is greater than "+ PnrDetails.Amount +" API amount");
			//driver.quit();
		}
		CebuPage.btn_Continue_Srp().click();
	}
	public static void handelAlertandGuestUser() throws Exception
	{
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
		try{
		CebuPage.btn_Alert_close().click();
		}
		catch(Exception e)
		{
			
		}
		PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
		CebuPage.Clk_continueGuestToggleBar().click();
	}
	
	/*public static void enterPassengerDetails(WebDriver driver,Database PnrDetails) throws Exception
	{
		
		try{
		passengersDetails.paxAPI(PnrDetails);
		
		String numofAdults =PnrDetails.Adults; 
		String numofChilds = PnrDetails.Childs;
		String numofInfants = PnrDetails.Infants;*/
	
	public static void enterPassengerDetails() throws Exception
	{
		
		
		
		String numofAdults ="2";
		String numofChilds = "0";
		String numofInfants = "0";
		
		if (numofAdults.equals("1")) {
			//PageUtils.getScreenShot(PnrDetails.PnrId, driver);
			//passengersDetails.adult1(PnrDetails);
			
		
		} else if (numofAdults.equals("2")) {
			System.out.println("Adults 2-----------------");
			passengersDetails.adult1();
			passengersDetails.adult2();
		}
		else if (numofAdults.equals("3")) {
			//passengersDetails.adult1(PnrDetails);
			passengersDetails.adult2();
			passengersDetails.adult3();
		}
		else if (numofAdults.equals("4")) {
			//passengersDetails.adult1(PnrDetails);
			passengersDetails.adult2();
			passengersDetails.adult3();
			passengersDetails.adult4();
		}
		else if (numofAdults.equals("5")) {
			//passengersDetails.adult1(PnrDetails);
			passengersDetails.adult2();
			passengersDetails.adult3();
			passengersDetails.adult4();
			passengersDetails.adult5();
		
		}
		else if (numofAdults.equals("6")) {
			//passengersDetails.adult1(PnrDetails);
			passengersDetails.adult2();
			passengersDetails.adult3();
			passengersDetails.adult4();
			passengersDetails.adult5();
			passengersDetails.adult6();
		}
		else if (numofAdults.equals("7")) {
			//passengersDetails.adult1(PnrDetails);
			passengersDetails.adult2();
			passengersDetails.adult3();
			passengersDetails.adult4();
			passengersDetails.adult5();
			passengersDetails.adult6();
			passengersDetails.adult7();
		}
		else if (numofAdults.equals("8")) {
			//passengersDetails.adult1(PnrDetails);
			passengersDetails.adult2();
			passengersDetails.adult3();
			passengersDetails.adult4();
			passengersDetails.adult5();
			passengersDetails.adult6();
			passengersDetails.adult7();
			passengersDetails.adult8();
		}
		else if (numofAdults.equals("9")) {
			//passengersDetails.adult1(PnrDetails);
			passengersDetails.adult2();
			passengersDetails.adult3();
			passengersDetails.adult4();
			passengersDetails.adult5();
			passengersDetails.adult6();
			passengersDetails.adult7();
			passengersDetails.adult8();
			passengersDetails.adult9();
		}
	
		if(numofChilds.equals("1"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			
		}
		else if(numofChilds.equals("2"))
		{
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			
		}
		else if(numofChilds.equals("3"))
		{
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
		
			
		}
		else if(numofChilds.equals("4"))
		{
			

			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
		
		}
		else if(numofChilds.equals("5"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
		}
		else if(numofChilds.equals("6"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child6(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child7(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child8(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			}
				
		}
		else if(numofChilds.equals("7"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child6(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child7(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child8(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child7(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child8(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);

			}
		}
		
		
		else if(numofChilds.equals("8"))
		{
			if ("1".equals(numofAdults)) {
				passengersDetails.child1(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child2(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child3(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child4(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child5(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child6(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child7(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			else if ("8".equals(numofAdults)) {
				passengersDetails.child8(child_1_Title,child_1_firstname,child_1_lastname,child1_dof_d,child1_dof_m,child1_dof_y,child1_doc_Type,child_1_IC,child1_doc_Number,child1_pass_d,child1_pass_m,child1_pass_y,child_1_nation);

			}
			System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child2(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child3(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child4(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child5(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child6(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child7(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
			else if ("7".equals(numofAdults)) {
				passengersDetails.child8(child_2_Title,child_2_firstname,child_2_lastname,child2_dof_d,child2_dof_m,child2_dof_y,child2_doc_Type,child_2_IC,child2_doc_Number,child2_pass_d,child2_pass_m,child2_pass_y,child_2_nation);

			}
             System.out.println("----");
			
			if ("1".equals(numofAdults)) {
				passengersDetails.child3(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child4(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("3".equals(numofAdults)) {
				passengersDetails.child5(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("4".equals(numofAdults)) {
				passengersDetails.child6(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("5".equals(numofAdults)) {
				passengersDetails.child7(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			else if ("6".equals(numofAdults)) {
				passengersDetails.child8(child_3_Title,child_3_firstname,child_3_lastname,child3_dof_d,child3_dof_m,child3_dof_y,child3_doc_Type,child_3_IC,child3_doc_Number,child3_pass_d,child3_pass_m,child3_pass_y,child_3_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child4(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child5(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child6(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child7(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			} else if ("5".equals(numofAdults)) {
				passengersDetails.child8(child_4_Title,child_4_firstname,child_4_lastname,child4_dof_d,child4_dof_m,child4_dof_y,child4_doc_Type,child_4_IC,child4_doc_Number,child4_pass_d,child4_pass_m,child4_pass_y,child_4_nation);

			}
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child5(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child6(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child7(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			} else if ("4".equals(numofAdults)) {
				passengersDetails.child8(child_5_Title,child_5_firstname,child_5_lastname,child5_dof_d,child5_dof_m,child5_dof_y,child5_doc_Type,child_5_IC,child5_doc_Number,child5_pass_d,child5_pass_m,child5_pass_y,child_5_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child6(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child7(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			} else if ("3".equals(numofAdults)) {
				passengersDetails.child8(child_6_Title,child_6_firstname,child_6_lastname,child6_dof_d,child6_dof_m,child6_dof_y,child6_doc_Type,child_6_IC,child6_doc_Number,child6_pass_d,child6_pass_m,child6_pass_y,child_6_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child7(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);
			} else if ("2".equals(numofAdults)) {
				passengersDetails.child8(child_7_Title,child_7_firstname,child_7_lastname,child7_dof_d,child7_dof_m,child7_dof_y,child7_doc_Type,child_7_IC,child7_doc_Number,child7_pass_d,child7_pass_m,child7_pass_y,child_7_nation);

			}
			
			System.out.println("----");

			if ("1".equals(numofAdults)) {
				passengersDetails.child8(child_8_Title,child_8_firstname,child_8_lastname,child8_dof_d,child8_dof_m,child8_dof_y,child8_doc_Type,child_8_IC,child8_doc_Number,child8_pass_d,child8_pass_m,child8_pass_y,child_8_nation);
			} 
		}
		
		
		Integer totalValue = Integer.parseInt(numofChilds) + Integer.parseInt(numofAdults);
		System.out.println("totalValue:" + totalValue);
		String numberAsString = Integer.toString(totalValue);
		System.out.println(numberAsString);
		
		if ("1".equals(numofInfants)) {
			if ("1".equals(numberAsString)) {
			   passengersDetails.Infant1(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
			} else if ("2".equals(numberAsString)) {
				 passengersDetails.Infant2(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				
			} else if ("3".equals(numberAsString)) {
				 passengersDetails.Infant3(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
			} else if ("4".equals(numberAsString)) {
				 passengersDetails.Infant4(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
			
			} else if ("5".equals(numberAsString)) {
				 passengersDetails.Infant5(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				
			} else if ("6".equals(numberAsString)) {
				 passengersDetails.Infant6(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				
			} else if ("7".equals(numberAsString)) {
				 passengersDetails.Infant7(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				
			} else if ("8".equals(numberAsString)) {
				 passengersDetails.Infant8(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				
			}
			
		}
		
		if ("2".equals(numofInfants)) {
			
			if ("1".equals(numberAsString)) {
				   passengersDetails.Infant1(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				} else if ("2".equals(numberAsString)) {
					 passengersDetails.Infant2(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					
				} else if ("3".equals(numberAsString)) {
					 passengersDetails.Infant3(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				} else if ("4".equals(numberAsString)) {
					 passengersDetails.Infant4(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
				
				} else if ("5".equals(numberAsString)) {
					 passengersDetails.Infant5(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					
				} else if ("6".equals(numberAsString)) {
					 passengersDetails.Infant6(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					
				} else if ("7".equals(numberAsString)) {
					 passengersDetails.Infant7(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					
				} else if ("8".equals(numberAsString)) {
					 passengersDetails.Infant8(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					
				}
			      System.out.println("----");
			     if ("1".equals(numberAsString)) {
				   passengersDetails.Infant2(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
				} else if ("2".equals(numberAsString)) {
					 passengersDetails.Infant3(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					
				} else if ("3".equals(numberAsString)) {
					 passengersDetails.Infant4(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
				} else if ("4".equals(numberAsString)) {
					 passengersDetails.Infant5(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
				
				} else if ("5".equals(numberAsString)) {
					 passengersDetails.Infant6(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					
				} else if ("6".equals(numberAsString)) {
					 passengersDetails.Infant7(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					
				} else if ("7".equals(numberAsString)) {
					 passengersDetails.Infant8(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					
				} 
		}
			
			if ("3".equals(numofInfants)) {
				
				if ("1".equals(numberAsString)) {
					   passengersDetails.Infant1(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					} else if ("2".equals(numberAsString)) {
						 passengersDetails.Infant2(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("3".equals(numberAsString)) {
						 passengersDetails.Infant3(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					} else if ("4".equals(numberAsString)) {
						 passengersDetails.Infant4(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					
					} else if ("5".equals(numberAsString)) {
						 passengersDetails.Infant5(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("6".equals(numberAsString)) {
						 passengersDetails.Infant6(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("7".equals(numberAsString)) {
						 passengersDetails.Infant7(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("8".equals(numberAsString)) {
						 passengersDetails.Infant8(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					}
				      System.out.println("----");
				     if ("1".equals(numberAsString)) {
					   passengersDetails.Infant2(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					} else if ("2".equals(numberAsString)) {
						 passengersDetails.Infant3(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} else if ("3".equals(numberAsString)) {
						 passengersDetails.Infant4(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					} else if ("4".equals(numberAsString)) {
						 passengersDetails.Infant5(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					
					} else if ("5".equals(numberAsString)) {
						 passengersDetails.Infant6(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} else if ("6".equals(numberAsString)) {
						 passengersDetails.Infant7(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} else if ("7".equals(numberAsString)) {
						 passengersDetails.Infant8(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} 
				     System.out.println("----");
				     if ("1".equals(numberAsString)) {
					   passengersDetails.Infant3(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
					} else if ("2".equals(numberAsString)) {
						 passengersDetails.Infant4(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
						
					} else if ("3".equals(numberAsString)) {
						 passengersDetails.Infant5(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
					} else if ("4".equals(numberAsString)) {
						 passengersDetails.Infant6(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
					
					} else if ("5".equals(numberAsString)) {
						 passengersDetails.Infant7(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
						
					} else if ("6".equals(numberAsString)) {
						 passengersDetails.Infant8(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
						
					} 
				     
				     
			}
			
			if ("4".equals(numofInfants)) {
				
				if ("1".equals(numberAsString)) {
					   passengersDetails.Infant1(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					} else if ("2".equals(numberAsString)) {
						 passengersDetails.Infant2(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("3".equals(numberAsString)) {
						 passengersDetails.Infant3(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					} else if ("4".equals(numberAsString)) {
						 passengersDetails.Infant4(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
					
					} else if ("5".equals(numberAsString)) {
						 passengersDetails.Infant5(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("6".equals(numberAsString)) {
						 passengersDetails.Infant6(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("7".equals(numberAsString)) {
						 passengersDetails.Infant7(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					} else if ("8".equals(numberAsString)) {
						 passengersDetails.Infant8(infant_1_Title,infant_1_firstname,infant_1_lastname,infant1_dof_d,infant1_dof_m,infant1_dof_y,infant1_doc_Type,infant_1_IC,infant1_doc_Number,infant1_pass_d,infant1_pass_m,infant1_pass_y,infant_1_nation);
						
					}
				      System.out.println("----");
				     if ("1".equals(numberAsString)) {
					   passengersDetails.Infant2(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					} else if ("2".equals(numberAsString)) {
						 passengersDetails.Infant3(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} else if ("3".equals(numberAsString)) {
						 passengersDetails.Infant4(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					} else if ("4".equals(numberAsString)) {
						 passengersDetails.Infant5(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
					
					} else if ("5".equals(numberAsString)) {
						 passengersDetails.Infant6(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} else if ("6".equals(numberAsString)) {
						 passengersDetails.Infant7(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} else if ("7".equals(numberAsString)) {
						 passengersDetails.Infant8(infant_2_Title,infant_2_firstname,infant_2_lastname,infant2_dof_d,infant2_dof_m,infant2_dof_y,infant2_doc_Type,infant_2_IC,infant2_doc_Number,infant2_pass_d,infant2_pass_m,infant2_pass_y,infant_2_nation);
						
					} 
				     System.out.println("----");
				     if ("1".equals(numberAsString)) {
					   passengersDetails.Infant3(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
					} else if ("2".equals(numberAsString)) {
						 passengersDetails.Infant4(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
						
					} else if ("3".equals(numberAsString)) {
						 passengersDetails.Infant5(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
					} else if ("4".equals(numberAsString)) {
						 passengersDetails.Infant6(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
					
					} else if ("5".equals(numberAsString)) {
						 passengersDetails.Infant7(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
						
					} else if ("6".equals(numberAsString)) {
						 passengersDetails.Infant8(infant_3_Title,infant_3_firstname,infant_3_lastname,infant3_dof_d,infant3_dof_m,infant3_dof_y,infant3_doc_Type,infant_3_IC,infant3_doc_Number,infant3_pass_d,infant3_pass_m,infant3_pass_y,infant_3_nation);
						
					} 
				     
				     System.out.println("----");
				     if ("1".equals(numberAsString)) {
					   passengersDetails.Infant4(infant_4_Title,infant_4_firstname,infant_4_lastname,infant4_dof_d,infant4_dof_m,infant4_dof_y,infant4_doc_Type,infant_4_IC,infant4_doc_Number,infant4_pass_d,infant4_pass_m,infant4_pass_y,infant_4_nation);
					} else if ("2".equals(numberAsString)) {
						 passengersDetails.Infant5(infant_4_Title,infant_4_firstname,infant_4_lastname,infant4_dof_d,infant4_dof_m,infant4_dof_y,infant4_doc_Type,infant_4_IC,infant4_doc_Number,infant4_pass_d,infant4_pass_m,infant4_pass_y,infant_4_nation);
						
					} else if ("3".equals(numberAsString)) {
						 passengersDetails.Infant6(infant_4_Title,infant_4_firstname,infant_4_lastname,infant4_dof_d,infant4_dof_m,infant4_dof_y,infant4_doc_Type,infant_4_IC,infant4_doc_Number,infant4_pass_d,infant4_pass_m,infant4_pass_y,infant_4_nation);
					} else if ("4".equals(numberAsString)) {
						 passengersDetails.Infant7(infant_4_Title,infant_4_firstname,infant_4_lastname,infant4_dof_d,infant4_dof_m,infant4_dof_y,infant4_doc_Type,infant_4_IC,infant4_doc_Number,infant4_pass_d,infant4_pass_m,infant4_pass_y,infant_4_nation);
					
					} else if ("5".equals(numberAsString)) {
						 passengersDetails.Infant8(infant_4_Title,infant_4_firstname,infant_4_lastname,infant4_dof_d,infant4_dof_m,infant4_dof_y,infant4_doc_Type,infant_4_IC,infant4_doc_Number,infant4_pass_d,infant4_pass_m,infant4_pass_y,infant_4_nation);
						
					}
				     
			}
		
			/*}
		catch(Exception e)
		{
			PageUtils.getScreenShot(PnrDetails.PnrId,driver);
			passengersDetails.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId,"Document Details Element Not Found");
			driver.quit();
		}*/
		
		
		
		Thread.sleep(2000);
	  
		System.out.println("Enter All Passenger Details Successfully");
		////PageUtils.getScreenShot(pnrdetails.PnrId,driver);
		
		CebuPage.btn_Continue_Passenger().click();
		
		
		
	
}


	public static void extrasAddOns() throws Exception
	{
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		CebuPage.btn_Continue_Passenger().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		PageUtils.isElementVisibil(driver, CebuPage.PopUp_No_Meal());
		CebuPage.PopUp_No_Meal().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		PageUtils.isElementVisibil(driver, CebuPage.btn_Proceed_Yes());
		CebuPage.btn_Proceed_Yes().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		CebuPage.btn_submitPhTravelTax().click();
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		CebuPage.chk_Agree().click();
		CebuPage.btn_Confirm_Continue().click();
	}

	
	public static void contact_Information() throws Exception
	{
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		PageUtils.isElementVisibil(driver, CebuPage.contact_number_CountryCode());
		CebuPage.contact_number_CountryCode().click();
		
		CebuPage.select_Value("India, Republic of (+91)");
		
		CebuPage.contact_number().sendKeys("9874561235");
		PageUtils.isElementVisibil(driver, CebuPage.Alt_Contact_number_CountryCode());
		CebuPage.Alt_Contact_number_CountryCode().click();
		
		CebuPage.select_Value("India, Republic of (+91)");
		CebuPage.Alt_Contact_number().sendKeys("8974561235");
		CebuPage.contact_Email().sendKeys("test@gmail.com");
		CebuPage.contact_Confirm_Email().sendKeys("test@gmail.com");
		
		
		
		
	}
	
	public static void enterCardDetails() throws Exception
	{
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL);
		PageUtils.isElementVisibil(driver, CebuPage.btn_creditCard());
		CebuPage.btn_creditCard().click();
		
		CebuPage.txt_cardNumber().sendKeys("54879456123");
		CebuPage.txt_validationNumber().sendKeys("4568");
		
		PageUtils.isElementVisibil(driver, CebuPage.drp_Exp_Month());
		CebuPage.drp_Exp_Month().click();
		CebuPage.select_Value("06");
		
		PageUtils.isElementVisibil(driver, CebuPage.drp_Exp_Year());
		CebuPage.drp_Exp_Year().click();
		CebuPage.select_Value("2030");
		
		CebuPage.txt_CardHolder_First_Name().sendKeys("nagababu");
		CebuPage.txt_CardHolder_Last_Name().sendKeys("babunaga");
		
		//Billing Details
		CebuPage.txt_Street_Address().sendKeys("SRNAGAR");
		CebuPage.txt_city_name().sendKeys("Hydarabad");
		
		PageUtils.isElementVisibil(driver, CebuPage.billing_Country_Code());
		CebuPage.billing_Country_Code().click();
		
		CebuPage.select_Value("India, Republic of");
		
		CebuPage.chk_Privacy().click();
		CebuPage.btn_Submit_Card().click();
		
		
	}
}
