package lotto

import lotto.controller.LottoController
import java.math.RoundingMode
import java.text.DecimalFormat

fun main() {
    try {
        LottoController().play()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
