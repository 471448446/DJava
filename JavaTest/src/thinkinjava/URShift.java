package thinkinjava;

import common.Utils;

/**
 * 移位运算
 * long,int,sort,byte,char
 * @author better
 *
 */
public class URShift {
	public static void main(String[] args) {
		/*2的n次方？>>除,不够时+1除，<<乘*/
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
		Utils.log(msg+" 值："+i+","+Integer.toBinaryString(i));
	}
}
