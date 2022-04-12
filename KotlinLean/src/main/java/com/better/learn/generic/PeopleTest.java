package com.better.learn.generic;

/**
 * Created by better on 2022/4/5.
 */
public class PeopleTest {
    public static void main(String[] args) {
        People<String> test = new People<>();
        System.out.println(test.getClass());
        System.out.println(test.getClass().getSuperclass());
        System.out.println(test.getClass().getGenericSuperclass());
    }
}
