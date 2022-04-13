package com.better.learn.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
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

    public static void printParameterizedType(ParameterizedType parameterizedType) {
        System.out.println("---printParameterizedType()");
        System.out.println("getOwnerType(): " + parameterizedType.getOwnerType());
        System.out.println("getRawType(): " + parameterizedType.getRawType());
        System.out.println("getActualTypeArguments(): ");
        for (Type argument : parameterizedType.getActualTypeArguments()) {
            // 这里其实是获取不到 TypeVariable 的，TypeVariable是泛型变量
            // 比如List<T> 在定义的时候，申明了一个泛型，可以通过List的Class文件信息来读取TypeVariable，
            // 比如List.class.getTypeParameters() 来查看申明的泛型变量信息
            /*if (argument instanceof TypeVariable) {
                SeeTypeVariable.printTypeVariable((TypeVariable) argument);
            } else */
            if (argument instanceof ParameterizedType) {
                // 如果是参数化类型 比如 List<String>
                printParameterizedType((ParameterizedType) argument);
                //argument.getClass()获取出来的类型是 sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
                // 并不是List的类型，所以信息被丢掉了
                // 既只能通过Class类文件来获取 TypeVariable 泛型信息，不能通过 ParameterizedType来获取泛型类的泛型信息
                TypeVariable<? extends Class<? extends Type>>[] typeParameters = argument.getClass().getTypeParameters();
                for (TypeVariable<? extends Class<? extends Type>> typeParameter : typeParameters) {
                    SeeTypeVariable.printTypeVariable(typeParameter);
                }
            } else {
                System.out.println(argument.getTypeName());
            }
        }
    }
}
