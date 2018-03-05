package learn.oclass.initorder;


import common.Utils;


/**
 * 顺序：静态>成员和代码块>构造函数
 * <p>
 * Created by better on 2018/3/4.
 */
public class ClassA {
    public static String sAFiled = "静态变量";

    static {
        l(sAFiled);
        l("静态代码块");
    }

    public static String sAFiled2 = "静态变量2";

    static {
        l(sAFiled2);
        l("2静态代码块");
    }


    private String mAFiled = "变量";

    {
        l(mAFiled);
        l("代码块");
    }

    public ClassA() {
        l("构造函数");
    }

    public static void main(String[] args) {
        new ClassA();
    }

    private static void l(String msg) {
        Utils.log("A_" + msg);
    }
}
