package algorithm.lt.link;

/**
 * 字母来做hash表，因为题目限定了数据的大小，比如这里是字母26个
 * 字母易位词：两个单词如果包含相同的字母，次序不同，则称为字母易位词(anagram)。
 * https://leetcode-cn.com/problems/valid-anagram/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 你可以假设字符串只包含小写字母。
 * 列：
 * anagram和nagaram 是字母易位次
 * eat和att不是
 */
public class PAnagram {
    public static void main(String[] args) {
        test0("anagram", "nagaram");
        test0("eat", "att");
        test0("abcdefg", "abcdefh");
        test1("anagram", "nagaram");
        test1("eat", "att");
        test1("abcdefg", "abcdefh");
    }

    private static void test1(String s1, String s2) {
        // 这个优化方式牛逼
        boolean is = is1(s1, s2);
        System.out.println(String.format("1 %s,%s is anagram? %b", s1, s2, is));
    }

    // n+n+26 = O(n)
    private static boolean is1(String s1, String s2) {
        // 只包含小写的字母
        // 字母顺序是连续，用一个数组来记录次数就完事了
        int[] record = new int[26];
        int offset = 'a';
        for (int i = 0; i < s1.length(); i++) {
            record[s1.charAt(i) - offset] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            record[s2.charAt(i) - offset] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private static void test0(String s1, String s2) {
        boolean is = is0(s1, s2);
        System.out.println(String.format("0 %s,%s is anagram? %b", s1, s2, is));
    }

    // 两个for O(n^2)
    private static boolean is0(String s1, String s2) {
        // 直接判断两个单词里面，么个字母重复次数是不是一样就行，是一样就是易位词，但会申请其他的额外控件
        if (s1.length() != s2.length()) {
            // 长度肯定是一样的才可能是易位词
            return false;
        }
        int i, l;
        char tmpChar;
        int tmpCountS1, tmpCountS2;
        for (i = 0, l = s1.length(); i < l; i++) {
            tmpChar = s1.charAt(i);
            tmpCountS1 = 0;
            for (int i1 = 0; i1 < l; i1++) {
                if (s1.charAt(i1) == tmpChar) {
                    tmpCountS1++;
                }
            }
            tmpCountS2 = 0;
            for (int i1 = 0; i1 < s2.length(); i1++) {
                if (s2.charAt(i1) == tmpChar) {
                    tmpCountS2++;
                }
            }
            if (tmpCountS1 != tmpCountS2) {
                return false;
            }
        }
        return true;
    }
}
