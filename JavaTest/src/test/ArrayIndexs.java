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
        ���� n ������� int �������� arr��
        ������Щ������ȡֵ��Χ���� 0-20 ֮�䣬
        Ҫ���� O(n) ��ʱ�临�Ӷ��а��� n �������մ�С�����˳���ӡ����
        */
        int[] temp = new int[21];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        //˳���ӡ
        for (int i = 0; i < 21; i++) {
            // ���ֻ����һ�εĻ�
//            if (temp[i]>0){
//                System.out.println(i);
//            }
            for (int j = 0; j < temp[i]; j++) {
                System.out.println(i);
            }
        }
    }

}
