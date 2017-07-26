package algorithm.linear.list;

import common.Utils;

import java.util.*;

/**
 * Created by better on 2017/4/18.
 */
public class Main {
    public static void main(String[] args) {
//        sortList();
        linkList();
//        arrayList();
    }

    private static void arrayList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("b");
        list.add(list.size(), "C");
        list.remove(list.size() - 1);
        Utils.log(list.toString());

    }

    private static void linkList() {
        LinkList list = new LinkList();
        list.insert(0, "A");
        list.insert(1, "B");
        list.insert(1, "C");
        list.insert(2, "D");
        list.insert(list.size(), "AA");
        list.insert(list.size(), "BB");
        list.insert(list.size(), "CC");

        Utils.log(list.size() + "," + list.toString());
        list.delete(0);
        Utils.log("del:" + 0 + "," + list.toString());
        list.delete(list.size() - 1);
        Utils.log("del:" + list.size() + "," + list.toString());
        list.clear();
        Utils.log("clear:"+list.toString());

    }

    private static void sortList() {
        SortList list = new SortList();
        list.insert(0, "AA");
        list.insert(1, "BB");
        list.insert(3, "C");
        Utils.log(list.toString());
        list.delete(1);
        Utils.log(list.toString());
        list.clear();
        Utils.log(list.toString());
    }
}
