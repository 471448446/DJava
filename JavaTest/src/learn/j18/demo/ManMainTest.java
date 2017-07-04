package learn.j18.demo;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在一组人中操作：
 * 选择年龄大于30岁的人出来
 * 选择存款大于5000的人出来
 * ...
 * 来自：https://ke.qq.com/webcourse/index.html#course_id=182668&term_id=100215997&taid=950261514422668&vid=x1415m4oxxq
 * Created by better on 2017/6/14.
 */
public class ManMainTest {
    public static void main(String[] args) {
        List<Persion> persionList = Arrays.asList(
                new Persion("AA", 22, 7000.00),
                new Persion("张三", 40, 19000.00),
                new Persion("李四", 18, 900.00),
                new Persion("王五", 7, 17900.00)
        );
        Utils.log("常规--");
        List<Persion> list1 = getAgeAmount30(persionList);
        printList(list1);
        List<Persion> list2 = getMoneyAmount5000(persionList);
        printList(list2);
        Utils.log("优化--1策略模式");
        List<Persion> list3 = getPersionByFilter(persionList, new FilterPersionAgeAmoutImp());
        printList(list3);
        List<Persion> list4 = getPersionByFilter(persionList, new FilterPersionMoneyAmout());
        printList(list4);
        Utils.log("优化-2匿名内部类");
        List<Persion> list5 = getPersionByFilter(persionList, new IFilterPsersion() {
            @Override
            public boolean filter(Persion persion) {
                return persion.getAge() > 20;
            }
        });
        printList(list5);
        List<Persion> list6 = getPersionByFilter(persionList, new IFilterPsersion() {
            @Override
            public boolean filter(Persion persion) {
                return persion.getMoney() > 5000;
            }
        });
        printList(list6);
        Utils.log("优化-3Lamda");
        List<Persion> list7 = getPersionByFilter(persionList, (persion)/*只有一个参数，可以省略（）*/ -> persion.getAge() > 20);
        printList(list7);
        List<Persion> list8 = getPersionByFilter(persionList, persion -> persion.getMoney() > 5000);
        printList(list8);
        Utils.log("优化-4 Stream");
        persionList.stream()
                .filter(persion -> persion.getAge() > 20)
                .forEach(System.out::println);
        persionList.stream()
                .filter(persion -> persion.getMoney() > 5000)
                .forEach(System.out::println);


    }

    private static void printList(List<Persion> list1) {
        for (Persion persion : list1) {
            Utils.log(persion.toString());
        }
    }

    private static List<Persion> getAgeAmount30(List<Persion> list) {
        List<Persion> persions = new ArrayList<>();
        for (Persion persion : list) {
            if (persion.getAge() > 30) {
                persions.add(persion);
            }
        }
        return persions;
    }

    private static List<Persion> getMoneyAmount5000(List<Persion> list) {
        List<Persion> persions = new ArrayList<>();
        for (Persion persion : list) {
            if (persion.getMoney() > 5000) {
                persions.add(persion);
            }
        }
        return persions;
    }

    private static List<Persion> getPersionByFilter(List<Persion> list, IFilterPsersion filter) {
        List<Persion> persions = new ArrayList<>();
        for (Persion persion : list) {
            if (filter.filter(persion)) {
                persions.add(persion);
            }
        }
        return persions;
    }


}
