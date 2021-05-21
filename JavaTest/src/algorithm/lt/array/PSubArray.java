package algorithm.lt.array;

import common.Utils;

/**
 * 滑动窗口
 * 题目链接： https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class PSubArray {
    public static void main(String[] args) {
        test0(new int[]{2, 3, 1, 2, 4, 3}, 7);
        test1(new int[]{2, 3, 1, 2, 4, 3}, 7);
    }

    private static void test1(int[] array, int target) {
        int size = sub1(array, target);
        System.out.println(String.format("1 array:%s,target:%d,length:%d", Utils.string(array), target, size));
    }

    private static int sub1(int[] array, int target) {
        int l = array.length;
        int sum = 0;
        int ps = 0;
        int min = l + 1;//假设不存在，方便找最小值
        int tmp;
        for (int pe = 0; pe < l; pe++) {
            sum += array[pe];
            while (sum >= target) {
                tmp = pe - ps + 1;
                if (tmp < min) {
                    min = tmp;
                }
                //移动左边的位置，找最小的
                sum -= array[ps++];//重点 将前置位置不断的向后移动，找最小
            }
        }
        return min == l + 1 ? 0 : min;
    }

    private static void test0(int[] array, int target) {
        int size = sub0(array, target);
        System.out.println(String.format("0 array:%s,target:%d,length:%d", Utils.string(array), target, size));
    }

    /**
     * 直接将所有的情况都找一遍，然后选最小的
     * 最小的只能是1，就是元素本身就 >= 满足条件
     */
    private static int sub0(int[] array, int target) {
        int min = 0;
        int sum;
        int sub;
        int l = array.length;
        for (int i = 0; i < l; i++) {
            if (array[i] >= target) {
                // 没说的，最小数组1
                return 1;
            }
            sum = 0;
            for (int j = i; j < l; j++) {
                sum += array[j];
                if (sum >= target) {
                    sub = j - i + 1;
                    if (min == 0) {
                        min = sub;
                    } else if (sub < min) {
                        min = sub;
                    }
                    break;
                }
            }
        }
        return min;
    }
}
