package test;

import common.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//https://www.4spaces.org/utc-string-to-date/
public class TimeFormate {
    public static void main(String[] args) {
        String time = "2019-03-25T12:26:03-04:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        try {
            format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        way0(time);
        way1(time);
    }

    private static void way0(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        try {
            Date date = format.parse(time);
            Utils.log("T1", time, date.getTime(), date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void way1(String time) {
        time = time.replace("T", " ");
        time = time.substring(0, time.lastIndexOf("-"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try {
            Date data = format.parse(time);
            Utils.log("T2", time, data.getTime(), data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
