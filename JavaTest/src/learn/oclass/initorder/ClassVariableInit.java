package learn.oclass.initorder;

import common.Utils;

/**
 * �����ж���ľ�̬����Ҫ��������ı�����ֵ����
 * Created by better on 2018/3/5.
 */
public class ClassVariableInit {
    static class A {
        static int sId = 1;

        static {
            sId = 2;
        }
    }

    static class B extends A {
        static int sIdB = sId;
    }

    public static void main(String[] args) {
        Utils.log("" + B.sIdB);
    }

}
