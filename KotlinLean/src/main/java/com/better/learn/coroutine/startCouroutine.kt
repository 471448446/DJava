package com.better.learn.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/05_Concurrency
 * 1. 同一个scope中启动的协程都完成后，scope才结束
 * 2. launch只是启动一个新的协程，并没有等待的意思，async才会有等待的功能
 * 3. awaitAll()和多次调用launch都是可以并发执行协程，只不过awaitAll()效果好点
 */
fun main() {

    val repeats = 0..9
    var castAllWork: Long = measureTimeMillis {
        runBlocking {
            val cast = measureTimeMillis {
                for (i in repeats) {
                    launch {
                        work(i)
                    }
                }
            }
            println("done launch $cast")
        }
    }
    println("all launch cast $castAllWork")

    castAllWork = measureTimeMillis {
        runBlocking {
            val cast = measureTimeMillis {
                for (i in repeats) {
                    val deferred = async {
                        work(i)
                    }
                    deferred.await()
                }
            }
            println("done async $cast")
        }
    }
    println("all async cast $castAllWork")
    castAllWork = measureTimeMillis {
        runBlocking {
            val cast = measureTimeMillis {
                val list: ArrayList<Deferred<Unit>> = ArrayList()
                for (i in repeats) {
                    val deferred = async {
                        work(i)
                    }
                    list.add(deferred)
                }
                list.awaitAll()
            }
            println("done all async $cast")
        }
    }
    println("all async concurrency cast $castAllWork")
/*
D:\Software\Java\jdk1.8.0_171\bin\java.exe "-javaagent:D:\Software\JetBrains\IntelliJ IDEA Community Edition 2020.3\lib\idea_rt.jar=53907:D:\Software\JetBrains\IntelliJ IDEA Community Edition 2020.3\bin" -Dfile.encoding=UTF-8 -classpath D:\Software\Java\jdk1.8.0_171\jre\lib\charsets.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\deploy.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\access-bridge-64.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\cldrdata.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\dnsns.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\jaccess.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\jfxrt.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\localedata.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\nashorn.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunec.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunjce_provider.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunmscapi.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\sunpkcs11.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\ext\zipfs.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\javaws.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jce.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jfr.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jfxswt.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\jsse.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\management-agent.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\plugin.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\resources.jar;D:\Software\Java\jdk1.8.0_171\jre\lib\rt.jar;D:\WP\gitHub\DJava\KotlinLean\build\classes\kotlin\main;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlinx\kotlinx-coroutines-core\1.4.2\4b9c6b2de7cabfb2c9ad7a5c709b1ddb7bbfd2ad\kotlinx-coroutines-core-1.4.2.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-jdk8\1.4.21\3ad7f99fb330947a12451ea16767d192d763600a\kotlin-stdlib-jdk8-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib\1.4.21\4a668382d7c38688d3490afde93b6a113ed46698\kotlin-stdlib-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-common\1.4.21\7f48a062aa4b53215998780f7c245a4276828e1d\kotlin-stdlib-common-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-stdlib-jdk7\1.4.21\26b6082f9296911bdcb8e72a7cc68692c7025a03\kotlin-stdlib-jdk7-1.4.21.jar;C:\Users\Administrator\.gradle\caches\modules-2\files-2.1\org.jetbrains\annotations\13.0\919f0dfe192fb4e063e7dacadee7f8bb9a2672a9\annotations-13.0.jar com.better.learn.coroutine.TestKt
done launch 5
0
1
2
3
4
5
6
7
8
9
all launch cast 169
0
1
2
3
4
5
6
7
8
9
done async 1092
all async cast 1092
0
1
2
3
4
5
6
7
8
9
done all async 125
all async concurrency cast 127

Process finished with exit code 0
 */
}

private suspend fun work(i: Int) {
    delay(100)
    println(i)
}