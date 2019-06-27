package com.better.learn.kotlin.collections

fun main() {
    val a1 = arrayListOf(1, 2, 3)
//   fold 带着初始值遍历
    var r = a1.fold(1, { a, b ->
        val ret = a + b
        System.out.println("fold() a = $a,b = $b return = $ret")
        ret
    })
    System.out.println("r = $r")
    // 从右边开始遍历
    r = a1.foldRight(1, { a, b -> a })
    System.out.println("r = $r")
//    reduce 也是遍历，但是没有初始值，第一次就之前前两个
    r = a1.reduce { acc, i ->
        System.out.println("reduce() acc = $acc,i = $i return = ${acc + i}")
        acc + i
    }
    System.out.println("reduce() = $r")
    // 从右边开始遍历
    r = a1.reduceRight { i, acc ->
        System.out.println("reduceRight() acc = $acc,i = $i return = ${acc + i}")
        i + acc
    }
    System.out.println("reduceRight() = $r")

}