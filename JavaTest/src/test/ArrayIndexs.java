package test;


/**
 * Created by better on 2018/12/4.
 */
public class ArrayIndexs {

    public static void main(String[] args) {
        int[] array = new int[]{10, 8, 20, 12, 1, 15, 11};
        f(array);
    }

    public static void f(int arr[]) {
        /*
        给你 n 个无序的 int 整型数组 arr，
        并且这些整数的取值范围都在 0-20 之间，
        要你在 O(n) 的时间复杂度中把这 n 个数按照从小到大的顺序打印出来
        */
        int[] temp = new int[21];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        //顺序打印
        for (int i = 0; i < 21; i++) {
            // 如果只出现一次的话
//            if (temp[i]>0){
//                System.out.println(i);
//            }
            for (int j = 0; j < temp[i]; j++) {
                System.out.println(i);
            }
        }
    }

}
