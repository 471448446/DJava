package com.better.learn.annoation.inherited;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试：带有和不带有{@link Inherited}时，子类和子接口的区别
 */
public class TestInherited {
    public static void main(String[] args) throws Exception {
        printAnnotationClass(SubClass.class);
        printAnnotationClass(SubInterface.class);
    }

    /**
     * 当使用了 {@link Inherited}来标记一个注解A时
     * 1. 当这个注解A注解类时，可以被继承，子类获取它的注解是父类的注解信息。
     * 2. 当这个注解A标记方法或字段是不能被继承的，子类重新的方法或字段获取注解，默认是没有的。
     * 3. 当这个注解A标记接口时，也是不能被继承的
     * 只有当带有{@link Inherited}注解的注解，标记在类上才能被继承
     *
     * @param cl
     * @throws Exception
     */
    private static void printAnnotationClass(Class cl) throws Exception {
        System.out.println("-------start------");
        System.out.println("print cls-------: " + cl.getName());
        for (Annotation annotation : cl.getAnnotations()) {
            System.out.println("class annotation:" + annotation);
        }
        for (Method method : cl.getMethods()) {
            // 这里只打印method方法
            if (method.getName().startsWith("method")) {
                System.out.println("print method-------: " + method.getName());
                for (Annotation annotation : method.getAnnotations()) {
                    System.out.println(method.getName() + " annotation:" + annotation);
                }
            }
        }
        for (Field field : cl.getFields()) {
            if (field.getName().startsWith("field")) {
                System.out.println("print field-------: " + field.getName());
                for (Annotation annotation : field.getAnnotations()) {
                    System.out.println(field.getName() + " annotation:" + annotation);
                }
            }
        }
        System.out.println("-------end------");
    }
}
