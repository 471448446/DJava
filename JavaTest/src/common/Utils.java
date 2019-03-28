package common;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 常用方法
 *
 * @author better
 */
public class Utils {
    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void log(Object... msg) {
        System.out.println(TextUtil.join(",", msg));
    }

    public static String toString(int[] a) {
        if (null == a) {
            return "NULL";
        }
        Object[] o = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            o[i] = a[i];
        }
        return TextUtil.join(",", o);
    }

    public static void logThread(String msg) {
        System.out.println(Thread.currentThread().getName() + " " + msg);
    }


}
