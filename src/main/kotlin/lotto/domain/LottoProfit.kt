package lotto.domain

import lotto.PRICE_RATE_MESSAGE

class LottoProfit(val lottoWinner: List<Int>, val userGameAmount: Int) {

    init {
        print(PRICE_RATE_MESSAGE.format(calLottoProfit() * 100))
    }

    fun calLottoProfit(): Double {
        val priceTag = listOf(5000.0, 50000.0, 1500000.0, 30000000.0, 2000000000.0)
        var sumPrice = 0.0
        for (i in lottoWinner.indices) {
            sumPrice += priceTag[i] * lottoWinner[i]
        }
        return sumPrice / (userGameAmount.toDouble())
    }

}