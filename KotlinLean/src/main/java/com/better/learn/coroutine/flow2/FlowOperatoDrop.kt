package com.better.learn.coroutine.flow2

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val abc = ('a'..'z').toList()
        val flow = abc.asFlow()
        val r = flow
            .drop(23)
            .toList()
        //[x, y, z]
        println(
            "drop(23):\n" +
                    "I:${abc}\n" +
                    "O:${r}"
        )
        //[x, y, z]
        val r2 = flow
            .dropWhile {
                it < 'x'
            }.toList()
        println(
            "dropWhile():\n" +
                    "I:${abc}\n" +
                    "O:${r2}"
        )
    }
}