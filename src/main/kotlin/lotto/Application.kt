package lotto

import lotto.controller.LottoController
import lotto.util.Constant.Companion.ERROR_EXIT

fun main() {
    try {
        var lottoController = LottoController()
        lottoController.startLotto()
    } catch (e : IllegalArgumentException) {
        println(ERROR_EXIT)
    }
}
