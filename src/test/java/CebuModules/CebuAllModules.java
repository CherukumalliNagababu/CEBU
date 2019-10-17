package CebuModules;

import java.io.IOException;
import java.util.ArrayList;
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
	
	
	
	public static void Flight_Srp_Details(WebDriver driver,Database PnrDetails) throws InterruptedException, IOException
	{
		//table[@id='depart-table']//tbody/tr
		Thread.sleep(10000);
		
		String From=PnrDetails.From;
		String To=PnrDetails.To;
		String DepDate=PnrDetails.DepartureDate;
		
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
		
		 List<CBFlightDetails> finalList =  new ArrayList<CBFlightDetails>();
		
		
		List<WebElement> element=driver.findElements(By.xpath("//table[@id='depart-table']//tbody/tr"));
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
				  
				  String FlyOnlyAmount=str1.split(" ")[5];
				  String FlyOnlyAmountS=FlyOnlyAmount.replaceAll(",", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("HKD", "");
				  FlyOnlyTotalAmount=FlyOnlyTotalAmount.replaceAll("This", "");
				 
			}
			else{
				FlightNumberFirst= str1.split(",")[0];
				 FlightNumberSecond= str1.split(",")[1];
				
				 FirstFlightStartTime= str1.split(",")[2];
				 FirstFlightStartTime_WithOutH= FirstFlightStartTime.split(" ")[0];
				 FirstFlightEndTime= str1.split(",")[3];
				 FirstFlightEndTime_WithOutH= FirstFlightEndTime.split(" ")[0];
				 
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
				 
				  String FlyOnlyAmount=str1.split(" ")[12];
				  String FlyOnlyAmountS=FlyOnlyAmount.replaceAll(",", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("HKD", "");
				  FlyOnlyTotalAmount=FlyOnlyTotalAmount.replaceAll("This", "");
				 
				 
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
				 
				  String FlyOnlyAmount=str1.split(" ")[12];
				  String FlyOnlyAmountS=FlyOnlyAmount.replaceAll(",", "");
				  FlyOnlyTotalAmount=FlyOnlyAmountS.replaceAll("HKD", "");
				  FlyOnlyTotalAmount=FlyOnlyTotalAmount.replaceAll("This", "");
				  
				
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
			currentFirstFlight.StartDt="";
			currentFirstFlight.ADTBG="";
			currentFirstFlight.CHDBG="";
		    currentFirstFlight.INFBG="";
			currentFirstFlight.DayChg = FirstFlightEndTime_DayChange;
			currentFirstFlight.JrnyTm=FirstFlightTime;
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
			currentSecondFlight.StartDt="";
			currentSecondFlight.DayChg = SecondFlightEndTime_DayChange;
			currentSecondFlight.JrnyTm=SecondFlightTime;
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
			
			ApiMethods.sendResults(From, To,DepDate, finalList);
			}
		}
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
		
		/*	}
		catch(Exception e)
		{
			PageUtils.getScreenShot(PnrDetails.PnrId,driver);
			passengersDetails.returnStatus_fail(PnrDetails.Domain,PnrDetails.PnrId,"Document Details Element Not Found");
			driver.quit();
		}*/
		
		
		
		Thread.sleep(2000);
	  
		System.out.println("Enter All Passenger Details Successfully");
		////PageUtils.getScreenShot(pnrdetails.PnrId,driver);
		/*flynasPage.txt_Conf_Pwd().sendKeys("test");
		flynasPage.txt_Conf_Pwd().clear();*/
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
