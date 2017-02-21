package thinkinjava;

import common.Utils;

/**
 * 跳过当次循环未执行的代码，直接执行下一次循环。
 * 如果需要跳过外部的循环，则需要使用标签语句标识对应的循环结构
 * @author better
 */
public class Continue {
	public static void main(String[] args) {
		backLable:
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(5==j){
						Utils.log("满足,跳出到lable");
						continue backLable;
					}
					Utils.log("i="+i+",j="+j);
				}
			}
	Utils.log("-----");
		for (int j = 0; j < 10; j++) {
			if(5==j){
				Utils.log("满足,跳出到lable");
				continue ;
			}
			Utils.log("j="+j);
		}
	}

}
