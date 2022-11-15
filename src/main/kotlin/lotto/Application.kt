package lotto

fun main() {
    try {
        Lottery(
            Computer()
        ).start()
    } catch (_: IllegalArgumentException) {
    }
}
