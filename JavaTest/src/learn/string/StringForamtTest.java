package learn.string;

import common.Utils;

/**
 * %1是可以不写的
 * Created by better on 2018/4/26.
 */
public class StringForamtTest {
    public static void main(String[] args) {

        Utils.log(String.format("这是%s座位，%2s的本子，%2s的钢笔", "张三", "李四", "王五"));
        Utils.log(String.format("还剩%fGB", 1f));
        //控制小数长度
        Utils.log(String.format("还剩%1$.2fGB，总共%2$.2GB", 1f,3.94444f));
    }
}
