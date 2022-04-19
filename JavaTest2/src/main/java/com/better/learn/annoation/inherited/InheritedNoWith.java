package com.better.learn.annoation.inherited;

import java.lang.annotation.*;

/**
 * 测试：带有{@link Inherited}时，子类和子接口的区别
 * 这个不对带{@link Inherited}
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedNoWith {
    String value();
}
