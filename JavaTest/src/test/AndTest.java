package test;
/**
 * ���� &��&& ����
 * @author Better
 *
 */
public class AndTest {

	static int i=4;
	static int b=7;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testAnd();
//		testAanAnd();
		int c=i&b;
		System.out.println("& int="+c);
	}
	private static void testAanAnd() {
		String andStr=null;
		if(andStr!=null&&andStr.isEmpty()){
			System.out.println("testAanAnd() true");
		}
	}
	/**
	 * &��һ������ִ��
	 */
	private static void testAnd() {
		String andStr=null;
		if(andStr!=null&andStr.isEmpty()){
			
		}
	}

}
