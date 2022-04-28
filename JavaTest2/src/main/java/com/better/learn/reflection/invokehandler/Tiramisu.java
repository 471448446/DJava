package com.better.learn.reflection.invokehandler;

public class Tiramisu implements Meal {
    @Override
    public String name() {
        return "Tiramisu";
    }

    @Override
    public float price() {
        return 0.5f;
    }
}
