package lg;

/**
 * Created by better on 2020/6/2.
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println("Test classLoader is " + classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println("Test parent classLoader is " + parent);
        ClassLoader grandParent = parent.getParent();
        System.out.println("Test Grandparent classLoader is " + grandParent);
    }
}
