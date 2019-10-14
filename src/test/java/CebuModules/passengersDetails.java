package CebuModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.hamcrest.core.Is;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.Gson;

import PageObjects.CardDetails;
import PageObjects.CebuPage;
import PageObjects.Database;
import PageObjects.PageUtils;
import PageObjects.Pax;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;






public class passengersDetails {
	
	//DOB
	static String adult1_dof_d;
	static String adult1_dof_m;
	static String adult1_dof_y;
	static String adult1_doc_Number;
	static String adult1_doc_Type;
	
	static String adult2_dof_d;
	static String adult2_dof_m;
	static String adult2_dof_y;
	static String adult2_doc_Number;
	static String adult2_doc_Type;
	
	static String adult3_dof_d;
	static String adult3_dof_m;
	static String adult3_dof_y;
	static String adult3_doc_Number;
	static String adult3_doc_Type;
	
	static String adult4_dof_d;
	static String adult4_dof_m;
	static String adult4_dof_y;
	static String adult4_doc_Number;
	static String adult4_doc_Type;
	
	static String adult5_dof_d;
	static String adult5_dof_m;
	static String adult5_dof_y;
	static String adult5_doc_Number;
	static String adult5_doc_Type;
	
	static String adult6_dof_d;
	static String adult6_dof_m;
	static String adult6_dof_y;
	static String adult6_doc_Number;
	static String adult6_doc_Type;
	
	static String adult7_dof_d;
	static String adult7_dof_m;
	static String adult7_dof_y;
	static String adult7_doc_Number;
	static String adult7_doc_Type;
	
	static String adult8_dof_d;
	static String adult8_dof_m;
	static String adult8_dof_y;
	static String adult8_doc_Number;
	static String adult8_doc_Type;
	
	static String adult9_dof_d;
	static String adult9_dof_m;
	static String adult9_dof_y;
	static String adult9_doc_Number;
	static String adult9_doc_Type;
	
	
	 
	static String child1_dof_d;
	static String child1_dof_m;
	static String child1_dof_y;
	static String child1_doc_Number;
	static String child1_doc_Type;
	
	static String child2_dof_d;
	static String child2_dof_m;
	static String child2_dof_y;
	static String child2_doc_Number;
	static String child2_doc_Type;
	
	static String child3_dof_d;
	static String child3_dof_m;
	static String child3_dof_y;
	static String child3_doc_Number;
	static String child3_doc_Type;
	
	static String child4_dof_d;
	static String child4_dof_m;
	static String child4_dof_y;
	static String child4_doc_Number;
	static String child4_doc_Type;
	
	static String child5_dof_d;
	static String child5_dof_m;
	static String child5_dof_y;
	static String child5_doc_Number;
	static String child5_doc_Type;
	
	static String child6_dof_d;
	static String child6_dof_m;
	static String child6_dof_y;
	static String child6_doc_Number;
	static String child6_doc_Type;
	
	static String child7_dof_d;
	static String child7_dof_m;
	static String child7_dof_y;
	static String child7_doc_Number;
	static String child7_doc_Type;
	
	static String child8_dof_d;
	static String child8_dof_m;
	static String child8_dof_y;
	static String child8_doc_Number;
	static String child8_doc_Type;
	 
	static String infant1_dof_d;
	static String infant1_dof_m;
	static String infant1_dof_y;
	static String infant1_doc_Number;
	static String infant1_doc_Type;
	
	static String infant2_dof_d;
	static String infant2_dof_m;
	static String infant2_dof_y;
	static String infant2_doc_Number;
	static String infant2_doc_Type;
	
	static String infant3_dof_d;
	static String infant3_dof_m;
	static String infant3_dof_y;
	static String infant3_doc_Number;
	static String infant3_doc_Type;
	
	static String infant4_dof_d;
	static String infant4_dof_m;
	static String infant4_dof_y;
	static String infant4_doc_Number;
	static String infant4_doc_Type;
	
		 
	
	 
	 //PSAA
	static String adult1_pass_d;
	static String adult1_pass_m;
	static String adult1_pass_y;
	
	static String adult2_pass_d;
	static String adult2_pass_m;
	static String adult2_pass_y;
	
	static String adult3_pass_d;
	static String adult3_pass_m;
	static String adult3_pass_y;
	
	
	static String adult4_pass_d;
	static String adult4_pass_m;
	static String adult4_pass_y;
	
	static String adult5_pass_d;
	static String adult5_pass_m;
	static String adult5_pass_y;
	
	static String adult6_pass_d;
	static String adult6_pass_m;
	static String adult6_pass_y;
	
	static String adult7_pass_d;
	static String adult7_pass_m;
	static String adult7_pass_y;
	
	static String adult8_pass_d;
	static String adult8_pass_m;
	static String adult8_pass_y;
	
	static String adult9_pass_d;
	static String adult9_pass_m;
	static String adult9_pass_y;
	 
	static String child1_pass_d;
	static String child1_pass_m;
	static String child1_pass_y;
	
	static String child2_pass_d;
	static String child2_pass_m;
	static String child2_pass_y;
	
	static String child3_pass_d;
	static String child3_pass_m;
	static String child3_pass_y;
	
	static String child4_pass_d;
	static String child4_pass_m;
	static String child4_pass_y;
	
	static String child5_pass_d;
	static String child5_pass_m;
	static String child5_pass_y;
	
	static String child6_pass_d;
	static String child6_pass_m;
	static String child6_pass_y;
	
	static String child7_pass_d;
	static String child7_pass_m;
	static String child7_pass_y;
	
	static String child8_pass_d;
	static String child8_pass_m;
	static String child8_pass_y;
	 
	static String infant1_pass_d;
	static String infant1_pass_m;
	static  String infant1_pass_y;
	
	static String infant2_pass_d;
	static String infant2_pass_m;
	static  String infant2_pass_y;
	
	static String infant3_pass_d;
	static String infant3_pass_m;
	static  String infant3_pass_y;
	
	
	static String infant4_pass_d;
	static String infant4_pass_m;
	static  String infant4_pass_y;
	
	static String infant5_pass_d;
	static String infant5_pass_m;
	static  String infant5_pass_y;
	
	static String infant6_pass_d;
	static String infant6_pass_m;
	static  String infant6_pass_y;
	
	static String infant7_pass_d;
	static String infant7_pass_m;
	static  String infant7_pass_y;
	
	static String infant8_pass_d;
	static String infant8_pass_m;
	static  String infant8_pass_y;
	
	
	
	static String adult_1_Title;
	static String adult_1_firstname;
	static String adult_1_lastname;
	static String adult_1_nation;
	static String adult_1_IC;
	
