package learn.oclass.initorder;

import common.Utils;

/**
 * 1、父类的静态变量和静态代码块，然后是子类的静态变量和静态代码块
 * 2、父类的成员、代码块、构造函数
 * 3、子类的成员、代码块、构造函数
 * <p>
 * 总的是先父类在子类，静态的要优先于成员和代码块以及构造函数
 * Created by better on 2018/3/4.
 */
public class ClassB extends ClassA {
    public static String sBFiled = "静态变量";

    static {
        l(sBFiled);
        l("静态代码块");
    }

    private String mBFiled = "变量";

    {
        l(mBFiled);
        l("代码块");
    }

    public ClassB() {
        l("构造函数");
    }

    {
        l("B 构造函数后面的代码块：" + mBFiled);
    }

    private static void l(String msg) {
        Utils.log("B_" + msg);
    }

    public static void main(String[] args) {
        new ClassB();
    }

}
