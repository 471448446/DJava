package test;

import common.Utils;

import java.math.BigDecimal;

/**
 * Created by better on 2020/2/22.
 */
public class EMap {
    public static void main(String[] args) {
        String m = "1E29095";
        BigDecimal bigDecimal = new BigDecimal(m);
        String number = bigDecimal.toPlainString();
        Utils.log(number);
        Long max = Long.parseLong(number);
        max = max / (1024 * 1024);
        Utils.log(max);
    }
}