	static String adult_2_Title;
	static String adult_2_firstname;
	static String adult_2_lastname;
	static String adult_2_nation;
	static String adult_2_IC;
	
	static String adult_3_Title;
	static String adult_3_lastname;
	static String adult_3_firstname;
	static String adult_3_nation;
	static String adult_3_IC;
	
	static String adult_4_Title;
	static String adult_4_lastname;
	static String adult_4_firstname;
	static String adult_4_nation;
	static String adult_4_IC;
	
	static String adult_5_Title;
	static String adult_5_lastname;
	static String adult_5_firstname;
	static String adult_5_nation;
	static String adult_5_IC;
	
	static String adult_6_Title;
	static String adult_6_lastname;
	static String adult_6_firstname;
	static String adult_6_nation;
	static String adult_6_IC;
	
	static String adult_7_Title;
	static String adult_7_lastname;
	static String adult_7_firstname;
	static String adult_7_nation;
	static String adult_7_IC;
	
	static String adult_8_Title;
	static String adult_8_lastname;
	static String adult_8_firstname;
	static String adult_8_nation;
	static String adult_8_IC;
	
	static String adult_9_Title;
	static String adult_9_lastname;
	static String adult_9_firstname;
	static String adult_9_nation;
	static String adult_9_IC;
	
	
	
	
	static String child_1_Title;
	static String child_1_firstname;
	static String child_1_lastname;
	static String child_1_nation;
	static String child_1_IC;
	
	static String child_2_Title;
	static String child_2_firstname;
	static String child_2_lastname;
	static String child_2_nation;
	static String child_2_IC;
	
	static String child_3_Title;
	static String child_3_firstname;
	static String child_3_lastname;
	static String child_3_nation;
	static String child_3_IC;
	
	static String child_4_Title;
	static String child_4_firstname;
	static String child_4_lastname;
	static String child_4_nation;
	static String child_4_IC;
	
	static String child_5_Title;
	static String child_5_firstname;
	static String child_5_lastname;
	static String child_5_nation;
	static String child_5_IC;
	
	static String child_6_Title;
	static String child_6_firstname;
	static String child_6_lastname;
	static String child_6_nation;
	static String child_6_IC;
	
	static String child_7_Title;
	static String child_7_firstname;
	static String child_7_lastname;
	static String child_7_nation;
	static String child_7_IC;
	
	static String child_8_Title;
	static String child_8_firstname;
	static String child_8_lastname;
	static String child_8_nation;
	static String child_8_IC;
	
	static String infant_1_Title;
	static String infant_1_firstname;
	static String infant_1_lastname;
	static String infant_1_nation;
	static String infant_1_IC;
	
	static String infant_2_Title;
	static String infant_2_firstname;
	static String infant_2_lastname;
	static String infant_2_nation;
	static String infant_2_IC;
	
	static String infant_3_Title;
	static String infant_3_firstname;
	static String infant_3_lastname;
	static String infant_3_nation;
	static String infant_3_IC;
	
	static String infant_4_Title;
	static String infant_4_firstname;
	static String infant_4_lastname;
	static String infant_4_nation;
	static String infant_4_IC;
	
	
	
	static String phoneNumber;
	static String emailId;
	static String CountryCode;
	static String mobileCode;
	static String CityName;
	static WebDriver driver;
	
	static String CustomeremailId;
	static String ProcessIdValue="1";
	static String emailWithCustomerName;
	public static void ENTER() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		/*robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);*/
		
		
		
	}
	
    public static void adult1() throws Exception {
		
		PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
		PageUtils.isElementVisibil(driver, CebuPage.drp_title_1());
		
		CebuPage.drp_title_1().click();
		CebuPage.select_Value("Mr.");
		
		
		CebuPage.firstname_1().sendKeys("Naga");
		CebuPage.lastname_1().sendKeys("Babu");
		
		PageUtils.isElementVisibil(driver, CebuPage.drp_year_1());
		CebuPage.drp_year_1().click();
		
		CebuPage.select_Value("1991");
		
		PageUtils.isElementVisibil(driver, CebuPage.drp_month_1());
		CebuPage.drp_month_1().click();
		
		CebuPage.select_Value("December");
		
		PageUtils.isElementVisibil(driver, CebuPage.drp_date_1());
		CebuPage.drp_date_1().click();
		
		CebuPage.select_Value("29");
		
		
		PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_1());
		CebuPage.btn_Nationality_1().click();
		
		CebuPage.select_Value("India, Republic of");
		
		
		//Enter Passport Details
		CebuPage.txt_Passport_Num_1().sendKeys("1452Rte");
		
		PageUtils.isElementVisibil(driver, CebuPage.select_country_Of_Issue_1());
		CebuPage.select_country_Of_Issue_1().click();
		
		CebuPage.select_Value("India, Republic of");
		

		
		PageUtils.isElementVisibil(driver, CebuPage.drp_pass_Exp_Year_1());
		CebuPage.drp_pass_Exp_Year_1().click();
		
		CebuPage.select_Value("2030");
		
		PageUtils.isElementVisibil(driver, CebuPage.drp_pass_Exp_Month_1());
		CebuPage.drp_pass_Exp_Month_1().click();
		
		CebuPage.select_Value("May");
		
		PageUtils.isElementVisibil(driver, CebuPage.drp_pass_Exp_day_1());
		CebuPage.drp_pass_Exp_day_1().click();
		
		CebuPage.select_Value("30");
		
		CebuPage.chk_Pasport_In_1().click();
		
		
        
}
public static void adult2() throws Exception {
	CebuPage.btn_Continue_Passenger().click();
    PageUtils.waitForFixedTime(BrowserContants.WAIT_SMALL_ENGINE);
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_2());
	
	CebuPage.drp_title_2().click();
	CebuPage.select_Value("Mr.");
	
	
	CebuPage.firstname_2().sendKeys("HASAN");
	CebuPage.lastname_2().sendKeys("KEPEPI");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_2());
	CebuPage.drp_year_2().click();
	
	CebuPage.select_Value("1999");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_2());
	CebuPage.drp_month_2().click();
	
	CebuPage.select_Value("June");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_2());
	CebuPage.drp_date_2().click();
	
	CebuPage.select_Value("14");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_2());
	CebuPage.btn_Nationality_2().click();
	
	CebuPage.select_Value("Saudi Arabia, Kingdom of");
	
	
	//Enter Passport Details
			CebuPage.txt_Passport_Num_2().sendKeys("1110095310");
			
			PageUtils.isElementVisibil(driver, CebuPage.select_country_Of_Issue_2());
			CebuPage.select_country_Of_Issue_2().click();
			
			CebuPage.select_Value("Saudi Arabia, Kingdom of");
			

			
			PageUtils.isElementVisibil(driver, CebuPage.drp_pass_Exp_Year_2());
			CebuPage.drp_pass_Exp_Year_2().click();
			
			CebuPage.select_Value("2030");
			
			PageUtils.isElementVisibil(driver, CebuPage.drp_pass_Exp_Month_2());
			CebuPage.drp_pass_Exp_Month_2().click();
			
			CebuPage.select_Value("May");
			
			PageUtils.isElementVisibil(driver, CebuPage.drp_pass_Exp_day_2());
			CebuPage.drp_pass_Exp_day_2().click();
			
			CebuPage.select_Value("30");
			

			
}
	
	
	
   


