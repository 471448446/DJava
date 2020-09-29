package com.better.learn.collections

fun main() {
    val a1 = arrayListOf(1, 2, 3, 4)
    val any = arrayListOf(1, "Hello", 2, "World")
    // 找元素
    // elementAt,类似的
    // first，firstOrNull,firstOrElse
    // getOrNull,getOrElse
    // last,lastOrNull,lastOrElse,lastIndexOf
    // random 随机返回一个元素
    // single 返回第一个元素或者抛异常
    // 另外indexOf 返回元素的下表
    log(
        "component1 = ${a1.component1()}",
        "elementAt(1) = ${a1.elementAt(1)}",
        // it = index,
        "elementAtOrElse(4) = ${a1.elementAtOrElse(4) { it * 100 }}",
        "elementAtOrNull(4) = ${a1.elementAtOrNull(4)}"
    )
    // find 从前后找的区分 ,
    log(
        "find { it % 2 == 0 } = ${a1.find { it % 2 == 0 }}",
        "findLast { it % 2 == 0 } = ${a1.findLast { it % 2 == 0 }}"
    )
    //------舍弃某些值
    // drop 丢弃前N个值，n是负值的时候抛异常 ，dropWhile 根据一定条件丢弃值
    // dropLast 从后面丢弃N个值，dropLastWhile 根据一定条件从后面丢弃值
    log("drop(5) = ${a1.drop(5)}")
    // take 返回前n个元素，这里和drop相反 。takeLast() 从最后开始返回
    log("take(2) = ${a1.take(2)}")
    //-------筛选某些值
    // filter 过滤掉某些元素 filterIndexed ，传递index,filterIndexedTo 将符合条件的放到指定集合里面
    // filterIsInstance,筛选集合中是某个类型的值
    log(
        "filter { it % 2 == 0 } = ${a1.filter { it % 2 == 0 }}",
        "filterIsInstance<String>() = ${a1.filterIsInstance<String>()}",
        "any.filterIsInstance<String>() = ${any.filterIsInstance<String>()}"
    )
    // slice 按某个返回返回 ，这里util 时不包含终点的
    log("slice(0 until 2) = ${a1.slice(0 until 2)}")
    //-----排序
    //反序 reverse，reversed
    //排序 sort,sortBy 正序,sortByDescending 降序,sortWith 自己写两个怎么比较
    log(
        "sortByDescending = ${a1.sortByDescending { it }} ${a1.joinToString("_")}",
        "sortBy = ${a1.sortBy { it }} ${a1.joinToString("_")}"
    )
    // -----转换
    // toIntArray 等
    // associate associateBy 这个会把Key 拿来遍历一次.associateTo 转换结果放在指定集合里面。associateWith
    log(
        // 键跟值的关系
        "associate = ${a1.associate { it.toString() to it }}",
        "associateBy = ${a1.associateBy({ "k_$it" }) { it }}",
        "associateTo = ${a1.associateTo(mutableMapOf()) { it.toString() to it }}",
        // 将value 当作key，然后将值进行转变
        "associateWith = ${a1.associateWith { it }}"
    )
    // map
    //flatMap,flatMapTo
    //---------分组
    // groupBy,groupByTo,groupingBy 返回一个Grouping对象。
    // 去重
    // distinct,distinctBy 根据一定规则去重。
    ///------ 1395
    ///-----  2484


//   fold 带着初始值遍历
    var r = a1.fold(1, { a, b ->
        val ret = a + b
        System.out.println("fold() a = $a,b = $b return = $ret")
        ret
    })
    System.out.println("r = $r")
    // 从右边开始遍历
    r = a1.foldRight(1, { a, b -> a })
    System.out.println("r = $r")
//    reduce 也是遍历，但是没有初始值，第一次就之前前两个
    r = a1.reduce { acc, i ->
        System.out.println("reduce() acc = $acc,i = $i return = ${acc + i}")
        acc + i
    }
    System.out.println("reduce() = $r")
    // 从右边开始遍历
    r = a1.reduceRight { i, acc ->
        System.out.println("reduceRight() acc = $acc,i = $i return = ${acc + i}")
        i + acc
    }
    System.out.println("reduceRight() = $r")
}

private fun log(vararg s: Any) {
    System.out.println(s.joinToString(","))
}