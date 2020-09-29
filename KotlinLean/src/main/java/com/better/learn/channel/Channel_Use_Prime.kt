package com.better.learn.channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/**
 * 素数（Prime number），又称素数，指在大于1的自然数中，除了1和该数自身外，
 * 无法被其他自然数整除的数（也可定义为只有1与该数本身两个正因数的数）。
 * 大于1的自然数若不是素数，则称之为合数（也称为合成数）。例如，5是个素数，
 * 因为其正约数只有1与5。而6则是个合数，因为除了1与6外，2与3也是其正约数。
 * 算术基本定理确立了素数于数论里的核心地位：任何大于1的整数均可被表示成一串唯一素数之乘积。
 * 为了确保该定理的唯一性，1被定义为不是素数，因为在因式分解中可以有任意多个1（如3、1×3、1×1×3等都是3的有效约数分解）。
 * https://zh.wikipedia.org/wiki/%E8%B4%A8%E6%95%B0
 */
fun main() {
    //让我们来展示一个极端的例子——在协程中使用一个管道来生成素数。
    runBlocking {
        var number = createNumber(2)
        repeat(4) {
            val prime = number.receive()
            println(prime)
            number = prime(number, prime)
        }
        coroutineContext.cancelChildren()
    }
}

/**
 * 在下面的管道阶段中过滤了来源于流中的数字，删除了所有可以被给定素数整除的数字。
 */
fun CoroutineScope.prime(channel: ReceiveChannel<Int>, prime: Int): ReceiveChannel<Int> = produce {
    for (x in channel) {
        println("$prime: calculate $x")
        if (x % prime != 0) {
            send(x)
        }
    }
}