package lotto

import lotto.controller.LottoController
import java.lang.IllegalArgumentException

fun main() {
    val lottoController = LottoController()
    try {
        lottoController.startLotto()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
/*    try {
        var lottoController = LottoController()
        lottoController.startLotto()
    } catch (e : IllegalArgumentException) {
        println(ERROR_EXIT)
    }*/
}
