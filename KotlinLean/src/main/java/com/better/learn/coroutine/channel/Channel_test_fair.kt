package com.better.learn.coroutine.channel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val channel = Channel<String>()
        launch(Dispatchers.IO) {
            for (c in Channel_test_send.text.toCharArray()) {
                println("-->$c")
                channel.send("$c")
            }
            channel.close()
        }
        var pend = ""
        launch(Dispatchers.IO) {
            channel.consumeEach {
                pend += it
                println("<--$it")
            }
            println(pend)
        }
    }
}

class Channel_test_send {
    companion object {
        val text =
            "1.计时器通道是一种特别的会合通道，每次经过特定的延迟都会从该通道进行消费并产生 Unit。 虽然它看起来似乎没用，它被用来构建分段来创建复杂的基于时间的 produce 管道和进行窗口化操作以及其它时间相关的处理。 可以在 select 中使用计时器通道来进行“打勾”操作。\n" +
                    "2.使用工厂方法 ticker 来创建这些通道。 为了表明不需要其它元素，请使用 ReceiveChannel.cancel 方法。\n" +
                    "3.现在让我们看看它是如何在实践中工作的：\n" +
                    "4. 请注意，ticker知道可能的消费者暂停，并且默认情况下会调整下一个生成的元素如果发生暂停则延迟，试图保持固定的生成元素率。\n" +
                    "\n" +
                    "5.给可选的 mode 参数传入 TickerMode.FIXED_DELAY 可以保持固定元素之间的延迟。"
    }
}