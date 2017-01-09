package test;

public class PatternTest {
	//电话格式
//	static String pattern="^1[3|4|5|7|8][0-9]\\d{8}]";
	static String pattern="^(13\\d|15[^4\\D]|17[13678]|18\\d)\\d{8}|170[^346\\D]\\d{7}";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("17000141846".matches(pattern));
	}
}
