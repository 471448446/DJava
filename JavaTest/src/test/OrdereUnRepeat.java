package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * set 是按添加的有序的，不能重复
 * @author Better
 *
 */
public class OrdereUnRepeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Object> set=new HashSet<Object>();
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		set.add(1);
		map.put(1, "字段1");
		print("添加了 1",set);
		printMap(map);
		set.add(2);
		set.add(3);
		map.put(2, "字段2");
		map.put(3, "字段3");
		print("insert 2 3",set);
		printMap(map);
		
		set.add(3);
		map.put(2, "字段3");
		print("again insert 3 后",set);
		printMap(map);
		
		set.remove(2);
		map.remove(2);
		print("remove 2",set);
		printMap(map);
		set.add(2);
		map.put(2, "字段2");
		print("insert 2",set);
		printMap(map);
		set.remove(100);
	}

	private static void printMap(HashMap<Integer, String> map) {
	   System.out.println("但钱map:"+map.toString());	
	}

	private static void print(String des,Set<Object> set) {
		System.out.println(des);
		Iterator<Object> iterator=set.iterator();
		while (iterator.hasNext()) {
			System.out.println(""+iterator.next());
		}
	}

}
