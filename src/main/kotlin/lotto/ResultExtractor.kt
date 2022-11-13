package lotto

import java.awt.font.FontRenderContext
import java.text.DecimalFormat
import kotlin.math.round

object ResultExtractor {
    fun extractResult(
        generatedLotto: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): Map<LottoStatus, Int> {
        val result = mutableMapOf<LottoStatus, Int>()

        generatedLotto.forEach { eachLotto ->
            val lottoStatus = eachLotto.checkLotto(winningNumbers, bonusNumber)

            result[lottoStatus] = if (!result.contains(lottoStatus)) {
                1
            } else {
                result[lottoStatus]!! + 1
            }
        }
        return result.toMap()
    }

    fun showResult(extractedResult: Map<LottoStatus, Int>) {
        LottoStatus.values().forEach { eachLottoStatus ->
            var eachStatusCount = 0
            extractedResult[eachLottoStatus]?.let { eachStatusCount = it }

            val msg = when (eachLottoStatus) {
                LottoStatus.FIFTH_PLACE -> "3개 일치 (5,000원) - %d개".format(eachStatusCount)
                LottoStatus.FOURTH_PLACE -> "4개 일치 (50,000원) - %d개".format(eachStatusCount)
                LottoStatus.THIRD_PLACE -> "5개 일치 (1,500,000원) - %d개".format(eachStatusCount)
                LottoStatus.SECOND_PLACE -> "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개".format(eachStatusCount)
                LottoStatus.FIRST_PLACE -> "6개 일치 (2,000,000,000원) - %d개".format(eachStatusCount)
                else -> return@forEach
            }
            println(msg)
        }
    }

        fun calcProfit(money: Double, extractedResult: Map<LottoStatus, Int>): Double {
        val lottoPrices =
            arrayOf(0, FIFTH_PLACE_PRICE, FOURTH_PLACE_PRICE, THIRD_PLACE_PRICE, SECOND_PLACE_PRICE, FIRST_PLACE_PRICE)
        var totalPrice: Double = 0.00

        extractedResult.forEach { eachLottoResult ->
            repeat(eachLottoResult.value) {
                totalPrice += lottoPrices[eachLottoResult.key.ordinal]
            }
        }

        return totalPrice * 100 / money
    }
}