package com.better.learn.coroutine.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.RENDEZVOUS
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED

fun main() {
    runBlocking {
        // 无限容量限制的channel,
        // 发送端可以无脑发送，不会suspend
        // 接收端在没有数据的时候会suspend等待
        println(".....unlimitedChannel...")
        val unlimitedChannel = Channel<Int>(UNLIMITED)
        // 结果：发送端一直在工作，中途打印了结果端的数据
        startChannel(this, unlimitedChannel)

        // 带有缓冲的channel或者是有容量的channel
        // 发送端发送的数据，到达最大的容量后会suspend暂停发送
        // 接收端没有数据时，也会suspend
        println(".....bufferChannel...")
        val bufferChannel = Channel<Int>(2)
        // 结果：发送端到达容量后，等待，接收端处理数据后，发送端在哪继续发送数据
        startChannel(this, bufferChannel)

        // 容量为0的channel
        // 发送端和接收端总是会有一个被suspend
        // 一端调用后，另外一端才能开始工作，并且另外一端会被暂停
        println(".....rendezvousChannel...")
        val rendezvousChannel = Channel<Int>(RENDEZVOUS)
        // 发送端发送一个数据，接收端处理一个数据
        startChannel(this, rendezvousChannel)

        //折叠的channel
        // 发送端无脑发送数据，但是接收端会取最新的数据
        // 接收端在channel为空时会暂停
        println(".....conflateChannel...")
        val conflateChannel = Channel<Int>(CONFLATED)
        // 除第一次外(因为第一次两个都起来工作了，刚好channel里面只有一个值)，后面的都是发送端发送了多个值，但是接收端只处理最新的一个值
        startChannel(this, conflateChannel)
    }
}

private suspend fun startChannel(scope: CoroutineScope, channel: Channel<Int>) {
    // 接收端每隔200ms接收一个值
    scope.launch {
        println("receiver work")
        for (i in channel) {
            println("receive:$i")
            delay(200)
        }
    }
    // 确保接收端先工作
    delay(100)
    // 发送端，每个20ms发送一个值
    scope.launch {
        println("sender work")
        for (i in (0 until 10)) {
            println("send: $i")
            channel.send(i)
            delay(20)
        }
    }
    // 只让channel执行1秒，然后全部退出
    delay(1000)
    scope.coroutineContext.cancelChildren(CancellationException("-----------force quit-----------"))
}
/*
D:\Software\Java\jdk1.8.0_171\bin\java.exe "-javaagent:D:\Software\JetBrains\IntelliJ IDEA Community Edition 2020.3\lib\idea_rt.jar=57968:D:\Software\JetBrains\IntelliJ IDEA Community Edition 2020.3\bin" -Dfile.encoding=UTF-8 -classpath D:\Software\Java\jdk1.8.0_171\jre\lib\charsets.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\deploy.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\access-bridge-64.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\cldrdata.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\dnsns.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\jaccess.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\jfxrt.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\localedata.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\nashorn.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunec.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunjce_provider.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunmscapi.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunpkcs11.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\zipfs.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\javaws.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jce.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jfr.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jfxswt.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jsse.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\management-agent.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\plugin.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\resources.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\rt.jar;D:\WP\gitHub\DJava\KotlinLean\build\classes\kotlin\main;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlinx\kotlinx-coroutines-core\1.4.2\4b9c6b2de7cabfb2c9ad7a5c709b1ddb7bbfd2ad\kotlinx-coroutines-core-1.4.2.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-jdk8\1.4.21\3ad7f99fb330947a12451ea16767d192d763600a\kotlin-stdlib-jdk8-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib\1.4.21\4a668382d7c38688d3490afde93b6a113ed46698\kotlin-stdlib-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-common\1.4.21\7f48a062aa4b53215998780f7c245a4276828e1d\kotlin-stdlib-common-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-jdk7\1.4.21\26b6082f9296911bdcb8e72a7cc68692c7025a03\kotlin-stdlib-jdk7-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains\annotations\13.0\919f0dfe192fb4e063e7dacadee7f8bb9a2672a9\annotations-13.0.jar com.better.learn.coroutine.channel.Channel_CreateKt
.....unlimitedChannel...
receiver work
sender work
send: 0
receive:0
send: 1
send: 2
send: 3
send: 4
send: 5
send: 6
send: 7
receive:1
send: 8
send: 9
receive:2
receive:3
receive:4
.....bufferChannel...
receiver work
sender work
send: 0
receive:0
send: 1
send: 2
send: 3
receive:1
send: 4
receive:2
send: 5
receive:3
send: 6
receive:4
send: 7
.....rendezvousChannel...
receiver work
sender work
send: 0
receive:0
send: 1
receive:1
send: 2
receive:2
send: 3
receive:3
send: 4
receive:4
send: 5
.....conflateChannel...
receiver work
sender work
send: 0
receive:0
send: 1
send: 2
send: 3
send: 4
send: 5
send: 6
receive:6
send: 7
send: 8
send: 9
receive:9

Process finished with exit code 0

 */