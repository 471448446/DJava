package com.better.learn.math.prime;

import java.util.Locale;

public class PrimeTest {
    public static void main(String[] args) {
//        justPrint(2);
//        justPrint(3);
        justPrint(10);
        justPrint(20);
    }

    private static void justPrint(int n) {
        System.out.printf(Locale.CANADA, "[2,%d] have prime %d \n", n, countOfPrime(n));
    }

    /**
     * 埃拉托斯特尼筛法
     * https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
     *
     * @param n [2,n]范围内包含的质数个数
     * @return 质数个数
     */
    private static int countOfPrime(int n) {
        int size = n + 1;
        // 数组的下表，从0开始，0就对应数字0，但是0和1都不参与计算
        boolean[] prime = new boolean[size];
        for (int i = 0; i < size; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= size; i++) { // 遍历小于等于根号n范围内
            if (prime[i]) {
                for (int j = i + i; j < size; j += i) { // 质数的倍数，都是合数，剔除
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < size; i++) {
            if (prime[i]) {
                count++;
            }
        }
        return count;
    }
}
