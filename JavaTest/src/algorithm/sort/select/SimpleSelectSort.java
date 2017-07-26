package algorithm.sort.select;

import algorithm.sort.SortUtil;
import common.Utils;

/**
 * Created by better on 2017/7/16.
 */
public class SimpleSelectSort {
    static int[] arr0 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};

    public static void main(String[] args) {
        Utils.log("ԭʼ����---");
        SortUtil.logArray(arr0);
        Utils.log("������");
        selectSort(arr0);
        Utils.log("���--��");
        SortUtil.logArray(arr0);


    }

    public static void selectSort(int[] array) {
        int i, j, min, length = array.length;
        int temp;
        for (i = 0; i < length - 1; i++) {
            SortUtil.logArray(array);
            //δ������������С���������±�
            min = i;
            for (j = i + 1; j < length; j++) {
                //��δ����Ԫ���м���Ѱ����СԪ�أ����������±�
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            // �ҵ���Сֵ
            if (i != min) {
                //����СԪ�طŵ����������е�ĩβ
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
