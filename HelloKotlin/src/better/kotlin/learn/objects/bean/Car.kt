package better.kotlin.learn.objects.bean

/**
 * Created by better on 2017/6/4.
 */
data class Car constructor(var name: String, var price: Double) {
    /**
     * 默认是：Ford(name=Ford, model=Focus)
     * Car(name=宝马,price=0)
     */
    override fun toString(): String {
        return "name:$name,price:$price"
    }
}