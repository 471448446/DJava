package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * set �ǰ���ӵ�����ģ������ظ�
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
		map.put(1, "�ֶ�1");
		print("����� 1",set);
		printMap(map);
		set.add(2);
		set.add(3);
		map.put(2, "�ֶ�2");
		map.put(3, "�ֶ�3");
		print("insert 2 3",set);
		printMap(map);
		
		set.add(3);
		map.put(2, "�ֶ�3");
		print("again insert 3 ��",set);
		printMap(map);
		
		set.remove(2);
		map.remove(2);
		print("remove 2",set);
		printMap(map);
		set.add(2);
		map.put(2, "�ֶ�2");
		print("insert 2",set);
		printMap(map);
		set.remove(100);
	}

	private static void printMap(HashMap<Integer, String> map) {
	   System.out.println("��Ǯmap:"+map.toString());	
	}

	private static void print(String des,Set<Object> set) {
		System.out.println(des);
		Iterator<Object> iterator=set.iterator();
		while (iterator.hasNext()) {
			System.out.println(""+iterator.next());
		}
	}

}
