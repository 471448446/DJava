package test;

import common.Utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuckTest {
    public static void main(String[] args) {
        arrayIndex();
        String size = "1.34Gb";
        Utils.log(trans2byte(size) + " byte");
    }

    private static long trans2byte(String size) {
        String regex = "\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(size);
        if (!matcher.find()) {
            return 0;
        }
        String num = matcher.group();
        String unit = size.substring(num.length(), size.length());
        Utils.log(num + " " + unit);
        double byteSize = Double.parseDouble(num);

        if (unit.contains("G") || unit.contains("g")) {
            byteSize = byteSize * 1024 * 1024 * 1024;
        } else if (unit.contains("M") || unit.contains("m")) {
            byteSize = byteSize * 1024 * 1024;
        } else {
            byteSize = 1024;
        }
        return new BigDecimal(byteSize).setScale(0, BigDecimal.ROUND_UP).longValue();
    }

    private static void arrayIndex() {
        int[] arr = new int[]{1, 12, 9, 11, 20, 18, 16, 13};

        int[] temp = new int[21];
        for (int anArr : arr) {
            temp[anArr]++;
        }
        //顺序打印
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < temp[i]; j++) {
                System.out.println(i);
            }
        }
    }

}
