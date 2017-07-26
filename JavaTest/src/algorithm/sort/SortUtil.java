package algorithm.sort;

import common.Utils;

/**
 * Created by better on 2017/7/16.
 */
public class SortUtil {
    /**
     * 将 i，和j的数据进行交换
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void logArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        Utils.log(builder.toString());
    }

    public static void logArray(int p, int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        Utils.log(p + "=" + builder.toString());
    }

    public static void logArray(String p, int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i] + ",");
        }
        Utils.log(p + "=" + builder.toString());
    }

}
