package algorithm.sort.bubble;

import algorithm.sort.SortUtil;
import common.Utils;

/**
 * 两两比较相邻记录的关键字，如果反序则交换，知道没有反序为止
 * Created by better on 2017/7/15.
 */
public class BubbleSort {
    static int[] arr0 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
    static int[] arr0Copy = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
    static int[] arr1 = new int[]{2, 1, 5, 7, 10};
    static int[] arr1Copy = new int[]{2, 1, 5, 7, 10};

    public static void main(String[] args) {
        Utils.log("0--->");
        bubbleSort0(arr0);
        Utils.log("0 r--->");
        log(arr0);
        Utils.log("--->");
        bubbleSort(arr0Copy);
        Utils.log("r--->");
        log(arr0Copy);
        Utils.log("已经有序？");
        bubbleSort(arr1);
        Utils.log("已经有序 改进？");
        bubbleSortPlus(arr1Copy);

    }

    /**
     * 交换排序
     */
    public static void bubbleSort0(int[] array) {
        if (null == array) return;
        for (int j = 0, k = array.length; j < k; j++) {
            //内层循环走一次，就把最小的值放在了首端。所以最多循环array.length次把数据排列好
            for (int i = 0, l = array.length - 1; i < l; i++) {
                if (array[i] > array[i + 1]) {
                    SortUtil.swap(array, i, i + 1);
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 1, l = array.length; i < l; i++) {
            log(array);
            for (int j = array.length - 1; j >= i; j--) {
                if (array[j - 1] > array[j]) {
                    SortUtil.swap(array, j - 1, j);
                }
            }
        }
    }

    public static void bubbleSortPlus(int[] array) {
        /*在走了i的循环后，如果数组以及有序了，就不需要在比较循环了*/
        boolean itemPositionChanged = true;
        for (int i = 1, l = array.length; i < l && itemPositionChanged; i++) {
            itemPositionChanged = false;
            log(array);
            for (int j = array.length - 1; j >= i; j--) {
                if (array[j - 1] > array[j]) {
                    SortUtil.swap(array, j - 1, j);
                    itemPositionChanged = true;
                }
            }
        }
    }

    /**
     * https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F
     * @param arr
     */
    public static void bubbleSortB(int[] arr) {
        int i, j, temp, len = arr.length;
        for (i = 0; i < len - 1; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void log(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        Utils.log(builder.toString());
    }

}
