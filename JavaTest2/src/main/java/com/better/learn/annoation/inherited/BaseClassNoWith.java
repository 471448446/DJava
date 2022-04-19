package com.better.learn.annoation.inherited;

@InheritedNoWith("没有使用@Inherited，在Class处")
public class BaseClassNoWith {
    @InheritedNoWith("没有使用@Inherited，在Filed处")
    public String field1;
    @InheritedNoWith("没有使用@Inherited，在Filed处")
    public String field2;

    @InheritedNoWith("没有使用@Inherited，在Method处")
    public void method1() {

    }

    @InheritedNoWith("没有使用@Inherited，在Method处")
    public void method2() {

    }
}
