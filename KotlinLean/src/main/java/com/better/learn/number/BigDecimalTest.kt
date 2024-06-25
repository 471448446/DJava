package com.better.learn.number

import java.math.BigDecimal
import java.text.NumberFormat

fun main() {
    println(
        BigDecimal("600").setScale(2, BigDecimal.ROUND_HALF_UP).toString()
    )
    println(
        numberString(600.00)
    )
    println(
        numberString(600.10)
    )
    println(
        numberString(600.1)
    )
    println(
        numberString(600)
    )
    println(
        numberString(600.10f)
    )
    println(
        numberString(600.0f)
    )
    println(
        numberString(600.1f)
    )
    println(
        numberString(600f)
    )
    println(
        numberString(600L)
    )
}

/**
 * 最多保留2位小数
 * 1.11
 * 1.1
 * 1
 */
private fun numberString(number: Number): String {
    return NumberFormat.getNumberInstance().apply {
        maximumFractionDigits = 2
    }.format(number)
}