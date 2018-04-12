package learn.load;

import common.Utils;

/**
 * 在编译的时候能确定下来的静态变量(编译常量),不会对类进行初始化
 * Created by better on 2018/4/11.
 */
public class InitTest1Main {
    public static void main(String[] args) {

        Utils.log("" + InitTest1.X);
//        InitTest1.X = 2;
    }
}
