package test;

import java.util.TreeMap;
/**
 * treeMapÊÇÓÐÐòµÄ
 * @author Better
 *
 */
public class TreeMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<String, Object> treeMap=new TreeMap<String, Object>();
		treeMap.put("0", "0000");
		System.out.println("treemap:"+treeMap.toString());
		treeMap.put("1", "1111111");
		System.out.println("treemap:"+treeMap.toString());
		treeMap.put("2", "22222");
		System.out.println("treemap:"+treeMap.toString());
		treeMap.put("3", "33333");
		System.out.println("treemap:"+treeMap.toString()+",updata2");
		treeMap.put("2", "244444");
		System.out.println("treemap:"+treeMap.toString()+"remove:2");
		treeMap.remove("2");
		System.out.println("treemap:"+treeMap.toString()+"add2");
		treeMap.put("2", "8989989");
		System.out.println("treemap:"+treeMap.toString());
	}

}
