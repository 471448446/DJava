package com.better.learn.collections.sequence

/**
 * https://www.kotlincn.net/docs/reference/sequences.html
 */
fun main() {
    /*
        sequence
        1. 是对集合中的每个元素进行一整套变换。就是对每个元素执行filter、map。而不是执行完filter后，将结果进行map
        2. 直到有结果操作请求时，才进行转换
        所以要将filter的放在map之前，就是将过滤操作放到map之前，这里操作可以减少执行步骤
     */
    val sequence = (1..5).asSequence()
        .filter {
            System.out.println("filter $it")
            it > 2
        }
        .map {
            System.out.println("map $it")
            "$it mapped"
        }

    System.out.println("___start to List")
    val result = sequence.toList()
    System.out.println("___iterate result list")
    result.forEach {
        System.out.println("result $it")
    }
}