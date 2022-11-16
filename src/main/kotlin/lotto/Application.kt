package lotto

import lotto.domain.LottoGames

fun main() {
    try {
        LottoGames().startGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
