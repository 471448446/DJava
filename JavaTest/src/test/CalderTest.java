package test;

import java.util.Calendar;

public class CalderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		calendar.set(2016, 6, 1);
		System.out.println(""+calendar.get(Calendar.DAY_OF_MONTH));
		//获取小时
		calendar.set(2016, 6, 1,23,23,23);
		System.out.println(""+calendar.get(Calendar.HOUR_OF_DAY));

	}

}
