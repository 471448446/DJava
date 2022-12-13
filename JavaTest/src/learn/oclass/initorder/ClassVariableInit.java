package learn.oclass.initorder;

import common.Utils;

/**
 * 父类中定义的静态语句块要优于子类的变量赋值操作
 * Created by better on 2018/3/5.
 */
public class ClassVariableInit {
    static class A {
        static int sId = 1;

        static {
            sId = 2;
        }
    }

    static class B extends A {
        static int sIdB = sId;
    }

    public static void main(String[] args) {
        Utils.log("" + B.sIdB);
    }

}
