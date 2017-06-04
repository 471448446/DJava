package test;

import common.Utils;

/**
 * https://mp.weixin.qq.com/s?chksm=96cda0b2a1ba29a4cc9912cb1bf8a955f97ee45a7b8db48e384f1694ddbabbd4d5e7fa90f880&sn=c20d3172052bd7db9a1ad6a95f112bc9&scene=23&idx=1&mpshare=1&utm_source=gank.io&__biz=MzIwMzYwMTk1NA%3D%3D&mid=2247483903&srcid=0327b2qp5X0Mmlhqfwu6TNug&utm_medium=email#rd
 * Created by better on 2017/4/24.
 */
public class CLassInitTest {
        private static CLassInitTest instance = new CLassInitTest();
    public static int count1;
    public static int count2 = 0;
    /*==================*/
//    public static int count1;
//    public static int count2 = 0;
//    private static CLassInitTest instance = new CLassInitTest();


    private CLassInitTest() {
        count1++;
        count2++;
        Utils.log("构造方法:" + count1 + ";" + count2);
    }

    public static CLassInitTest getInstance() {
        return instance;
    }
}
