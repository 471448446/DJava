package learn.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 动态访问方法，方法不能被混淆，混淆了就无法找到方法名了
 * 反射也是动态调用方法，访问字段，反射提供的信息要多很多，访问权限、名称等
 * 方法句柄只是用于动态调用方法
 * https://www.baeldung.com/java-method-handles
 */
public class MethodHandleDemo {
    private String mapName(String s) {
        return "hello " + s;
    }

    private String getName() {
        return "default name is Job";
    }

    public static void main(String[] args) {

        MethodHandleDemo hello = new MethodHandleDemo();

        invokePrivate(hello);
        invokePrivate2(hello);
        invokeNoParameter(hello);

    }

    private static void invokePrivate2(MethodHandleDemo hello) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(String.class, String.class);
        try {
            MethodHandle methodHandle = lookup.findVirtual(MethodHandleDemo.class, "mapName", methodType);

            MethodHandle methodHandleBind = methodHandle.bindTo(hello);
            String name = (String) methodHandleBind.invokeWithArguments("world");
            System.out.println(name);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void invokeNoParameter(MethodHandleDemo hello) {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(String.class);
        try {
            String name = (String) lookup.findVirtual(MethodHandleDemo.class, "getName", mt)
                    .invokeExact(hello);
            System.out.println(name);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void invokePrivate(MethodHandleDemo hello) {
        /*
         * 1.访问： private and protected methods
         */
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        /*
         * 2.定义：方法的返回类型、参数类型
         */
        MethodType methodType = MethodType.methodType(String.class, String.class);
        /*
         * 3.创建方法句柄
         */
        MethodHandle methodHandle = null;
        try {
            methodHandle = lookup.findVirtual(MethodHandleDemo.class, "mapName", methodType);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (null == methodHandle) {
            return;
        }
        /*
         * 4.调用
         */
        try {
            String result = (String) methodHandle.invokeExact(hello, "world");
            System.out.println(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
