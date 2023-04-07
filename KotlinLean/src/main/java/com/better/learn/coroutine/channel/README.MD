[kotlincn-Channels](https://www.kotlincn.net/docs/reference/coroutines/channels.html)
[英文：channels](https://kotlinlang.org/docs/reference/coroutines/channels.html)
[Channels](https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/08_Channels)

> 一个 Channel 是一个和 BlockingQueue 非常相似的概念。其中一个不同是它代替了阻塞的 put 操作并提供了挂起的 send，还替代了阻塞的 take 操作并提供了挂起的 receive。
> PS：BlockingQueue 是一个阻塞的队列，当队列中元素满时，再向其中放元素(put)会阻塞当前线程，同理当队列空时，再从其中取出元素(take)也会阻塞当前线程。

Channel（通道）是kotlin中用于协程间通信的工具。在不同协程间建立通道，通过通道发送数据，达到通信目的。
通道具有公平性、缓冲性、以及可以被关闭。
默认情况下通道是没有缓冲的，意味这，发送数据时，如果没有接收者，将被挂起（挂起协程，而不是阻塞）。利用缓存特性，也可以在被挂起时，发送更多的数据。缓冲其实只是增加了被挂起前发送的数量（容量）。
公平性，指的是发送和接受的顺序，是根据他们的调用先后顺序来的。
通道被关闭后，无法再发送数据，同时关闭操作，也导致接收方的迭代循环关闭

构建通道
协程生成一系列元素的模式很常见。 这是 **生产者——消费者** 模式的一部分，并且经常能在并发的代码中看到它。 你可以将生产者抽象成一个函数，并且使通道作为它的参数，但这与必须从函数中返回结果的常识相违悖。
1. 通过构造方法`Channel<>()`创建。根据Channel的容量有区别的，以及折叠未处理的值，取最新的值。[Channel_Create.kt](Channel_Create.kt)
    1. （无限容量）管道无缓存大小限制。既是send不会等待，可以无限的放数据。管道中数据过多，会OOM。而接收端，在没有数据的时候会等待。`val unlimitedChannel = Channel<String>(UNLIMITED)`
    2. （有容量限定）管道有缓存大小限制。当到达管道大小限制后，发送端无法再发送数据，会等待，协程被挂起。等到接收端消耗数据后，才能继续发送。`val bufferedChannel = Channel<String>(10)`
    3. （没有容量）实时管道。管道是没有缓存大小的。所谓实时就是希望数据立马被消耗。如果发送了数据，没有接收者，那么发送方会等待。如果准备接收数据，发现没有已经发送的数据，那么接收方会等待。这样发送或者接收方，总是会等待，直到另外一方调用。`val rendezvousChannel = Channel<String>(RENDEZVOUS)`
    4. （折叠最新的）合并管道。管道中数据是最新的。既接收方，接收到的数据始终是发送方最新发送的。`val conflatedChannel = Channel<String>(CONFLATED)`
2. 使用`produce{}`函数构建生产者通道。这就有点意思了，跟Flow一样返回的是一个代表一系列值得对象。[`ChannelConstructor.kt`](Channel_Create_Constructor.kt)


通道的特性：
1. 通道是公平的。发送和接受操作是公平，意味着，他们之前的顺序是根据他们在不同协程中调用的现后顺序来决定的。遵循先入先出规则。[`ChannelFeaturesFair.kt`](ChannelFeaturesFair.kt)
2. 关闭通道。通道是可以被关闭的。关闭发送通道可以终止通道上的接受迭代。[`ChannelFeaturesClose.kt`](ChannelFeaturesClose.kt)
    * 从概念上来说，一个 close 操作就像向通道发送了一个特殊的关闭指令。 这个迭代停止就说明关闭指令已经被接收了。所以这里保证**所有先前发送出去的元素**都在通道**关闭前**被接收到。
    * 注意，取消生产者协程将关闭它的通道，从而最终终止处理器协程正在执行的此通道上的迭代。
3. 缓冲的通道[`ChannelFeaturesBuffer.kt`](ChannelFeaturesBuffer.kt)
    * 无缓冲的通道在发送者和接收者相遇时传输元素（也称“对接”）。如果发送先被调用，则它将被挂起直到接收被调用， 如果接收先被调用，它将被挂起直到发送被调用。
    * 缓冲允许发送者在被挂起前发送多个元素， 就像 BlockingQueue 有指定的容量一样，当缓冲区被占满的时候将会引起阻塞。

通道的使用
通过`channel.send()` 发送数据,通过`channel.receive()`接受数据。两者都是suspend方法，可以被挂起。接收方可以指定接受次数`repeat()`，也可以在迭代器中一直接受`for(x in channel)`
1. 被另外一个通道消耗。我觉得这里是想说，通道中得元素可以在另外一个通道中消耗吧，这样无形中就来了一次转换map操作。[`Channel_Use_Channel.kt`](Channel_Use_Channel.kt)
2. 利用通道来求素数。不是很明白这个用法。[`Channel_Use_Prime.kt`](Channel_Use_Prime.kt)
3. 多个协程间的使用，见扇出和扇入
    1. 扇出FanOut。[`Channel_Use_FanOut.kt`](Channel_Use_FanOut.kt)
        * 多个协程也许会接收相同的管道，在它们之间进行分布式工作。
        * 多个协程从同一个通道中接受值，他们**并没有重复获取值**，而是每个只获取一次通道中的值，意思是不会同时出现，A、B两个协程都获取到X值。
    2. 扇入FanIn。[`Channel_Use_FanIn.kt`](Channel_Use_FanIn.kt)
        * 多个协程可以发送到同一个通道。这个没有什么特别的，反正只有一个接收者，发送端传入数据，接收端就收到数据。
