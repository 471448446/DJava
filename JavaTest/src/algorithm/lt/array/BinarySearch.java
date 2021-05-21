package algorithm.lt.array;

/**
 * 二分前提：元素有序，元素不重复（重复导致查找会有多个结果）
 */
public class BinarySearch {
    private static final int[] DATA = new int[]{0, 10, 23, 45, 70, 99, 110, 119, 120};
    private static final int[] DATA2 = new int[]{0, 9, 23, 45, 70, 99, 110, 119, 120};

    public static void main(String[] args) {
        int search = 9;
        int find = b1(DATA, 9);
        System.out.println(String.format("search1 %d index = %d", search, find));

//        binarySearch(DATA, 9);
//        System.out.println("----------------------");
//        binarySearch(DATA, 10);
//        System.out.println("----------------------");
//        binarySearch(DATA2, 9);
//        System.out.println("----------------------");
//        binarySearch(DATA2, 10);
    }

    private static void binarySearch(int[] data, int search) {
        int find = b1(data, search);
        System.out.println(String.format("search1 %d index = %d", search, find));
        find = b2(data, search);
        System.out.println(String.format("search2 %d index = %d", search, find));
    }

    public static int b2(int[] data, int search) {
        int left = 0;
        int right = data.length;
        int middle;
        //使用区间 [left,right)
        while (left < right) {
            middle = (left + right) / 2;
//            System.out.println(String.format("b2 [left:%d,right%d],middle:%d", left, right, middle));
            if (search == data[middle]) {
                return middle;
            } else if (search < data[middle]) { //[left, middle)
                right = middle;
            } else {                           //[middle+1, right)
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * [left,right] 使用左闭右闭来查找
     * left <= right 每一次如果没有找到是使用的middle-1或者middle+1来移动区间，
     * 那么最后一次是需要判断的，因为指是取的middle来判断。并没有判断left或者right的值
     * 比如：0, 10, 23, 45, 70, 99, 110, 119, 120 中查找9
     * [left:0,right8],middle:4
     * [left:0,right3],middle:1
     * [left:0,right0],middle:0
     * 最后一个区间是[0,0],其实就是判断index为0的值,如果是left < right 最后一个就丢失了
     */
    public static int b1(int[] data, int search) {
        int left = 0;
        int right = data.length - 1;
        int middle;
        // 使用区间[left,right]
        while (left <= right) {
            middle = (left + right) / 2;
            System.out.println(String.format("b1 [left:%d,right%d],middle:%d", left, right, middle));
            if (search == data[middle]) {
                return middle;
            } else if (search < data[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
