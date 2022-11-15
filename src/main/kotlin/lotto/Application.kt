package lotto

fun main() {
    val world = World()
    try {
        world.purchaseLotto()
        world.publishWinningLotto()
    } catch (e: Exception) {
        println(e.message)
        return
    }

    world.showResult()
}
