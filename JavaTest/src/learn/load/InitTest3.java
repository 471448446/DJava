package learn.load;

import java.util.Random;

/**
 * 在编译时无法确定下来的静态变量(运行时常量),会对类进行初始化
 * Created by better on 2018/4/11.
 */
public class InitTest3 {
    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("FinalTest3 static block");
    }
}
