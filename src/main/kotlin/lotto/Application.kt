package lotto

import lotto.controller.LottoController

fun main() {

    val lottoGame = LottoController()
    try {
        lottoGame.start()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}