public static void adult3() throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_3());
	PageUtils.selectByVisibleText(CebuPage.drp_title_3(), "");
	
	CebuPage.firstname_3().sendKeys("");
	CebuPage.lastname_3().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_3());
	PageUtils.selectByVisibleText(CebuPage.drp_year_3(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_3());
	PageUtils.selectByVisibleText(CebuPage.drp_month_3(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_3());
	PageUtils.selectByVisibleText(CebuPage.drp_date_3(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_3());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_3(), "");

	
}
		
	
	
	
   
public static void adult4() throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_4());
	PageUtils.selectByVisibleText(CebuPage.drp_title_4(), "");
	
	CebuPage.firstname_4().sendKeys("");
	CebuPage.lastname_4().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_4());
	PageUtils.selectByVisibleText(CebuPage.drp_year_4(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_4());
	PageUtils.selectByVisibleText(CebuPage.drp_month_4(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_4());
	PageUtils.selectByVisibleText(CebuPage.drp_date_4(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_4());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_4(), "");
	
	
    
}

public static void adult5() throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_5());
	PageUtils.selectByVisibleText(CebuPage.drp_title_5(), "");
	
	CebuPage.firstname_5().sendKeys("");
	CebuPage.lastname_5().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_5());
	PageUtils.selectByVisibleText(CebuPage.drp_year_5(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_5());
	PageUtils.selectByVisibleText(CebuPage.drp_month_5(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_5());
	PageUtils.selectByVisibleText(CebuPage.drp_date_5(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_5());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_5(), "");
	
	
   
}

public static void adult6() throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_6());
	PageUtils.selectByVisibleText(CebuPage.drp_title_6(), "");
	
	CebuPage.firstname_6().sendKeys("");
	CebuPage.lastname_6().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_6());
	PageUtils.selectByVisibleText(CebuPage.drp_year_6(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_6());
	PageUtils.selectByVisibleText(CebuPage.drp_month_6(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_6());
	PageUtils.selectByVisibleText(CebuPage.drp_date_6(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_6());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_6(), "");
	
   
}
public static void adult7() throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_7());
	PageUtils.selectByVisibleText(CebuPage.drp_title_7(), "");
	
	CebuPage.firstname_7().sendKeys("");
	CebuPage.lastname_7().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_7());
	PageUtils.selectByVisibleText(CebuPage.drp_year_7(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_7());
	PageUtils.selectByVisibleText(CebuPage.drp_month_7(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_7());
	PageUtils.selectByVisibleText(CebuPage.drp_date_7(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_7());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_7(), "");

	
		
}
			
		
	
	
   

public static void adult8() throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_8());
	PageUtils.selectByVisibleText(CebuPage.drp_title_8(), "");
	
	CebuPage.firstname_8().sendKeys("");
	CebuPage.lastname_8().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_8());
	PageUtils.selectByVisibleText(CebuPage.drp_year_8(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_8());
	PageUtils.selectByVisibleText(CebuPage.drp_month_8(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_8());
	PageUtils.selectByVisibleText(CebuPage.drp_date_8(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_8());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_8(), "");
			

		}
			
		

public static void adult9() throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_9());
	PageUtils.selectByVisibleText(CebuPage.drp_title_9(), "");
	
	CebuPage.firstname_9().sendKeys("");
	CebuPage.lastname_9().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_9());
	PageUtils.selectByVisibleText(CebuPage.drp_year_9(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_9());
	PageUtils.selectByVisibleText(CebuPage.drp_month_9(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_9());
	PageUtils.selectByVisibleText(CebuPage.drp_date_9(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_9());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_9(), "");

	
}

public static void child1(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_2());
	PageUtils.selectByVisibleText(CebuPage.drp_title_2(), "");
	
	CebuPage.firstname_2().sendKeys("");
	CebuPage.lastname_2().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_2());
	PageUtils.selectByVisibleText(CebuPage.drp_year_2(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_2());
	PageUtils.selectByVisibleText(CebuPage.drp_month_2(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_2());
	PageUtils.selectByVisibleText(CebuPage.drp_date_2(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_2());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_2(), "");
}
			
	
	
   

public static void child2(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_3());
	PageUtils.selectByVisibleText(CebuPage.drp_title_3(), "");
	
	CebuPage.firstname_3().sendKeys("");
	CebuPage.lastname_3().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_3());
	PageUtils.selectByVisibleText(CebuPage.drp_year_3(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_3());
	PageUtils.selectByVisibleText(CebuPage.drp_month_3(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_3());
	PageUtils.selectByVisibleText(CebuPage.drp_date_3(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_3());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_3(), "");


   
}
public static void child3(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_4());
	PageUtils.selectByVisibleText(CebuPage.drp_title_4(), "");
	
	CebuPage.firstname_4().sendKeys("");
	CebuPage.lastname_4().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_4());
	PageUtils.selectByVisibleText(CebuPage.drp_year_4(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_4());
	PageUtils.selectByVisibleText(CebuPage.drp_month_4(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_4());
	PageUtils.selectByVisibleText(CebuPage.drp_date_4(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_4());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_4(), "");

		

}
public static void child4(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_5());
	PageUtils.selectByVisibleText(CebuPage.drp_title_5(), "");
	
	CebuPage.firstname_5().sendKeys("");
	CebuPage.lastname_5().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_5());
	PageUtils.selectByVisibleText(CebuPage.drp_year_5(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_5());
	PageUtils.selectByVisibleText(CebuPage.drp_month_5(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_5());
	PageUtils.selectByVisibleText(CebuPage.drp_date_5(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_5());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_5(), "");
		


	
   
}
public static void child5(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_6());
	PageUtils.selectByVisibleText(CebuPage.drp_title_6(), "");
	
	CebuPage.firstname_6().sendKeys("");
	CebuPage.lastname_6().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_6());
	PageUtils.selectByVisibleText(CebuPage.drp_year_6(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_6());
	PageUtils.selectByVisibleText(CebuPage.drp_month_6(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_6());
	PageUtils.selectByVisibleText(CebuPage.drp_date_6(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_6());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_6(), "");

		

   
}
public static void child6(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_7());
	PageUtils.selectByVisibleText(CebuPage.drp_title_7(), "");
	
	CebuPage.firstname_7().sendKeys("");
	CebuPage.lastname_7().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_7());
	PageUtils.selectByVisibleText(CebuPage.drp_year_7(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_7());
	PageUtils.selectByVisibleText(CebuPage.drp_month_7(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_7());
	PageUtils.selectByVisibleText(CebuPage.drp_date_7(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_7());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_7(), "");
}
		


    

public static void child7(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_8());
	PageUtils.selectByVisibleText(CebuPage.drp_title_8(), "");
	
	CebuPage.firstname_8().sendKeys("");
	CebuPage.lastname_8().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_8());
	PageUtils.selectByVisibleText(CebuPage.drp_year_8(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_8());
	PageUtils.selectByVisibleText(CebuPage.drp_month_8(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_8());
	PageUtils.selectByVisibleText(CebuPage.drp_date_8(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_8());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_8(), "");
	
}
		


    

public static void child8(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_9());
	PageUtils.selectByVisibleText(CebuPage.drp_title_9(), "");
	
	CebuPage.firstname_9().sendKeys("");
	CebuPage.lastname_9().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_9());
	PageUtils.selectByVisibleText(CebuPage.drp_year_9(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_9());
	PageUtils.selectByVisibleText(CebuPage.drp_month_9(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_9());
	PageUtils.selectByVisibleText(CebuPage.drp_date_9(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_9());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_9(), "");
}
		

   

public static void Infant1(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_2());
	PageUtils.selectByVisibleText(CebuPage.drp_title_2(), "");
	
	CebuPage.firstname_2().sendKeys("");
	CebuPage.lastname_2().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_2());
	PageUtils.selectByVisibleText(CebuPage.drp_year_2(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_2());
	PageUtils.selectByVisibleText(CebuPage.drp_month_2(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_2());
	PageUtils.selectByVisibleText(CebuPage.drp_date_2(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_2());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_2(), "");
}
		

	
	
	
	
    

public static void Infant2(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_3());
	PageUtils.selectByVisibleText(CebuPage.drp_title_3(), "");
	
	CebuPage.firstname_3().sendKeys("");
	CebuPage.lastname_3().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_3());
	PageUtils.selectByVisibleText(CebuPage.drp_year_3(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_3());
	PageUtils.selectByVisibleText(CebuPage.drp_month_3(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_3());
	PageUtils.selectByVisibleText(CebuPage.drp_date_3(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_3());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_3(), "");

}
	
   
public static void Infant3(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_4());
	PageUtils.selectByVisibleText(CebuPage.drp_title_4(), "");
	
	CebuPage.firstname_4().sendKeys("");
	CebuPage.lastname_4().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_4());
	PageUtils.selectByVisibleText(CebuPage.drp_year_4(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_4());
	PageUtils.selectByVisibleText(CebuPage.drp_month_4(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_4());
	PageUtils.selectByVisibleText(CebuPage.drp_date_4(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_4());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_4(), "");
}
		


public static void Infant4(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_5());
	PageUtils.selectByVisibleText(CebuPage.drp_title_5(), "");
	
	CebuPage.firstname_5().sendKeys("");
	CebuPage.lastname_5().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_5());
	PageUtils.selectByVisibleText(CebuPage.drp_year_5(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_5());
	PageUtils.selectByVisibleText(CebuPage.drp_month_5(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_5());
	PageUtils.selectByVisibleText(CebuPage.drp_date_5(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_5());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_5(), "");
}
		


public static void Infant5(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_6());
	PageUtils.selectByVisibleText(CebuPage.drp_title_6(), "");
	
	CebuPage.firstname_6().sendKeys("");
	CebuPage.lastname_6().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_6());
	PageUtils.selectByVisibleText(CebuPage.drp_year_6(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_6());
	PageUtils.selectByVisibleText(CebuPage.drp_month_6(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_6());
	PageUtils.selectByVisibleText(CebuPage.drp_date_6(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_6());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_6(), "");
	
}
		


public static void Infant6(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	 
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_7());
	PageUtils.selectByVisibleText(CebuPage.drp_title_7(), "");
	
	CebuPage.firstname_7().sendKeys("");
	CebuPage.lastname_7().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_7());
	PageUtils.selectByVisibleText(CebuPage.drp_year_7(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_7());
	PageUtils.selectByVisibleText(CebuPage.drp_month_7(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_7());
	PageUtils.selectByVisibleText(CebuPage.drp_date_7(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_7());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_7(), "");

		
}

public static void Infant7(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_8());
	PageUtils.selectByVisibleText(CebuPage.drp_title_8(), "");
	
	CebuPage.firstname_8().sendKeys("");
	CebuPage.lastname_8().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_8());
	PageUtils.selectByVisibleText(CebuPage.drp_year_8(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_8());
	PageUtils.selectByVisibleText(CebuPage.drp_month_8(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_8());
	PageUtils.selectByVisibleText(CebuPage.drp_date_8(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_8());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_8(), "");

	
}
		


public static void Infant8(String Title,String FN,String LN,String d,String m,String y,String docType,String IsCou,String number,String P_d,String P_m,String P_y,String nation) throws Exception {
	PageUtils.isElementVisibil(driver, CebuPage.drp_title_9());
	PageUtils.selectByVisibleText(CebuPage.drp_title_9(), "");
	
	CebuPage.firstname_9().sendKeys("");
	CebuPage.lastname_9().sendKeys("");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_year_9());
	PageUtils.selectByVisibleText(CebuPage.drp_year_9(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_month_9());
	PageUtils.selectByVisibleText(CebuPage.drp_month_9(), "");
	
	PageUtils.isElementVisibil(driver, CebuPage.drp_date_9());
	PageUtils.selectByVisibleText(CebuPage.drp_date_9(), "");
	
	
	PageUtils.isElementVisibil(driver, CebuPage.btn_Nationality_9());
	PageUtils.selectByVisibleText(CebuPage.btn_Nationality_9(), "");


		
}





public static void paxAPI(Database pnrDetails) throws InterruptedException, IOException
{		
	
	//randomMails();
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://stageapi.rehlat.com/v1/Rehlat/flights";
	
	RequestSpecification request = RestAssured.given();
	//request.accept("text/xml");
	JSONObject requestParams = new JSONObject();
	request.header("Content-Type", "text/json");
	requestParams.put("Domain", pnrDetails.Domain);
	requestParams.put("PnrId", pnrDetails.PnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	//request.header("Accept", "text/xml");
   // request.contentType("text/json");
	//JSONObject requestParams = new JSONObject();
	//requestParams.put("id","142531");
	//requestParams.put("undefined", "\"142531\"");
	// Cast
	//requestParams.put("Language", "en");
	/*requestParams.put("To", "JED");
	requestParams.put("DepartureDate", "20190225");	
	requestParams.put("ReturnDate",  "20190228");
	requestParams.put("Currency", "USD");	 
	requestParams.put("Adults",  "1");
	requestParams.put("Children",  "0");
	requestParams.put("Infant",  "0");
	requestParams.put("CLASS",  "Economy");
	requestParams.put("UserName",  "rehlat");
	requestParams.put("Password",  "123456");*/
 
	//request.body(pnrDetails.PnrId);
	request.body(requestParams.toJSONString());
	Response response = request.post("/GetPaxDetailsForScraping");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	//System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	Gson g = new Gson();
	Pax[] mcArray = g.fromJson(s, Pax[].class);
	List<Pax> p = Arrays.asList(mcArray);
	/*Gson g = new Gson();
	List<Pax> p =  g.fromJson(s, List<Pax.class>);
	*/
	//System.out.println("Pnr: " + p.pnr);
	int adultPaxCount = 1;
	int childPaxCount = 1;
	int infantPaxCount = 1;
	
	
	
	
	
	

	 for(Pax pax:p){
		 if(pax.PaxType.equals("ADULT")){
			 
			
			 if(adultPaxCount==1)
			 {
				 adult_1_firstname=pax.FirstNameF3;
				 adult_1_lastname=pax.LastNameF3;
				 adult_1_Title=pax.Title;
				 adult_1_nation= pax.Nationality;
				 adult_1_IC= pax.IssuingCountryName;
				  CityName=pax.FromCity;
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.FirstNameF3 +"\n" +", Pax Type: " + pax.PaxType);
				 System.out.println("Adult Last Name_"+adultPaxCount +": "+ pax.LastNameF3 +"\n" +", Pax Type: " + pax.PaxType); 
				  phoneNumber=pax.PhoneNumber;
				   CustomeremailId=pax.Email;
				  String [] Customeremail=CustomeremailId.split("@");
				    emailWithCustomerName=Customeremail[0]+""+"@mailsaudi.com";
				  System.out.println("Using Mail Id:"+emailWithCustomerName);
				  
				  //emailId="travelme686@gmail.com";
				 // randomMails();
				  CountryCode=pax.MobileCountry;
				   mobileCode=pax.MobileCode;
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.DocumentNumber );
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.DocumentTypeF3 );
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.DobStrF3 );
				  adult1_doc_Number=pax.DocumentNumber;
				 adult1_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult1_dof_d=S[0];
				  adult1_dof_m=S[1];
				  adult1_dof_y=S[2];
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.PassportExpiryDateStrF3 );
				 String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult1_pass_d=P[0];
				  adult1_pass_m=P[1];
				  adult1_pass_y=P[2];
			 
			 }
			 if(adultPaxCount==2)
			 {
				 adult_2_firstname=pax.FirstNameF3;
				 adult_2_lastname=pax.LastNameF3;
				 adult_2_Title=pax.Title;
				 adult_2_nation= pax.Nationality;
				 adult_2_IC= pax.IssuingCountryName;
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.FirstNameF3 +"\n" +", Pax Type: " + pax.PaxType);
				 System.out.println("Adult Last Name_"+adultPaxCount +": "+ pax.LastNameF3 +"\n" +", Pax Type: " + pax.PaxType); 
				
				 System.out.println("Adult2 First Name_"+adultPaxCount +": "+ pax.DocumentNumber );
				 System.out.println("Adult2 First Name_"+adultPaxCount +": "+ pax.DocumentTypeF3 );
				 System.out.println("Adult2 First Name_"+adultPaxCount +": "+ pax.DobStrF3 );
				  adult2_doc_Number=pax.DocumentNumber;
				  adult2_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult2_dof_d=S[0];
				  adult2_dof_m=S[1];
				  adult2_dof_y=S[2];
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.PassportExpiryDateStrF3 );
				 String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult2_pass_d=P[0];
				  adult2_pass_m=P[1];
				  adult2_pass_y=P[2];
			 
			 }
			 
			 if(adultPaxCount==3)
			 {
				 adult_3_firstname=pax.FirstNameF3;
				 adult_3_lastname=pax.LastNameF3;
				 adult_3_Title=pax.Title;
				 adult_3_nation= pax.Nationality;
				 adult_3_IC= pax.IssuingCountryName;
				 adult3_doc_Number=pax.DocumentNumber;
				 adult3_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult3_dof_d=S[0];
				  adult3_dof_m=S[1];
				  adult3_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult3_pass_d=P[0];
				  adult3_pass_m=P[1];
				  adult3_pass_y=P[2];
				 
				 
			 }
			 
			 if(adultPaxCount==4)
			 {
				 adult_4_firstname=pax.FirstNameF3;
				 adult_4_lastname=pax.LastNameF3;
				 adult_4_Title=pax.Title;
				 adult_4_nation= pax.Nationality;
				 adult_4_IC= pax.IssuingCountryName;
				 adult4_doc_Number=pax.DocumentNumber;
				 adult4_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult4_dof_d=S[0];
				  adult4_dof_m=S[1];
				  adult4_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult4_pass_d=P[0];
				  adult4_pass_m=P[1];
				  adult4_pass_y=P[2];
				 
				 
			 }
			 if(adultPaxCount==5)
			 {
				 adult_5_firstname=pax.FirstNameF3;
				 adult_5_lastname=pax.LastNameF3;
				 adult_5_Title=pax.Title;
				 adult_5_nation= pax.Nationality;
				 adult_5_IC= pax.IssuingCountryName;
				 adult5_doc_Number=pax.DocumentNumber;
				 adult5_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult5_dof_d=S[0];
				  adult5_dof_m=S[1];
				  adult5_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult5_pass_d=P[0];
				  adult5_pass_m=P[1];
				  adult5_pass_y=P[2];
				 
				 
			 }
			 if(adultPaxCount==6)
			 {
				 adult_6_firstname=pax.FirstNameF3;
				 adult_6_lastname=pax.LastNameF3;
				 adult_6_Title=pax.Title;
				 adult_6_nation= pax.Nationality;
				 adult_6_IC= pax.IssuingCountryName;
				 adult6_doc_Number=pax.DocumentNumber;
				 adult6_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult6_dof_d=S[0];
				  adult6_dof_m=S[1];
				  adult6_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult6_pass_d=P[0];
				  adult6_pass_m=P[1];
				  adult6_pass_y=P[2];
				 
				 
			 }
			 if(adultPaxCount==7)
			 {
				 adult_7_firstname=pax.FirstNameF3;
				 adult_7_lastname=pax.LastNameF3;
				 adult_7_Title=pax.Title;
				 adult_7_nation= pax.Nationality;
				 adult_7_IC= pax.IssuingCountryName;
				 adult7_doc_Number=pax.DocumentNumber;
				 adult7_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult7_dof_d=S[0];
				  adult7_dof_m=S[1];
				  adult7_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult7_pass_d=P[0];
				  adult7_pass_m=P[1];
				  adult7_pass_y=P[2];
				 
				 
			 }
			 if(adultPaxCount==8)
			 {
				 adult_8_firstname=pax.FirstNameF3;
				 adult_8_lastname=pax.LastNameF3;
				 adult_8_Title=pax.Title;
				 adult_8_nation= pax.Nationality;
				 adult_8_IC= pax.IssuingCountryName;
				 adult8_doc_Number=pax.DocumentNumber;
				 adult8_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult8_dof_d=S[0];
				  adult8_dof_m=S[1];
				  adult8_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult8_pass_d=P[0];
				  adult8_pass_m=P[1];
				  adult8_pass_y=P[2];
				 
				 
			 }
			 if(adultPaxCount==9)
			 {
				 adult_9_firstname=pax.FirstNameF3;
				 adult_9_lastname=pax.LastNameF3;
				 adult_9_Title=pax.Title;
				 adult_9_nation= pax.Nationality;
				 adult_9_IC= pax.IssuingCountryName;
				 adult9_doc_Number=pax.DocumentNumber;
				 adult9_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  adult9_dof_d=S[0];
				  adult9_dof_m=S[1];
				  adult9_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  adult9_pass_d=P[0];
				  adult9_pass_m=P[1];
				  adult9_pass_y=P[2];
				 
				 
			 }
			 
			 adultPaxCount +=1;
		 }
		 else if(pax.PaxType.equals("CHILD")){
			 
			 if(childPaxCount==1)
			 {
				 child_1_firstname=pax.FirstNameF3;
				 child_1_lastname=pax.LastNameF3;
				 child_1_Title=pax.Title;
				 child_1_nation= pax.Nationality;
				 child_1_IC= pax.IssuingCountryName;
				 child1_doc_Number=pax.DocumentNumber;
				 child1_doc_Type=pax.DocumentTypeF3;
				 System.out.println("CHILD First Name_"+childPaxCount +": "+ pax.FirstNameF3 +"\n" +", Pax Type: " + pax.PaxType);
				 System.out.println("CHILD last Name_"+childPaxCount +": "+ pax.LastNameF3 +"\n" +", Pax Type: " + pax.PaxType);
				
				 System.out.println("CHILD First Name_"+adultPaxCount +": "+ pax.DocumentNumber );
				 System.out.println("CHILD First Name_"+adultPaxCount +": "+ pax.DocumentTypeF3 );
				 System.out.println("CHILD First Name_"+adultPaxCount +": "+ pax.DobStrF3 );
				 String[] S=pax.DobStrF3.split("-");
				  child1_dof_d=S[0];
				  child1_dof_m=S[1];
				  child1_dof_y=S[2];
				 System.out.println("Adult First Name_"+adultPaxCount +": "+ pax.PassportExpiryDateStrF3 );
				 String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child1_pass_d=P[0];
				  child1_pass_m=P[1];
				  child1_pass_y=P[2];
				 
				 
				 
			 }
			 if(childPaxCount==2)
			 {
				 child_2_firstname=pax.FirstNameF3;
				 child_2_lastname=pax.LastNameF3;
				 child_2_Title=pax.Title;
				 child_2_nation= pax.Nationality;
				 child_2_IC= pax.IssuingCountryName;
				 child2_doc_Number=pax.DocumentNumber;
				 child2_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  child2_dof_d=S[0];
				  child2_dof_m=S[1];
				  child2_dof_y=S[2];
				  
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child2_pass_d=P[0];
				  child2_pass_m=P[1];
				  child2_pass_y=P[2];
			 }
			 
			 if(childPaxCount==3)
			 {
				 child_3_firstname=pax.FirstNameF3;
				 child_3_lastname=pax.LastNameF3;
				 child_3_Title=pax.Title;
				 child_3_nation= pax.Nationality;
				 child_3_IC= pax.IssuingCountryName;
				 child3_doc_Number=pax.DocumentNumber;
				 child3_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  child3_dof_d=S[0];
				  child3_dof_m=S[1];
				  child3_dof_y=S[2];
				  
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child3_pass_d=P[0];
				  child3_pass_m=P[1];
				  child3_pass_y=P[2];
			 }
			 
			 if(childPaxCount==4)
			 {
				 child_4_firstname=pax.FirstNameF3;
				 child_4_lastname=pax.LastNameF3;
				 child_4_Title=pax.Title;
				 child_4_nation= pax.Nationality;
				 child_4_IC= pax.IssuingCountryName;
				 child4_doc_Number=pax.DocumentNumber;
				 child4_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  child4_dof_d=S[0];
				  child4_dof_m=S[1];
				  child4_dof_y=S[2];
				  
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child4_pass_d=P[0];
				  child4_pass_m=P[1];
				  child4_pass_y=P[2];
			 }
			 
			 if(childPaxCount==5)
			 {
				 child_5_firstname=pax.FirstNameF3;
				 child_5_lastname=pax.LastNameF3;
				 child_5_Title=pax.Title;
				 child_5_nation= pax.Nationality;
				 child_5_IC= pax.IssuingCountryName;
				 child5_doc_Number=pax.DocumentNumber;
				 child5_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  child5_dof_d=S[0];
				  child5_dof_m=S[1];
				  child5_dof_y=S[2];
				  
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child5_pass_d=P[0];
				  child5_pass_m=P[1];
				  child5_pass_y=P[2];
			 }
			 
			 if(childPaxCount==6)
			 {
				 child_6_firstname=pax.FirstNameF3;
				 child_6_lastname=pax.LastNameF3;
				 child_6_Title=pax.Title;
				 child_6_nation= pax.Nationality;
				 child_6_IC= pax.IssuingCountryName;
				 child6_doc_Number=pax.DocumentNumber;
				 child6_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  child6_dof_d=S[0];
				  child6_dof_m=S[1];
				  child6_dof_y=S[2];
				  
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child6_pass_d=P[0];
				  child6_pass_m=P[1];
				  child6_pass_y=P[2];
			 }
			 
			 if(childPaxCount==7)
			 {
				 child_7_firstname=pax.FirstNameF3;
				 child_7_lastname=pax.LastNameF3;
				 child_7_Title=pax.Title;
				 child_7_nation= pax.Nationality;
				 child_7_IC= pax.IssuingCountryName;
				 child7_doc_Number=pax.DocumentNumber;
				 child7_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  child7_dof_d=S[0];
				  child7_dof_m=S[1];
				  child7_dof_y=S[2];
				  
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child7_pass_d=P[0];
				  child7_pass_m=P[1];
				  child7_pass_y=P[2];
			 }
			 
			 if(childPaxCount==8)
			 {
				 child_8_firstname=pax.FirstNameF3;
				 child_8_lastname=pax.LastNameF3;
				 child_8_Title=pax.Title;
				 child_8_nation= pax.Nationality;
				 child_8_IC= pax.IssuingCountryName;
				 child8_doc_Number=pax.DocumentNumber;
				 child8_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  child8_dof_d=S[0];
				  child8_dof_m=S[1];
				  child8_dof_y=S[2];
				  
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  child8_pass_d=P[0];
				  child8_pass_m=P[1];
				  child8_pass_y=P[2];
			 }
			childPaxCount +=1;
		 }
		 else if(pax.PaxType.equals("INFANT")){
			 
			 if(infantPaxCount==1)
			 {
			 infant_1_firstname=pax.FirstNameF3;
			 infant_1_lastname=pax.LastNameF3;
			 infant_1_Title=pax.Title;
			 infant_1_nation= pax.Nationality;
			 infant_1_IC= pax.IssuingCountryName;
			 infant1_doc_Number=pax.DocumentNumber;
			 infant1_doc_Type=pax.DocumentTypeF3;
			 System.out.println("INFANT First Name_"+infantPaxCount +": "+ pax.FirstNameF3 +"\n" +", Pax Type: " + pax.PaxType);
			  System.out.println("INFANT last Name_"+infantPaxCount +": "+ pax.LastNameF3 +"\n" +", Pax Type: " + pax.PaxType);
			
			 System.out.println("INFANT First Name_"+infantPaxCount +": "+ pax.DocumentNumber );
			 System.out.println("INFANT First Name_"+infantPaxCount +": "+ pax.DocumentTypeF3 );
			 System.out.println("INFANT First Name_"+infantPaxCount +": "+ pax.DobStrF3 );
			 String[] S=pax.DobStrF3.split("-");
			  infant1_dof_d=S[0];
			  infant1_dof_m=S[1];
			  infant1_dof_y=S[2];
			 System.out.println("INFANT First Name_"+infantPaxCount +": "+ pax.PassportExpiryDateStrF3 );
			 String[] P=pax.PassportExpiryDateStrF3.split("-");
			  infant1_pass_d=P[0];
			  infant1_pass_m=P[1];
			  infant1_pass_y=P[2];
			 System.out.println("INFANT First Name_"+infantPaxCount +": "+ pax.FirstNameF3 +"\n" +", Pax Type: " + pax.PaxType);
			 }
			 
			 if(infantPaxCount==2)
			 {
				 infant_2_firstname=pax.FirstNameF3;
				 infant_2_lastname=pax.LastNameF3;
				 infant_2_Title=pax.Title;
				 infant_2_nation= pax.Nationality;
				 infant_2_IC= pax.IssuingCountryName;
				 infant2_doc_Number=pax.DocumentNumber;
				 infant2_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  infant2_dof_d=S[0];
				  infant2_dof_m=S[1];
				  infant2_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  infant2_pass_d=P[0];
				  infant2_pass_m=P[1];
				  infant2_pass_y=P[2];
			 }
			 
			 if(infantPaxCount==3)
			 {
				 infant_3_firstname=pax.FirstNameF3;
				 infant_3_lastname=pax.LastNameF3;
				 infant_3_Title=pax.Title;
				 infant_3_nation= pax.Nationality;
				 infant_3_IC= pax.IssuingCountryName;
				 infant3_doc_Number=pax.DocumentNumber;
				 infant3_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  infant3_dof_d=S[0];
				  infant3_dof_m=S[1];
				  infant3_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  infant3_pass_d=P[0];
				  infant3_pass_m=P[1];
				  infant3_pass_y=P[2];
			 }
			 
			 if(infantPaxCount==4)
			 {
				 infant_4_firstname=pax.FirstNameF3;
				 infant_4_lastname=pax.LastNameF3;
				 infant_4_Title=pax.Title;
				 infant_4_nation= pax.Nationality;
				 infant_4_IC= pax.IssuingCountryName;
				 infant4_doc_Number=pax.DocumentNumber;
				 infant4_doc_Type=pax.DocumentTypeF3;
				 String[] S=pax.DobStrF3.split("-");
				  infant4_dof_d=S[0];
				  infant4_dof_m=S[1];
				  infant4_dof_y=S[2];
				  String[] P=pax.PassportExpiryDateStrF3.split("-");
				  infant4_pass_d=P[0];
				  infant4_pass_m=P[1];
				  infant4_pass_y=P[2];
			 }
			 infantPaxCount +=1;
		 }
		 
		 
		
		   
		    } 
	 
	 
	 System.out.println("------------------------------------------------------------------------------------");
	 
	 /*System.out.println(adult_1_firstname);
	 System.out.println(adult_1_lastname);
	 System.out.println(adult_2_firstname);
	 System.out.println(adult_2_lastname);
	 System.out.println(adult_3_firstname);
	 System.out.println(adult_3_lastname);
	 System.out.println(child_1_firstname);
	 System.out.println(child_1_lastname);*/
}

