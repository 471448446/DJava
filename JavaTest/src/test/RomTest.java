package test;

public class RomTest {
	final static int count=3;
	public static void main(String[] args) {
		rom(0);
		rom(1);
		rom(2);
		rom(3);
	}

	private static void rom(int i) {
		System.out.println(i%count);
	}
}
