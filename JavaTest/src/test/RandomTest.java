package test;

import java.util.Random;

public class RandomTest {

	/**
	 * @param args
	 */
	public static void main(StringTest[] args) {
		// TODO Auto-generated method stub
		int max = 20;
		int min = 0;
		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			int s = random.nextInt(max) % (max - min + 1) + min;
			System.out.println(s);
		}
		int i;
		do {
			i=random.nextInt(max) % (max - min + 1) + min;
		} while (i!=19);
//		for (int j = 0; j < max; j++) {
//			int k=random.nextInt(max) % (max - min + 1) + min;
//			if(k!=)
//		}

		System.out.println("自己的异常：");
		throw new IllegalStateException("不合法的异常");
	}

}