public static void enetCardApi(Database pnrDetails) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Amount",  pnrDetails.Amount);
	request.body(requestParams.toJSONString());
	Response response = request.post("/GetEnettCard");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	//System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	Gson g = new Gson();
	
	CardDetails card = g.fromJson(s, CardDetails.class);
	
			System.out.println(card.VirtualAccountNumber); 
			
	 cardNumber=card.VirtualAccountNumber;
	 expiryMonth=card.ExpiryMonthNameF3;
	 expiryYear=card.ExpiryYear;
	 CVV=card.CardSecurityCode;
	 transactionID=card.VNettTransactionID;
	
	
	
	

	
}

static String cardNumber;
static String CVV;
static String expiryMonth;
static String expiryYear;
static String transactionID;
/*public static void enterCardDetails(Database pnrDetails,WebDriver driver) throws Exception
{
	try{
	enetCardApi(pnrDetails);
	PageUtils.isElementDisplayed(driver, flyadealPage.select_Card_Type("Credit/Debit Card"));
	flyadealPage.select_Card_Type("Credit/Debit Card");
	PageUtils.isElementVisibil(driver, flyadealPage.txt_Card_Number());
	flyadealPage.txt_Card_Number().sendKeys(cardNumber);
	System.out.println("Enter Card Number:"+cardNumber);
	PageUtils.isElementVisibil(driver, flyadealPage.txt_Holder_Name());
	flyadealPage.txt_Holder_Name().sendKeys(adult_1_firstname);
	PageUtils.isElementVisibil(driver, flyadealPage.btn_card_month());
	flyadealPage.btn_card_month().click();
	PageUtils.isElementVisibil(driver, flyadealPage.select_card_Month(expiryMonth));
	flyadealPage.select_card_Month(expiryMonth).click();
	PageUtils.isElementVisibil(driver, flyadealPage.btn_card_year());
	flyadealPage.btn_card_year().click();
	PageUtils.isElementVisibil(driver, flyadealPage.select_card_year(expiryYear));
	flyadealPage.select_card_year(expiryYear).click();
	PageUtils.isElementVisibil(driver,flyadealPage.txt_CVV_Number());
	flyadealPage.txt_CVV_Number().sendKeys(CVV);
	System.out.println("Enter CVV Number:"+CVV);
	PageUtils.isElementVisibil(driver,flyadealPage.btn_Payment_Continue());
	flyadealPage.btn_Payment_Continue().click();
	//Thread.sleep(15000);
	PageUtils.getScreenShot(pnrDetails.PnrId,driver);
	
	}
	catch(Exception e)
	{
		PageUtils.getScreenShot(pnrDetails.PnrId,driver);
		passengersDetails.returnStatus_fail(pnrDetails.Domain,pnrDetails.PnrId,"Payment Gateway Error");
		driver.quit();
	}
	GetPnr(driver,pnrDetails);
}
*/

