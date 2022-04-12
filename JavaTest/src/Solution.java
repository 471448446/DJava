import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int findNumber(int[] n) {
        /* 在这里编写你的程序  */

        int length = n.length;
        Set<String> s = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                swipe(n, i, j);
                s.add(arrayToString(n));
                swipe(n, i, j);
            }
        }
        return s.size();
    }

    private static String arrayToString(int[] n) {
        StringBuilder tmp = new StringBuilder();
        for (int i : n) {
            tmp.append(",").append(i);
        }
        return tmp.toString();
    }

    private static void swipe(int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }

    public static void main(String[] args) {

        int[] n = {2, 5, 8, 2, 5, 4, 5};
//        int[] n = {1, 2, 1};


        Solution result = new Solution();
        int s = result.findNumber(n);
        System.out.println(s);
    }
}