package learn.oclass.initorder;

import common.Utils;

/**
 * 1������ľ�̬�����;�̬����飬Ȼ��������ľ�̬�����;�̬�����
 * 2������ĳ�Ա������顢���캯��
 * 3������ĳ�Ա������顢���캯��
 * <p>
 * �ܵ����ȸ��������࣬��̬��Ҫ�����ڳ�Ա�ʹ�����Լ����캯��
 * Created by better on 2018/3/4.
 */
public class ClassB extends ClassA {
    public static String sBFiled = "��̬����";

    static {
        l(sBFiled);
        l("��̬�����");
    }

    private String mBFiled = "����";

    {
        l(mBFiled);
        l("�����");
    }

    public ClassB() {
        l("���캯��");
    }

    {
        l("B ���캯������Ĵ���飺" + mBFiled);
    }

    private static void l(String msg) {
        Utils.log("B_" + msg);
    }

    public static void main(String[] args) {
        new ClassB();
    }

}
