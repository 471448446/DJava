package com.better.learn.reflection.annotation;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 可以通过 {@link Class#getGenericSuperclass()}获取到父类的泛型信息。
 * 这里有个取巧的方式，使用匿名内部类的方式来获取当前类的泛型信息
 */
public class GetGenericSuperclass {
    static abstract class AbstractDemo01<T> {

    }

    static class Demo02<T> {

    }

    static class Demo01Impl extends AbstractDemo01<String> {

    }

    public static void main(String[] args) {
        // 获取父类申明的泛型变量
        Type genericSuperclass = Demo01Impl.class.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            SeeParameterizedType.printParameterizedType((ParameterizedType) genericSuperclass);
        }
        // 这里使用匿名内部类来获取当前类的泛型类型getGenericSuperclass()
        Type genericSuperclass2 = new Demo02<List<String>>() {
        }.getClass().getGenericSuperclass();
        if (genericSuperclass2 instanceof ParameterizedType) {
            SeeParameterizedType.printParameterizedType((ParameterizedType) genericSuperclass2);
        }
    }
}
