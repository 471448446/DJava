package com.better.learn.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * 通配符泛型，获得上下限信息
 */
public class SeeWildcardType {
    // 上限
    private List<? extends Number> a;
    // 下限
    private List<? super String> b;

    public static void test() throws NoSuchFieldException {
        print(SeeWildcardType.class.getDeclaredField("a").getGenericType());
        print(SeeWildcardType.class.getDeclaredField("b").getGenericType());
    }

    private static void print(Type type) {
        //范型类型
        ParameterizedType parameterizedType = (ParameterizedType) type;
        //从范型里拿到通配符类型
        WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[0];
        System.out.println("getTypeName: " + wildcardType.getTypeName());
        if (wildcardType.getUpperBounds().length > 0) {
            System.out.println("getUpperBounds: " + wildcardType.getUpperBounds()[0]);
        } else {
            System.out.println("getUpperBounds: " + null);
        }
        if (wildcardType.getLowerBounds().length > 0) {
            System.out.println("getLowerBounds: " + wildcardType.getLowerBounds()[0]);
        } else {
            System.out.println("getLowerBounds: " + null);
        }
    }
}
