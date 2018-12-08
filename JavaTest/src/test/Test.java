package test;

import common.Utils;

import java.io.UnsupportedEncodingException;

public class Test {
    public static void main(String[] args) {
        String s = "\\u5927\\u5e08\\u6027\\u80fd\\u8bc4\\u6d4b";
        try {
            Utils.log(new String(s.getBytes("GBK"),"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
