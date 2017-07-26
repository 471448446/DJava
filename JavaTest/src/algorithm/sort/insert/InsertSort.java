package algorithm.sort.insert;

import algorithm.sort.SortUtil;
import common.Utils;

/**
 * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
 * ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��
 * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��
 * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��
 * ����Ԫ�ز��뵽��λ�ú�
 * �ظ�����2~5
 * Created by better on 2017/7/17.
 */
public class InsertSort {
    static int[] arr0 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
    static int[] arr2 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
    static int[] arr3 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};

    public static void main(String[] args) {
        insertSort(arr0);
        insertSort2(arr2);
        insertSort3(arr3);

    }

    public static void insertSort(int[] array) {
        Utils.log("���룺");
        SortUtil.logArray(array);
        for (int i = 0, l = array.length - 1; i < l; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
            SortUtil.logArray(i, array);
        }
        Utils.log("�����");
        SortUtil.logArray(array);
    }

    public static void insertSort2(int[] array) {
        Utils.log("2���룺");
        SortUtil.logArray(array);
        int i, j, length = array.length;
        int temp;
        for (i = 1; i < length; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
                temp = array[j + 1];
            }
            SortUtil.logArray(i, array);

        }
        Utils.log("2�����");
        SortUtil.logArray(array);
    }

    public static void insertSort3(int[] array) {
        Utils.log("3���룺");
        SortUtil.logArray(array);
        int i, j, length = array.length;
        int temp;
        for (i = 1; i < length; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
                SortUtil.logArray("moved" + j, array);
            }
            array[j + 1] = temp;
            SortUtil.logArray(i, array);
        }
        Utils.log("3�����");
        SortUtil.logArray(array);
    }

    /**
     * https://segmentfault.com/a/1190000003039009
     */
    private static void insertSort4(int[] a) {
        int i, j, t, h;
        for (i = 1; i < a.length; i++) {
            t = a[i];
            j = i - 1;
            while (j >= 0 && t < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = t;
        }
    }
}
