package CebuModules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class ApiMethods {
	
	@Test
	
	public static void sendResults(String F,String T,String DD,List<CBFlightDetails> FlightDetails) throws InterruptedException, IOException
	{
	
		
		if(BrowserContants.ENV.equals("PRD"))
		{
			RestAssured.baseURI =BrowserContants.PRD_API_URL;
		}
		else if(BrowserContants.ENV.equals("STG"))
		{
			RestAssured.baseURI =BrowserContants.STG_API_URL;
		}
		
		//RestAssured.baseURI =BrowserContants.STG_API_URL;
		//RestAssured.baseURI ="http://commonrehlat.azurewebsites.net/v1/scraping";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "text/json");
		CBFlightResponse result = new CBFlightResponse();
		result.From =F;
		result.To = T;
		result.Currency = "SAR";
		result.DepartureDate = DD;
		result.FlightDetails = FlightDetails;
		
		//System.out.println("FlightDetails:"+result);
		Gson gson = new Gson();
		
		request.body(gson.toJson(result));
		System.out.println(gson.toJson(result));
		Response response = request.post("/Save5JSrpToCache");
		System.out.println("Response body: " + response.body().asString());
		String s=response.body().asString();
		System.out.println(s);
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		
		
	}

}