/*public static void GetPnr(WebDriver driver,Database pnrDetails) throws Exception
{
	PageUtils.isElementLocated(driver, By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Share on'])[1]/following::b[1]"));
	PageUtils.waitForFixedTime(BrowserContants.WAIT_MEDIUM);
	 PnrId=flyadealPage.PNR_get().getText();
	System.out.println("PNR ID:"+PnrId);
	PageUtils.getScreenShot(pnrDetails.PnrId,driver);
	PageUtils.waitForFixedTime(BrowserContants.WAIT_VERY_SMALL);
	returnStatus(pnrDetails);
	generateMail(pnrDetails);
}
*/
public static void randomMails() {
	emailId = PageUtils.getMail();
	System.out.println("Get Mail Id:"+emailId);
	
}

public static void returnStatus(Database pnrDetails,String PnrID,String WebSiteAmount) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Status",  "1");
	requestParams.put("Remarks",  PnrID);
	requestParams.put("WebSiteTotalBookingAmount",  WebSiteAmount);
	request.body(requestParams.toJSONString());
	Response response = request.post("/UpdatePnrStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
}

public static void returnStatus_fail(String domain,String pnrId,String remarks) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain", domain);
	requestParams.put("PnrId",  pnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	requestParams.put("Status",  "0");
	requestParams.put("Remarks",  remarks);
	request.body(requestParams.toJSONString());
	Response response = request.post("/UpdatePnrStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
}

public static void readPnrId(Database pnrDetails) throws InterruptedException, IOException
{		
	
	if(BrowserContants.ENV.equals("PRD"))
	{
		RestAssured.baseURI =BrowserContants.PRD_API_URL;
	}
	else if(BrowserContants.ENV.equals("STG"))
	{
		RestAssured.baseURI =BrowserContants.STG_API_URL;
	}
	//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "text/json");
	JSONObject requestParams = new JSONObject();
	requestParams.put("Domain",  pnrDetails.Domain);
	requestParams.put("PnrId",  pnrDetails.PnrId);
	requestParams.put("ProcessId",  ProcessIdValue);
	request.body(requestParams.toJSONString());
	Response response = request.post("/SetPnrReadStatus");
	System.out.println("Response body: " + response.body().asString());
	String s=response.body().asString();
	System.out.println(s);
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	
	
}

public static void generateMail(Database pnrDetails) throws EmailException
{
	StringBuilder htmlStringBuilder=new StringBuilder();
	
	//Mail sent

	System.out.println("Started");
	 //StringBuilder htmlStringBuilder=new StringBuilder();
	 HtmlEmail email = new HtmlEmail();
	//Email email = new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	System.out.println("1");
	email.setAuthenticator(new DefaultAuthenticator("nagababu.cherukumalli@rehlat.com", "naga@qtselenium"));
	email.setSSLOnConnect(true);
	email.setFrom("naga123.ch@gmail.com");
	
	 Date mDate = new Date();
	 DateFormat date = new SimpleDateFormat("dd-MMMM-yyyy");
	 String Date=date.format(mDate);
	 System.out.println(Date);
		if (Date.equals(pnrDetails.DepartureDate)) {
			email.setSubject(
					"[HIGH PRIORITY] FlyaDeal Booking Using ENETT  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		} else {
			email.setSubject("FlyaDeal Booking Using ENETT  " + pnrDetails.Domain + "_" + pnrDetails.PnrId);
		}
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr>Dear Team,</tr>"));
	//email.setHtmlMsg(""+htmlStringBuilder.append("<tr>FlyaDeal transaction completed successful for BookingId <b> "+pnrDetails.PnrId+"</b>  with PNR <b> "+flyaDealModule.PnrId+"</b>  in <b> "+pnrDetails.Domain+"</b>  domain using enett card with transactionId <b>"+transactionID+"</b> </tr>"));
	email.setHtmlMsg(""+htmlStringBuilder.append("<tr></tr>"));
	
	email.addTo("qateam@rehlat.com");
	email.addCc("rajendra.purohit@rehlat.com");
	email.addCc("rajashekar.uppu@rehlat.com");
	 
	 //email.addTo("naga.ch199@gmail.com");
	
	
	System.out.println("2");
	email.send();
	System.out.println("END");
}


}
