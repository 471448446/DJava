package better.kotlin.learn.list

import better.kotlin.log

/**
 * 列表的过滤操作，按条件取，删除，
 * Created by better on 2017/8/10.
 */
val listConflict = listOf(12, 11, 9999, 0, -1, 2)

fun main(args: Array<String>) {
    testListFilter()
}

fun testListFilter() {
    drop()
    dropWhile()
    dropLastWhile()
    dropLast()

    filterM()
    sliceM()
    takeM()

}

/**
 * 返回从第一个开始的n个元素,或 返回从最后一个开始的n个元素
 * 或者 返回从第一个开始符合给定函数条件的元素
 */
fun takeM() {
    log("返回前2个元素：${list.take(2)}" + "\n" +
            "返回最后的两个元素：${list.takeLast(2)}" + "\n" +
            "返回大于0：${list.takeWhile { it > 0 }}" + "\n" +
            "返回大于0 Last：${list.takeLastWhile { it > 0 }}" + "\n" +
            "如果列表不empty返回：${list.takeIf { it.size > 0 }}" + "\n" +
            "如果列表empty返回：${list.takeUnless { it.size > 0 }}"
    )
}

/**
 * 过滤一个list中指定index的元素。
 */
fun sliceM() {
    log("只取某几位元素：${list.slice(listOf(1, 2))}")
}

/**
 * 过滤所有符合给定函数条件的元素。+
 */
fun filterM() {
    log("只要大于0的元素：${list.filter { it > 0 }}" + "\n" +
            "只要小于0的？${list.filterNot { it >= 0 }}" + "\n" +
            "排除null： ${list.filterNotNull()} " + "\n" +
            "只要Float的：${list.filterIsInstance<Float>()}" + "\n" +
            "只要前面三个元素中内部2整除的：${list.filterIndexed { index, i -> index < 3 && i % 2 == 0 }}"
    )

}

fun dropLast() {
    log("drop 最后的：" + list.dropLast(2))
}

/**
 * 只针对最后项
 */
fun dropLastWhile() {
    log("drop Last 大于0：" + list.dropLastWhile { it > 0 })

}

/**
 * 返回根据给定函数从第一项开始去掉指定元素的列表。
 */
fun dropWhile() {
    log("drop 前面大于0的 ：" + list.dropWhile { it > 0 })
}

/**
 * 返回包含去掉前n个元素的所有元素的列表
 */
fun drop() {
    log("drop:" + list.drop(2))
}
