package pro;

/**
 * Created by better on 2020/11/25.
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        // P:true all Integer and value equal
        // R: true
        System.out.println(c == d);
        // P:true all Integer and value equal
        // R: false
        System.out.println(e == f);
        // P:true all Integer and c=3,(a+b)=3
        // R: true
        System.out.println(c == (a + b));
        // P:true all Integer and c=3,(a+b)=3,Integer.equals will auto unbox to int compare
        // R:true
        System.out.println(c.equals(a + b));
        // P:false all Integer and g=3L,(a+b)=3,value jingdu not the same
        // R:true
        System.out.println(g == (a + b));
        // P:true all Integer and g=3L,(a+b)=3, will cast right Integer 3 to 3L
        // R: false
        System.out.println(g.equals(a + b));
    }
}
