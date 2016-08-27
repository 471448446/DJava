package test;

public class LatTest {
	public static void main(String[] args) {
		String str="(23.12344|34.212)";
		int length=str.length();
		int _half=str.indexOf("|");
		System.out.println(str.subSequence(1, _half));
		System.out.println(","+str.subSequence(_half+1, length-1));
	}
}
