package test;

import common.Utils;

/**
 * ���� &��&& ����
 *
 * @author Better
 */
public class AndTest {

    static int i = 4;
    static int b = 7;

    /**
     * @param args
     */
    public static void main(String[] args) {
//		testAnd();
//		testAanAnd();
        int c = i & b;
        System.out.println("& int=" + c);
        int K = 8;
        K = K << 2;
        Utils.log("__<<2=" + K);
    }

    private static void testAanAnd() {
        String andStr = null;
        if (andStr != null && andStr.isEmpty()) {
            System.out.println("testAanAnd() true");
        }
    }

    /**
     * &��һ������ִ��
     */
    private static void testAnd() {
        String andStr = null;
        if (andStr != null & andStr.isEmpty()) {

        }
    }

}
