package lotto

fun main() {
    try {
        val controller = Controller()
        controller.run()
    } catch (e: Exception) {
        println(e.message)
    }
}
