package learn.load;

import common.Utils;

/**
 * �ȼ��أ���Ĭ��ֵ�����ڳ�ʼ��
 * �����ྲ̬��������̬�����ᵼ���౻���أ���̬��������̬��������˳���Ǵ����ֺ�˳��
 * �����ೣ�����ᵼ���౻���أ���final���ξ�̬�ֶ��ڲ���ʹ��ʱ������ʹ����г�ʼ������Ϊ�ڱ������Ѿ����˳������ڳ�����
 * Created by better on 2018/4/11.
 */
public class LoadInit1Main {
    public static void main(String[] args) {
        /**
         * ��ʾ��̬��������˳��
         * �����̬����û�и�ֵ���ڼ��ص�ʱ��ḳĬ��ֵ
         */
        LoadInit1.getInstance();
        Utils.log("LoadInit1Main A=" + LoadInit1.A);
        Utils.log("LoadInit1Main B=" + LoadInit1.B);
        Utils.log("---------------------line other------------------------------");
        /**
         * ���س��������ᵼ���౻����
         * ��final���ξ�̬�ֶ��ڲ���ʹ��ʱ������ʹ����г�ʼ������Ϊ�ڱ������Ѿ����˳������ڳ�����
         */
        Utils.log("load final statistics " + LoadStatistics.NAME);
        // ��ʱ���������౻����
        Utils.log("--- then create object");
        new LoadStatistics();
        Utils.log("---------------------line other------------------------------");
        /**
         * ���ؾ�̬���������౻����,
         */
        Utils.log("load statistics var " + LoadStatisticsValiable.NAME);
        Utils.log("---------------------line other------------------------------");
        /**
         * ���ؾ�̬�����ᵼ���౻����
         */
        Utils.log("load statistics method" + LoadStatisticsMethod.justLoad());
    }
}
