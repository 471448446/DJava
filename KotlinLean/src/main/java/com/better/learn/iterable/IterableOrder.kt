package com.better.learn.iterable

fun main() {
    /*
       sequence
       1. 对每个步骤进行变换，将变换结果进行下一步变换。将集合进行filter，然后将filter结果进行map。
       2. 有变换操作时就执行
    */
    val iterable = (1..5)
        .filter {
            System.out.println("filter $it")
            it > 2
        }
        .map {
            System.out.println("map $it")
            "$it mapped"
        }

    System.out.println("___start to List")
    val result = iterable.toList()
    System.out.println("___iterate result list")
    result.forEach {
        System.out.println("result $it")
    }
}