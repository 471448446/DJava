package algorithm.sort.quick;

import algorithm.sort.SortUtil;

/**
 * Created by better on 2017/7/25.
 */
public class QuickSort {
    static int[] arr0 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
//    static int[] arr0 = new int[]{50, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};

    public static void main(String[] args) {
        quickSort(arr0);
    }

    public static void quickSort(int[] array) {
        SortUtil.logArray("input array==", array);
        quickSort(array, 0, array.length - 1);
        SortUtil.logArray("finish array==", array);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivotValue = array[left];
        while (left < right) {
            //找当前数组右边的小值，移动到左边
            while (left < right && pivotValue <= array[right]) {
                right--;
            }
            array[left] = array[right];
            //找当前数组左边的大值，移动到右边
            while (left < right && pivotValue >= array[left]) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivotValue;
        return left;
    }

}
