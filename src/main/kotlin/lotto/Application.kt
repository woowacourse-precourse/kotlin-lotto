package lotto

fun main() {
    try {
        Lottery(
            Computer()
        ).start()
    } catch (e: IllegalArgumentException) {
        Printer.printError(e.message!!)
    }
}
