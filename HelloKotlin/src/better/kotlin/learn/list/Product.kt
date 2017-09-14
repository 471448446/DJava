package better.kotlin.learn.list

import better.kotlin.log

/**
 * Created by better on 2017/8/10.
 */
fun main(args: Array<String>) {
    testListProduct()
}

fun testListProduct() {
    mergeM()
    partition()
}

/**
 * 把一个给定的集合分割成两个，第一个集合是由原集合每一项元素匹配给定函数条件返回true的元素组成，
 * 第二个集合是由原集合每一项元素匹配给定函数条件返回false的元素组成。
 */
fun partition() {
    log("分割：" + list.partition { it % 2 == 0 })

}

fun mergeM() {
//    log("合并："+ list.merge(listEqual))
}
