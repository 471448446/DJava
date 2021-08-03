
[如何启动](https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/05_Concurrency)

协程只能是在coroutineScope中启动
1. 比如通过launch启动，后会返回一个job，可以通过job来控制协程，比如cancel，join
2. 同一个scope中一个执行完后执行才下一个协程
3. 轻量级

使用launch, async, or runBlocking启动协程
async和launch区别
1. launch启动协程是返回的一个job，通过操作这个job来控制协程的生命周期，比如cancel()，jon()。launch是运行就启动了。
2. async启动协程是先申明要运行的协程，在合适的时机通过Deferred.await()来运行。
3. runBlocking启动的协程会阻塞当前的线程，在其内部，可以启动其他的协程。

[并发性 concurrency](https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/05_Concurrency)

如何启动多个协程，得到一组结果。
单个async会返回一个Deferred，然后调用Deferred.await()来获取结果，如果是一个集合可以awaitAll()获取所有的结果。这种方式所有的协程都会运行，并发了。

[Structured concurrency 结构化并发](https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/06_StructuredConcurrency)

有点拗口
1. 协程是在coroutineScope中启动，协程被启动后，就跟它的coroutineScope有了父子关系。协程中也可以启动协程，被启动的协程和原先的协程也有了父子关系。父协程只有等它的所有子协程执行完成后，才算执行完成。取消父协程，它的所有的自协程也会被去掉。
2. 这种父子关系，父协程会向子协程会传递协程的上下文，比如调度器Dispatcher。
3. 这里有种特殊情况GlobalScope是直接创建一个全局的协程，如果在父协程中创建这个全局的协程，是没有这种父子关系的。
4. 而GlobalScope也是提高了一种创建scope的方式，比如coroutineScope()方法也提高了船舰scope的方式。所以在其内部是满足父子协程关系的。

[Channels](https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/08_Channels)

channel是用于协程间通信的一种方式，一边放数据到池子中，一边从池子中取数据，生产消费模型，这里的池子就是管道。生产消费模型中有个问题就是两边数据生产或者消耗的速度不一致问题，没有数据时要不要等待。所以这里根据池子的大小有区别。发送端send()方法，接收端receive()方法。在线程中等待时挂起当前线程，而这里时协程，就是挂起当前协程。
1. 管道无缓存大小限制。既是send不会等待，可以无限的放数据。管道中数据过多，会OOM。而接收端，在没有数据的时候会等待。`val unlimitedChannel = Channel<String>()`
2. 管道有缓存大小限制。当到达管道大小限制后，发送端无法再发送数据，会等待，协程被挂起。等到接收端消耗数据后，才能继续发送。`val bufferedChannel = Channel<String>(10)`
3. 实时管道。管道是没有缓存大小的。所谓实时就是希望数据立马被消耗。如果发送了数据，没有接收者，那么发送放会等待。如果准备接收数据，发现没有已经发送的数据，那么接收方会等待。这样发送或者接收方，总是会等待，直到另外一方调用。`val rendezvousChannel = Channel<String>(UNLIMITED)`
4. 合并管道。管道中数据是最新的。既接收方，接收到的数据始终是发送方最新发送的。`val conflatedChannel = Channel<String>(CONFLATED)`
