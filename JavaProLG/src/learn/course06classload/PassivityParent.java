package learn.course06classload;

/**
 * Created by better on 2020/6/14.
 */
public class PassivityParent {
    public static int value = 1;

    static {
        System.out.println("parent static block");
    }
}
