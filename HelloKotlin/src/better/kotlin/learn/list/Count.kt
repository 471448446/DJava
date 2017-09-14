package better.kotlin.learn.list

import better.kotlin.log

/**
 * 针对集合中的个数：找，遍历，归到一起
 * Created by better on 2017/8/10.
 */
val list = listOf(12, 11, 9999, 0, -1, 2)
val listEqual = listOf(1, 1)
val listEmpty = listOf<Int>()
val listWithNull = listOf(1, null, 100, -10, 0)

fun main(args: Array<String>) {
    testListCount()
}

/*
  any()
    all()
    count()

    fold()
    foldRight()
    forEachM()
    forEachIndexed()

    maxM()
    maxByM()
    minM()
    minByM()

    none()

    reduceM()
    reduceRightM()

    sumBy()
 */
private fun testListCount() {
    any()
    all()
    maxM()
    maxByM()
    minM()
    minByM()
    none()


    fold()
    foldRight()
    reduceM()
    reduceRightM()
    forEachM()
    forEachIndexed()


    count()
    sumBy()
}

/**
 * 返回所有每一项通过函数转换之后的数据的总和。+
 */
fun sumBy() {
    log("根据规则求和" + list.sumBy { i ->
        log("_步骤：$i")
        i % 2
    })
}

fun reduceRightM() {
    log("叠加 reduce:" + list.reduceRight { result, item ->
        log("_步骤：$result,$item")
        result + item
    })
}

/**
 * 与fold一样，但是没有一个初始值。通过一个函数从第一项到最后一项进行累计。+
 */
fun reduceM() {
    log("叠加 reduce:" + list.reduce { result, item ->
        log("_步骤：$result,$item")
        result + item
    })
}

/**
 * 如果没有任何元素与给定的函数匹配，则返回true。+
 */
fun none() {
    log("没有被7整除的元素：${list.none { it % 7 == 0 }}")
}

fun minByM() {
    log("最大的：${list.minBy { -it }}")
}

fun minM() {
    log("最大元素：list=${list.min()}")
    log("最大元素：listEqual=${listEqual.min()}")
    log("最大元素：listEmpty=${listEmpty.min()}")
}

/**
 * 根据给定的函数返回最大的一项，如果没有则返回null。
 */
fun maxByM() {
    log("最大的：${list.maxBy { -it }}")
}

/**
 * 返回最大的一项，如果没有则返回null
 */
fun maxM() {
    log("最大元素：list=${list.max()}")
    log("最大元素：listEqual=${listEqual.max()}")
    log("最大元素：listEmpty=${listEmpty.max()}")
}

/**
 * 遍历并带index
 */
fun forEachIndexed() {
    list.forEachIndexed { index, i -> log("遍历得到元素：$index,$i") }
}

/**
 * 遍历，怎么样使用传参的高阶方法
 */
fun forEachM() {
    list.forEach {
        log("编列数据：$it")
    }
}

/**
 * 与fold一样，但是顺序是从最后一项到第一项。
 */
fun foldRight() {
    log("叠加：" + list.foldRight(1) { result, item ->
        log("_步骤：$result,$item")
        result + item
    })
}

/**
 * 叠加在一个初始值的基础上从第一项到最后一项通过一个函数累计所有的元素
 */
fun fold() {
    log("叠加" + list.fold(1) { result, item ->
        log("_步骤：$result,$item")
        result + item
    })
}

/**
 * 返回符合给出判断条件的元素总数。
 */
fun count() {
    log("能被2整除的个数有：" + list.count { it % 2 == 0 })
}

/**
 * 如果全部的元素符合给出的判断条件，则返回true。
 */
fun all() {
    log("全部大于0？" + list.all { it > 0 })
}

/**
 * 如果至少有一个元素符合给出的判断条件，则返回true。
 */
fun any() {
    log("含有0？" + list.any { it == 0 })
}
