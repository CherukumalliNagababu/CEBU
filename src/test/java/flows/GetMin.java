package flows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class GetMin {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*String FirstFlightTime="10h 30m";
		FirstFlightTime = FirstFlightTime.replace(" ","");
		FirstFlightTime = FirstFlightTime.toLowerCase();
		String[] jrnyTmHrs = FirstFlightTime.split("h");
		int hrs = Integer.parseInt(jrnyTmHrs[0]);
		hrs = hrs*60;
		String[] minsstr =  jrnyTmHrs[1].split("m");
		int mins = Integer.parseInt(minsstr[0]);
		mins = mins + hrs;
		System.out.println(mins);*/
		Date depDate=new SimpleDateFormat("dd MMM yyyy").parse("24 Oct 2019");  
		
		
		Calendar c = Calendar.getInstance();
		c.setTime(depDate);
		c.add(Calendar.DATE, 1);
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		String strDate= formatter2.format(c.getTime());
		System.out.println(strDate);
	}

}
