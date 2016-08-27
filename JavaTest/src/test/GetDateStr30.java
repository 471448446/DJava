package test;

import java.util.Calendar;

public class GetDateStr30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR)+"."+calendar.get(Calendar.MONTH)+"."+calendar.get(Calendar.DATE));
		for (int i = 0,j=40; i < j; i++) {
//			calendar.roll(Calendar.DATE, 1);
			calendar.add(Calendar.DATE, 1);
			System.out.println(calendar.get(Calendar.YEAR)+"."+calendar.get(Calendar.MONTH)+"."+calendar.get(Calendar.DATE));
		}
	}
}
