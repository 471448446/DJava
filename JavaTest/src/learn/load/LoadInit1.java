package learn.load;

import common.Utils;

/**
 * Created by better on 2018/4/11.
 */
public class LoadInit1 {
    //A=1,B=0
    /**
     * 类文件从上往下加载，然后这个静态变量先调用了构造方法，先对A、B赋值了
     * 但建在完这行后，
     * 又将B赋值了
     */
    private static LoadInit1 instance = new LoadInit1();
    public static int A;
    public static int B = 0;
    // A=1,B=1
//    private static LoadInit1 instance = new LoadInit1();

    private LoadInit1() {
        A++;
        B++;
        Utils.log("LoadInit1Main construct A:" + A + ",B:" + B);
    }

    public static LoadInit1 getInstance() {
        return instance;
    }
}
