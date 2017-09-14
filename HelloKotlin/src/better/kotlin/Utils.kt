package better.kotlin

/**
 * 常用工具类，kotlin中默认访问控制是public的，即：到处可见
 * Created by better on 2017/5/29.
 */

fun log(a: String) {
    println(a)
}

fun logPart(a: String) {
    println("____{$a}____")
}

fun logStart(a: String) {
    println(a + " start")
}

fun logEnd(a: String) {
    println(a + " end")
}
