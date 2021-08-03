package com.better.learn.coroutine.flow2

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * 使用try捕获了，发射端、接收端、中间转换 中产生的异常
 */
fun main() {
    runBlocking {
        //这段代码成功的在末端操作符 collect 中捕获了异常，并且， 如我们所见，在这之后不再发出任何值：
        /*========接收端=========*/
        try {
            simpleUseFlow().collect {
                println("collect $it")
                check(it <= 1)
            }
        } catch (e: Exception) {
            println("caught exception $e")
        }
        /*========发送端=========*/
        val flow = simpleException()
        try {
            flow.collect {
                println("collected $it")
            }
        } catch (e: Exception) {
//            e.printStackTrace()
            println("caught exception $e")
        }
    }
}

fun simpleException(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i) // 发射下一个值
        }
    }
        .map { value ->
            check(value <= 1) { "Crashed on $value" }
            "string $value"
        }
