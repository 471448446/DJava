package test;


import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * 注意：java文件使用utf-8编码 with no bom
 */
public class StringLength {
    public static void main(String[] args) {
        System.out.println("JDK: " + System.getProperty("java.specification.version"));
//        System.out.println("Hello World!".length());
//        String stringChinese = "仙剑奇侠传";
//        String stringLd = "A";
//        System.out.println(stringChinese.length() + "," + stringChinese.codePointCount(0, stringChinese.length()));
//        System.out.println(stringLd.length() + "," + stringLd.codePointCount(0, stringLd.length()));

        char[] data = {'a', 'b', 'c'};
        String str = new String(data);
        String str2 = "abc";
        System.out.println(str + "==" + str2 + "?" + (str.equals(str2)));
        print("Hello World!");
        print("仙");
        print("仙剑");
        print("仙剑奇");
        print("仙剑奇侠");
        print("仙剑奇侠传");
        //表情
        print("😀");
        print("😎");
        // 生僻字
        print("槑");
        print("玃");
    }

    private static void print(String v) {
        System.out.printf(Locale.CHINA, "%s length: %d ,bytes length:%d ,char length:%d %n", v,
                //String.length返回Unicode code units的长度。
                v.length(),
                // 不传编码，会使用系统默认的编码
                v.getBytes(StandardCharsets.UTF_8).length,
                // charArray其实就是跟length()关联的
                v.toCharArray().length);
        StringBuilder sb = new StringBuilder();
        for (char c : v.toCharArray()) {
            // 这里查看每个字符的unniCode编码值，
            sb.append((int) c).append(",");
        }
        System.out.println(sb);
        System.out.printf(Locale.CHINA, "codePointAt(0) = %d %n", v.codePointAt(0));
        if (v.length() > 1) {
            System.out.printf(Locale.CHINA, "codePointAt(1) = %d %n", v.codePointAt(1));
        }
    }
}
