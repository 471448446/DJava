package test;

import java.util.Random;

public class RandomTest2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("-----------------");
        // ÿһ���ı���
        int[] percents = new int[]{100, 200, 200};
        int length = percents.length;
        int[] count = new int[length];
        // ִ��һ���
        for (int i1 = 0; i1 < 10000; i1++) {
            int randomWeight = randomWeight(percents);
            count[randomWeight]++;
            // ���ν��
//            System.out.println("random weight " + randomWeight);
        }
        for (int j = 0; j < length; j++) {
            System.out.println("random weight " + percents[j] + " count:" + count[j]);
        }
    }

    /**
     * [min,max)
     */
    public static int random(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int randomWeight(int[] percents) {
        int find = -1;
        // û�кϷ�����
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
        // û�кϷ�����
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
