package com.better.learn.coroutine.flow2

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * 发射器可以使用 catch 操作符来保留此异常的透明性并允许封装它的异常处理。catch 操作符的代码块可以分析异常并根据捕获到的异常以不同的方式对其做出反应：
 * 可以使用 throw 重新抛出异常。
 * 可以使用 catch 代码块中的 emit 将异常转换为值发射出去。
 * 可以将异常忽略，或用日志打印，或使用一些其他代码处理它
 */
fun main() {
    runBlocking {
        simpleException()
            // 在这里统一处理发射器异常
            .catch { e ->
                println("catch() exception $e")
                emit("this is catch $e")
            }
            .collect {
                println("collect: $it")
            }
        println("------------------------")
        /*透明捕获*/
        // catch() 只处理上游的异常，后面的不能处理
        val flow = flow {
            for (i in 1..3) {
                println("Emitting $i")
                emit(i)
            }
        }
        flow
            .catch { e ->
                println("catch() exception $e")
            }
            .collect {
                check(it <= 1)
                println("collect: $it")
            }

    }
}