package com.better.learn.functional

import java.util.ArrayList

// 函数作为返回值==>闭包
// 变量i被翻译成了final
//https://www.liaoxuefeng.com/wiki/1022910821149312/1023021250770016
fun sumOneArray(): List<() -> Int> {
    val tmp = ArrayList<() -> Int>()
    for (i in (1 until 4)) {
        tmp.add {
            i * i
        }
    }
    return tmp
}

fun main() {
    val list = sumOneArray()
    for (function in list) {
        println(function.invoke())
    }
}
