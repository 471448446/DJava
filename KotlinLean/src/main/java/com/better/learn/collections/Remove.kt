package com.better.learn.collections

fun main() {
    val l = mutableListOf(1, 2, 3, 22, 1, 4, 4, 3, 2)
    val iterator = l.iterator()
    while (iterator.hasNext()) {
        iterator.next().also {
            if (it == 1) {
                iterator.remove()
            }
        }
    }
    //error same in Java
    l.forEach {
        if (it == 1) {
            l.remove(it)
        }
    }
}