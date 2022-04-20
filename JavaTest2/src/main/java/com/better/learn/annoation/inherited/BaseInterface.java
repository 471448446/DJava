package com.better.learn.annoation.inherited;

/**
 * 定义了两个方法，都使用了注解一个被子类重新，一个不被子类重新
 */
@InheritedWith("使用了@Inherited，在Class处")
@InheritedNoWith("没有使用@Inherited，在Class处")
public interface BaseInterface {

    @InheritedWith("使用了@Inherited，在Method处")
    @InheritedNoWith("没有使用@Inherited，在Method处")
    void method1();

    @InheritedWith("使用了@Inherited，在Method处")
    @InheritedNoWith("没有使用@Inherited，在Method处")
    void method2();
}
