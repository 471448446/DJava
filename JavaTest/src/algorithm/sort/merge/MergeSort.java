package algorithm.sort.merge;

import algorithm.sort.SortUtil;
import common.Utils;

/**
 * Created by better on 2017/7/21.
 */
public class MergeSort {
    static int[] arr0 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
    static int[] arr1 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};
    static int[] arr2 = new int[]{100, 70, 80, 1, 60, 88, 60, 77, 10, 30, 7,};

    public static void main(String[] args) {
        mergeSortRecursionFake(arr0);
        Utils.log("------------");
        mergeSortRecursion(arr1);
        Utils.log("------------");
    }

    public static void mergeSortRecursion(int[] array) {
        SortUtil.logArray("input array==", array);
        mergeSort(array, 0, array.length - 1);
        SortUtil.logArray("finish array==", array);
    }

    /**
     * ����
     */
    private static void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int middle = (left + right) >> 1;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    /**
     * ��ָ����block���й鲢��
     * ������������ָ��������ݿ�ĵ�һ�к��ұߵĵ�һ��Ȼ����бȽϡ�
     */
    private static void merge(int[] array, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = middle + 1, k = 0, h = 0;
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        //������ʣ��ȫ������
        while (i <= middle) {
            temp[k++] = array[i++];
        }
        //����ұ߱�ʣ��ȫ������
        while (j <= right) {
            temp[k++] = array[j++];
        }
        //���鲢�����ֵ��ԭ������
        while (h < temp.length) {
            array[left + h]
                    = temp[h++];
        }
        SortUtil.logArray("merge:" + left + "," + right, array);
    }

    /**
     * ���ַ�ʽ��Ȼʵ�������򣬵��ǲ�û�й鲢���������ֲ��˷��η���˼�롣
     * ��������ϣ�������һ��˼�룺�����������
     * length=1,input--->=100,70,80,1,60,88,60,77,10,30,7,
     * length=1,result=70,100,1,80,60,88,60,77,10,30,7,
     * length=2,input--->=70,100,1,80,60,88,60,77,10,30,7,
     * length=2,result=1,70,80,100,60,60,77,88,7,10,30,
     * length=4,input--->=1,70,80,100,60,60,77,88,7,10,30,
     * length=4,result=1,60,60,70,77,80,88,100,7,10,30,
     * length=8,input--->=1,60,60,70,77,80,88,100,7,10,30,
     * length=8,result=1,7,10,30,60,60,70,77,80,88,100,
     */
    public static void mergeSortRecursionFake(int[] array) {
        SortUtil.logArray("input array==", array);
        mergeSortFake(array, 1);
        SortUtil.logArray("finish array==", array);

    }

    private static void mergeSortFake(int[] array, int arrayLength) {
//        SortUtil.logArray("length=" + arrayLength + ",input--->", array);
        int i, j, h, temp;
        for (i = 0; i <= array.length - arrayLength; i += 2 * arrayLength) {
            //�ڵڶ��������������ڵ�һ�������������
            for (j = i + arrayLength; j < i + 2 * arrayLength; j++) {
                if (j >= array.length) {
                    break;
                }
                temp = array[j];
                h = j - 1;
                while (h >= i && temp < array[h]) {
                    array[h + 1] = array[h];
                    h--;
                }
                array[h + 1] = temp;
            }
        }
//        SortUtil.logArray("length=" + arrayLength + ",result", array);
        if (2 * arrayLength >= array.length) {
            return;
        } else {
            mergeSortFake(array, arrayLength << 1);
        }
    }
}
