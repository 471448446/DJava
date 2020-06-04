package lg.test;

import java.lang.reflect.Method;

/**
 * Created by better on 2020/6/2.
 */
public class TestLoader {
    public static void main(String[] args) {
        //动态加载的 class 的路径。
        DiskClassLoader diskClassLoader = new DiskClassLoader("file:///Users/better/Documents/WorkSpace/git/DJava/JavaTest/src/lg/test/");
        try {
            Class<?> loadClass = diskClassLoader.loadClass("Secret");
            if (null != loadClass) {
                Object newInstance = loadClass.newInstance();
                Method declaredMethod = loadClass.getDeclaredMethod("main");
                declaredMethod.invoke(newInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
