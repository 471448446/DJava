//package com.better.learn.reflection.invokehandler;
//
//import java.lang.reflect.ProxyGenerator;
//
//import java.io.FileOutputStream;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.Locale;
//
//public class TestInvokeHandler {
//    public static void main(String[] args) throws Exception {
//        generateClassFile(Meal.class, "Proxy$0");
//        hello();
//        System.out.println("------------------------");
//        Meal meal1 = new Tiramisu();
//        proxyObject(meal1);
//    }
//
//    private static void proxyObject(Meal meal) {
//        // 对真实的对象做一层代理。
//        // 这里对访问代理对象的方法做了统一的处理，打印日志
//        Object o1 = Proxy.newProxyInstance(meal.getClass().getClassLoader(),
//                meal.getClass().getInterfaces(), new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        // 这里也不能使用proxy来访问它的方法：proxy.toString(); 或 method.invoke(proxy, args);
//                        // 上面两种都是错误的，，proxy对象的方法被调用，就是通过用invoke()方法向外暴露，来获取调用结果，所以这里在调用proxy就嵌套了，死循环。
//                        System.out.println("before invoke..." + method.getName());
//                        Object invoke = method.invoke(meal, args); // 这里用的是真实的对象，被代理的对象
//                        System.out.println("after invoke..." + method.getName());
//                        return invoke;
//                    }
//                });
//        Meal proxy = (Meal) o1;
//        System.out.println(String.format(Locale.CHINA, "dynamic proxy object:%s %f", proxy.name(), proxy.price()) +
//                " toString():" + proxy.toString() +
//                " hashCode():" + proxy.hashCode());
//    }
//
//    private static void hello() {
//        // 凭空创造一个实现类，并不代理任何对象，这种是没有任何意义的
//        Object o = Proxy.newProxyInstance(
//                Meal.class.getClassLoader(),
//                new Class[]{Meal.class},
//                new InvocationHandler() {
//
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        switch (method.getName()) {
//                            case "name":
//                                return "Tiramisu";
//                            case "price":
//                                return 0.55f;
//                            // 下面这些方法不是必须的，用到了才使用
//                            case "toString":
//                                return "DynamicMealTiramisu";
//                            case "hashCode":
//                                return 0;
//                            case "equals":
//                                return false;
//                        }
////                        return method.invoke(args);
//                        return null;
//                    }
//                });
//        Meal meal = (Meal) o;
//        System.out.println(
//                String.format(Locale.CHINA, "dynamic meal:%s %f", meal.name(), meal.price()) +
//                        " toString():" + meal.toString()
//                        + " hashCode():" + meal.hashCode()
//        );
//    }
//
//    public static void generateClassFile(Class clazz, String proxyName) throws Exception {
//        // 根据类信息和提供的代理类名称，生成字节码
//        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, new Class[]{clazz});
//        String paths = clazz.getResource(".").getPath();
//        System.out.println(paths);
//        //保留到硬盘中
//        FileOutputStream out = new FileOutputStream(paths + proxyName + ".class");
//        out.write(classFile);
//        out.flush();
//    }
//
//}
