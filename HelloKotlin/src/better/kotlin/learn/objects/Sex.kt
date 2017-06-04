package better.kotlin.learn.objects

/**
 * Created by better on 2017/6/3.
 */
interface Sex {
    val man: Int
        get() = 1
    val woman: Int
        get() = 0
}