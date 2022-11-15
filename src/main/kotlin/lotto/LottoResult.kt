package lotto

import kotlin.math.round

enum class LottoResult(
    val rank: String,
    val price: Int,
    var count: Int = 0
) {
    Rank5("3개일치", 5000, 0),
    Rank4("4개일치", 50000, 0),
    Rank3("5개일치", 1500000, 0),
    Rank2("5개일치, 보너스 볼 일치", 30000000, 0),
    Rank1("6개일치", 2000000000, 0);

    companion object {
        fun getWinningResult(winningNumber: List<Int>) {
            Lotto.lotteries.forEach {
                when (checkEqualNumber(winningNumber, it)) {
                    listOf(3, 0) -> Rank5.count++
                    listOf(4, 0) -> Rank4.count++
                    listOf(5, 0) -> Rank3.count++
                    listOf(5, 1) -> Rank2.count++
                    listOf(6, 0) -> Rank1.count++
                }
            }
        }


        fun calculateProfit(cost: Int): Double {
            var profitRate = 0.0

            for (prize in enumValues<LottoResult>()) {
                profitRate += prize.price * prize.count
            }

            profitRate = profitRate / cost * 100
            profitRate = round(profitRate * 10) / 10

            return profitRate
        }


        private fun checkEqualNumber(winningNumber: List<Int>, lottoNumber: List<Int>): List<Int> {
            val count = mutableListOf(0, 0)

            for (index in 0 until winningNumber.size - 1) {
                if (lottoNumber.contains(winningNumber[index]))
                    count[0] += 1
            }

            if (count[0] == 5 && lottoNumber.contains(winningNumber.last()))
                count[1] += 1

            return count
        }
    }
}