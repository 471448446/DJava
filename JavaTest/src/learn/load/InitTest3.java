package learn.load;

import java.util.Random;

/**
 * �ڱ���ʱ�޷�ȷ�������ľ�̬����(����ʱ����),�������г�ʼ��
 * Created by better on 2018/4/11.
 */
public class InitTest3 {
    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("FinalTest3 static block");
    }
}
