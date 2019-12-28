package com.better.learn.kotlin.functional

fun main() {
    val list = listOf(1, 2, 3)
    val l1 = list.flatMap { listOf(it) }
    System.out.println("__1__$l1")
    val l2 = list.flatMap { listOf(it + 3) }
    System.out.println("__1__$l2")
    val l3 = list.flatMap { it.rangeTo(it + 2).toList() }
    System.out.println("__1__$l3")
}