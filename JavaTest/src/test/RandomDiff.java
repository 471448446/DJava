package test;

import java.util.Random;

public class RandomDiff {
	public static void main(String[] args) {
		int[] temp=getRandomDifferent(3, 9);
		if(null!=temp){
			for (int i : temp) {
				System.out.println(""+i);
			}
		}
	}
	public static int[] getRandomDifferent(int size,int max){
		int[] diff=new int[size];
		int i;
		for (int j=0;j<size;j++){
			do{
				i=getRandom(0,max);
				System.out.println("得到随机数="+i);
			}while (isEqual(diff,i,j));
		}

		return diff;
	}

	private static boolean isEqual(int[] diff, int random,int current) {
		boolean is=false;
		for (int item:diff){
			is=item==random;
//			if(item==random)break;
			if(is)break;
			System.out.println("循环值="+item+",当前大循环位置="+current+","+is);
		}
		System.out.println("isEqual="+is);
		if(!is) diff[current]=random;
		return is;
	}
	public static int getRandom(int s,int e){
		Random random=new Random();
		return random.nextInt(e)%(e-s+1)+s;
	}

}
