package learn.course06classload;

/**
 * Created by better on 2020/6/14.
 */
public class PassivityChild extends PassivityParent {

    static {
        System.out.println("child static block");
    }
}
