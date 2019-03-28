package test.sort;

import common.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BobSort {
    /*
    190327 上班路上
    对比赛分数进行排序
    1. 希望大分数在前面，比如2:1 和3:1,那么3:1在前
    2. 希望相同数字的在一起，比如2:1,1:2,3:1,5:1，那么1:2.2:1,3:1,5:1
     */
    private static List<String> scores = new ArrayList<>();

    static {
        scores.add("0:0");
        scores.add("0:1");
        scores.add("1:0");
        scores.add("1:1");
        scores.add("2:0");
        scores.add("2:1");
        scores.add("2:2");
        scores.add("2:2");
        scores.add("1:2");
        scores.add("0:2");
        scores.add("0:2");
        scores.add("3:0");
        scores.add("3:0");
        scores.add("3:1");
        scores.add("3:2");
        scores.add("3:3");
        scores.add("3:3");
        scores.add("2:3");
        scores.add("1:3");
        scores.add("1:3");
        scores.add("0:3");
    }

    public static void main(String[] args) {
        sort1();
        sort2();
        sort3();
        sort4();
    }

    /*
    2-1, 0-1, 2-0, 1-1, 2-2, 1-2, 1-0, 0-0, 0-2，结果应该为2-2, 2-1, 1-2, 2-0, 0-2, 1-1, 1-0, 0-1, 0-0
    从结果来看其实是有序的，先是按照比分的最大值来排序，这样整体就有序了，然后排相同最大值的比分顺序，
    按照剩下的最小值来排序
    比如0:2,1:2,1:1,这个0:2,1:2 应该放到2的比分里面,1:1放到1的比分里面。
    剩下的就是排每个比分类里面的排序，比如2:2,2:1,1:2,2:0,0:2,他们就按照最小值来排序2,1,0
    所以规则就是：同一级别的分数，按照小比分排序，其他情况根据大比分进行分类
     */
    private static void sort4() {
        Collections.shuffle(scores);
        Utils.log("input4 ", scores);
        scores.sort((s1, s2) -> {
            String[] ss1 = reSortByMinThenMax(s1.split(":"));
            String[] ss2 = reSortByMinThenMax(s2.split(":"));
            int max = ss1[1].compareTo(ss2[1]);
            if (max == 0) {
                return ss1[0].compareTo(ss2[0]);
            } else {
                return max;
            }
        });
        Utils.log("sort4 ", scores);
    }

    private static void sort3() {
        Collections.shuffle(scores);
        Utils.log("input3 ", scores);
        scores.sort((s1, s2) -> {
             /*
               a:b,b:a 是一样的顺序，排序是按照比分的最小值是来排序
               最小值一样大的时候，取剩下最大数字比较这样排出
                   3:2,2:3,2:4 => 2:4,3:2.2:3
               最小值不一样大的时候,通过最大值来排序
                   最大值相等，1:3,2:3,0:3 => 2:3,1:3,0:3
                   最大值不等，1:3,2:1=> 1:3,2:1
             */
            String[] ss1 = reSortByMinThenMax(s1.split(":"));
            String[] ss2 = reSortByMinThenMax(s2.split(":"));

            int min = ss1[0].compareTo(ss2[0]);
            int max = ss1[1].compareTo(ss2[1]);
            if (min == 0) {// 1:2,1:3,1:0
                return max;// 1:3,1:2,1:0
            } else {
                if (max == 0) {//1:3,2:3,3:3
                    return min;//3:3,2:3,1:3
                } else {       //0:0,1:3.2:2
                    return max;//1:3,2:2,0:0
                }
            }
        });
        Utils.log("sort3 ", scores);
    }

    private static String[] reSortByMinThenMax(String[] ss) {
        if (ss[0].compareTo(ss[1]) > 0) {
            String temp = ss[1];
            ss[1] = ss[0];
            ss[0] = temp;
        }
        return ss;
    }

    /*
    按照大小排排序升序，先左边，后右边
    */
    private static void sort2() {
        Collections.shuffle(scores);
        Utils.log("input2 ", scores);
        scores.sort((s1, s2) -> {
            if (s1.equals(s2)) {
                return 0;
            }
            return s1.compareTo(s2);
        });
        Utils.log("sort2 ", scores);
    }

    /*
    sort1按照大小排排序，废弃
    sort2简单粗暴的实现了
     */
    private static void sort1() {
        Collections.shuffle(scores);
        Utils.log("input1 ", scores);
        scores.sort((s1, s2) -> {
            String[] s1Score = s1.split(":");
            String[] s2Score = s2.split(":");
            int[] ss1 = new int[]{Integer.parseInt(s1Score[0]), Integer.parseInt(s1Score[1])};
            int[] ss2 = new int[]{Integer.parseInt(s2Score[0]), Integer.parseInt(s2Score[1])};
            if (ss1[0] > ss2[0]) {
                return -1;
            } else if (ss1[0] == ss2[0]) {
                if (ss1[1] > ss2[1]) {
                    return -1;
                } else if (ss1[1] == ss2[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });
        Utils.log("sort1 ", scores);
    }
}
