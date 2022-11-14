package lotto

import java.lang.Math.pow
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.round

fun main() {
    TODO("프로그램 구현")
}

fun calEarningRate(purchasePrize: Int, winningPrize: Int): Double {
    return roundDigit(winningPrize.toDouble() / purchasePrize.toDouble())
}

// 소숫점 둘 째자리에서 반올림한다.
fun roundDigit(number: Double): Double {
    return round(number * 1000.0) * 10.0.pow(-1.0)
}