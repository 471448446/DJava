package algorithm.lt.array;

import common.Utils;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class P35 {
    public static void main(String[] args) {
        test(new int[]{1, 3, 5, 6}, 5);
        test(new int[]{1, 3, 5, 6}, 2);
        test(new int[]{1, 3, 5, 6}, 7);
        test(new int[]{1, 3, 5, 6}, 0);
    }

    private static void test(int[] data, int search) {
        int result = b1(data, search);
        System.out.println(Utils.string(data) + String.format("search1:%d,index:%d", search, result));
        result = b2(data, search);
        System.out.println(Utils.string(data) + String.format("search2:%d,index:%d", search, result));
        System.out.println("---------------------");
    }

    private static int b2(int[] data, int search) {
        int left = 0;
        int right = data.length;
        int middle;
        while (left < right) {
            middle = (left + right) / 2;
            if (search == data[middle]) {
                return middle;
            } else if (search < data[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    private static int b1(int[] data, int search) {
        int l = 0;
        int r = data.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (search == data[m]) {
                return m;
            } else if (search < data[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r + 1;
    }
}
