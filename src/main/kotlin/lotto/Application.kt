package lotto

import java.lang.Math.pow
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.round

fun main() {
    TODO("프로그램 구현")
}

fun calEarningRate(purchasePrize: Int, winningPrize: Int): String {
    val dec = DecimalFormat("#,###.0")
    return dec.format(
        (winningPrize * 100.0).toBigDecimal().divide(purchasePrize.toBigDecimal(), 1, RoundingMode.FLOOR)
    )
}
