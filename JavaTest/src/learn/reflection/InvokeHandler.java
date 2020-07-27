package learn.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一个列子：
 * 假定有一个Library库，库提供了一个厨师类的操作，提供了厨师能支持的工作
 * 1. 厨师可以做菜
 * 2. 厨师可以吃饭
 * 在不修改源码的情况下，打印做菜的前后日志
 * <p>
 * Using Java Reflection to create dynamic implementations of interfaces at runtime
 * https://www.cnblogs.com/techyc/p/3455950.html
 */
public class InvokeHandler {
    /**
     * 面向接口编程。抽象处动作
     */
    interface IWork {
        String work();

        boolean eat(String food);
    }

    static class Cook implements IWork {

        @Override
        public String work() {
            return "cook food";
        }

        @Override
        public boolean eat(String food) {
            // 假设厨师任何事物都可以吃完
            System.out.println("i am eat done with " + food);
            return true;
        }
    }

    public static void main(String[] args) {
        /*
         * 准备一个被代理的对象
         */
        IWork cook = new Cook();

        /*
         * 1. 准备接口的方法实现者
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 只是观察厨师工作
                if ("work".equals(method.getName())) {
                    System.out.println("method:" + method.getName() + " before cook");
                    String result = (String) method.invoke(cook, args);
                    System.out.println("method:" + method.getName() + " after cook");
                    /*
                     * return 返回的是方法的返回值
                     */
                    return result;
                }
                // 不处理方法
                return method.invoke(cook, args);
            }
        };
        /*
         * 2. 生成 接口的动态实现者
         * 参数1. 使用哪个classloader来加载代理对象
         * 参数2. 要代理的接口
         * 参数3. 关联到调用者上，当接口的方法被调用时，可以根据方法做一些逻辑
         */
        IWork proxyInstance = (IWork) Proxy.newProxyInstance(
                invocationHandler.getClass().getClassLoader(),
                cook.getClass().getInterfaces(),
                invocationHandler);
        /*
         * 3. 调用接口
         */
        System.out.println("prepare work() ------------");
        String work = proxyInstance.work();
        System.out.println("result:" + work);
        System.out.println("prepare eat() ------------");
        boolean eat = proxyInstance.eat("sugar");
        System.out.println("eat ok? " + eat);
    }
}
