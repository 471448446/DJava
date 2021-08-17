[`Drop.kt`](OperateDrop.kt)

* `Array.drop(count)`,丢弃前count个元素
* `Arrar.dropLast(count)` 丢弃后面的count个元素
* `Array.dropWhile(predicate)` 从头到尾尝试丢弃元素，如果元素满足条件就丢弃，否正不满足给定的条件就停止丢弃，停止丢弃意味着，后面的元素会被保留下来。
* `Array.dropLastWhile(predicate)` 这个跟`dropWhile`类似，不过是从尾到头尝试丢弃元素，只要有元素不满足给的的条件就停止丢弃。

`dropWhile`用于丢弃集合中满足某个条件之前的元素，或者说保留后面一段的元素。而`filter`是整个集合中过滤满足条件的元素。

[`OperateReduce.kt`](OperateReduce.kt) 遍历集合累计值

* `reduce()` 从左到右遍历集合累计值
* `fold()` 从左到右遍历集合累计值，但是提供了一个初始值