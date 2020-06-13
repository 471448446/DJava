package com.better.demclassloader.hotfix;

/**
 * Created by better on 2020/6/12 8:11 AM.
 */
public class SayException implements ISay {
    @Override
    public String saySomething() {
        return "everything ok";
    }
}
