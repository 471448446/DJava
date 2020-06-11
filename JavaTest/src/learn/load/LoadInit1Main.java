package learn.load;

import common.Utils;

/**
 * 先加载（赋默认值），在初始化
 * 访问类静态方法、静态变量会导致类被加载，静态变量、静态方法加载顺序是代码现后顺序
 * 访问类常量不会导致类被加载，被final修饰静态字段在操作使用时，不会使类进行初始化，因为在编译期已经将此常量放在常量池
 * Created by better on 2018/4/11.
 */
public class LoadInit1Main {
    public static void main(String[] args) {
        /**
         * 演示静态变量加载顺序，
         * 如果静态变量没有赋值，在加载的时候会赋默认值
         */
        LoadInit1.getInstance();
        Utils.log("LoadInit1Main A=" + LoadInit1.A);
        Utils.log("LoadInit1Main B=" + LoadInit1.B);
        Utils.log("---------------------line other------------------------------");
        /**
         * 加载常量，不会导致类被加载
         * 被final修饰静态字段在操作使用时，不会使类进行初始化，因为在编译期已经将此常量放在常量池
         */
        Utils.log("load final statistics " + LoadStatistics.NAME);
        // 此时创建对象，类被加载
        Utils.log("--- then create object");
        new LoadStatistics();
        Utils.log("---------------------line other------------------------------");
        /**
         * 加载静态变量导致类被加载,
         */
        Utils.log("load statistics var " + LoadStatisticsValiable.NAME);
        Utils.log("---------------------line other------------------------------");
        /**
         * 加载静态方法会导致类被加载
         */
        Utils.log("load statistics method" + LoadStatisticsMethod.justLoad());
    }
}
