package test;

import common.Utils;

/**
 * 不可变在Kotlin（和其它很多现代语言）中是一个很重要的概念。
 * 一个不可变对象意味着它在实例化之后就不能再去改变它的状态了。
 * 如果你需要一个这个对象修改之后的版本，那就会再创建一个新的对象。
 * 这个让编程更加具有健壮性和预估性。在Java中，大部分的对象是可变的，
 * 那就意味着任何可以访问它这个对象的代码都可以去修改它，从而影响整个程序的其它地方。
 *
 * ---没有啊，我final了你还怎么变wtf。
 * Created by better on 2017/5/29.
 */
public class VarTest {
    public static void main(String[] args) {
        int a = 10;
        final int b = a;
        a--;
        Utils.log("结果a=" + a + "," + b);
    }
}
