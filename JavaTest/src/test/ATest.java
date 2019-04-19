package test;

import common.Utils;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ATest {
    static Random random = new Random(10);
    public static void main(String[] args) {
        Utils.log("Better",new Random().nextInt(5));
        Utils.log("Better",ThreadLocalRandom.current().nextInt(1,3));
        Utils.log("Better",getRandomNumberInRange(1,3));
       String[] s=  getFormatSizeSourceForProcess();
        Utils.log("Better",s[0],s[1]);
//        Utils.log(numberFormatAtMost2Point(Double.parseDouble("8")));
//        Utils.log(numberFormatAtMost2Point(Double.parseDouble("8.0")));
//        Utils.log(numberFormatAtMost2Point(Double.parseDouble("8.00")));
//        Utils.log(numberFormatAtMost2Point(Double.parseDouble("5.01")));
//        Utils.log(numberFormatAtMost2Point(Double.parseDouble("5.1")));
//        Utils.log(numberFormatAtMost2Point(Double.parseDouble("0")));
    }
    public static String[] getFormatSizeSourceForProcess() {
        String[] s = new String[]{"11.50","G"};
        if (s[1].contains("G")) {
            s[0] = String.valueOf(new BigDecimal(s[0]).setScale(BigDecimal.ROUND_HALF_UP, 0).intValue());
        } else {
            s[0] = String.valueOf(new BigDecimal(s[0]).setScale(BigDecimal.ROUND_DOWN, 2).floatValue());
        }
        return s;
    }
    private static int getRandomNumberInRange(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    static  int getRandom(){
        return random.nextInt();
    }
    public static String numberFormatAtMost2Point(Double number) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        String a = df.format(number).toString();
        if (a.startsWith(".")) {
            a = "0" + a;
        }
        String[] b = new String[2];
        if (a.contains(".")) {
            b = a.split("[.]");
        }
        if (b[1].endsWith("00")) {
            return b[0];
        } else if (b[1].endsWith("0") && !b[1].startsWith("0")) {
            return b[0] + "." + b[1].substring(0, b[1].length() - 1);
        } else {
            return a;
        }
    }

}
