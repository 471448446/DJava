package thinkinjava;

import common.Utils;
/**
 * break 跳出当前的循环，
 * 一，你已经看到，在switch语句中，它被用来终止一个语句序列。
 * 二，它能被用来退出一个循环。
 * 三，它能作为一种“先进”的goto 语句来使用
 * https://www.kancloud.cn/digest/javashare/142708
 * @author better
 * @date: 2017年2月21日 下午1:11:03
 */
public class Break {
	public static void main(String[] args) {
		//标签语句必须和循环匹配使用
		backLable:
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
				if(5==j){
					Utils.log("满足,跳出到lable");
					break backLable;
				}
				Utils.log("i="+i+",j="+j);
			}
		}
	}
}
