package algorithm.lt.array;

import common.Utils;

/**
 * 双指针
 * 题目地址：https://leetcode-cn.com/problems/remove-element/
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并**原地**修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * **你不需要考虑数组中超出新长度后面的元素。**
 */
public class PArrayRemove {
    public static void main(String[] args) {
        testRm0(new int[]{3, 2, 2, 3}, 2);
        testRm1(new int[]{3, 2, 2, 3}, 2);
//        testRm(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }

    private static void testRm0(int[] array, int rm) {
        System.out.println("input:" + Utils.string(array));
        int rp = rm0(array, rm);
        System.out.println(String.format("0 array:%s,number:%d,new size:%d", Utils.string(array), rm, rp));
    }

    private static void testRm1(int[] array, int rm) {
        System.out.println("input:" + Utils.string(array));
        int rp = rm1(array, rm);
        System.out.println(String.format("1 array:%s,number:%d,new size:%d", Utils.string(array), rm, rp));
    }

    /**
     * 双指针法（快慢指针法）： **通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。**
     * 你不需要考虑数组中超出新长度后面的元素，所以后面的元素是错的也行
     * 真牛皮
     */
    private static int rm1(int[] array, int rm) {
        int slowIndex = 0;
        for (int fastIndex = 0, l = array.length; fastIndex < l; fastIndex++) {
            if (array[fastIndex] != rm) {
                array[slowIndex++] = array[fastIndex];
            }
//            System.out.println(Utils.string(array));
        }
        return slowIndex;
    }

    /**
     * 默认
     */
    private static int rm0(int[] array, int rm) {
        int repeatCount = 0;
        int length = array.length;
        //强制冒泡到最后去，在计数
        for (int j = length; j > 0; j--) {
            // 最后一个不考虑,前一个已经移动了
            for (int i = 0; i < length - 1; i++) {
                if (array[i] == rm) {
                    array[i] = array[i + 1];
                    array[i + 1] = rm;
                }
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == rm) {
                repeatCount++;
            } else {
                break;
            }
        }
        return length - repeatCount;
    }
}
