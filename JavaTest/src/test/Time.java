package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date(1450485000000L));
		System.out.println(date); 
		String []string=date.split(" ");
		System.out.println(string[0]+","+string[1]);
		System.out.println("=======================");
		
		
		Date _currentDate=new Date(System.currentTimeMillis());
		Date _canStartTime=new Date(1447882200000L-1800000L);
		System.out.println("curr:"+_currentDate.getTime()+",canstart:"+_canStartTime.getTime());
		if(_canStartTime.before(_currentDate)){
			System.out.println("_canStartTime:"+sdf.format(_canStartTime)+" after,当前时间："+sdf.format(_currentDate)+",开始动画");
		}else{
			System.out.println("还没没到开始时间");
		}
		if(System.currentTimeMillis()-1447882200000L>=1800000L){
			System.out.println("可以开哦是");
		}else{
			System.err.println("还没开始");
		}
	}

}
