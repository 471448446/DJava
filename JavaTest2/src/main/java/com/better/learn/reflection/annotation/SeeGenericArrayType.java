package com.better.learn.reflection.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.List;

/**
 * 当需要描述的类型是泛型类的数组时，比如List[],Map[]，此接口会作为Type的实现
 * @param <T>
 */
public class SeeGenericArrayType<T> {
    List<String>[] lists;

    public static void test() throws NoSuchFieldException {
        Field lists = SeeGenericArrayType.class.getDeclaredField("lists");
        GenericArrayType genericArrayType = (GenericArrayType) lists.getGenericType();
        System.out.println(genericArrayType.getGenericComponentType());
    }
}
