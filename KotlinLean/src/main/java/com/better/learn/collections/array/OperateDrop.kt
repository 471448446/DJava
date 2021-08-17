package com.better.learn.collections.array

/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/drop-while.html
 * https://stackoverflow.com/questions/19352030/why-list-dropwhile-doesnt-work/19352082
 * https://stackoverflow.com/questions/57175546/what-will-be-the-result-for-the-dropwhile-in-scala
 */
fun main() {
    val chars = ('a'..'z').toList()
    println(chars.drop(23)) // [x, y, z]
    println(chars.dropLast(23)) // [a, b, c]
    // it stops dropping as long as the condition is no longer met
    // dropWhile will continue to drop elements from the list until it hits that x (it < 'x' not match)
    println(chars.dropWhile { it < 'x' }) // [x, y, z]
    println(chars.dropLastWhile { it > 'c' }) // [a, b, c]
    println(chars.filter { it > 'x' })//[y, z]
    // 丢弃负数，直接用filter不是更好？
    // dropWhile的时候，不要带有filter思想，他只是无脑丢弃元素，遇到满足规则的就停止丢弃
    val droppedWhileNegative = (-3..3).dropWhile { it < 0 }
    println(droppedWhileNegative)
    // 下面就是一个列子：如何丢弃一段重复的元素，
    // 一个集合[0,0,0,0,0,3,5,0,2,5]，丢弃3前面的0，而且保留后后面的0.这种情况用filter就不好操作
    // https://stackoverflow.com/questions/64310504/how-to-remove-duplicate-ints-before-a-certain-element-in-scala/64315780#64315780
    val array = arrayOf(0, 0, 0, 0, 0, 3, 5, 0, 2, 5)
    println(array.dropWhile { it == 0 })
    // dropWhile 用于丢弃集合中满足某个条件之前的元素，或者说保留后面一段的元素
    // https://stackoverflow.com/questions/17332666/remove-items-in-list-before-a-matched-item-groovy/17332915#17332915
}