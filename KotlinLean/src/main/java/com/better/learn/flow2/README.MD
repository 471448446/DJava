工具版本
```
IntelliJ IDEA 2020.3 (Community Edition)
Build #IC-203.5981.155, built on December 1, 2020
```

[Flow](https://www.kotlincn.net/docs/reference/coroutines/flow.html)
> 挂起函数可以异步的返回单个值，但是该如何异步返回多个计算好的值呢？这正是 Kotlin 流（Flow）的用武之地。

流是一个Kotlin中的概念，配合协程使用，表示异步的多个值。正如引文中说到，挂起函数可以返回单个值，流主要是用来异步返回多个值。发射端发射值，可以经过操作符处理值，最后接收端处理值或者说收集值。这点有点像RxJava中的订阅-发布的概念。
开篇就讲到如何表示多个值，常规的方式是集合，序列，但是集合需要一次性返回所有的值，而序列可以执行耗时操作，但是会阻塞当前线程。
这篇文章主要介绍了涉及到流的一些基础概念。流的构建，流的上下文，以及流的一些特性，比如冷的、可以被取消的、连续的。再对流运用一些操作符进行处理。最后如何检测流的异常、取消、完成。

创建多个值
1. ###### 集合，需要一次性返回所有的值。`CreateMutiValue1_Collection.kt`
2. 序列，分批次返回多个值。可以执行耗时操作，但是会阻塞当前线程。`CreateMutiValue2_Sequence.kt`
3. 使用suspend 来返回集合，虽然可以执行耗时操作，但是结果需要一次返回。`CreateMutiValue3_Suspend.kt`
4. Flow,使用流来表示多个值。可以执行耗时操作，内部使用协程来实现。`CreateMutiValue4_Flow.kt`

流构建器
1. `flow{}`。`FlowConstructor.kt`
2. `flowOf` 构建器定义了一个发射固定值集的流。
3. 使用 ` .asFlow()` 扩展函数，可以将各种集合与序列转换为流。

流特性：
1. # 流是冷的。只有当有末端操作符，消耗数据时，才会触发流的发射。`FlowFeaturesCold.kt`
2. 流是可以取消的。流是运行在协程中，协程中suspend方法取消时，流就取消了。`FlowFeaturesCancel.kt`
3. 流是连续的。流中的值，从起点，经过各种流操作符，最后到达末端操作符消耗。每个值执行完成后，才执行下一个（**顺序执行**）。
执行完成的意思是直到有末端收集器使用才算完成。连续的意思是，每个一次执行，每一个执行的时候，
顺序流过每一个操作符，到达末端。`FlowFeaturesContinuation.kt`
   * 流的**每次单独收集都是按顺序执行的**，除非进行特殊操作的操作符使用多个流。该收集过程直接在协程中运行，该协程调用末端操作符。 默认情况下不启动新协程
   * 从上游到下游每个过渡操作符都会处理每个发射出的值然后再交给末端操作符。

流的上下文
流的上下文是指流代码的运行在哪个线程。默认情况下构建器的部分会跟调用收集器时的上下文一致，比如这种代码`flow{}.collect{}`。
   * 流的上下文保存：流的收集总是在调用协程的上下文中执行。`FlowContext.kt`
   * 对于flow构建器，流的收集必须遵守上下文保存逻辑，发送端和接收端需要在一个上下文中，否则会报错。而对于其他的构建器，flowOf，asFlow
      都是直接就构建了发送端，没有机会做到不同线程的切换。这是不是就说明流的发送端和接收端必须都在一个线程呢？？通过例子来看确实是这样。`FlowContext.kt`
   * `flowOn() `，函数用于更改流发射的上下文。`FlowContextFlowOn.kt`

流操作符
流与序列的主要区别在于这些操作符中的代码可以调用挂起函数。
1. 过度操作符。map、filter。可以使用操作符转换流，就像使用集合与序列一样。过渡操作符应用于上游流，并返回下游流。
这些**操作符也是冷操作符**，就像流一样。这类操作符本身不是挂起函数。它运行的速度很快，返回新的转换流的定义。`FlowOperatorMap.kt`
2. 转换操作符。transform,它可以用来模仿简单的转换，例如 map 与 filter，以及实施更复杂的转换。`FlowOperatorTransform.kt`
使用 transform 操作符，我们可以** 发射 任意值任意次**。
3. 限长操作符。限长过渡操作符（例如 take）在流触及相应限制的时候会将它的执行取消。协程中的取消操作总是通过抛出异常来执行
这样可以通过catch来获取异常，当然，也可以不处理。`FlowOperatorTake.kt`
4. 末端操作符。末端操作符是在流上用于启动流收集的挂起函数。比如collect。`FlowOperatorEnd.kt`
   * 转换为各种集合toList、toSet
   * 获取第一个first和确保发设单个值single
   * 使用 reduce 与 fold 将流规约到单个值。
   * 使用launchIn()在当前协程中新开协程执行，不会阻塞当前协程`FlowOperatorEnd_LaunchIn.kt`
5. 缩短流执行时间，加速流
    1. 缓冲buffer()。并发执行发送端的发送数据。`FlowOperatorBuffer.kt`
    2. 合并conflate()。跳过中间值，处理最新的值。当流代表部分操作结果或操作状态更新时，可能没有必要处理每个值，
    而是只处理最新的那个。`FlowOperatorConflate.kt`
    3. 处理最新值collectLatest()。这种方式是，当收集器比较慢时，取消它，重新执行。`FlowOperatorCollectLatest.kt`
6. 组合多个流。
    1. 组合两个流zip()。严格按照index一一对应，多的会被丢弃。`FlowOperatorCombine_Zip.kt`
    2. 组合两个流combine()。并不是按照index一一对应，采用响应流的最新值进行组合，原始流每变化一次，都会触发一次组装。**这个就很不一样了**。
    这个更像是结合的意思，只要有就可以，没有时，先等到另外一个值有才结合。`FlowOperatorCombine_Combine.kt`
    3. merge()。将多个流合并在一起，流集合中的每一个发生变化，终端处都会收到对应的值。和combine不一样，它是将两个流中最新的值进行结合，结合后得出最终的值。`FlowOperatorCombine_merge.kt`
7. 展平流，如何处理包含流的流。
有点绕口，就是发送端是流`flow{}`，这个没有异议，它发生的是另外的流Flow。例如，我们得到了一个包含流的流（Flow<Flow<String>>），
需要将其进行展平为单个流以进行下一步处理。
    1. 一种打平模式是：顺序连接流中的每一个值。flatMapContact()、flattenContact()。`FlowOperatorFlat_FlatMapConcat.kt`
    2. 另一种打平模式是：（尽可能快的发送值）是并发收集所有传入的流，并将它们的值合并到一个单独的流，以便尽快的发射值。
    flatMapMerge()、flattenMerge()。`FlowOperatorFlat_FlatMapMerge.kt`
    3. 加速模式：取最新值flatMapLatest()。与 collectLatest 操作符类似（在"处理最新值" 小节中已经讨论过），
    也有相对应的“最新”展平模式，在发出新流后立即取消先前流的收集。`FlowOperatorFlat_FlatMapLatest.kt`

conflate() 和 collectLatest() 区别
当发射器和收集器都很慢的时候，

* 合并是加快处理速度的一种方式。它通过删除发射值来实现。
* 另一种方式是取消缓慢的收集器，并在每次发射新值的时候重新启动它。有一组与 xxx 操作符执行相同基本逻辑的 xxxLatest 操作符，但是在新值产生的时候取消执行其块中的代码。

检测流异常（异常流）
当运算符中的发射器或代码抛出异常时，流收集可以带有异常的完成。 有几种处理异常的方法。
1. 使用try、catch，处理收集器异常。
2. **异常透明性**。至于发射器中的异常，不应该使用try、catch方式处理，这样收集器就无法收到异常。`FlowException_Catch.kt`
    * 应该使用，catch()操作符来处理发射器的异常。`FlowException_TryCatch.kt`
    * catch() 过渡操作符遵循异常透明性，仅捕获上游异常（catch 操作符上游的异常，但是它下面的不是）`FlowException_Catch1.kt`
    * 正式由于catch() 操作符只能捕获上游异常。所有尽可能将下游的异常放到上游`FlowException_Catch2.kt`

检测流完成
如何检测流收集已经完成。

1. 命令式，在finally代码块中检测。`FlowDone_Finally.kt`
2. 申明式，通过操作符onCompletion()监听。`FlowDone_Completion.kt`
    * onCompletion 的主要优点是其 lambda 表达式的可空参数 Throwable 可以用于确定上游的流是正常完成还是有异常发生
    * 与 catch() 操作符的另一个不同点是 onCompletion 能观察到**所有异常并且仅在上游流成功完成**（没有取消或失败）的情况下接收一个 null 异常。**并没有验证到**，在下游发射一次后，还是打印的null

检测流取消
流时可以被取消的，**如何检查流的取消** `FlowFeaturesCancel_Check.kt`

1. 繁忙的流可以检查到取消(`flow{}`)，
2. 非繁忙的流(`asFlow()`、`flowOf()`)也可以转为为可以取消（`.cancelable()`）的方式，在进行取消。**并没有cancelable()**方法。