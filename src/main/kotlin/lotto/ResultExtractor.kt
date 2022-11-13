package lotto

import java.awt.font.FontRenderContext
import java.text.DecimalFormat
import kotlin.math.round

object ResultExtractor {
    fun extractResult(
        generatedLotto: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): Map<LottoPrice, Int> {
        val result = mutableMapOf<LottoPrice, Int>()

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

    fun calcProfit(money: Double, extractedResult: Map<LottoPrice, Int>): Double {
        var totalPrice: Double = 0.00

        extractedResult.forEach { eachLottoResult ->
            repeat(eachLottoResult.value) {
                totalPrice += eachLottoResult.key.price
            }
        }

        return totalPrice * 100 / money
    }
}