package com.better.learn

import kotlinx.coroutines.*
import java.lang.Exception
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    System.out.println("____")
    runBlocking {
        val workScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        val counter = AtomicInteger()
        counter.set(0)
        val array = (0..3)
        val jobs = array.map {
            workScope.launch {
                delay(3000)
                counter.incrementAndGet()

            }
        }
        val scope = this
        launch {
            delay(1000)
            println("cancel workScope")
            workScope.coroutineContext.cancelChildren()
        }
        jobs.forEach {
            try {
                it.join()
            } catch (e: Exception) {
                println(e)
            }
        }

        // 更新状态
        val suc = counter.get()
        println(suc)
        scope.launch {
            println("after workScope canceled")
        }
    }
}