package learn.system;

import common.Utils;

public class SystemTest {
    public static void main(String[] args) {
        int[] array1 = new int[]{0, 1, 2, 4, 3, 2};
        int[] array2 = new int[]{9, 8, 7, 6, 5, 4};
        System.arraycopy(array1, 1, array2, 0, 4);
        Utils.log(Utils.string(array2));
        Integer[] array11 = new Integer[]{0, 1, 2, 4, 3, 2};
        Integer[] array21 = new Integer[]{9, 8, 7, 6, 5, 4};
        System.arraycopy(array11, 1, array21, 0, 4);
        Utils.log(Utils.string(array21));
    }
}
