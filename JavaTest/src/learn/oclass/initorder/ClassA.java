package learn.oclass.initorder;


import common.Utils;


/**
 * ˳�򣺾�̬>��Ա�ʹ����>���캯��
 * <p>
 * Created by better on 2018/3/4.
 */
public class ClassA {
    public static String sAFiled = "��̬����";

    static {
        l(sAFiled);
        l("��̬�����");
    }

    public static String sAFiled2 = "��̬����2";

    static {
        l(sAFiled2);
        l("2��̬�����");
    }


    private String mAFiled = "����";

    {
        l(mAFiled);
        l("�����");
    }

    public ClassA() {
        l("���캯��");
    }

    {
        l("A ���캯������Ĵ���飺" + mAFiled);
    }

    public static void main(String[] args) {
        new ClassA();
    }

    private static void l(String msg) {
        Utils.log("A_" + msg);
    }
}
