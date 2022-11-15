package lotto

import lotto.controller.LottoController

fun main() {
        try {
                LottoController().gameStart()
        } catch (e: IllegalArgumentException){}
}


