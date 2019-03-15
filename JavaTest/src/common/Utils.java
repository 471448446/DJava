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

    public static void logThread(String msg) {
        System.out.println(Thread.currentThread().getName() + " " + msg);
    }


}
