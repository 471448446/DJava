package algorithm.bte;

import common.Utils;

public class TestByte {
    public static void main(String[] args) {
        // int 4字节
        Utils.log(-3, "_bit_=", Integer.toBinaryString(-3));
        Utils.log(3, "_bit_=", Integer.toBinaryString(3));
        Utils.log(97, "_bit_=", Integer.toBinaryString(97));
    }
}
