package learn.load;

import common.Utils;

/**
 * 在编译时无法确定下来的静态变量(运行时常量),会对类进行初始化
 * Created by better on 2018/4/11.
 */
public class InitTest2 {
    public static int X = 6 / 2;

    static {
        Utils.log("InitTest2 stats block");
    }

}
