package domain

import resource.DECIMAL_PLACES
import kotlin.math.roundToLong

class Calculator {
    fun calculateWinningRate(result: List<Int>, money: Int): Double {
        val sum = Winning.getAllPrize(result)
        val rate = (sum.toDouble() / money.toDouble()) * 100

        return roundDecimal(rate)
    }

    fun calculateWinnings(lottos: List<Lotto>, winnings: List<Int>, bonus: Int): List<Int> {
        val result = mutableListOf(0, 0, 0, 0, 0)
        for (lotto in lottos) {
            val prize = lotto.getWinningRank(winnings, bonus)
            if (prize == -1) {
                continue
            }
            result[prize]++
        }

        return result
    }

    fun roundDecimal(number: Double): Double {
        var decimalPlaces = 1.0
        for (i in 0 until DECIMAL_PLACES - 1) {
            decimalPlaces *= 10
        }

        return ((number * decimalPlaces).roundToLong()) / decimalPlaces
    }
}