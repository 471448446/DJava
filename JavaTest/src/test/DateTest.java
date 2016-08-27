package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
//		Date date=DateFormat.;
		String dateStr="20161218";
		DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		try {
			Date date=dateFormat.parse(dateStr);
			System.out.println("date="+date.getYear()+","+date.getMonth()+","+date.getDate());
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			System.out.println(","+calendar.get(Calendar.YEAR)+",position="+(calendar.get(Calendar.MONTH)+1)+","+calendar.get(Calendar.DAY_OF_MONTH));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
