package com.better.learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 具体的泛型类型，可以获得元数据中泛型签名类型(泛型真实类型)
 */
public class SeeParameterizedType {
    Map<String, String> map;

    public static void test() throws Exception {
        Field f = SeeParameterizedType.class.getDeclaredField("map");
        System.out.println(f.getGenericType()); // java.util.Map<java.lang.String,java.lang.String>
        ParameterizedType pType = (ParameterizedType) f.getGenericType();
        System.out.println("getRawType(): " + pType.getRawType()); // interface java.util.Map
        // 获取申明的泛型信息，这里Map申明了两个泛型，实际传递的是两个String
        for (Type type : pType.getActualTypeArguments()) {
            System.out.println("getActualTypeArguments(): " + type); // 打印两遍: class java.lang.String
        }
    }
}
