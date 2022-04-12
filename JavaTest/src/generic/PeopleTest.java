package generic;

import java.lang.reflect.Type;

/**
 * Created by better on 2022/4/5.
 */
public class PeopleTest extends People<String> {
    public static void main(String[] args) {
        People<String> test = new People<>();
        System.out.println(test.getClass());
        System.out.println(test.getClass().getSuperclass());
        System.out.println(test.getClass().getGenericSuperclass());
        Type[] genericInterfaces = test.getClass().getGenericInterfaces();
        for (int i = 0; i < genericInterfaces.length; i++) {
            System.out.println(genericInterfaces[i]);
        }
        System.out.println("-----------");
        System.out.println(new PeopleTest().getClass().getGenericSuperclass());

    }
}
