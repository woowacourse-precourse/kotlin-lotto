package lotto

object ResultExtractor {
    fun extractResult(
        generatedLotto: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): Map<LottoPlace, Int> {
        val result = mutableMapOf<LottoPlace, Int>()

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

    fun calcProfit(money: Double, extractedResult: Map<LottoPlace, Int>): Double {
        var totalPrice: Double = 0.00

        extractedResult.forEach { eachLottoResult ->
            repeat(eachLottoResult.value) {
                totalPrice += eachLottoResult.key.price
            }
        }

        return totalPrice * 100 / money
    }
}