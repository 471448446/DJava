package thinkinjava;

import common.Utils;

/**
 * ��������ѭ��δִ�еĴ��룬ֱ��ִ����һ��ѭ����
 * �����Ҫ�����ⲿ��ѭ��������Ҫʹ�ñ�ǩ����ʶ��Ӧ��ѭ���ṹ
 * @author better
 */
public class Continue {
	public static void main(String[] args) {
		backLable:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(5==j){
						Utils.log("����,������lable");
						continue backLable;
					}
					Utils.log("i="+i+",j="+j);
				}
			}
	Utils.log("-----");
		for (int j = 0; j < 10; j++) {
			if(5==j){
				Utils.log("����,������lable");
				continue ;
			}
			Utils.log("j="+j);
		}
	}

}
