package learn.gc;

/**
 * Created by better on 2020/5/17.
 */
public class GCRootUtils {

    static void printMemory() {
        System.out.print("current Mem: " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println(",total Mem: " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
    }
}
