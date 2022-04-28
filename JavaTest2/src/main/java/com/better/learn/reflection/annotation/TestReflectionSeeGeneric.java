package com.better.learn.reflection.annotation;

/**
 * 通过反射获取泛型的信息
 */
public class TestReflectionSeeGeneric {
    public static void main(String[] args) throws Exception {
        SeeGenericDeclaration.test();
        System.out.println("TypeVariableSee--------------------------");
        SeeTypeVariable.test();
        System.out.println("ParameterizedTypeSee--------------------------");
        SeeParameterizedType.test();
        System.out.println("SeeGenericArrayType--------------------------");
        SeeGenericArrayType.test();
        System.out.println("SeeWildcardType--------------------------");
        SeeWildcardType.test();
    }
}
