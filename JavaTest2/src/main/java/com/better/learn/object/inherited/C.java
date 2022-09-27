package com.better.learn.object.inherited;

/**
 * 菱形问题：
 * https://www.cnblogs.com/xybaby/p/6484262.html
 */
public class C implements A, B {
    /**
     * 接口A、B中虽然有同名的方法，这里实现后，都可以指向各自的接口（父类）。
     * 因为接口中都是未被实现的方法（这里排除默认方法），所以不会存在找不到改调用哪个类中的方法的问题。
     */
    @Override
    public void hello() {

    }
}
