package algorithm.lt.link;

import common.Utils;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * <p>
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 * [1,2,2,1]和[2,2]交集是[2]
 * [4,9,5]和[9,4,9,8,4]交集是[9,4]
 * **说明：**
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class PUnionArray {
    public static void main(String[] args) {
        test0(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        test0(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }

    private static void test0(int[] a1, int[] a2) {
        int[] union = union0(a1, a2);
        System.out.println(String.format("0 %s,%s union %s", Utils.string(a1), Utils.string(a2), Utils.string(union)));
    }

    private static int[] union0(int[] a1, int[] a2) {
        // 嵌套轮询
        int max;
        if (a1.length >= a2.length) {
            max = a1.length;
        } else {
            max = a2.length;
        }
        int[] tmp = new int[max];
        int have = 0;
        boolean find;
        for (int i : a1) {
            find = false;
            for (int i1 : a2) {
                if (i == i1) {
                    find = true;
                    break;
                }
            }
            if (find) {
                tmp[have++] = i;
            }
        }
        int[] result = new int[have];
        for (int i = 0; i < tmp.length; i++) {
            if (i < have) {
                result[i] = tmp[i];
            }
        }
        return result;
    }
}
