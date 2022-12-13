package common;

/**
 * 常用方法
 *
 * @author better
 */
public class Utils {
    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void logMethodS(String msg) {
        log(msg, "____start_____");
    }

    public static void logMethodE(String msg) {
        log(msg, "____end_____");

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

    public static String string(int[] data) {
        StringBuilder s = new StringBuilder();
        for (int datum : data) {
            s.append(datum).append(",");
        }
        return s.toString();
    }

    public static String string(Object[] data) {
        StringBuilder s = new StringBuilder();
        for (Object datum : data) {
            s.append(datum).append(",");
        }
        return s.toString();
    }


}
