package lotto

fun main() {
    try {
        InputLottoPrice().input()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
