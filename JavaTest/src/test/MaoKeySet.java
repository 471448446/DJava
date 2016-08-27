package test;

import java.util.HashMap;

public class MaoKeySet {
	public static void main(String[] args) {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("1", "hello");
		map.put("2", "hello");
		map.put("3", "hello");
		map.put("4", "hello");
		for (String string : map.keySet()) {
			System.out.println(string);
		}
	}
}
