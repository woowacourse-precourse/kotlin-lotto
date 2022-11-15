package lotto.util

import kotlin.math.pow
import kotlin.math.roundToLong

fun Double.roundAt(n: Int): Double {
    return (this * 10.0.pow(-n - 1)).roundToLong() / 10.0.pow(-n - 1)
}