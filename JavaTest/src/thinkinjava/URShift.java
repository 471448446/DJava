package thinkinjava;

import common.Utils;

/**
 * ��λ����
 * long,int,sort,byte,char
 * @author better
 *
 */
public class URShift {
	public static void main(String[] args) {
		/*2��n�η���>>��,����ʱ+1����<<��*/
		int i=8;
		log("init",i);
		i=i>>2;
		log(">>",i);
		i=i<<2;
		log("<<",i);
		Utils.log("-----");
		Utils.log(""+(-5<<1));
		Utils.log(""+(-5>>1));
		Utils.log(""+(-7>>1));

	}
	static void log(String msg,int i){
		Utils.log(msg+" ֵ��"+i+","+Integer.toBinaryString(i));
	}
}
