package learn.collections;

import common.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Test {
    public static void main(String[] args) {
        useComparable();
        useComparator();
        binarySearch();
        reverse();
        shuffle();
        minMax();
        rotate();
        replaceAll();
        indexSubList();
        unmodifiableCollection();
        checkList();
    }

    private static void checkList() {
        Utils.log("checkList___not use");
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "one", "two", "three");
        List temp = names;
        List<Integer> nums = temp;
        // 应该出现异常的位置, 因为插入了非 String 类型的数据，但这一行并没有抛出异常，而是在下一行抛出了
        nums.add(1);
        Utils.log("" + nums);
        //stream:jdk1.8 新特性，可百度一下 StreamAPI, 下面这行代码意思是将集合中的所有元素连接在一起，以 + 号分隔开
        // 这一行抛出了类型转换异常
        try {
            Utils.log("" + names.stream().collect(joining("+")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.log("checkList___ use");

        List<String> names1 = new ArrayList<>();
        names1 = Collections.checkedList(names1, String.class);
        Collections.addAll(names1, "one", "two", "three");
        List temp1 = names1;
        List<Integer> nums1 = temp1;
        try {
            nums1.add(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void unmodifiableCollection() {
        List<BeanA> aList = getBeansA();
        List<BeanA> unModify = Collections.unmodifiableList(aList);
        try {
            unModify.add(new BeanA(10));
        } catch (Exception e) {
            Utils.log("unmodifiableCollection:" + e);
        }
    }

    private static void indexSubList() {
        List<BeanA> aList = getBeansA();
        List<BeanA> list = new ArrayList<>();
        list.add(new BeanA(5));
        list.add(new BeanA(2));
        Utils.log(aList + " \n" + list + " \nindexSubList =" + Collections.indexOfSubList(aList, list));
        Utils.log(aList + " \n" + list + " \nlastIndexOfSubList =" + Collections.lastIndexOfSubList(aList, list));
    }

    private static void replaceAll() {
        List<BeanA> aList = getBeansA();
        Utils.log("replaceAll before:" + aList);
        boolean success = Collections.replaceAll(aList, new BeanA(0), new BeanA(-1));
        Utils.log("replaceAll after:" + success + aList);
    }

    private static void rotate() {
        List<BeanA> aList = getBeansA();
        Utils.log("rotate before:" + aList);
        Collections.rotate(aList, 2);
        Utils.log("rotate after:" + aList);
    }

    private static void minMax() {
        List<BeanA> aList = getBeansA();
        Utils.log(aList + "\n min:" + Collections.min(aList) + "\n max:" + Collections.max(aList));
        List<BeanB> bList = getBeansB();
        Comparator<BeanB> comparator = Comparator.comparingInt(o -> o.count);
        Utils.log(bList + "\n min:" + Collections.min(bList, comparator) + "\n max:" + Collections.max(bList, comparator));
    }

    private static void shuffle() {
        List<BeanA> aList = getBeansA();
        Utils.log("shuffle before:" + aList);
        Collections.shuffle(aList);
        Utils.log("shuffle after:" + aList);
    }

    private static void reverse() {
        List<BeanA> aList = getBeansA();
        Utils.log("input:" + aList);
        Collections.reverse(aList);
        Utils.log("reverse:" + aList);
    }

    private static void binarySearch() {
        List<BeanA> aList = getBeansA();
        Collections.sort(aList);
        BeanA aOne = new BeanA(5);
        BeanA aTwo = new BeanA(0);
        BeanA aThree = new BeanA(6);
        Utils.log(aOne + " binarySearch comparable index :" + Collections.binarySearch(aList, aOne));
        Utils.log(aTwo + " binarySearch comparable index :" + Collections.binarySearch(aList, aTwo));
        Utils.log(aThree + " binarySearch comparable index :" + Collections.binarySearch(aList, aThree));

        List<BeanB> bList = getBeansB();
        Comparator<BeanB> comparator = Comparator.comparingInt(o -> o.count);
        bList.sort(comparator);
        BeanB bOne = new BeanB(5);
        BeanB bTwo = new BeanB(0);
        BeanB bThree = new BeanB(6);
        Utils.log(bOne + " binarySearch comparator index :" + Collections.binarySearch(bList, bOne, comparator));
        Utils.log(bTwo + " binarySearch comparator index :" + Collections.binarySearch(bList, bTwo, comparator));
        Utils.log(bThree + " binarySearch comparator index :" + Collections.binarySearch(bList, bThree, comparator));
    }

    private static void useComparator() {
        List<BeanB> list = getBeansB();
        Collections.sort(list, Comparator.comparingInt(o -> o.count));
        Utils.log("useComparator:" + list);
    }

    private static void useComparable() {
        List<BeanA> list = getBeansA();
        Collections.sort(list);
        Collections.sort(list,Collections.reverseOrder());
        Utils.log("useComparable:" + list);
    }

    private static List<BeanB> getBeansB() {
        List<BeanB> list = new ArrayList<>();
        list.add(new BeanB(3));
        list.add(new BeanB(5));
        list.add(new BeanB(2));
        list.add(new BeanB(4));
        list.add(new BeanB(4));
        list.add(new BeanB(1));
        list.add(new BeanB(0));
        list.add(new BeanB(0));
        return list;
    }

    private static List<BeanA> getBeansA() {
        List<BeanA> list = new ArrayList<>();
        list.add(new BeanA(3));
        list.add(new BeanA(5));
        list.add(new BeanA(2));
        list.add(new BeanA(4));
        list.add(new BeanA(4));
        list.add(new BeanA(1));
        list.add(new BeanA(0));
        list.add(new BeanA(0));
        return list;
    }

}
