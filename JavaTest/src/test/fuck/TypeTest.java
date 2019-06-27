package test.fuck;

import java.util.ArrayList;
import java.util.List;

public class TypeTest {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        // 第一眼认为这两个是不相等的，毕竟是两种List的class
        // 但是，true。在运行的时候两个的class信息都是ArrayList.class
        System.out.println(l1.getClass() == l2.getClass());
        String a1 = "dd";
        Integer a2 = 2;
        // 编译不过，不同类型的class 不能应用 == ？？
        // 因为Class<?> 具体应用的时候类型已经被指定了
//        System.out.print(a1.getClass() == a2.getClass());
        List<?> c1 = new ArrayList<String>();
        // 编译不过。只能读取与泛型无关的方法，比如size()
//        c1.add("");
    }
}
