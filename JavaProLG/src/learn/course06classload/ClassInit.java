package learn.course06classload;

/**
 * Created by better on 2020/6/14.
 */
public class ClassInit {
    public static int value = 1;

    static {
        System.out.println("Class Init static block");
    }

    {
        System.out.println("Class Init no static block");
    }
}
