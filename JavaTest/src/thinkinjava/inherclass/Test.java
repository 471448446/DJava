package thinkinjava.inherclass;

/**
 * 生成非静态的内部类的对象需要外部类的引用才能生产。
 * 静态的就不必。
 * 于内部接口不同
 * Created by better on 2017/3/9.
 */
public class Test {
    public static void main(String[] args) {
        InhertClass inhertClass = new InhertClass();
        InhertClass.ASun aSun = inhertClass.new ASun();
        InhertClass.BSun bSun = new InhertClass.BSun();
    }
}
