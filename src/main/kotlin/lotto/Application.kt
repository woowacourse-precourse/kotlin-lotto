package lotto

fun main() {
    try {
        val controller = Controller()
        controller.run()
    } catch (e: Exception) {
        MessageMaker.errorMessage()
    }
}
