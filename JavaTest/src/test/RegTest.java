package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
	static String string="2016��04��05�� 00:00";
	static String string2="2016-04-05 00:00:00";
	public static void main(String[] args) {
		String str="��Ҫ����0���������֧�������򶩵��Զ�ʧЧ��";
		System.out.println("ƥ��="+RegexFind("/[0-9]*/", str));
		String str_num=RegexFind("\\d+", str);
		System.out.println("ƥ��2="+str.indexOf(str_num));
		
		
		System.out.println(RegexFind("\\d+��\\d+��", string));
		System.out.println(RegexFind("\\d+:", string));
		System.out.println(RegexFind("-\\d+-", string2));
	}
	public static String RegexFind(String regex,String string){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		String res = string;
		while (matcher.find()){
			res = matcher.group();
		}
		return res;
	}
}
