package better.kotlin.learn.list

import better.kotlin.log

/**
 * Created by better on 2017/8/10.
 */
fun main(args: Array<String>) {
    testListElement()
}

fun testListElement() {
    contain()

    elementAt()
    elementAtOrElse()
    elementAtOrNull()

    first()
    firstOrNull()

    index()
    indexOfFirst()
    indexOfLast()
}

/**
 * 返回最后一个符合给定函数条件的元素的index，如果没有符合则返回-1。+
 */
fun indexOfLast() {
    log("指定符合条件方向的第一个位置，没有就-1" + list.indexOfLast { it == 4 })


}

/**
 * 返回第一个符合给定函数条件的元素的index，如果没有符合则返回-1。+
 */
fun indexOfFirst() {
    log("指定符合条件正向的第一个位置，没有就-1" + list.indexOfFirst { it == 4 })
}

/**
 * 返回指定元素的第一个index，如果不存在，则返回-1。+
 */
fun index() {
    log("指定元素的位置，没有就-1" + list.indexOf(4))
}

/**
 * 返回符合给定函数条件的第一个元素，如果没有符合则返回null。+
 */
fun firstOrNull() {
    log("符合某个条件的第一个元素,否者null：" + list.firstOrNull { it % 2 == 0 })
}

/**
 * 返回符合给定函数条件的第一个元素。+
 */
fun first() {
    log("符合某个条件的第一个元素：" + list.first { it % 2 == 0 })
}

fun elementAtOrNull() {
    log("返回某个位置元素，否者null：" + list.elementAtOrNull(9))
}

/**
 * 返回给定index对应的元素，如果index数组越界则会根据给定函数返回默认值。
 */
fun elementAtOrElse() {
    log("返回某个元素：" + list.elementAtOrElse(9) { it })
}

/**
 * 返回给定index对应的元素，如果index数组越界则会抛出IndexOutOfBoundsException。+
 */
fun elementAt() {
    try {
        log("返回某个位置的元素：" + list.elementAt(4))
    } catch (e: IndexOutOfBoundsException) {
        e.printStackTrace()
    }
}

fun contain() {
    log("列表包含元素-1？" + list.contains(-1))
}
