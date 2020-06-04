package lg;

/**
 * Created by better on 2020/6/2.
 */
public class ClassLoaderInfo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
