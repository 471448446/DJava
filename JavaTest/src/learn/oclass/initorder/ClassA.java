package learn.oclass.initorder;


import common.Utils;


/**
 * ˳�򣺾�̬>��Ա�ʹ����>���캯��
 *
 * Created by better on 2018/3/4.
 */
public class ClassA {
    public static String sAFiled = "��̬����";

    static {
        l(sAFiled);
        l("��̬�����");
    }

    private String mAFiled = "����";

    {
        l(mAFiled);
        l("�����");
    }

    public ClassA() {
        l("���캯��");
    }

    public static void main(String[] args) {
        new ClassA();
    }

    private static void l(String msg) {
        Utils.log("A_" + msg);
    }
}
