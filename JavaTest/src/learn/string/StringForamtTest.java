package learn.string;

import common.Utils;

/**
 * %1�ǿ��Բ�д��
 * Created by better on 2018/4/26.
 */
public class StringForamtTest {
    public static void main(String[] args) {

        Utils.log(String.format("����%s��λ��%2s�ı��ӣ�%2s�ĸֱ�", "����", "����", "����"));
        Utils.log(String.format("��ʣ%fGB", 1f));
        //����С������
        Utils.log(String.format("��ʣ%1$.2fGB���ܹ�%2$.2GB", 1f,3.94444f));
    }
}
