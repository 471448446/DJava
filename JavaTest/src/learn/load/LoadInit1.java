package learn.load;

/**
 * Created by better on 2018/4/11.
 */
public class LoadInit1 {
    //A=1,B=0
    private static LoadInit1 instance = new LoadInit1();
    public static int A;
    public static int B = 0;
    // A=1,B=1
//    private static LoadInit1 instance = new LoadInit1();

    public LoadInit1() {
        A++;
        B++;
    }

    public static LoadInit1 getInstance() {
        return instance;
    }
}
