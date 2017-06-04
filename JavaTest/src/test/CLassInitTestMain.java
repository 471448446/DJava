package test;

import common.Utils;

/**
 * Created by better on 2017/4/24.
 */
public class CLassInitTestMain {
    public static void main(String[] args) {
        CLassInitTest initTest=CLassInitTest.getInstance();
        Utils.log("count1="+initTest.count1);
        Utils.log("count2="+initTest.count2);
    }
}
