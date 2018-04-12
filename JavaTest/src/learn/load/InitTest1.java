package learn.load;

import common.Utils;

/**
 * Created by better on 2018/4/11.
 */
public class InitTest1 {
    public static final int X = 6 / 2;

    static {
        Utils.log("InitTest1 stats block");
    }

}
