package algorithm.sort.select;

import algorithm.sort.SortUtil;
import common.Utils;

/**
 * Created by better on 2017/7/16.
 */
public class SimpleSelectSort {
    static int[] arr0 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};

    public static void main(String[] args) {
        Utils.log("原始数据---");
        SortUtil.logArray(arr0);
        Utils.log("简单排序");
        selectSort(arr0);
        Utils.log("结果--》");
        SortUtil.logArray(arr0);


    }

    public static void selectSort(int[] array) {
        int i, j, min, length = array.length;
        int temp;
        for (i = 0; i < length - 1; i++) {
            SortUtil.logArray(array);
            //未排序序列中最小数据数组下标
            min = i;
            for (j = i + 1; j < length; j++) {
                //在未排序元素中继续寻找最小元素，并保存其下标
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            // 找到最小值
            if (i != min) {
                //将最小元素放到已排序序列的末尾
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
