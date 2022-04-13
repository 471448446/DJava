package com.better.learn.reflection;

import java.io.Serializable;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * 假设有个类，申明了两个泛型的参数。
 * 通过反射获取这些泛型信息
 * TypeVariable 泛型类型变量。可以泛型上下限等信息
 *
 * @param <K>
 * @param <T>
 */
public class SeeTypeVariable<K extends Comparable & Serializable, T> {
    K key;
    T value;
    String string;

    public static void test() throws Exception {
        // 反射获取字段
        Field key = SeeTypeVariable.class.getDeclaredField("key");
        Field value = SeeTypeVariable.class.getDeclaredField("value");
        Field string = SeeTypeVariable.class.getDeclaredField("string");

        print((TypeVariable) key.getGenericType());
        print((TypeVariable) value.getGenericType());
        // 因为这个字段不是用泛型申明的，所以getGenericType()获取出来的类型是Class类型，强转不了
        if (string.getGenericType() instanceof TypeVariable) {
            print((TypeVariable) string.getGenericType());
        }
    }

    /**
     * getGenericType()可以在运行时，获取到泛型信息：
     * 1. 名称
     * 2. 上限，既泛型被限定的类型，默认是Object
     * 3. 被哪个对象申明的
     * https://www.matools.com/file/manual/jdk_api_1.8_google/java/lang/reflect/TypeVariable.html
     */
    private static void print(TypeVariable typeVariable) {
        System.out.println("TypeVariableSee print()");
        // 泛型的名称：返回此类型变量的名称，因为它在源代码中出现。
        System.out.println(typeVariable.getName());
        // 申明泛型时定义的包裹对象，比如这里是TypeVariableSee在定义时，申明的泛型变量K和V，那么者两个泛型对象获取的值就是TypeVariableSee的Class对象
        // ：返回表示声明为此类型变量的通用声明的 GenericDeclaration对象。
        System.out.println(typeVariable.getGenericDeclaration());
        // 泛型的上限，默认是Object。：返回表示此类型变量的上限的 Type对象的数组。
        // 这里K在申明时指定上限的 继承于Comparable和Serializable
        // V是没有指定上限，默认是Object
        for (Type bound : typeVariable.getBounds()) {
            System.out.println("bound: " + bound);
        }
        // 这个也是获取上限，只不过用的AnnotatedType
        for (AnnotatedType annotatedBound : typeVariable.getAnnotatedBounds()) {
            System.out.println("annotatedBound: " + annotatedBound);
        }
    }

    public static void printTypeVariable(TypeVariable typeVariable) {
        System.out.println("printTypeVariable()----");
        // 泛型变量申明的类，既在那个类中申明了这个泛型变量
        System.out.println("Generic Declaration: " + typeVariable.getGenericDeclaration());
        // 泛型变量的名称
        System.out.println("Generic name: " + typeVariable.getName());
        // 泛型变量的上限，默认是Object
        System.out.println("Generic up info: ");
        for (Type bound : typeVariable.getBounds()) {
            System.out.println(bound.getTypeName());
        }
        // 这个也是获取上限，只不过用的AnnotatedType
        System.out.println("generic AnnotatedBounds: ");
        for (AnnotatedType annotatedBound : typeVariable.getAnnotatedBounds()) {
            System.out.println(annotatedBound.getType());
        }
    }
}
