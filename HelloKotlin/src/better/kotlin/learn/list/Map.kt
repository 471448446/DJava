package better.kotlin.learn.list

import better.kotlin.log

/**
 * 映射相关
 * Created by better on 2017/8/10.
 */
fun main(args: Array<String>) {
    testListMap()
}

fun testListMap() {
//    flatMap()
//    groupBy()
//    mapM()
    mapIndex()
//    mapNull()
}

fun mapIndex() {
    log("前面三个元素小于12的变为null：" + list.mapIndexed { index, i ->
        log("mapIndex步骤：$index")
        if (index < 3) {
            if (i > 12) {
                i
            } else {
                null
            }
        } else i
    }
    )
}

/**
 *返回一个每一个非null元素根据给定的函数转换所组成的List。
 */
fun mapNull() {
    //Error:(39, 58) Kotlin: Infix call corresponds to a dot-qualified call 'it.times(2)' which is not allowed on a nullable receiver 'it'. Use '?.'-qualified call instead
//    log("所有非null的元素都乘以2：" + listWithNull.mapNotNull { it * 2 })
    log("所有非null的元素都乘以2：" + listWithNull.mapNotNull {
        if (null != it) {
            it * 2
        } else {
            null
        }
    })
    log("所有非null的元素：" + listWithNull.mapNotNull { it })
}

fun mapM() {
    log("整体乘以2：" + list.map { it * 2 })
}

/**
 * 返回一个根据给定函数分组后的map。
 * 可以用来分组列表中的杂乱数据
 */
fun groupBy() {
    log("按能被2整除的分组：" + list.groupBy { if (it % 2 == 0) "能被整除的" else "不合适的数据" })
}

/**
 * 遍历所有的元素，为每一个创建一个集合，最后把所有的集合放在一个集合中。
 * 有什么用？
 */
fun flatMap() {
    log("flatMap：${list.flatMap {
        log("_步骤：$it")
        listOf(it, 1)
    }}")
}
