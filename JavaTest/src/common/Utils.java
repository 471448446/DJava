package common;

/**
 * ���÷���
 *
 * @author better
 */
public class Utils {
    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void logThread(String msg) {
        System.out.println(Thread.currentThread().getName() + " " + msg);
    }

}
