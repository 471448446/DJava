package better.kotlin.functional

/**
 * Created by better on 2019/6/16.
 */
class Work {
    private fun speck() = "speck() from Work"
    fun talk() = "talk() from Work"
}

fun Work.speck() = "speck() from extension"
fun Work.talk() = "talk() from extension"
fun main(args: Array<String>) {
    val work = Work()
    System.out.println(work.speck())
    System.out.println(work.talk())
}