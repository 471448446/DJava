package test;
import common.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
	//�绰��ʽ
//	static String pattern="^1[3|4|5|7|8][0-9]\\d{8}]";
	static String pattern="^(13\\d|15[^4\\D]|17[13678]|18\\d)\\d{8}|170[^346\\D]\\d{7}";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("17000141846".matches(pattern));
		Utils.log(regexFindNum("1999��"));
	}
	/**
	 * @param string ƥ��������ַ���
	 * @return ���� ��ҪXXX����֧��
	 */
	public static String regexFindNum(String string) {
		String regex="\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		String res = string;
		while (matcher.find()) {
			res = matcher.group();
		}
		return res;
	}
}
