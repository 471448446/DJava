package algorithm.sort.shell;

import algorithm.sort.SortUtil;
import common.Utils;

/**
 * 先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
 * 然后依次缩减增量再进行排序，
 * 待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序
 * http://blog.csdn.net/morewindows/article/details/6668714
 * http://bubkoo.com/2014/01/15/sort-algorithm/shell-sort/
 * Created by better on 2017/7/18.
 */
public class ShellSort {
    static int[] arr0 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
    static int[] arr3 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};

    public static void main(String[] args) {
        shellSort0(arr0);
        shellSort3(arr3);

    }

    public static void shellSort0(int[] array) {
        Utils.log("输入：");
        SortUtil.logArray(array);
        int step;
        //步长，每次减为原来的一半
        for (step = array.length / 2; step > 0; step /= 2) {
            //插入排序每个小组的数据
            for (int i = 0; i < step; i++) {
                //直接插入排序
                for (int j = i; j < array.length - step; j += step) {
                    for (int k = j + step; k - step >= 0; k -= step) {
                        if (array[k - step] > array[k]) {
                            int temp = array[k - step];
                            array[k - step] = array[k];
                            array[k] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            SortUtil.logArray(step, array);
        }
        Utils.log("结果：");
        SortUtil.logArray(array);
    }

    public static void shellSort3(int[] array) {
        SortUtil.logArray("输入：", array);

        int step, i, j, length = array.length;
        int temp;
        for (step = length / 2; step > 0; step /= 2) {
            Utils.log("step=" + step);
            for (i = step; i < length; i++) {
                temp = array[i];
                j = i - step;
                while (j >= 0 && temp < array[j]) {
                    array[j + step] = array[j];
                    j -= step;
                    SortUtil.logArray("插入j" + i + "=", array);
                }
                array[j + step] = temp;
                SortUtil.logArray("i" + i + "=", array);
            }
        }

        SortUtil.logArray("输出：", array);
    }
}
