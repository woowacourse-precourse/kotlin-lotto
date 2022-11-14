package lotto

import java.lang.IllegalArgumentException
import java.text.DecimalFormat
import kotlin.math.round

const val ERROR_NEGATIVE = "[ERROR] [ERROR] 수익률이 음수일 수는 없습니다."
const val ERROR_ROUND_UNIT = "[ERROR] 수익률은 반올림을 통해 소수 첫째 자리까지만 있어야 합니다."

enum class WinningStatistics(
    val winName: String,
    val price: Int,
    var count: Int
) {
    WIN3("3개 일치", 5000, 0),
    WIN4("4개 일치", 50000, 0),
    WIN5("5개 일치", 1500000, 0),
    WIN5Bonus("5개 일치, 보너스 볼 일치", 30000000, 0),
    WIN6("6개 일치", 2000000000, 0);

    companion object {
        var roundUnit = 10
        fun print(allPrice: Int) {
            println("\n당첨 통계")
            println("---")
            val dec = DecimalFormat("#,###")
            enumValues<WinningStatistics>()
                .map { "${it.winName} (${dec.format(it.price)}원) - ${it.count}개" }
                .forEach { println(it) }
            val returnRate = calculateReturn(allPrice)
            println("총 수익률은 ${returnRate}%입니다.")
        }

        private fun calculateReturn(allPrice: Int): Double {
            var returnRate: Double = 0.0
            for (win in enumValues<WinningStatistics>()) {
                returnRate += win.price * win.count
            }
            returnRate = (returnRate) / (allPrice) * 100
            returnRate = round(returnRate * roundUnit) / roundUnit
            returnRateException(returnRate)
            return returnRate
        }

        fun returnRateException(returnRate: Double) {
            require(returnRate >= 0) {
                println(ERROR_NEGATIVE)
                throw IllegalArgumentException(ERROR_NEGATIVE)
            }
            val regex = "[0-9]+\\.[0-9]".toRegex()
            val returnRate = returnRate.toString()
            require(returnRate.matches(regex)) {
                println(ERROR_ROUND_UNIT)
                throw IllegalArgumentException(ERROR_ROUND_UNIT)
            }
        }

        fun calculateWin(lottoes: List<List<Int>>) {
            val winNumbers = makeWinNumbers()
            for (lotto in lottoes) {
                when (countEqual(lotto, winNumbers)) {
                    listOf(3, 0) -> WIN3.count++
                    listOf(4, 0) -> WIN4.count++
                    listOf(5, 0) -> WIN5.count++
                    listOf(5, 1) -> WIN5Bonus.count++
                    listOf(6, 0) -> WIN6.count++
                }
            }
        }

        private fun countEqual(lotto: List<Int>, winNumbers: List<Int>): List<Int> {
            var count = mutableListOf(0, 0)
            for (order in 0 until winNumbers.size - 1) {
                if (lotto.contains(winNumbers[order])) {
                    count[0]++
                }
            }
            if (count[0] == 5 && lotto.contains(winNumbers.last())) {
                count[1]++
            }
            return count
        }

        fun makeWinNumbers(): List<Int> {
            val winNumbers = mutableListOf<Int>()
            for (winNumber in LottoWin.values()) {
                winNumbers.add(winNumber.number)
            }
            return winNumbers
        }

        fun clear(){
            WIN3.count=0;
            WIN4.count=0;
            WIN5.count=0;
            WIN5Bonus.count=0;
            WIN6.count=0;
        }
    }
}