package better.kotlin.learn.objects

/**
 * java中可以用接口申明常量，
 * Created by better on 2017/6/3.
 */
interface Constant {
    val man: Int
        get() = 1
    val woman: Int
        get() = 0
}

enum class Sex(var type: Int) {
    woman(1), man(0)
}