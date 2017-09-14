package better.kotlin.learn.`object`

/**
 * 创建了一个View类的单列
 * Created by better on 2017/8/9.
 */
object SingletonView : View() {
    fun setClick(l: CallBackOneInJava) {
        l.OnClick("Hello")
    }
}