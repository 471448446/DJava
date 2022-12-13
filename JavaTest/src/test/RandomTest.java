package test;

import java.util.Random;

public class RandomTest {
    private static Random random = new Random();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int max = 20;
        int min = 0;

        for (int i = 0; i < 20; i++) {
            int s = random.nextInt(max) % (max - min + 1) + min;
            System.out.println(s);
        }
        int i;
        do {
            i = random.nextInt(max) % (max - min + 1) + min;
        } while (i != 19);
//		for (int j = 0; j < max; j++) {
//			int k=random.nextInt(max) % (max - min + 1) + min;
//			if(k!=)
//		}

        System.out.println("自己的异常：");
//        throw new IllegalStateException("不合法的异常");
        System.out.println("-----------------");
        int[] percents = new int[]{100, 200, 200};
        int length = percents.length;
        int[] count = new int[length];
        for (int i1 = 0; i1 < 10000; i1++) {
            int randomWeight = randomWeight(percents);
            count[randomWeight] = count[randomWeight] + 1;
//            System.out.println("random weight " + randomWeight);
        }
        for (int j = 0; j < length; j++) {
            System.out.println("random weight " + percents[j] + " count:" + count[j]);
        }
        /*
        100, 200, 300
          random weight 0 count:173
          random weight 1 count:339
          random weight 2 count:488
         */
    }

    /**
     * [min,max)
     */
    public static int random(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int randomWeight(int[] percents) {
        int find = -1;
        // 没有合法数据
        if (percents.length == 0) {
            return find;
        }
        int max = 0;
        int valueEqualZeroCount = 0;
        for (int percent : percents) {
            max += percent;
            if (percent > 0) {
                valueEqualZeroCount++;
            }
        }
        // 没有合法数据
        if (valueEqualZeroCount == 0) {
            return find;
        }
        int length = percents.length;
        int current;
        do {
            int random = random(0, max);
            current = 0;
            for (int i = 0; i < length; i++) {
                current += percents[i];
                if (random <= current) {
                    find = i;
                    break;
                }
            }
        } while (find == -1);
        return find;
    }

}
