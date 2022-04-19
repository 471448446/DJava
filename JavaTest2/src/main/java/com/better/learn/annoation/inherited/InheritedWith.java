package com.better.learn.annoation.inherited;

import java.lang.annotation.*;

/**
 * 这个带了{@link Inherited}
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InheritedWith {
    /**
     * 假设它有个描述文案
     */
    String value();
}
