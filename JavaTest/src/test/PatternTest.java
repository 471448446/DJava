package test;

import common.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    //电话格式
//	static String pattern="^1[3|4|5|7|8][0-9]\\d{8}]";
    static String pattern = "^(13\\d|15[^4\\D]|17[13678]|18\\d)\\d{8}|170[^346\\D]\\d{7}";
    static String msg = "你好好{sb}阿坝";
    static String msg1 = "你好好{0}驱蚊器";
    static String msg2 = "你好好{0}驱{就问问aa9}蚊器";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("17000141846".matches(pattern));
        Utils.log(regexFindNum("1999年"));
        log(getBracketsStr(msg));
        log(getBracketsStr(msg1));
        log(getBracketsStr(msg2));

        String tipMsg = msg;
        String checkStr = null;
        List<String> msg = getBracketsStr(tipMsg);
        if (!msg.isEmpty()) {
            checkStr = getBracketsStrValue(msg.get(0));
            Utils.log("" + tipMsg.contains(msg.get(0)) + "," + msg.get(0) + "," + checkStr);
            tipMsg = tipMsg.replace(msg.get(0), checkStr);
        }
        Utils.log(tipMsg);
    }

    private static void log(List<String> list) {
        for (String s : list) {
            Utils.log("" + s);
        }
    }

    /**
     * @param string 匹配的数字字符串
     * @return 用于 需要XXX分钟支付
     */
    public static String regexFindNum(String string) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        String res = string;
        while (matcher.find()) {
            res = matcher.group();
        }
        return res;
    }

    public static List<String> getBracketsStr(String msg) {
        List<String> list = new ArrayList<>();
        if (null != msg && msg.contains("{")) {
//            String pattrn ="(\\{\\S+\\})";
            String pattrn = "\\{[^}]*\\}";
            Matcher matcher = Pattern.compile(pattrn).matcher(msg);
            String res;
            while (matcher.find()) {
                res = matcher.group();
//                res = res.substring(1, res.length() - 1);
                list.add(res);
            }
        }

        return list;
    }

    /**
     * 返回{文字}的文字
     * Create By better on 2017/7/17 14:40.
     */
    public static String getBracketsStrValue(String msg) {
        return msg.substring(1, msg.length() - 1);
    }
}
