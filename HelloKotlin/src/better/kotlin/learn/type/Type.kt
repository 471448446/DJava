package better.kotlin.learn.type

/**
 * Created by better on 2017/8/11.
 */
class Food<T>(something: T) {
    val food: T = something
}

/**
 * 类型限制，比起Food限制增强了
 */
class FoodNotNull<T : Any>(something: T) {
    val food: T = something
}

fun main(args: Array<String>) {
    val foodInt = Food(1)
    val foodNull = Food(null)

//    val foodPlus =FoodNotNull(null)

}