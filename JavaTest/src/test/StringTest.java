package test;

public class StringTest {
	public static void main(String[] args) {
		/**
		 * String lastIndexOf(str)函数。即是str最后一个匹配的的位置
		 */
		String name1 = "asss.jpg";
		String name2 = ".asss.jpg";
		String name3 = ".as.ss.jpg";
		System.out.println("lastIndexOf 1=" + name1.lastIndexOf("."));//4
		System.out.println("lastIndexOf 2=" + name2.lastIndexOf("."));//5
		System.out.println("lastIndexOf 3=" + name3.lastIndexOf("."));//6
		
		String datatime2="载客时间 08：00";
		int length=datatime2.length();
		System.out.println(datatime2.substring(4, length));
	}

}
