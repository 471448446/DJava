package thinkinjava;

import common.Utils;
/**
 * break ������ǰ��ѭ����
 * һ�����Ѿ���������switch����У�����������ֹһ��������С�
 * �������ܱ������˳�һ��ѭ����
 * ����������Ϊһ�֡��Ƚ�����goto �����ʹ��
 * https://www.kancloud.cn/digest/javashare/142708
 * @author better
 * @date: 2017��2��21�� ����1:11:03
 */
public class Break {
	public static void main(String[] args) {
		//��ǩ�������ѭ��ƥ��ʹ��
		backLable:
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				if(5==j){
					Utils.log("����,������lable");
					break backLable;
				}
				Utils.log("i="+i+",j="+j);
			}
		}
	}
}
