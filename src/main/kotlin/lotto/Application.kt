package lotto

import lotto.ui.LottoGame

fun main() {
    val game = LottoGame()
    try {
        game.start()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
